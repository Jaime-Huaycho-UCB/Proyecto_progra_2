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
import java.awt.event.ActionListener;
import java.awt.event.*;

public class TablaTiposCuenta extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public Object[][] data;

	public TablaTiposCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 524);
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
		
		String[] atributos = {"Nombre", "Tipo de interes", "Interes"};
		data = LlenarTabla();        
        // Crear un DefaultTableModel con los datos y los nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(data, atributos);
		
		table = new JTable(model);
		table.setSelectionBackground(Color.WHITE);
		table.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 96, 380, 280);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Tabla de tipos de cuentas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 29, 580, 55);
		contentPane.add(lblNewLabel);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuTipoCuenta(),base);
				dispose();
			}
		});
		BotonVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		BotonVolver.setBounds(242, 410, 117, 29);
		contentPane.add(BotonVolver);
		
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
