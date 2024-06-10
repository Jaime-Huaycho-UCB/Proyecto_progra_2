package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;

public class RealizarTransaccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaMonto;
	public JComboBox<String> EntradaTipoTransaccion;
	public JTextArea EntradaDescripcion;

	public BaseDatos base = new BaseDatos();
	public Libreria lib = new Libreria();

	public int numeroCuenta;
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public RealizarTransaccion(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 596);
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
		
		JLabel lblNewLabel = new JLabel("Realizar una transaccion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblNewLabel.setBounds(6, 51, 526, 79);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 287, 349, 167);
		contentPane.add(scrollPane);
		
		EntradaDescripcion = new JTextArea();
		scrollPane.setViewportView(EntradaDescripcion);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de transaccion");
		lblNewLabel_1.setBounds(96, 142, 132, 16);
		contentPane.add(lblNewLabel_1);
		
		String[] listaTiposTransaccion = {"Deposito","Retiro"};
		EntradaTipoTransaccion = new JComboBox<String>(listaTiposTransaccion);
		EntradaTipoTransaccion.setBounds(240, 138, 205, 27);
		contentPane.add(EntradaTipoTransaccion);
		
		JLabel lblNewLabel_1_1 = new JLabel("Monto");
		lblNewLabel_1_1.setBounds(96, 202, 132, 16);
		contentPane.add(lblNewLabel_1_1);
		
		EntradaMonto = new JTextField();
		EntradaMonto.setBounds(240, 197, 205, 26);
		contentPane.add(EntradaMonto);
		EntradaMonto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(96, 259, 349, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton BotonRealizarTransaccion = new JButton("Realizar");
		BotonRealizarTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionRealizarTransaccion();
			}
		});
		BotonRealizarTransaccion.setBounds(328, 489, 117, 29);
		contentPane.add(BotonRealizarTransaccion);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				MenuIngresarACuenta ventanMenuIngresarACuenta = new MenuIngresarACuenta(getNumeroCuenta());
				ventanMenuIngresarACuenta.setLocationRelativeTo(null);
				ventanMenuIngresarACuenta.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(96, 489, 117, 29);
		contentPane.add(BotonVolver);
	}

	public void AccionRealizarTransaccion(){
		double saldo = EncontrarSaldo();
		int tipoTransaccion = (((String) EntradaTipoTransaccion.getSelectedItem()).equals("Deposito")?1:2);
		String descripcion = EntradaDescripcion.getText();
		try {
			double monto = Double.parseDouble(EntradaMonto.getText());
			if (tipoTransaccion==2){
				if (monto<=saldo){
					ActualizarSaldoCuenta(saldo-monto, tipoTransaccion);
					IngresaNuevaTransaccion(tipoTransaccion, descripcion, monto);
				}else{
					lib.MostrarMensaje("No puedes retirar "+monto+" bs, tu saldo es de "+saldo+" bs");
				}
			}else if(tipoTransaccion==1){
				ActualizarSaldoCuenta(saldo+monto, tipoTransaccion);
				IngresaNuevaTransaccion(tipoTransaccion, descripcion, monto);
			}else{
				lib.MostrarMensaje(getName());
			}
		} catch (Exception e) {
			lib.MostrarMensaje("Ingrese el monto en el formato correcto");
		}
	}

	public double EncontrarSaldo(){
		String query = "SELECT numeroCuenta,saldo FROM CUENTAS_AHORRO WHERE numeroCuenta="+getNumeroCuenta();
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = instruccion.executeQuery();
			while (ejecutar.next()) {
				return ejecutar.getDouble("saldo");
			}
		} catch (Exception e) {
			lib.MostrarMensaje("Error: "+e.getMessage());
		}
		return 0.00;
	}

	public void ActualizarSaldoCuenta(Double saldoNuevo,int tipo){
		String query = "UPDATE CUENTAS_AHORRO SET saldo = ? WHERE numeroCuenta = ?";
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			instruccion.setDouble(1,saldoNuevo);
			instruccion.setInt(2, getNumeroCuenta());
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
			} else {
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}

	public void IngresaNuevaTransaccion(int tipoTransaccion,String descripcionTransaccion,double montoTransaccion){
		int numeroCuenta=getNumeroCuenta();
		int tipo = tipoTransaccion;
		String fecha=lib.Fecha();
		String descripcion = descripcionTransaccion;
		double monto = montoTransaccion;
		String query = "INSERT INTO TRANSACCIONES_CUENTA (numeroCuenta,tipo,fecha,descripcion,monto) values(?,?,?,?,?)";
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			instruccion.setInt(1, numeroCuenta);
			instruccion.setInt(2, tipo);
			instruccion.setString(3, fecha);
			instruccion.setString(4, descripcion);
			instruccion.setDouble(5, monto);
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
				lib.MostrarMensaje("Se completo la transaccion exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al realizar la transaccion");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}
}
