package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.PantallaInicio;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuIngresarACuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public int numeroCuenta;
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public MenuIngresarACuenta(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 38, 672, 57);
		contentPane.add(lblNewLabel);
		
		JButton BotonReporte = new JButton("Reporte de cuenta");
		BotonReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCuenta ventanaReporteCuenta = new ReporteCuenta(getNumeroCuenta());
				ventanaReporteCuenta.setLocationRelativeTo(null);
				ventanaReporteCuenta.setVisible(true);
				dispose();
			}
		});
		BotonReporte.setBounds(221, 128, 245, 95);
		contentPane.add(BotonReporte);
		
		JButton BotonTransaccion = new JButton("Realizar transaccion");
		BotonTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarTransaccion ventanaRealizarTransaccion = new RealizarTransaccion(getNumeroCuenta());
				ventanaRealizarTransaccion.setLocationRelativeTo(null);
				ventanaRealizarTransaccion.setVisible(true);
				dispose();
			}
		});
		BotonTransaccion.setBounds(221, 259, 245, 95);
		contentPane.add(BotonTransaccion);
		
		JButton BotonCalcularInteres = new JButton("Calcular interes");
		BotonCalcularInteres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonCalcularInteres.setBounds(221, 393, 245, 95);
		contentPane.add(BotonCalcularInteres);
		
		JButton BotonVolver_1 = new JButton("Volver");
		BotonVolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInicio ventanSeleccionCuenta = new PantallaInicio();
				ventanSeleccionCuenta.setLocationRelativeTo(null);
				ventanSeleccionCuenta.setVisible(true);
				dispose();
			}
		});
		BotonVolver_1.setBounds(221, 525, 245, 95);
		contentPane.add(BotonVolver_1);
	}

}
