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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.*;

public class EliminarTipoCuenta extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JComboBox<String> EntradaTipoCuenta;



	public EliminarTipoCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 345);
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
		
		JLabel lblNewLabel = new JLabel("Eliminar un tipo de cuenta");
		lblNewLabel.setBounds(173, 36, 213, 57);
		contentPane.add(lblNewLabel);
		
		EntradaTipoCuenta = new JComboBox<String>();
		EntradaTipoCuenta.setBounds(115, 123, 340, 27);
		contentPane.add(EntradaTipoCuenta);
		
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
		BotonVolver.setBounds(115, 221, 117, 29);
		contentPane.add(BotonVolver);
		
		JButton BotonEliminar = new JButton("Eliminar");
		BotonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionEliminarTipoCuenta();
			}
		});
		BotonEliminar.setBounds(338, 221, 117, 29);
		contentPane.add(BotonEliminar);
		LLenarListaTipoCuenta();
	}

	public void AccionEliminarTipoCuenta(){
		TipoCuenta tipoCuenta = EncontrarTipoCuenta((String) EntradaTipoCuenta.getSelectedItem());
		String[] botones = {"No","Si"};
		String opcion = lib.EntradaBotones(
			"ADVERTENCIA:"+lib.n()+
			"ESTA OPCIONELIMINARA TODAS LAS CUENTAS QUE CONTENGAN ESTE TIPODE CUENTA\nDesea eliminar?"
			,botones);
		if (opcion.equals("Si")){
			EliminarTipo(tipoCuenta.getId(),"TIPOS_CUENTA");
		}
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
				String texto = tipoCuenta.toString();
				if (texto.equals(buscar)){
					return tipoCuenta;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	public void LLenarListaTipoCuenta(){
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
				EntradaTipoCuenta.addItem(tipoCuenta.toString());
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}

	public void EliminarTipo(int id,String tabla){
		String query = "DELETE FROM "+tabla+" WHERE id = ?";
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			instruccion.setInt(1, id);
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
				lib.MostrarMensaje("Se elimino el tipo de cuenta exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al intentar eliminar el tipo de cuenta.");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
		base.CerrarConexion();
		MenuTipoCuenta ventanaMenuTipoCuenta = new MenuTipoCuenta();
		ventanaMenuTipoCuenta.setLocationRelativeTo(null);
		ventanaMenuTipoCuenta.setVisible(true);
		dispose();
	}
}
