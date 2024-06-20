package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Vista.PantallaInicio;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MenuIngresarACuenta extends JFrame {

	public Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public int numeroCuenta;
	private JButton botonTransferencias;

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public MenuIngresarACuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 684, 504);
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
		separadorTitulo.setBounds(10, 99, 650, 2);
		panelRojo.add(separadorTitulo);

		JLabel lblNewLabel = new JLabel("BIENVENDIDO A GOLIATH NATIONAL BANK");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-13, 44, 672, 57);
		panelRojo.add(lblNewLabel);

		JButton BotonReporte = new JButton("Reporte de cuenta");
		BotonReporte.setOpaque(true);
		BotonReporte.setFont(new Font("Dialog", Font.BOLD, 13));
		BotonReporte.setBackground(new Color(16, 136, 188));
		BotonReporte.setForeground(Color.BLACK);
		BotonReporte.setFocusPainted(false);
		BotonReporte.setBorderPainted(false);
		BotonReporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonReporte.setIcon(new ImageIcon(MenuIngresarACuenta.class.getResource("/Imagenes/icono_reporte.png")));
		BotonReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCuenta ventanaReporteCuenta = new ReporteCuenta(getNumeroCuenta());
				ventanaReporteCuenta.setLocationRelativeTo(null);
				ventanaReporteCuenta.setVisible(true);
				dispose();
			}
		});
		BotonReporte.setBounds(48, 127, 267, 65);
		panelFondo.add(BotonReporte);

		JButton BotonTransaccion = new JButton("Realizar transaccion");
		BotonTransaccion.setOpaque(true);
		BotonTransaccion.setFont(new Font("Dialog", Font.BOLD, 14));
		BotonTransaccion.setBackground(Color.WHITE);
		BotonTransaccion.setForeground(Color.BLACK);
		BotonTransaccion.setFocusPainted(false);
		BotonTransaccion.setBorderPainted(false);
		BotonTransaccion.setCursor(new Cursor(Cursor.HAND_CURSOR));

		BotonTransaccion
				.setIcon(new ImageIcon(MenuIngresarACuenta.class.getResource("/Imagenes/icono_transferencia2.0.jpg")));
		BotonTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarTransaccion ventanaRealizarTransaccion = new RealizarTransaccion(getNumeroCuenta());
				ventanaRealizarTransaccion.setLocationRelativeTo(null);
				ventanaRealizarTransaccion.setVisible(true);
				dispose();
			}
		});
		BotonTransaccion.setBounds(343, 127, 267, 65);
		panelFondo.add(BotonTransaccion);

		JButton BotonCalcularInteres = new JButton("Calcular interes");
		BotonCalcularInteres.setOpaque(true);
		BotonCalcularInteres.setFont(new Font("Dialog", Font.BOLD, 14));
		BotonCalcularInteres.setBackground(new Color(216, 133, 58));
		BotonCalcularInteres.setForeground(Color.BLACK);
		BotonCalcularInteres.setFocusPainted(false);
		BotonCalcularInteres.setBorderPainted(false);
		BotonCalcularInteres.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonCalcularInteres
				.setIcon(new ImageIcon(MenuIngresarACuenta.class.getResource("/Imagenes/icono_interes.png")));
		BotonCalcularInteres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new CalcularInteres(getNumeroCuenta()));
				dispose();
			}
		});
		BotonCalcularInteres.setBounds(48, 235, 267, 65);
		panelFondo.add(BotonCalcularInteres);

		JButton BotonVolver_1 = new JButton("Volver");
		BotonVolver_1.setOpaque(true);
		BotonVolver_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver_1.setBackground(Color.RED);
		BotonVolver_1.setForeground(Color.WHITE);
		BotonVolver_1.setFocusPainted(false);
		BotonVolver_1.setBorderPainted(false);
		BotonVolver_1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		BotonVolver_1.setIcon(new ImageIcon(MenuIngresarACuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInicio ventanSeleccionCuenta = new PantallaInicio();
				ventanSeleccionCuenta.setLocationRelativeTo(null);
				ventanSeleccionCuenta.setVisible(true);
				dispose();
			}
		});
		BotonVolver_1.setBounds(533, 448, 145, 50);
		panelFondo.add(BotonVolver_1);

		JButton BotonTransferenciaBancaria = new JButton("Realizar Transferencia");
		BotonTransferenciaBancaria.setOpaque(true);
		BotonTransferenciaBancaria.setFont(new Font("Dialog", Font.BOLD, 14));
		BotonTransferenciaBancaria.setBackground(new Color(62, 179, 73));
		BotonTransferenciaBancaria.setForeground(Color.BLACK);
		BotonTransferenciaBancaria.setFocusPainted(false);
		BotonTransferenciaBancaria.setBorderPainted(false);
		BotonTransferenciaBancaria.setCursor(new Cursor(Cursor.HAND_CURSOR));

		BotonTransferenciaBancaria
				.setIcon(new ImageIcon(MenuIngresarACuenta.class.getResource("/Imagenes/icono_trans.png")));
		BotonTransferenciaBancaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new TransfereciasBancarias(getNumeroCuenta()));
				dispose();
			}
		});
		BotonTransferenciaBancaria.setBounds(343, 235, 267, 65);
		panelFondo.add(BotonTransferenciaBancaria);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MenuIngresarACuenta.class.getResource("/Imagenes/2.jpg")));
		lblNewLabel_1.setBounds(6, 447, 103, 50);
		panelFondo.add(lblNewLabel_1);

		JLabel separador1 = new JLabel();
		separador1.setBackground(Color.WHITE);
		separador1.setOpaque(true);
		separador1.setBounds(348, 210, 262, 2);
		panelFondo.add(separador1);

		JLabel separador2 = new JLabel();
		separador2.setBackground(Color.WHITE);
		separador2.setOpaque(true);
		separador2.setBounds(48, 315, 267, 2);
		panelFondo.add(separador2);

		JLabel separador3 = new JLabel();
		separador3.setBackground(Color.WHITE);
		separador3.setOpaque(true);
		separador3.setBounds(47, 210, 268, 2);
		panelFondo.add(separador3);

		JLabel separador4 = new JLabel();
		separador4.setBackground(Color.WHITE);
		separador4.setOpaque(true);
		separador4.setBounds(343, 315, 267, 2);
		panelFondo.add(separador4);
		
		JLabel separador5 = new JLabel();
		separador5.setBackground(Color.WHITE);
		separador5.setOpaque(true);
		separador5.setBounds(206, 429, 267, 2);
		panelFondo.add(separador5);

		botonTransferencias = new JButton("Reporte de transferencias");
		botonTransferencias.setIcon(new ImageIcon(MenuIngresarACuenta.class.getResource("/Imagenes/icono_reporte.png")));
		botonTransferencias.setFont(new Font("Dialog", Font.BOLD, 14));
		botonTransferencias.setBackground(new Color(255, 147, 0));
		botonTransferencias.setForeground(Color.BLACK);
		botonTransferencias.setFocusPainted(false);
		botonTransferencias.setBorderPainted(false);
		botonTransferencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonTransferencias.setOpaque(true);
		botonTransferencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new ReporteTransferencias(getNumeroCuenta()));
				dispose();
			}
		});
		botonTransferencias.setBounds(225, 342, 229, 75);
		panelFondo.add(botonTransferencias);
	}
}
