package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Vista.PantallasAdministracionPrograma.LogIn;
import Vista.PantallasIngresarACuentaAhorro.SeleccionCuenta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class PantallaInicio extends JFrame {
	public Libreria lib = new Libreria();


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtGoliathBankGfxfgxrtxtrrt;

	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JButton BotonIngresarCuenta = new JButton("CLIENTE");
		BotonIngresarCuenta.setForeground(new Color(0, 0, 0));
		BotonIngresarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionCuenta ventanaSeleccionCuenta = new SeleccionCuenta();
				lib.CambiarPantalla(ventanaSeleccionCuenta);
				dispose();
			}
		});
		BotonIngresarCuenta.setFont(new Font("Courier New", Font.ITALIC, 20));
		BotonIngresarCuenta.setBounds(391, 128, 259, 71);
		contentPane.add(BotonIngresarCuenta);
		
		JButton BotonAdministrar = new JButton("ADMINISTRACION");
		BotonAdministrar.setBackground(new Color(255, 146, 0));
		BotonAdministrar.setForeground(new Color(9, 18, 17));
		BotonAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new LogIn());
				dispose();
			}
		});
		BotonAdministrar.setFont(new Font("Courier New", Font.ITALIC, 20));
		BotonAdministrar.setBounds(63, 128, 259, 71);
		contentPane.add(BotonAdministrar);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(284, 237, 140, 45);
		contentPane.add(btnNewButton);
		
		
		
		txtGoliathBankGfxfgxrtxtrrt = new JTextField();
		txtGoliathBankGfxfgxrtxtrrt.setForeground(new Color(254, 255, 255));
		txtGoliathBankGfxfgxrtxtrrt.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 28));
		txtGoliathBankGfxfgxrtxtrrt.setBackground(new Color(4, 50, 255));
		txtGoliathBankGfxfgxrtxtrrt.setText("                GOLIATH  NATIONAL BANK");
		txtGoliathBankGfxfgxrtxtrrt.setBounds(0, 0, 722, 91);
		contentPane.add(txtGoliathBankGfxfgxrtxtrrt);
		txtGoliathBankGfxfgxrtxtrrt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(111, 249, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/jaimehuaycho/Downloads/1631338443895.jpeg"));
		lblNewLabel_1.setBounds(0, 268, 200, 98);
		contentPane.add(lblNewLabel_1);
	}
}
