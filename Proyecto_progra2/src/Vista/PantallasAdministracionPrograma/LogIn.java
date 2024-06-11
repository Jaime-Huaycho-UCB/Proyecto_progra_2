package Vista.PantallasAdministracionPrograma;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallaInicio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaUsuario;
	private JTextField EntradaContrasena;
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(52, 62, 91));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRACION");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setForeground(new Color(221, 253, 253));
		lblNewLabel.setBackground(new Color(221, 253, 253));
		lblNewLabel.setBounds(31, 18, 151, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(221, 253, 253));
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(230, 55, 100, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USUARIO: ");
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setForeground(new Color(219, 252, 240));
		lblNewLabel_2.setBounds(55, 141, 90, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD: ");
		lblNewLabel_3.setForeground(new Color(219, 252, 240));
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(55, 198, 110, 28);
		contentPane.add(lblNewLabel_3);
		
		EntradaUsuario = new JTextField();
		EntradaUsuario.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaUsuario.setBounds(187, 141, 229, 28);
		contentPane.add(EntradaUsuario);
		EntradaUsuario.setColumns(10);
		
		EntradaContrasena = new JTextField();
		EntradaContrasena.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaContrasena.setColumns(10);
		EntradaContrasena.setBounds(187, 199, 229, 28);
		contentPane.add(EntradaContrasena);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionIngresarAdministracion();
			}
		});
		btnNewButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(240, 261, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				lib.CambiarPantalla(new PantallaInicio());
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(398, 318, 117, 29);
		contentPane.add(btnNewButton_1);
	}

	public void AccionIngresarAdministracion(){
		String nombre = EntradaUsuario.getText();
		String contrasena = EntradaContrasena.getText();
		if (ExisteUsuario(nombre, contrasena)){
			base.CerrarConexion();
			lib.CambiarPantalla(new PantallaAdmin());
			dispose();
		}else{
			lib.MostrarMensaje("Usuario o contrasena incorrecto");
		}
	}

	public boolean ExisteUsuario(String nombre,String contrasena){
		String query = "SELECT * FROM USUARIOS_SISTEMA WHERE nombre = ? and contrasena = ?";
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			consulta.setString(1, nombre);
			consulta.setString(2, contrasena);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				return true;
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
		return false;
	}
}
