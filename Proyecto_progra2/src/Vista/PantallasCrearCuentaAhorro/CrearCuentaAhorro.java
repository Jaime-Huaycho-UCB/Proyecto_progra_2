package Vista.PantallasCrearCuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.TipoCuenta;
import Vista.PantallaInicio;
import Vista.PantallaRegistroPersona;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
// import java.beans.Statement;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JComboBox;

public class CrearCuentaAhorro extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaCi;
	public JComboBox<String> EntradaTipoCuenta;
	
	public CrearCuentaAhorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("Crear un cuenta de ahorro");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 46, 619, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CI de persona");
		lblNewLabel_1.setBounds(114, 142, 113, 16);
		contentPane.add(lblNewLabel_1);
		
		EntradaCi = new JTextField();
		EntradaCi.setBounds(239, 137, 181, 26);
		contentPane.add(EntradaCi);
		EntradaCi.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de cuenta");
		lblNewLabel_1_1.setBounds(114, 213, 113, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JButton BotonCrearCuenta = new JButton("Crear cuenta");
		BotonCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionCrearCuentaAhorro();
			}
		});
		BotonCrearCuenta.setBounds(392, 311, 117, 29);
		contentPane.add(BotonCrearCuenta);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				PantallaInicio ventanaPantallaInicio = new PantallaInicio();
				ventanaPantallaInicio.setLocationRelativeTo(null);
				ventanaPantallaInicio.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(134, 311, 117, 29);
		contentPane.add(BotonVolver);
		
		EntradaTipoCuenta = new JComboBox<String>();
		EntradaTipoCuenta.setBounds(239, 209, 181, 27);
		contentPane.add(EntradaTipoCuenta);
		LlenarTiposCuenta();
	}

	public void AccionCrearCuentaAhorro(){
		String[] botones = {"No","Si"};
		TipoCuenta tipoCuenta = EncontrarTipoCuenta((String) EntradaTipoCuenta.getSelectedItem());
		int idTipoCuenta = tipoCuenta.getId();
		int ci = Integer.parseInt(EntradaCi.getText());
		if (CiExistente(ci)){
			IngresarCuentaAhorro(ci,idTipoCuenta);
		}else{
			String opcion = lib.EntradaBotones("No se encontro al CI: "+ci+" en el sistema"+
			"Desea registrarlo?"
				, botones);
			if (opcion.equals("Si")){
				PantallaRegistroPersona ventanPantallaRegistroPersona = new PantallaRegistroPersona(1);
				ventanPantallaRegistroPersona.setLocationRelativeTo(null);
				ventanPantallaRegistroPersona.setVisible(true);
				dispose();
			}
		}
	}

	public void IngresarCuentaAhorro(int ci,int idTipoCuenta){
		String query = "INSERT INTO CUENTAS_AHORRO (numeroCuenta,ciPersona,tipo,fechaApertura,saldo) values (?,?,?,?,?)";
		int numeroCuenta = NumeroCuentaRandom();
		String fechaApertura = lib.Fecha();
		Double saldo = 0.00;
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			instruccion.setInt(1,numeroCuenta);
			instruccion.setInt(2, ci);
			instruccion.setInt(3, idTipoCuenta);
			instruccion.setString(4, fechaApertura);
			instruccion.setDouble(5, saldo);
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
				lib.MostrarMensaje("Se creo la cuenta de ahorro exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al insertar los datos.");
			}
		} catch (Exception e) {
			lib.MostrarMensaje("Error al crear una cuenta de ahorro: "+e.getMessage());
		}
	}

	public boolean CiExistente(int ci){
		String query = "SELECT Count(0) FROM PERSONAS WHERE ci = "+ci;
		try {
			Statement consulta = base.getConexion().createStatement();
			ResultSet ejecutar = consulta.executeQuery(query);
			if (ejecutar.next()){
				return (ejecutar.getInt(1)!=0? true : false);
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	public int NumeroCuentaRandom(){
		String salida = "";
		for (int i=0;i<8;i++){
			salida+=""+lib.RandomEntero(1,9);
		}
		return Integer.parseInt(salida);
	}

	public TipoCuenta EncontrarTipoCuenta(String buscar){
		String query = "SELECT * FROM TIPOS_CUENTA";
		TipoCuenta tipoCuenta = null;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet tupla = consulta.executeQuery();
			while (tupla.next()) {
				int id=tupla.getInt("id");
				String nombre = tupla.getString("nombre");
				String tipo = tupla.getString("tipoInteres");
				double interes = tupla.getDouble("interes");
				tipoCuenta = new TipoCuenta(id, nombre, tipo, interes);
				String texto = tipoCuenta.toString2();
				if (texto.equals(buscar)){
					return tipoCuenta;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	public void LlenarTiposCuenta(){
		EntradaTipoCuenta.removeAllItems();
		String query = "SELECT * FROM TIPOS_CUENTA";
		TipoCuenta tipoCuenta = null;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet tupla = consulta.executeQuery();
			while (tupla.next()) {
				int id=tupla.getInt("id");
				String nombre = tupla.getString("nombre");
				String tipo = tupla.getString("tipoInteres");
				double interes = tupla.getDouble("interes");
				tipoCuenta = new TipoCuenta(id, nombre, tipo, interes);
				EntradaTipoCuenta.addItem(tipoCuenta.toString2());
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}
}
