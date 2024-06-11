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

public class PantallaInicio extends JFrame {
	public Libreria lib = new Libreria();


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(79, 10, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GOLIATH NATIONAL BANK");
		lblNewLabel.setBackground(new Color(250, 255, 252));
		lblNewLabel.setForeground(new Color(226, 231, 229));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setBounds(6, 32, 715, 53);
		contentPane.add(lblNewLabel);
		
		
		
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
		BotonAdministrar.setForeground(new Color(0, 0, 0));
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
	}
}
