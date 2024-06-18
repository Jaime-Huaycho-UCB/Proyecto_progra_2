package Vista.PantallasAdministracionPrograma.PantallasTIposCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

public class AdicionTipoCuenta extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaNombre;
	private JTextField EntradaInteres;
	public JComboBox<String> EntradaTipo;


	public AdicionTipoCuenta() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 535, 448);
	        setTitle("Adición de Tipo de Cuenta");

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        // Fondo combinado de rojo y azul
	        JPanel panelFondo = new JPanel();
	        panelFondo.setBounds(0, 0, 535, 448);
	        panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
	        contentPane.add(panelFondo);
	        panelFondo.setLayout(null);

	        JPanel panelRojo = new JPanel();
	        panelRojo.setBackground(new Color(183, 0, 0)); // Rojo oscuro
	        panelRojo.setBounds(0, 0, 535, 100);
	        panelFondo.add(panelRojo);
	        panelRojo.setLayout(null);

	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                base.CerrarConexion();
	                dispose();
	            }
	        });

	        JLabel lblNewLabel = new JLabel("ADICIONAR TIPO DE CUENTA\r\n");
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD | Font.ITALIC, 24));
	        lblNewLabel.setForeground(Color.WHITE); // Texto en blanco
	        lblNewLabel.setBounds(10, 30, 499, 50);
	        panelRojo.add(lblNewLabel);
	        
	        JLabel lblNewLabel_2 = new JLabel("Goliath National Bank");
	        lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_2.setForeground(new Color(255, 255, 255));
	        lblNewLabel_2.setForeground(Color.WHITE);
	        lblNewLabel_2.setBounds(10, 10, 229, 13);
	        panelRojo.add(lblNewLabel_2);

	        JLabel separadorTitulo = new JLabel();
	        separadorTitulo.setBackground(Color.WHITE);
	        separadorTitulo.setOpaque(true);
	        separadorTitulo.setBounds(10, 90, 499, 2);
	        panelRojo.add(separadorTitulo);

	        JLabel lblNewLabel_1 = new JLabel("Nombre:");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_1.setForeground(Color.WHITE); // Texto en blanco
	        lblNewLabel_1.setBounds(92, 110, 98, 20);
	        panelFondo.add(lblNewLabel_1);

	        EntradaNombre = new JTextField();
	        EntradaNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        EntradaNombre.setBounds(202, 108, 238, 26);
	        panelFondo.add(EntradaNombre);
	        EntradaNombre.setColumns(10);

	        JLabel lblNewLabel_1_1 = new JLabel("Tipo de interés:");
	        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_1_1.setForeground(Color.WHITE); // Texto en blanco
	        lblNewLabel_1_1.setBounds(84, 171, 125, 20);
	        panelFondo.add(lblNewLabel_1_1);

	        JLabel lblNewLabel_1_2 = new JLabel("Interés:");
	        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_1_2.setForeground(Color.WHITE); // Texto en blanco
	        lblNewLabel_1_2.setBounds(92, 230, 98, 20);
	        panelFondo.add(lblNewLabel_1_2);

	        EntradaInteres = new JTextField();
	        EntradaInteres.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        EntradaInteres.setBounds(202, 228, 238, 26);
	        panelFondo.add(EntradaInteres);
	        EntradaInteres.setColumns(10);

	        JButton BotonAdicionar = new JButton("ADICIONAR");
	        BotonAdicionar.setOpaque(true);
	        BotonAdicionar.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/10.png"));
	        BotonAdicionar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
	        BotonAdicionar.setBackground(new Color(34, 139, 34)); // Verde
	        BotonAdicionar.setForeground(Color.WHITE);
	        BotonAdicionar.setFocusPainted(false);
	        BotonAdicionar.setBorderPainted(false);
	        BotonAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        BotonAdicionar.setBounds(202, 277, 157, 49);
	        BotonAdicionar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                AccionAdicionarTipoCuenta();
	            }
	        });
	        panelFondo.add(BotonAdicionar);

	        JButton BotonVolver = new JButton("VOLVER");
	        BotonVolver.setOpaque(true);
	        BotonVolver.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/8.1.png"));
	        BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
	        BotonVolver.setBackground(new Color(192, 57, 43)); // Rojo oscuro
	        BotonVolver.setForeground(Color.WHITE);
	        BotonVolver.setFocusPainted(false);
	        BotonVolver.setBorderPainted(false);
	        BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        BotonVolver.setBounds(365, 348, 144, 38);
	        BotonVolver.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                base.CerrarConexion();
	                MenuTipoCuenta ventanaMenuTipoCuenta = new MenuTipoCuenta();
	                ventanaMenuTipoCuenta.setLocationRelativeTo(null);
	                ventanaMenuTipoCuenta.setVisible(true);
	                dispose();
	            }
	        });
	        panelFondo.add(BotonVolver);

	        String[] tipoIntereses = {"Mensual", "Anual"};
	        EntradaTipo = new JComboBox<String>(tipoIntereses);
	        EntradaTipo.setOpaque(true);
	        EntradaTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        EntradaTipo.setBounds(202, 168, 238, 26);
	        panelFondo.add(EntradaTipo);

	        // Logo
	        ImageIcon logo = new ImageIcon(getClass().getResource("/ruta/del/logo.png")); // Ajusta la ruta del logo según tu proyecto
	        JLabel lblLogo = new JLabel(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/2.jpg"));
	        lblLogo.setBounds(10, 337, 98, 64); // Posición ajustable según el diseño
	        panelFondo.add(lblLogo);
	}

	public void AccionAdicionarTipoCuenta(){
		try {
			String nombre = EntradaNombre.getText();
			String tipo = (String) EntradaTipo.getSelectedItem();
			double interes = Double.parseDouble(EntradaInteres.getText());
			if (nombre.length()!=0){
				if (interes>=0.00 && interes<=100.00){
					IngresarTipoCuenta(nombre, tipo, interes);
				}
			}else{
				lib.MostrarMensaje("No deje espacios en blanco");
			}
		} catch (NumberFormatException num) {
			lib.MostrarMensaje("Ingrese los formatos de forma correcta");
		}
	}

	public void IngresarTipoCuenta(String nombre,String tipo,Double interes){
		String query = "INSERT INTO TIPOS_CUENTA (nombre,tipoInteres,interes) values (?,?,?)";
		try {
			PreparedStatement accion = base.getConexion().prepareStatement(query);
			accion.setString(1, nombre);
			accion.setString(2, tipo);
			accion.setDouble(3, interes);
			int ingresar = accion.executeUpdate();
			if (ingresar > 0) {
				lib.MostrarMensaje("Se completo la adicion exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al adicionar lel tipo de cuenta.");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}
}
