package Vista.PantallasAdministracionPrograma;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.PantallaInicio;
import Vista.PantallasAdministracionPrograma.PantallasTIposCuenta.MenuTipoCuenta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaAdministracionPrograma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaAdministracionPrograma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administracion del programa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 44, 740, 61);
		contentPane.add(lblNewLabel);
		
		JButton BotonTiposCuenta = new JButton("Tipos de cuenta");
		BotonTiposCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTipoCuenta ventanaMenuTipoCuenta = new MenuTipoCuenta();
				ventanaMenuTipoCuenta.setLocationRelativeTo(null);
				ventanaMenuTipoCuenta.setVisible(true);
				dispose();
			}
		});
		BotonTiposCuenta.setBounds(110, 145, 174, 81);
		contentPane.add(BotonTiposCuenta);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInicio ventanaPantallaInicio = new PantallaInicio();
				ventanaPantallaInicio.setLocationRelativeTo(null);
				ventanaPantallaInicio.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(302, 423, 117, 29);
		contentPane.add(BotonVolver);
		
		JButton BotonCuentasAhorro = new JButton("Cuentas de ahorro");
		BotonCuentasAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCuentasAhorro ventanReporteCuentasAhorro = new ReporteCuentasAhorro();
				ventanReporteCuentasAhorro.setLocationRelativeTo(null);
				ventanReporteCuentasAhorro.setVisible(true);
				dispose();
			}
		});
		BotonCuentasAhorro.setBounds(485, 145, 174, 81);
		contentPane.add(BotonCuentasAhorro);
	}
}
