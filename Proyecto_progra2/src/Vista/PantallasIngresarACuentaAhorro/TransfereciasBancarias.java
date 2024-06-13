package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransfereciasBancarias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaCuentaReceptora;
	private JTextField EntradaMonto;
	public JTextArea EntradaMotivo;

	public BaseDatos base = new BaseDatos();
	public Libreria lib = new Libreria();

	public int numeroCuenta;
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public TransfereciasBancarias(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 574);
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
		
		JLabel lblNewLabel = new JLabel("Numero de cuenta:");
		lblNewLabel.setBounds(128, 125, 137, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(128, 186, 137, 16);
		contentPane.add(lblMonto);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setBounds(128, 242, 137, 16);
		contentPane.add(lblMotivo);
		
		EntradaCuentaReceptora = new JTextField();
		EntradaCuentaReceptora.setBounds(277, 120, 130, 26);
		contentPane.add(EntradaCuentaReceptora);
		EntradaCuentaReceptora.setColumns(10);
		
		EntradaMonto = new JTextField();
		EntradaMonto.setColumns(10);
		EntradaMonto.setBounds(277, 181, 130, 26);
		contentPane.add(EntradaMonto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 294, 300, 155);
		contentPane.add(scrollPane);
		
		EntradaMotivo = new JTextArea();
		scrollPane.setViewportView(EntradaMotivo);
		
		JButton BotonTransferir = new JButton("Realizar transferencia");
		BotonTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionRealzarTransferencia();
				AccionVolver();
			}
		});
		BotonTransferir.setBounds(389, 475, 117, 29);
		contentPane.add(BotonTransferir);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionVolver();
			}
		});
		BotonVolver.setBounds(139, 475, 117, 29);
		contentPane.add(BotonVolver);
	}

	public void AccionRealzarTransferencia(){
		double saldoEmisor = EncontrarSaldo(getNumeroCuenta());
		double saldoReceptor = 0.00;
		try {
			int cuentaReceptora = Integer.parseInt(EntradaCuentaReceptora.getText());
			double monto = Double.parseDouble(EntradaMonto.getText());
			String motivo = EntradaMotivo.getText();
			saldoReceptor=EncontrarSaldo(cuentaReceptora);
			if (monto<=saldoEmisor){
				IngresaNuevaTransferencia(cuentaReceptora, lib.Fecha(), monto, motivo);
				ActualizarSaldoCuenta(getNumeroCuenta(),saldoEmisor-monto);
				ActualizarSaldoCuenta(cuentaReceptora, saldoReceptor+monto);
			}else{
				lib.MostrarMensaje("No puedes retirar "+monto+" bs, tu saldo es de "+saldoEmisor+" bs");
			}
		} catch (NumberFormatException e) {
			lib.MostrarMensaje("Respeta los formatos de entrada");
		}
	}

	public double EncontrarSaldo(int numeroCuenta){
		String query = "SELECT numeroCuenta,saldo FROM CUENTAS_AHORRO WHERE numeroCuenta="+numeroCuenta;
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

	public void IngresaNuevaTransferencia(int cuentaReceptora,String fecha,double monto,String motivo){
		String query = "INSERT INTO TRANSFERENCIAS (cuentaEmisora,cuentaReceptora,fecha,monto,motivo) values (?,?,?,?,?)";
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			instruccion.setInt(1, getNumeroCuenta());
			instruccion.setInt(2, cuentaReceptora);
			instruccion.setString(3, fecha);
			instruccion.setDouble(4, monto);
			instruccion.setString(5, motivo);
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
				lib.MostrarMensaje("Se completo la Transferencia exitosamente");
			} else {
				lib.MostrarMensaje("Fallo al realizar la transferencia");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}

	public void ActualizarSaldoCuenta(int numeroCuenta,double saldoNuevo){
		String query = "UPDATE CUENTAS_AHORRO SET saldo = "+saldoNuevo+" WHERE numeroCuenta = "+numeroCuenta;
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
			} else {
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}

	public void AccionVolver(){
		base.CerrarConexion();
		lib.CambiarPantalla(new MenuIngresarACuenta(getNumeroCuenta()));
		dispose();
	}
}
