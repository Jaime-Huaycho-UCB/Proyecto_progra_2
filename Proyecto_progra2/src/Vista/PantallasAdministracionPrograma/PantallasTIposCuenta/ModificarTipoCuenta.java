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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

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
		

		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, -11, 678, 536);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 678, 119);
		panelRojo.setBackground(new Color(183, 0, 0));
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(6, 102, 670, 3);
		panelRojo.add(separadorTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("GOLIATH NATIONAL BANK");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setForeground(new Color(254, 255, 255));
		lblNewLabel_1.setBounds(6, 30, 253, 16);
		panelRojo.add(lblNewLabel_1);
		

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("MODIFICAR UN TIPO DE CUENTA");
		lblNewLabel.setIcon(new ImageIcon(ModificarTipoCuenta.class.getResource("/Imagenes/Icono_modificacion.jpeg")));
		lblNewLabel.setForeground(new Color(254, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(2, 48, 666, 57);
		panelRojo.add(lblNewLabel);
		
		EntradaTipoCuenta = new JComboBox<String>();
		EntradaTipoCuenta.setBounds(197, 144, 307, 27);
		EntradaTipoCuenta.setFont(new Font("Courier New", Font.ITALIC, 14));
		EntradaTipoCuenta.setOpaque(true);
		EntradaTipoCuenta.setBackground(new Color(254, 255, 255));
		panelFondo.add(EntradaTipoCuenta);
		
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setBounds(516, 474, 133, 35);
		BotonVolver.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.WHITE);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(ModificarTipoCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuTipoCuenta(),base);
				dispose();
			}
		});
		panelFondo.add(BotonVolver);
		
		JButton BotonModificar = new JButton("MODIFICAR");
		BotonModificar.setBounds(252, 419, 195, 35);
		BotonModificar.setOpaque(true);
		BotonModificar.setIcon(new ImageIcon(AdicionTipoCuenta.class.getResource("/Imagenes/10.png")));
		BotonModificar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonModificar.setBackground(new Color(34, 139, 34)); // Verde
		BotonModificar.setForeground(Color.WHITE);
		BotonModificar.setFocusPainted(false);
		BotonModificar.setBorderPainted(false);
		BotonModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionModificarTipoCuenta();
				LLenarListaTipoCuenta();
			}
		});
		panelFondo.add(BotonModificar);
		
		JLabel lblNewLabel_2 = new JLabel("TIPO DE INTERES:");
		lblNewLabel_2.setBounds(53, 284, 132, 16);
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		panelFondo.add(lblNewLabel_2);
		LLenarListaTipoCuenta();

		EntradaTipo = new JComboBox<String>();
		EntradaTipo.setBounds(197, 279, 307, 27);
		EntradaTipo.setFont(new Font("Courier New", Font.ITALIC, 14));
		EntradaTipo.setOpaque(true);
		panelFondo.add(EntradaTipo);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE:");
		lblNewLabel_2_1.setBounds(70, 219, 108, 16);
		lblNewLabel_2_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		panelFondo.add(lblNewLabel_2_1);
		
		EntradaNombre = new JTextField();
		EntradaNombre.setBounds(197, 210, 307, 35);
		EntradaNombre.setFont(new Font("Courier New", Font.ITALIC, 14));
		panelFondo.add(EntradaNombre);
		EntradaNombre.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("INTERES:");
		lblNewLabel_2_1_1.setBounds(70, 357, 108, 16);
		lblNewLabel_2_1_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		panelFondo.add(lblNewLabel_2_1_1);
		
		EntradaInteres = new JTextField();
		EntradaInteres.setBounds(197, 347, 307, 35);
		EntradaInteres.setFont(new Font("Courier New", Font.ITALIC, 14));
		EntradaInteres.setColumns(10);
		panelFondo.add(EntradaInteres);
		
		JButton BotonBuscar = new JButton("BUSCAR");
		BotonBuscar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		BotonBuscar.setBackground(new Color(254, 255, 255));
		BotonBuscar.setBounds(516, 136, 133, 42);
		BotonBuscar.setIcon(new ImageIcon(ModificarTipoCuenta.class.getResource("/Imagenes/icono_buscar.png")));
		BotonBuscar.setOpaque(true);
		BotonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarDatosTipoCuenta();
			}
		});
		panelFondo.add(BotonBuscar);
		
		JLabel lblNewLabel_3 = new JLabel("TIPO DE CUENTA:");
		lblNewLabel_3.setBounds(55, 149, 127, 16);
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		panelFondo.add(lblNewLabel_3);
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
