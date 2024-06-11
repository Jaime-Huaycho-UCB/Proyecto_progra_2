package Vista.PantallasAdministracionPrograma;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Vista.PantallaInicio;
import Vista.PantallasCrearCuentaAhorro.CrearCuentaAhorro;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaAdmin extends JFrame {
	
	public Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public PantallaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonCrearCuenta = new JButton("Crear cuenta de ahorro");
		BotonCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCuentaAhorro ventanCrearCuentaAhorro = new CrearCuentaAhorro();
				lib.CambiarPantalla(ventanCrearCuentaAhorro);
				dispose();
			}
		});
		BotonCrearCuenta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		BotonCrearCuenta.setBounds(60, 83, 316, 100);
		contentPane.add(BotonCrearCuenta);
		
		JButton BotonAdministrar = new JButton("Administrar Programa");
		BotonAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdministracionPrograma ventanaPantallaAdministracionPrograma = new PantallaAdministracionPrograma();
				lib.CambiarPantalla(ventanaPantallaAdministracionPrograma);
				dispose();
			}
		});
		BotonAdministrar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		BotonAdministrar.setBounds(45, 6, 256, 77);
		contentPane.add(BotonAdministrar);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					PantallaInicio ventanCrearCuentaAhorro = new PantallaInicio();
					lib.CambiarPantalla(ventanCrearCuentaAhorro);
					dispose();
			}
		});
		BotonVolver.setBounds(106, 195, 187, 70);
		contentPane.add(BotonVolver);
	}
}
