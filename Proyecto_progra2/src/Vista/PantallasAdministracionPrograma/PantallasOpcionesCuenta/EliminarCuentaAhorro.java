package Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.CuentaAhorro;
import Vista.PantallasAdministracionPrograma.PantallasTIposCuenta.EliminarTipoCuenta;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class EliminarCuentaAhorro extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaNumeroCuenta;

	public EliminarCuentaAhorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 639, 415);
        panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
        contentPane.add(panelFondo);
        panelFondo.setLayout(null);

        JPanel panelRojo = new JPanel();
        panelRojo.setBounds(0, 0, 633, 113);
        panelRojo.setBackground(new Color(183, 0, 0));
        panelFondo.add(panelRojo);
        panelRojo.setLayout(null);
        
    	JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(0, 99, 650, 2);
		panelRojo.add(separadorTitulo);


		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
			}
		});
		
		EntradaNumeroCuenta = new JTextField();
		EntradaNumeroCuenta.setBounds(263, 139, 203, 26);
		panelFondo.add(EntradaNumeroCuenta);
		EntradaNumeroCuenta.setColumns(10);
		
		  JButton BotonEliminar = new JButton("ELIMINAR");
		  BotonEliminar.setBounds(232, 201, 154, 43);
	        BotonEliminar.setOpaque(true);
	        BotonEliminar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
	        BotonEliminar.setBackground(new Color(51, 152, 46)); // Rojo oscuro
	        BotonEliminar.setForeground(Color.WHITE);
	        BotonEliminar.setFocusPainted(false);
	        BotonEliminar.setBorderPainted(false);
	        BotonEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonEliminar.setIcon(new ImageIcon(EliminarCuentaAhorro.class.getResource("/Imagenes/12.png")));
		BotonEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		BotonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionEliminarCuenta();
			}
		});
		panelFondo.add(BotonEliminar);
		
		JLabel lblNewLabel = new JLabel("Numero de cuenta");
		lblNewLabel.setBounds(79, 141, 154, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelFondo.add(lblNewLabel);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setBounds(461, 248, 154, 29);
		BotonVolver.setOpaque(true);
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.BLACK);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(EliminarCuentaAhorro.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuOpcionesCuentaAhorro(),base);
				dispose();
			}
		});
		panelFondo.add(BotonVolver);
		
		JLabel lblNewLabel_1 = new JLabel("ELIMINAR CUENTA\r\n");
		lblNewLabel_1.setIcon(new ImageIcon(EliminarCuentaAhorro.class.getResource("/Imagenes/11.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(139, 43, 320, 60);
		panelRojo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Goliath National Bank");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 10, 172, 13);
		panelRojo.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 243, 109, 43);
		lblNewLabel_2.setIcon(new ImageIcon(EliminarCuentaAhorro.class.getResource("/Imagenes/2.jpg")));
		panelFondo.add(lblNewLabel_2);
	}

	public void AccionEliminarCuenta(){
		String query = "DELETE FROM CUENTAS_AHORRO WHERE numeroCuenta = ";
		CuentaAhorro cuenta = EncontrarCuentaAhorro();
		int numeroCuenta = Integer.parseInt(EntradaNumeroCuenta.getText());
		String[] botones = {"No","Si"};
		if (cuenta!=null){
			String opcion = lib.EntradaBotones("Seguro que desea eliminar a la siguiente cuenta de ahorro:\n"+
												cuenta.toString()
			,botones);
			if (opcion.equals("Si")){
				try {
					query+=numeroCuenta;
					PreparedStatement instruccion = base.getConexion().prepareStatement(query);
					int ejecutar = instruccion.executeUpdate();
					if (ejecutar>0){
						lib.MostrarMensaje("Se elimino la cuenta de "+cuenta.getTitular()+" de forma exitosa.");
						lib.CambiarPantalla(new MenuOpcionesCuentaAhorro(),base);
						dispose();
					} else {
						lib.MostrarMensaje("No se pudo eliminar la cuenta.");
					}
				} catch (Exception e) {
					lib.MostrarMensaje("Error: "+e.getMessage());
				}
			}
		} else {
			lib.MostrarMensaje("La cuenta ingresada no existe");
		}
	}

	public CuentaAhorro EncontrarCuentaAhorro(){
		CuentaAhorro cuenta = null;
		String query = "select CUENTAS_AHORRO.numeroCuenta,PERSONAS.nombre,PERSONAS.apellidoPaterno,PERSONAS.apellidoMaterno,TIPOS_CUENTA.nombre as Tipo,CUENTAS_AHORRO.saldo " +
						"FROM CUENTAS_AHORRO,TIPOS_CUENTA,PERSONAS " +
						"where CUENTAS_AHORRO.ciPersona = PERSONAS.ci and TIPOS_CUENTA.id=CUENTAS_AHORRO.tipo and CUENTAS_AHORRO.numeroCuenta = ";
		try {
			int numeroCuenta = Integer.parseInt(EntradaNumeroCuenta.getText());
			query+=numeroCuenta;
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = instruccion.executeQuery();
			while (ejecutar.next()) {
				String titular = ejecutar.getString("nombre")+" "+ejecutar.getString("apellidoPaterno")+" "+ejecutar.getString("apellidoMaterno");
				String tipoCuenta = ejecutar.getString("Tipo");
				double saldo = ejecutar.getDouble("saldo");
				cuenta = new CuentaAhorro(numeroCuenta, titular, tipoCuenta, saldo);
			}
		} catch (NumberFormatException a){
			lib.MostrarMensaje("Ingrese unicamente numeros");
		} catch (Exception e) {
			lib.MostrarMensaje("Error: "+e.getMessage());
		}
		return cuenta;
	}
}
