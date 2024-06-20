package Vista.PantallasAdministracionPrograma;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallaInicio;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

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

		// Crear un JPanel con un borde rojo grueso
		JPanel borderPanel = new JPanel();
		borderPanel.setBorder(new LineBorder(new Color(255, 255, 255), 4)); // Borde rojo grueso
		borderPanel.setLayout(new BorderLayout());
		setContentPane(borderPanel);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(67, 80, 169)); // Color de fondo existente
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		borderPanel.add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/2.jpg"))); // Asegúrate
																												// de
																												// tener
																												// un
																												// logo
		lblLogo.setBounds(430, -12, 211, 102);
		contentPane.add(lblLogo);

		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(236, 240, 241));
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(230, 69, 100, 39);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("USUARIO: ");
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setForeground(new Color(189, 195, 199));
		lblNewLabel_2.setBounds(75, 132, 90, 28);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("PASSWORD: ");
		lblNewLabel_3.setForeground(new Color(189, 195, 199));
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(75, 195, 110, 28);
		contentPane.add(lblNewLabel_3);

		EntradaUsuario = new JTextField();
		EntradaUsuario.setFont(new Font("Courier New", Font.ITALIC, 14));
		EntradaUsuario.setBounds(177, 134, 229, 28);
		contentPane.add(EntradaUsuario);
		EntradaUsuario.setColumns(10);

		JLabel lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/4.jpg"))); // Ruta
																												// a la
																												// imagen
																												// de
																												// persona
		lblIconoUsuario.setBounds(418, 132, 32, 28);
		contentPane.add(lblIconoUsuario);

		EntradaContrasena = new JPasswordField();
		EntradaContrasena.setFont(new Font("Courier New", Font.ITALIC, 14));
		EntradaContrasena.setBounds(177, 197, 229, 28);
		contentPane.add(EntradaContrasena);

		JLabel lblIconoContrasena = new JLabel("");
		lblIconoContrasena.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/3.png"))); // Ruta
																												// a la
																												// imagen
																												// de
																												// candado
		lblIconoContrasena.setBounds(418, 184, 32, 39);
		contentPane.add(lblIconoContrasena);

		JButton BotonIngresar = new JButton("INGRESAR");
		BotonIngresar.setOpaque(true);
		BotonIngresar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonIngresar.setBackground(new Color(41, 128, 185));
		BotonIngresar.setForeground(Color.WHITE);
		BotonIngresar.setFocusPainted(false);
		BotonIngresar.setBorderPainted(false);
		BotonIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonIngresar.setBounds(230, 253, 117, 29);
		contentPane.add(BotonIngresar);

		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.WHITE);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setBounds(398, 318, 117, 29);
		contentPane.add(BotonVolver);

		JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(28, 23, 170, 20);
		contentPane.add(lblNewLabel);
		BotonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionIngresarAdministracion();
			}
		});

		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new PantallaInicio(),base);
				dispose();
			}
		});
	}

	public void AccionIngresarAdministracion() {
		String nombre = EntradaUsuario.getText();
		String contrasena = EntradaContrasena.getText();
		if (ExisteUsuario(nombre, contrasena)) {
			lib.CambiarPantalla(new PantallaAdministracionPrograma(),base);
			dispose();
		} else {
			lib.MostrarMensaje("Usuario o contrasena incorrecto");
		}
	}

	public boolean ExisteUsuario(String nombre, String contrasena) {
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
