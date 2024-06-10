package Vista.PantallasAdministracionPrograma.PantallasTIposCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.PantallasAdministracionPrograma.PantallaAdministracionPrograma;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuTipoCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MenuTipoCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu de tipo de cuentas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 30, 479, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicionar tipo de cuenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionTipoCuenta ventanAdicionTipoCuenta = new AdicionTipoCuenta();
				ventanAdicionTipoCuenta.setLocationRelativeTo(null);
				ventanAdicionTipoCuenta.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(139, 85, 218, 67);
		contentPane.add(btnNewButton);
		
		JButton btnEliminarTipoDe = new JButton("Eliminar tipo de cuenta");
		btnEliminarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarTipoCuenta ventanaEliminarTipoCuenta = new EliminarTipoCuenta();
				ventanaEliminarTipoCuenta.setLocationRelativeTo(null);
				ventanaEliminarTipoCuenta.setVisible(true);
				dispose();
			}
		});
		btnEliminarTipoDe.setBounds(139, 164, 218, 67);
		contentPane.add(btnEliminarTipoDe);
		
		JButton btnModificarTipoDe = new JButton("Modificar tipo de cuenta");
		btnModificarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarTipoCuenta ventanModificarTipoCuenta = new ModificarTipoCuenta();
				ventanModificarTipoCuenta.setLocationRelativeTo(null);
				ventanModificarTipoCuenta.setVisible(true);
				dispose();
			}
		});
		btnModificarTipoDe.setBounds(139, 251, 218, 67);
		contentPane.add(btnModificarTipoDe);
		
		JButton btnNewButton_2_1 = new JButton("Volver");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdministracionPrograma ventanaPantallaAdministracionPrograma = new PantallaAdministracionPrograma();
				ventanaPantallaAdministracionPrograma.setLocationRelativeTo(null);
				ventanaPantallaAdministracionPrograma.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(139, 420, 218, 67);
		contentPane.add(btnNewButton_2_1);
		
		JButton BotonTablaTIposCuenta = new JButton("Tabla de tipos de cuenta");
		BotonTablaTIposCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaTiposCuenta ventanTablaTiposCuenta = new TablaTiposCuenta();
				ventanTablaTiposCuenta.setLocationRelativeTo(null);
				ventanTablaTiposCuenta.setVisible(true);
				dispose();
			}
		});
		BotonTablaTIposCuenta.setBounds(139, 341, 218, 67);
		contentPane.add(BotonTablaTIposCuenta);
	}

}
