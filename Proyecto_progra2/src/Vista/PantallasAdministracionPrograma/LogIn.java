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
	        contentPane.setBackground(new Color(44, 62, 80)); // Color de fondo existente
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        borderPanel.add(contentPane, BorderLayout.CENTER);
	        contentPane.setLayout(null);

	        JLabel lblLogo = new JLabel("");
	        lblLogo.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/2.jpg")); // Asegúrate de tener un logo
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
	        lblIconoUsuario.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/4.jpg")); // Ruta a la imagen de persona
	        lblIconoUsuario.setBounds(418, 132, 32, 28);
	        contentPane.add(lblIconoUsuario);

	        EntradaContrasena = new JPasswordField();
	        EntradaContrasena.setFont(new Font("Courier New", Font.ITALIC, 14));
	        EntradaContrasena.setBounds(177, 197, 229, 28);
	        contentPane.add(EntradaContrasena);

	        JLabel lblIconoContrasena = new JLabel("");
	        lblIconoContrasena.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/3.png")); // Ruta a la imagen de candado
	        lblIconoContrasena.setBounds(418, 184, 32, 39);
	        contentPane.add(lblIconoContrasena);

	        JButton btnNewButton = new JButton("INGRESAR");
	        btnNewButton.setOpaque(true);
	        btnNewButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
	        btnNewButton.setBackground(new Color(41, 128, 185));
	        btnNewButton.setForeground(Color.WHITE);
	        btnNewButton.setFocusPainted(false);
	        btnNewButton.setBorderPainted(false);
	        btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        btnNewButton.setBounds(230, 253, 117, 29);
	        contentPane.add(btnNewButton);

	        JButton btnNewButton_1 = new JButton("VOLVER");
	        btnNewButton_1.setOpaque(true);
	        btnNewButton_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
	        btnNewButton_1.setBackground(new Color(192, 57, 43));
	        btnNewButton_1.setForeground(Color.WHITE);
	        btnNewButton_1.setFocusPainted(false);
	        btnNewButton_1.setBorderPainted(false);
	        btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        btnNewButton_1.setBounds(398, 318, 117, 29);
	        contentPane.add(btnNewButton_1);

	        JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
	        lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setBounds(28, 23, 170, 20);
	        contentPane.add(lblNewLabel);

	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                AccionIngresarAdministracion();
	            }
	        });

	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                base.CerrarConexion();
	                lib.CambiarPantalla(new PantallaInicio());
	                dispose();
	            }
	        });
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
