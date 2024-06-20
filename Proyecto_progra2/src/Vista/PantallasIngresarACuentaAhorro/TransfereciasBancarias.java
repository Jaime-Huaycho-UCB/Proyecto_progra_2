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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 663, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 697, 536);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 689, 111);
		panelRojo.setBackground(new Color(183, 0, 0));
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(10, 103, 650, 2);
		panelRojo.add(separadorTitulo);


		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("Numero de Cuenta:");
		lblNewLabel.setBounds(104, 138, 153, 16);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		panelFondo.add(lblNewLabel);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(104, 187, 137, 16);
		lblMonto.setForeground(Color.WHITE);
		lblMonto.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		panelFondo.add(lblMonto);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setBounds(104, 241, 137, 16);
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		panelFondo.add(lblMotivo);
		
		EntradaCuentaReceptora = new JTextField();
		EntradaCuentaReceptora.setBounds(277, 132, 214, 26);
		EntradaCuentaReceptora.setFont(new Font("Courier New", Font.ITALIC, 13));
		panelFondo.add(EntradaCuentaReceptora);
		EntradaCuentaReceptora.setColumns(10);
		
		EntradaMonto = new JTextField();
		EntradaMonto.setBounds(277, 181, 214, 26);
		EntradaMonto.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaMonto.setColumns(10);
		panelFondo.add(EntradaMonto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Courier New", Font.ITALIC, 14));
		scrollPane.setBounds(191, 239, 300, 155);
		panelFondo.add(scrollPane);
		
		EntradaMotivo = new JTextArea();
		scrollPane.setColumnHeaderView(EntradaMotivo);
		
		JButton BotonTransferir = new JButton("Realizar transferencia");
		BotonTransferir.setBounds(239, 420, 192, 43);
		BotonTransferir.setOpaque(true);
		BotonTransferir.setBackground(new Color(51, 152, 46));
		BotonTransferir.setForeground(Color.BLACK);
		BotonTransferir.setFocusPainted(false);
		BotonTransferir.setBorderPainted(false);
		BotonTransferir.setCursor(new Cursor(Cursor.HAND_CURSOR));

		BotonTransferir.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 10));
		BotonTransferir.setIcon(new ImageIcon(TransfereciasBancarias.class.getResource("/Imagenes/icono_realizar.png")));
		BotonTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionRealzarTransferencia();
				AccionVolver();
			}
		});
		panelFondo.add(BotonTransferir);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setBounds(501, 476, 126, 33);
		BotonVolver.setOpaque(true);
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.BLACK);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(SeleccionCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionVolver();
			}
		});
		panelFondo.add(BotonVolver);
		
		JLabel lblNewLabel_1 = new JLabel("TRANSFERENCIA BANCARIA");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(TransfereciasBancarias.class.getResource("/Imagenes/icono_trans.png")));
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(127, 45, 465, 60);
		panelRojo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 473, 103, 36);
		lblNewLabel_2.setIcon(new ImageIcon(TransfereciasBancarias.class.getResource("/Imagenes/2.jpg")));
		panelFondo.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Goliath National Bank");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(10, 18, 210, 13);
		panelRojo.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(501, 179, 45, 33);
		lblNewLabel_4.setIcon(new ImageIcon(TransfereciasBancarias.class.getResource("/Imagenes/icono_saldo1.png")));
		panelFondo.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(501, 134, 33, 20);
		lblNewLabel_5.setIcon(new ImageIcon(TransfereciasBancarias.class.getResource("/Imagenes/4.jpg")));
		panelFondo.add(lblNewLabel_5);
	}

	public void AccionRealzarTransferencia(){
		double saldoEmisor = EncontrarSaldo(getNumeroCuenta());
		double saldoReceptor = 0.00;
		try {
			int cuentaReceptora = Integer.parseInt(EntradaCuentaReceptora.getText());
			double monto = Double.parseDouble(EntradaMonto.getText());
			String motivo = EntradaMotivo.getText();
			if (monto<=saldoEmisor){
				IngresaNuevaTransferencia(cuentaReceptora, lib.Fecha(), monto, motivo);
				ActualizarSaldoCuenta(getNumeroCuenta(),saldoEmisor-monto);
				saldoReceptor=EncontrarSaldo(cuentaReceptora);
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
