package Vista.PantallasAdministracionPrograma.PantallasTIposCuenta;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class TablaTiposCuenta extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public Object[][] data;

	public TablaTiposCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, -11, 592, 540);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 678, 115);
		panelRojo.setBackground(new Color(183, 0, 0));
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(2, 103, 670, 3);
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
		
		String[] atributos = {"Nombre", "Tipo de interes", "Interes"};
		data = LlenarTabla();        
        // Crear un DefaultTableModel con los datos y los nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(data, atributos);
		
		table = new JTable(model);
		table.setSelectionBackground(Color.WHITE);
		table.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 116, 516, 363);
		scrollPane.setFont(new Font("Courier New", Font.ITALIC, 14));
		scrollPane.setForeground(new Color(254, 255, 255));
		scrollPane.setBackground(new Color(254, 255, 255));
		panelFondo.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("TABLA DE TIPOS DE CUENTA");
		lblNewLabel.setIcon(new ImageIcon(TablaTiposCuenta.class.getResource("/Imagenes/icono_tabla.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(6, 51, 580, 55);
		panelRojo.add(lblNewLabel);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setBounds(238, 491, 121, 32);
		BotonVolver.setIcon(new ImageIcon(MenuTipoCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.WHITE);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelFondo.add(BotonVolver);
		BotonVolver.setIcon(new ImageIcon(TablaTiposCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setOpaque(true);
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuTipoCuenta(),base);
				dispose();
			}
		});
		BotonVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelFondo.add(BotonVolver);
		
	}

	public Object[][] LlenarTabla(){
		String tabla = "TIPOS_CUENTA";
		int n =NumeroTuplas(tabla);
		String query = "SELECT * FROM "+tabla;
		Object[][] tab = new Object[n][3];
		int f=0;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				tab[f][0]=ejecutar.getString("nombre");
				tab[f][1]=ejecutar.getString("tipoInteres");
				tab[f][2]=ejecutar.getDouble("interes")+"%";
				f+=1;
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
		return tab;
	}
	public int NumeroTuplas(String tabla){
        int n = 0;
		String query = "SELECT Count(*) FROM " + tabla;
        try {
			Statement consulta = base.getConexion().createStatement();
            ResultSet ejecutar = consulta.executeQuery(query);
            if (ejecutar.next()) {
                n = ejecutar.getInt(1);
            }
        } catch (Exception e) {
			
        }
        return n;
    }
}
