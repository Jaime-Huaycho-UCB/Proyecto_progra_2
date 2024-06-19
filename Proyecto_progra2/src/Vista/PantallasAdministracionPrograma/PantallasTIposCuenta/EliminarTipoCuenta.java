package Vista.PantallasAdministracionPrograma.PantallasTIposCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.TipoCuenta;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.*;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
public class EliminarTipoCuenta extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JComboBox<String> EntradaTipoCuenta;

	public EliminarTipoCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 576, 430);
        setTitle("Eliminar Tipo de Cuenta");

        contentPane = new JPanel(); // Inicializar contentPane
        contentPane.setLayout(null); // Establecer el layout del contentPane
        setContentPane(contentPane);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 576, 415);
        panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
        contentPane.add(panelFondo);
        panelFondo.setLayout(null);

        JPanel panelRojo = new JPanel();
        panelRojo.setBackground(new Color(183, 0, 0)); // Rojo oscuro
        panelRojo.setBounds(0, 0, 576, 113);
        panelFondo.add(panelRojo);
        panelRojo.setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                base.CerrarConexion();
                dispose();
            }
        });

        JLabel lblTitulo = new JLabel("Eliminar un tipo de cuenta");
        lblTitulo.setIcon(new ImageIcon(EliminarTipoCuenta.class.getResource("/Imagenes/11.png")));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Noto Sans", Font.BOLD | Font.ITALIC, 24));
        lblTitulo.setForeground(Color.WHITE); // Texto en blanco
        lblTitulo.setBounds(49, 30, 398, 60);
        panelRojo.add(lblTitulo);

        JLabel separadorTitulo = new JLabel();
        separadorTitulo.setBackground(Color.WHITE);
        separadorTitulo.setOpaque(true);
        separadorTitulo.setBounds(131, 88, 294, 2);
        panelRojo.add(separadorTitulo);

        EntradaTipoCuenta = new JComboBox<String>();
        EntradaTipoCuenta.setOpaque(true);
        EntradaTipoCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        EntradaTipoCuenta.setBounds(82, 169, 393, 27);
        panelFondo.add(EntradaTipoCuenta);

        JButton BotonVolver = new JButton("VOLVER");
        BotonVolver.setOpaque(true);
        BotonVolver.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/8.1.png"));
        BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
        BotonVolver.setBackground(new Color(192, 57, 43)); // Rojo oscuro
        BotonVolver.setForeground(Color.WHITE);
        BotonVolver.setFocusPainted(false);
        BotonVolver.setBorderPainted(false);
        BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BotonVolver.setBounds(350, 337, 157, 39);
        BotonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lib.CambiarPantalla(new MenuTipoCuenta(),base);
                dispose();
            }
        });
        panelFondo.add(BotonVolver);

        JButton BotonEliminar = new JButton("ELIMINAR");
        BotonEliminar.setOpaque(true);
        BotonEliminar.setIcon(new ImageIcon(EliminarTipoCuenta.class.getResource("/Imagenes/12.png")));
        BotonEliminar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
        BotonEliminar.setBackground(new Color(0, 255, 0)); // Rojo oscuro
        BotonEliminar.setForeground(Color.WHITE);
        BotonEliminar.setFocusPainted(false);
        BotonEliminar.setBorderPainted(false);
        BotonEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BotonEliminar.setBounds(181, 225, 176, 48);
        BotonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccionEliminarTipoCuenta();
            }
        });
        panelFondo.add(BotonEliminar);

        LLenarListaTipoCuenta();
        
        JLabel lblNewLabel_2 = new JLabel("Goliath National Bank");
        lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(10, 7, 229, 13);
        panelRojo.add(lblNewLabel_2);
        
        // ImageIcon logo = new ImageIcon(getClass().getResource("/ruta/del/logo.png")); // Ajusta la ruta del logo según tu proyecto
        JLabel lblLogo = new JLabel(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/2.jpg"));
        lblLogo.setBounds(10, 337, 98, 64); // Posición ajustable según el diseño
        panelFondo.add(lblLogo);
        
        JLabel lblNewLabel = new JLabel("CUENTA");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setBounds(83, 132, 88, 27);
        panelFondo.add(lblNewLabel);
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
                lib.CambiarPantalla(new MenuTipoCuenta(),base);
                dispose();
				lib.MostrarMensaje("Se elimino el tipo de cuenta exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al intentar eliminar el tipo de cuenta.");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
		lib.CambiarPantalla(new MenuTipoCuenta(),base);
		dispose();
	}
}
