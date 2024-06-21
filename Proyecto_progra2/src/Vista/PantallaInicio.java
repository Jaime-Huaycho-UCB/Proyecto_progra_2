package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Vista.PantallasAdministracionPrograma.LogIn;
import Vista.PantallasIngresarACuentaAhorro.SeleccionCuenta;
import Vista.PantallasTreEnRaya.MenuJuego;

// import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
// import javax.swing.ImageIcon;
// import java.awt.Canvas;
import javax.swing.JTextField;
// import javax.swing.DropMode;

public class PantallaInicio extends JFrame {
	public Libreria lib = new Libreria();


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtGoliathBankGfxfgxrtxtrrt;

	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(67, 80, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JButton BotonIngresarCuenta = new JButton("CLIENTE");
		BotonIngresarCuenta.setOpaque(true);
		BotonIngresarCuenta.setForeground(new Color(28, 49, 84));
		BotonIngresarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionCuenta ventanaSeleccionCuenta = new SeleccionCuenta();
				lib.CambiarPantalla(ventanaSeleccionCuenta);
				dispose();
			}
		});
		BotonIngresarCuenta.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
		BotonIngresarCuenta.setBounds(391, 128, 259, 71);
		contentPane.add(BotonIngresarCuenta);
		
		JButton BotonAdministrar = new JButton("ADMINISTRACION");
		BotonAdministrar.setOpaque(true);
		BotonAdministrar.setBackground(new Color(254, 255, 255));
		BotonAdministrar.setForeground(new Color(28, 49, 84));
		BotonAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new LogIn());
				dispose();
			}
		});
		BotonAdministrar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
		BotonAdministrar.setBounds(63, 128, 259, 71);
		contentPane.add(BotonAdministrar);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.setOpaque(true);
		btnNewButton.setForeground(new Color(28, 49, 84));
		btnNewButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(284, 237, 140, 45);
		contentPane.add(btnNewButton);
		
		
		
		txtGoliathBankGfxfgxrtxtrrt = new JTextField();
		txtGoliathBankGfxfgxrtxtrrt.setEditable(false);
		txtGoliathBankGfxfgxrtxtrrt.setHorizontalAlignment(SwingConstants.CENTER);
		txtGoliathBankGfxfgxrtxtrrt.setForeground(new Color(254, 255, 255));
		txtGoliathBankGfxfgxrtxtrrt.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 30));
		txtGoliathBankGfxfgxrtxtrrt.setBackground(new Color(183, 0, 0));
		txtGoliathBankGfxfgxrtxtrrt.setText("GOLIATH NATIONAL BANK");
		txtGoliathBankGfxfgxrtxtrrt.setBounds(-25, 6, 777, 91);
		contentPane.add(txtGoliathBankGfxfgxrtxtrrt);
		txtGoliathBankGfxfgxrtxtrrt.setColumns(10);
		
		JButton BotonJugar = new JButton("Juego");
		BotonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuJuego());
				dispose();
			}
		});
		BotonJugar.setBounds(515, 279, 117, 29);
		contentPane.add(BotonJugar);
	}
}
