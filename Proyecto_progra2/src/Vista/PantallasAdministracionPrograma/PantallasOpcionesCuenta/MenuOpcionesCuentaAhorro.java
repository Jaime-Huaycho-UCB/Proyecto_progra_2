package Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Vista.PantallasAdministracionPrograma.PantallaAdministracionPrograma;
import Vista.PantallasAdministracionPrograma.PantallasTIposCuenta.MenuTipoCuenta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class MenuOpcionesCuentaAhorro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Libreria lib = new Libreria();

	public MenuOpcionesCuentaAhorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, -11, 586, 470);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 678, 111);
		panelRojo.setBackground(new Color(183, 0, 0));
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(2, 103, 670, 3);
		panelRojo.add(separadorTitulo);
		
		
		JButton BotonReporteCuentasAhorro = new JButton("Reporte Cuentas de Ahorro");
		BotonReporteCuentasAhorro.setBounds(132, 143, 318, 52);
		BotonReporteCuentasAhorro.setOpaque(true);
		BotonReporteCuentasAhorro .setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonReporteCuentasAhorro .setBackground(new Color(23, 143, 179));
		BotonReporteCuentasAhorro .setForeground(Color.WHITE);
		BotonReporteCuentasAhorro .setFocusPainted(false);
		BotonReporteCuentasAhorro .setBorderPainted(false);
		BotonReporteCuentasAhorro .setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonReporteCuentasAhorro.setIcon(new ImageIcon(MenuOpcionesCuentaAhorro.class.getResource("/Imagenes/icono_reporte.png")));
		BotonReporteCuentasAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new ReporteCuentasAhorro());
				dispose();
			}
		});
		panelFondo.add(BotonReporteCuentasAhorro);
		
		JButton BotonCrearCuentaAhorro = new JButton("Crear Cuenta de Ahorro");
		BotonCrearCuentaAhorro.setBounds(132, 216, 318, 52);
		BotonCrearCuentaAhorro.setOpaque(true);
		BotonCrearCuentaAhorro .setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonCrearCuentaAhorro .setBackground(Color.GREEN);
		BotonCrearCuentaAhorro .setForeground(Color.WHITE);
		BotonCrearCuentaAhorro .setFocusPainted(false);
		BotonCrearCuentaAhorro .setBorderPainted(false);
		BotonCrearCuentaAhorro .setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonCrearCuentaAhorro.setIcon(new ImageIcon(MenuOpcionesCuentaAhorro.class.getResource("/Imagenes/icono_crear.png")));
		BotonCrearCuentaAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new CrearCuentaAhorro());
				dispose();
			}
		});
		panelFondo.add(BotonCrearCuentaAhorro);
		
		JButton BotonEliminarCuentasAhorro = new JButton("Eliminar Cuentas de Ahorro");
		BotonEliminarCuentasAhorro.setBounds(132, 299, 318, 58);
		BotonEliminarCuentasAhorro.setOpaque(true);
		BotonEliminarCuentasAhorro.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonEliminarCuentasAhorro.setBackground(Color.RED);
		BotonEliminarCuentasAhorro.setForeground(Color.WHITE);
		BotonEliminarCuentasAhorro.setFocusPainted(false);
		BotonEliminarCuentasAhorro.setBorderPainted(false);
		BotonEliminarCuentasAhorro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonEliminarCuentasAhorro.setIcon(new ImageIcon(MenuOpcionesCuentaAhorro.class.getResource("/Imagenes/12.png")));
		BotonEliminarCuentasAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new EliminarCuentaAhorro());
				dispose();
			}
		});
		panelFondo.add(BotonEliminarCuentasAhorro);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setBounds(418, 407, 144, 38);
		BotonVolver.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.WHITE);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(MenuOpcionesCuentaAhorro.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new PantallaAdministracionPrograma());
				dispose();
			}
		});
		panelFondo.add(BotonVolver);
		
		JLabel lblNewLabel = new JLabel("OPCIONES DE CUENTAS DE AHORRO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setBounds(87, 70, 447, 20);
		panelRojo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MenuOpcionesCuentaAhorro.class.getResource("/Imagenes/2.jpg")));
		lblNewLabel_1.setBounds(19, 348, 109, 38);
		panelRojo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Goliath National Bank");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(6, 12, 180, 46);
		panelRojo.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(MenuOpcionesCuentaAhorro.class.getResource("/Imagenes/2.jpg")));
		lblNewLabel_3.setBounds(20, 407, 104, 38);
		panelFondo.add(lblNewLabel_3);
	}
}
