package Vista.PantallasAdministracionPrograma.PantallasTIposCuenta;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.TipoCuenta;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
// import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.SQLException;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ModificarTipoCuenta extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JComboBox<String> EntradaTipoCuenta;
	public JComboBox<String> EntradaTipo;

	private JTextField EntradaNombre;
	private JTextField EntradaInteres;

	public ModificarTipoCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 553);
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
		
		JLabel lblNewLabel = new JLabel("Modificar un tipo de cuenta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 28, 666, 57);
		contentPane.add(lblNewLabel);
		
		EntradaTipoCuenta = new JComboBox<String>();
		EntradaTipoCuenta.setBounds(184, 147, 307, 27);
		contentPane.add(EntradaTipoCuenta);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuTipoCuenta(),base);
				dispose();
			}
		});
		BotonVolver.setBounds(149, 423, 117, 29);
		contentPane.add(BotonVolver);
		
		JButton BotonModificar = new JButton("Modificar");
		BotonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionModificarTipoCuenta();
				LLenarListaTipoCuenta();
			}
		});
		BotonModificar.setBounds(388, 423, 117, 29);
		contentPane.add(BotonModificar);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de cuenta");
		lblNewLabel_1.setBounds(64, 151, 108, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de interes");
		lblNewLabel_2.setBounds(106, 280, 108, 16);
		contentPane.add(lblNewLabel_2);
		LLenarListaTipoCuenta();

		EntradaTipo = new JComboBox<String>();
		EntradaTipo.setBounds(235, 276, 210, 27);
		contentPane.add(EntradaTipo);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre");
		lblNewLabel_2_1.setBounds(106, 220, 108, 16);
		contentPane.add(lblNewLabel_2_1);
		
		EntradaNombre = new JTextField();
		EntradaNombre.setBounds(235, 215, 210, 26);
		contentPane.add(EntradaNombre);
		EntradaNombre.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Interes");
		lblNewLabel_2_1_1.setBounds(106, 341, 108, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		EntradaInteres = new JTextField();
		EntradaInteres.setColumns(10);
		EntradaInteres.setBounds(235, 336, 210, 26);
		contentPane.add(EntradaInteres);
		
		JButton BotonBuscar = new JButton("Buscar");
		BotonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarDatosTipoCuenta();
			}
		});
		BotonBuscar.setBounds(491, 146, 117, 29);
		contentPane.add(BotonBuscar);
	}

	public void MostrarDatosTipoCuenta(){
		TipoCuenta tipoCuenta = EncontrarTipoCuenta((String) EntradaTipoCuenta.getSelectedItem());
		EntradaNombre.setText(tipoCuenta.getNombre());
		EntradaTipo.removeAllItems();
		if (tipoCuenta.getTipoInteres().equals("Mensual")){
			EntradaTipo.addItem("Mensual");
			EntradaTipo.addItem("Anual");
		}else{
			EntradaTipo.addItem("Anual");
			EntradaTipo.addItem("Mensual");
		}
		EntradaInteres.setText(String.valueOf(tipoCuenta.getInteres()));
	}

	public void AccionModificarTipoCuenta(){
		TipoCuenta tipoCuenta = EncontrarTipoCuenta((String) EntradaTipoCuenta.getSelectedItem());
		String nombre = EntradaNombre.getText();
		String tipo = (String) EntradaTipo.getSelectedItem();
		double interes = Double.parseDouble(EntradaInteres.getText());
		ModificarTipo(tipoCuenta.getId(),nombre, tipo, interes,"TIPOS_CUENTA");
		LLenarListaTipoCuenta();
	}

	public TipoCuenta EncontrarTipoCuenta(String buscar){
		String query = "SELECT * FROM TIPOS_CUENTA";
		TipoCuenta tipoCuenta = null;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet tupla = consulta.executeQuery();
			while (tupla.next()) {
				int id=tupla.getInt("id");
				String nombre = tupla.getString("nombre");
				String tipo = tupla.getString("tipoInteres");
				double interes = tupla.getDouble("interes");
				tipoCuenta = new TipoCuenta(id, nombre, tipo, interes);
				String texto = tipoCuenta.toString2();
				if (texto.equals(buscar)){
					return tipoCuenta;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	public void LLenarListaTipoCuenta(){
		EntradaTipoCuenta.removeAllItems();
		String query = "SELECT * FROM TIPOS_CUENTA";
		TipoCuenta tipoCuenta = null;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet tupla = consulta.executeQuery();
			while (tupla.next()) {
				int id=tupla.getInt("id");
				String nombre = tupla.getString("nombre");
				String tipo = tupla.getString("tipoInteres");
				double interes = tupla.getDouble("interes");
				tipoCuenta = new TipoCuenta(id, nombre, tipo, interes);
				EntradaTipoCuenta.addItem(tipoCuenta.toString2());
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}

	public void ModificarTipo(int id,String nombre,String tipo,double interes,String tabla){
		String query = "UPDATE "+tabla+" SET nombre = ?, tipoInteres = ?, interes = ? WHERE id = ?";
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			instruccion.setString(1,nombre);
			instruccion.setString(2, tipo);
			instruccion.setDouble(3, interes);
			instruccion.setInt(4, id);
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
				lib.CambiarPantalla(new MenuTipoCuenta(),base);
				dispose();
				lib.MostrarMensaje("Se modifico el tipo de cuenta exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al intentar eliminar el tipo de cuenta.");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
		
	}

}
