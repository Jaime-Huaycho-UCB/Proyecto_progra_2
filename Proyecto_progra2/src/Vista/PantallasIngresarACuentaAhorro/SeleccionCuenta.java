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
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;

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
		

		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 619, 429);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBackground(new Color(183, 0, 0)); // Rojo oscuro
		panelRojo.setBounds(0, -11, 689, 111);
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(0, 99, 650, 2);
		panelRojo.add(separadorTitulo);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("INGRESA A TU CUENTA");
		lblNewLabel.setIcon(new ImageIcon(SeleccionCuenta.class.getResource("/Imagenes/4.jpg")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(10, 55, 594, 44);
		panelRojo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doc. de identidad:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(91, 144, 149, 16);
		panelFondo.add(lblNewLabel_1);
		
		EntradaCi = new JTextField();
		EntradaCi.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaCi.setBounds(238, 139, 130, 26);
		panelFondo.add(EntradaCi);
		EntradaCi.setColumns(10);
		
		JButton BotonBuscar = new JButton("BUSCAR");
		BotonBuscar.setBackground(new Color(254, 255, 255));
		BotonBuscar.setOpaque(true);
		BotonBuscar.setIcon(new ImageIcon(SeleccionCuenta.class.getResource("/Imagenes/icono_buscar.png")));
		BotonBuscar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		BotonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarListaCuentas();
			}
		});
		BotonBuscar.setBounds(380, 124, 141, 44);
		panelFondo.add(BotonBuscar);
		
		EntradaCuenta = new JComboBox<String>();
		EntradaCuenta.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaCuenta.setBounds(164, 203, 357, 27);
		panelFondo.add(EntradaCuenta);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setOpaque(true);
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.BLACK);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(SeleccionCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		panelFondo.add(BotonVolver);
		
		BotonIngresar = new JButton("Ingresar");
		BotonIngresar.setOpaque(true);
		BotonIngresar.setBackground(new Color(51, 152, 46));
		BotonIngresar.setFocusPainted(false);
		BotonIngresar.setBorderPainted(false);
		BotonIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonIngresar.setIcon(new ImageIcon(SeleccionCuenta.class.getResource("/Imagenes/icono_ingresar.png")));
		BotonIngresar.setForeground(new Color(0, 0, 0));
		BotonIngresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		BotonIngresar.setEnabled(false);
		BotonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionIngresarACuenta();
			}
		});
		BotonIngresar.setBounds(361, 279, 160, 44);
		panelFondo.add(BotonIngresar);
		
		JLabel lblNewLabel_2 = new JLabel("Cuenta:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(91, 207, 73, 16);
		panelFondo.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Goliath National Bank");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(10, 20, 238, 13);
		panelRojo.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(SeleccionCuenta.class.getResource("/Imagenes/2.jpg")));
		lblNewLabel_4.setBounds(472, 21, 99, 44);
		panelRojo.add(lblNewLabel_4);
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
