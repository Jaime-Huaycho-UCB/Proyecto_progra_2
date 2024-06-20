package Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.CuentaAhorro;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;

public class EliminarCuentaAhorro extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaNumeroCuenta;

	public EliminarCuentaAhorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 675);
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
		
		EntradaNumeroCuenta = new JTextField();
		EntradaNumeroCuenta.setBounds(285, 163, 130, 26);
		contentPane.add(EntradaNumeroCuenta);
		EntradaNumeroCuenta.setColumns(10);
		
		JButton BotonEliminar = new JButton("Eliminar");
		BotonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionEliminarCuenta();
			}
		});
		BotonEliminar.setBounds(427, 238, 117, 29);
		contentPane.add(BotonEliminar);
		
		JLabel lblNewLabel = new JLabel("Numero de cuenta");
		lblNewLabel.setBounds(121, 168, 103, 16);
		contentPane.add(lblNewLabel);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuOpcionesCuentaAhorro(),base);
				dispose();
			}
		});
		BotonVolver.setBounds(124, 492, 117, 29);
		contentPane.add(BotonVolver);
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
