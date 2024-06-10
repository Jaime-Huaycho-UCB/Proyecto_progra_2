package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallaInicio;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class SeleccionCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaCi;
	public JComboBox<String> EntradaCuenta;
	public JButton BotonIngresar;

	public BaseDatos base = new BaseDatos();
	public Libreria lib = new Libreria();

	public SeleccionCuenta() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 417);
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
		
		JLabel lblNewLabel = new JLabel("Ingresa a tu cuenta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 46, 594, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carnet de identidad:");
		lblNewLabel_1.setBounds(91, 144, 141, 16);
		contentPane.add(lblNewLabel_1);
		
		EntradaCi = new JTextField();
		EntradaCi.setBounds(238, 139, 130, 26);
		contentPane.add(EntradaCi);
		EntradaCi.setColumns(10);
		
		JButton BotonBuscar = new JButton("Buscar");
		BotonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarListaCuentas();
			}
		});
		BotonBuscar.setBounds(380, 139, 141, 29);
		contentPane.add(BotonBuscar);
		
		EntradaCuenta = new JComboBox<String>();
		EntradaCuenta.setBounds(164, 203, 357, 27);
		contentPane.add(EntradaCuenta);
		
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
		BotonVolver.setBounds(91, 279, 160, 44);
		contentPane.add(BotonVolver);
		
		BotonIngresar = new JButton("Ingresar");
		BotonIngresar.setEnabled(false);
		BotonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionIngresarACuenta();
			}
		});
		BotonIngresar.setBounds(361, 279, 160, 44);
		contentPane.add(BotonIngresar);
		
		JLabel lblNewLabel_2 = new JLabel("Cuenta:");
		lblNewLabel_2.setBounds(91, 207, 61, 16);
		contentPane.add(lblNewLabel_2);
	}

	public void AccionIngresarACuenta(){
		int numeroCuenta = EncontrarNumeroCuenta();
		base.CerrarConexion();
		MenuIngresarACuenta ventanMenuIngresarACuenta = new MenuIngresarACuenta(numeroCuenta);
		ventanMenuIngresarACuenta.setLocationRelativeTo(null);
		ventanMenuIngresarACuenta.setVisible(true);
		dispose();
	}

	public int EncontrarNumeroCuenta(){
		String query = "SELECT numeroCuenta,saldo FROM CUENTAS_AHORRO WHERE ciPersona = "+EntradaCi.getText();
		int numeroCuenta = 0;
		double saldo = 0.00;
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = instruccion.executeQuery();
			while (ejecutar.next()) {
				numeroCuenta=ejecutar.getInt("numeroCuenta");
				saldo=ejecutar.getDouble("saldo");
				if (("Numero de cuenta: "+numeroCuenta+" - Saldo: "+saldo).equals((String) EntradaCuenta.getSelectedItem())){
					return numeroCuenta;
				}
			}
		} catch (Exception e) {
			lib.MostrarMensaje("No se encontro la cuenta: "+e.getMessage());
		}
		return 0;
	}

	public void ActualizarListaCuentas(){
		BotonIngresar.setEnabled(false);
		EntradaCuenta.removeAllItems();
		String query = "SELECT numeroCuenta,saldo FROM CUENTAS_AHORRO WHERE ciPersona = "+EntradaCi.getText();
		int numeroCuenta=0;
		double saldo = 0.00;
		try {
			int ci = Integer.parseInt(EntradaCi.getText());
			if (CiExistente(ci)){
				BotonIngresar.setEnabled(true);
				try {
					PreparedStatement instruccion = base.getConexion().prepareStatement(query);
					ResultSet ejecutar = instruccion.executeQuery();
					while (ejecutar.next()) {
						numeroCuenta=ejecutar.getInt("numeroCuenta");
						saldo=ejecutar.getDouble("saldo");
						EntradaCuenta.addItem("Numero de cuenta: "+numeroCuenta+" - Saldo: "+saldo);
					}
				} catch (Exception e) {
				}
			}else{
				lib.MostrarMensaje("La persona no cuenta con una cuenta de ahorro");
			}
		} catch (NumberFormatException a) {
			lib.MostrarMensaje("Ingresa el Ci en el formato correcto");
		}
	}	

	public boolean CiExistente(int ci){
		String query = "SELECT Count(0) FROM CUENTAS_AHORRO WHERE ciPersona = "+ci;
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
}
