package Vista.PantallasAdministracionPrograma.PantallasTIposCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Vista.PantallasAdministracionPrograma.PantallaAdministracionPrograma;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;

public class MenuTipoCuenta extends JFrame {

	public Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton botonTablaTIposCuenta;

	public MenuTipoCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 437);
		setTitle("Menu Tipo Cuenta ");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 535, 409);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBackground(new Color(183, 0, 0)); // Rojo oscuro
		panelRojo.setBounds(0, -11, 535, 111);
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU TIPO DE CUENTAS\n");
		lblNewLabel.setForeground(new Color(254, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(37, 50, 479, 43);
		panelRojo.add(lblNewLabel);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(10, 90, 499, 2);
		panelRojo.add(separadorTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("GOLIATH NATIONAL BANK");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setForeground(new Color(254, 255, 255));
		lblNewLabel_1.setBounds(27, 22, 232, 16);
		panelRojo.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Adicionar Tipo de Cuenta");
		btnNewButton.setFont(new Font("Courier New", Font.ITALIC, 12));
		btnNewButton.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/10.png")));
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionTipoCuenta ventanAdicionTipoCuenta = new AdicionTipoCuenta();
				ventanAdicionTipoCuenta.setLocationRelativeTo(null);
				ventanAdicionTipoCuenta.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(31, 140, 229, 67);
		panelFondo.add(btnNewButton);
		
		JButton BotonEliminarTipoCuenta = new JButton("Eliminar TIpo de Cuenta");
		BotonEliminarTipoCuenta.setFont(new Font("Courier New", Font.ITALIC, 12));
		BotonEliminarTipoCuenta.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/12.png")));
		BotonEliminarTipoCuenta.setOpaque(true);
		BotonEliminarTipoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new EliminarTipoCuenta());
				dispose();
			}
		});
		BotonEliminarTipoCuenta.setBounds(283, 140, 229, 67);
		panelFondo.add(BotonEliminarTipoCuenta);
		
		JButton btnModificarTipoDe = new JButton("Modificar Tipo de Cuenta");
		btnModificarTipoDe.setFont(new Font("Courier New", Font.ITALIC, 12));
		btnModificarTipoDe.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/Icono_modificacion.jpeg")));
		btnModificarTipoDe.setOpaque(true);
		btnModificarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarTipoCuenta ventanModificarTipoCuenta = new ModificarTipoCuenta();
				ventanModificarTipoCuenta.setLocationRelativeTo(null);
				ventanModificarTipoCuenta.setVisible(true);
				dispose();
			}
		});
		btnModificarTipoDe.setBounds(31, 238, 229, 67);
		panelFondo.add(btnModificarTipoDe);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.WHITE);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelFondo.add(BotonVolver);
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdministracionPrograma ventanaPantallaAdministracionPrograma = new PantallaAdministracionPrograma();
				ventanaPantallaAdministracionPrograma.setLocationRelativeTo(null);
				ventanaPantallaAdministracionPrograma.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(333, 345, 179, 50);
		panelFondo.add(BotonVolver);
		
		botonTablaTIposCuenta = new JButton("Tabla Tipos de Cuenta");
		botonTablaTIposCuenta.setFont(new Font("Courier New", Font.ITALIC, 12));
		botonTablaTIposCuenta.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/icono_tabla.png")));
		botonTablaTIposCuenta.setOpaque(true);
		botonTablaTIposCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaTiposCuenta ventanTablaTiposCuenta = new TablaTiposCuenta();
				ventanTablaTiposCuenta.setLocationRelativeTo(null);
				ventanTablaTiposCuenta.setVisible(true);
				dispose();
			}
		});
		botonTablaTIposCuenta.setBounds(283, 238, 229, 67);
		panelFondo.add(botonTablaTIposCuenta);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/2.jpg")));
		lblNewLabel_2.setBounds(31, 348, 102, 43);
		panelFondo.add(lblNewLabel_2);
	}

}
