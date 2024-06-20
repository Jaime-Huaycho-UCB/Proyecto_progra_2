package Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.TipoCuenta;
import Vista.PantallaRegistroPersona;

import Vista.PantallasAdministracionPrograma.PantallasTIposCuenta.MenuTipoCuenta;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
// import java.beans.Statement;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

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
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, -11, 631, 411);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 632, 118);
		panelRojo.setBackground(new Color(183, 0, 0));
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(2, 103, 670, 3);
		panelRojo.add(separadorTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("GOLIATH NATIONAL BANK");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(254, 255, 255));
		lblNewLabel_1.setBounds(6, 30, 253, 16);
		panelRojo.add(lblNewLabel_1);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("CREAR CUENTA DE AHORRO");
		lblNewLabel.setIcon(new ImageIcon(CrearCuentaAhorro.class.getResource("/Imagenes/icono_crear.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 46, 619, 65);
		panelRojo.add(lblNewLabel);
		
		EntradaCi = new JTextField();
		EntradaCi.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaCi.setBounds(261, 137, 227, 26);
		panelFondo.add(EntradaCi);
		EntradaCi.setColumns(10);
		
		JButton BotonCrearCuenta = new JButton("ADICIONAR");
		BotonCrearCuenta.setBounds(232, 261, 181, 42);
		BotonCrearCuenta.setOpaque(true);
		BotonCrearCuenta.setIcon(new ImageIcon(CrearCuentaAhorro.class.getResource("/Imagenes/10.png")));
		BotonCrearCuenta.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonCrearCuenta.setBackground(new Color(34, 139, 34)); // Verde
		BotonCrearCuenta.setForeground(Color.WHITE);
		BotonCrearCuenta.setFocusPainted(false);
		BotonCrearCuenta.setBorderPainted(false);
		BotonCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));

		BotonCrearCuenta.setIcon(new ImageIcon(CrearCuentaAhorro.class.getResource("/Imagenes/10.png")));
		BotonCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionCrearCuentaAhorro();
			}
		});
		panelFondo.add(BotonCrearCuenta);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setBounds(480, 352, 128, 42);
		BotonVolver.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.WHITE);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(CrearCuentaAhorro.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuOpcionesCuentaAhorro(),base);
				dispose();
			}
		});
		panelFondo.add(BotonVolver);
		
		EntradaTipoCuenta = new JComboBox<String>();
		EntradaTipoCuenta.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaTipoCuenta.setBounds(257, 205, 236, 34);
		panelFondo.add(EntradaTipoCuenta);
		
		JLabel lblNewLabel_2 = new JLabel("DOC. IDENTIDAD:");
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(113, 142, 136, 16);
		lblNewLabel_2.setForeground(Color.WHITE);
		panelFondo.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TIPO DE CUENTA:");
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(113, 213, 136, 16);
		lblNewLabel_3.setForeground(Color.WHITE);
		panelFondo.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(17, 351, 100, 42);
		lblNewLabel_4.setIcon(new ImageIcon(CrearCuentaAhorro.class.getResource("/Imagenes/2.jpg")));
		panelFondo.add(lblNewLabel_4);
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
				lib.CambiarPantalla(new MenuOpcionesCuentaAhorro(),base);
				dispose();
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
