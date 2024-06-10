package Vista.PantallasAdministracionPrograma.PantallasTIposCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.*;

public class AdicionTipoCuenta extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaNombre;
	private JTextField EntradaInteres;
	public JComboBox<String> EntradaTipo;


	public AdicionTipoCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("Adicionar un tipo de cuenta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 44, 523, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(92, 135, 98, 16);
		contentPane.add(lblNewLabel_1);
		
		EntradaNombre = new JTextField();
		EntradaNombre.setBounds(202, 130, 238, 26);
		contentPane.add(EntradaNombre);
		EntradaNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de interes:");
		lblNewLabel_1_1.setBounds(92, 191, 98, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Interes:");
		lblNewLabel_1_2.setBounds(92, 249, 98, 16);
		contentPane.add(lblNewLabel_1_2);
		
		EntradaInteres = new JTextField();
		EntradaInteres.setColumns(10);
		EntradaInteres.setBounds(202, 244, 238, 26);
		contentPane.add(EntradaInteres);
		
		JButton BotonAdicionar = new JButton("Adicionar");
		BotonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionAdicionarTipoCuenta();
			}
		});
		BotonAdicionar.setBounds(323, 314, 117, 29);
		contentPane.add(BotonAdicionar);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				MenuTipoCuenta ventanaMenuTipoCuenta = new MenuTipoCuenta();
				ventanaMenuTipoCuenta.setLocationRelativeTo(null);
				ventanaMenuTipoCuenta.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(92, 314, 117, 29);
		contentPane.add(BotonVolver);
		
		String[] tipoIntereses = {"Mensual","Anual"};
		EntradaTipo = new JComboBox<String>(tipoIntereses);
		EntradaTipo.setBounds(202, 187, 238, 27);
		contentPane.add(EntradaTipo);
	}

	public void AccionAdicionarTipoCuenta(){
		try {
			String nombre = EntradaNombre.getText();
			String tipo = (String) EntradaTipo.getSelectedItem();
			double interes = Double.parseDouble(EntradaInteres.getText());
			if (nombre.length()!=0){
				if (interes>=0.00 && interes<=100.00){
					IngresarTipoCuenta(nombre, tipo, interes);
				}
			}else{
				lib.MostrarMensaje("No deje espacios en blanco");
			}
		} catch (NumberFormatException num) {
			lib.MostrarMensaje("Ingrese los formatos de forma correcta");
		}
	}

	public void IngresarTipoCuenta(String nombre,String tipo,Double interes){
		String query = "INSERT INTO TIPOS_CUENTA (nombre,tipoInteres,interes) values (?,?,?)";
		try {
			PreparedStatement accion = base.getConexion().prepareStatement(query);
			accion.setString(1, nombre);
			accion.setString(2, tipo);
			accion.setDouble(3, interes);
			int ingresar = accion.executeUpdate();
			if (ingresar > 0) {
				lib.MostrarMensaje("Se completo la adicion exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al adicionar lel tipo de cuenta.");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}
}
