package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.PantallasAdministracionPrograma.PantallaAdministracionPrograma;
import Vista.PantallasCrearCuentaAhorro.CrearCuentaAhorro;
import Vista.PantallasIngresarACuentaAhorro.SeleccionCuenta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuentas de ahorro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 58, 733, 44);
		contentPane.add(lblNewLabel);
		
		JButton BotonCrearCuenta = new JButton("Crear cuenta de ahorro");
		BotonCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCuentaAhorro ventanCrearCuentaAhorro = new CrearCuentaAhorro();
				ventanCrearCuentaAhorro.setLocationRelativeTo(null);
				ventanCrearCuentaAhorro.setVisible(true);
				dispose();
			}
		});
		BotonCrearCuenta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		BotonCrearCuenta.setBounds(210, 268, 316, 100);
		contentPane.add(BotonCrearCuenta);
		
		JButton BotonIngresarCuenta = new JButton("Ingresar a una cuenta");
		BotonIngresarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionCuenta ventanaSeleccionCuenta = new SeleccionCuenta();
				ventanaSeleccionCuenta.setLocationRelativeTo(null);
				ventanaSeleccionCuenta.setVisible(true);
				dispose();
			}
		});
		BotonIngresarCuenta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		BotonIngresarCuenta.setBounds(210, 406, 316, 100);
		contentPane.add(BotonIngresarCuenta);
		
		JButton BotonAdministrar = new JButton("Administrar Programa");
		BotonAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdministracionPrograma ventanaPantallaAdministracionPrograma = new PantallaAdministracionPrograma();
				ventanaPantallaAdministracionPrograma.setLocationRelativeTo(null);
				ventanaPantallaAdministracionPrograma.setVisible(true);
				dispose();
			}
		});
		BotonAdministrar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		BotonAdministrar.setBounds(210, 130, 316, 100);
		contentPane.add(BotonAdministrar);
	}
}
