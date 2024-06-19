package Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Vista.PantallasAdministracionPrograma.PantallaAdministracionPrograma;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuOpcionesCuentaAhorro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Libreria lib = new Libreria();

	public MenuOpcionesCuentaAhorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonReporteCuentasAhorro = new JButton("Reporte de cuentas de ahorro");
		BotonReporteCuentasAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new ReporteCuentasAhorro());
				dispose();
			}
		});
		BotonReporteCuentasAhorro.setBounds(225, 73, 228, 29);
		contentPane.add(BotonReporteCuentasAhorro);
		
		JButton BotonCrearCuentaAhorro = new JButton("Crear cuenta de ahorro");
		BotonCrearCuentaAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new CrearCuentaAhorro());
				dispose();
			}
		});
		BotonCrearCuentaAhorro.setBounds(212, 141, 197, 29);
		contentPane.add(BotonCrearCuentaAhorro);
		
		JButton BotonEliminarCuentasAhorro = new JButton("Eliminar cuenta de ahorro");
		BotonEliminarCuentasAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonEliminarCuentasAhorro.setBounds(207, 221, 117, 29);
		contentPane.add(BotonEliminarCuentasAhorro);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new PantallaAdministracionPrograma());
				dispose();
			}
		});
		BotonVolver.setBounds(131, 347, 117, 29);
		contentPane.add(BotonVolver);
	}
}
