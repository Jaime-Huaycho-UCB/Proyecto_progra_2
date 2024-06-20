package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 538, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 559, 512);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 553, 111);
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
		
		JLabel lblNewLabel = new JLabel("REALIZAR UNA TRANSACCION ");
		lblNewLabel.setIcon(new ImageIcon(RealizarTransaccion.class.getResource("/Imagenes/icono_tranferencia.jpg")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(10, 32, 526, 79);
		panelRojo.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 239, 349, 167);
		panelFondo.add(scrollPane);
		
		EntradaDescripcion = new JTextArea();
		EntradaDescripcion.setFont(new Font("Courier New", Font.ITALIC, 13));
		scrollPane.setViewportView(EntradaDescripcion);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de transaccion:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(49, 133, 171, 16);
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		panelFondo.add(lblNewLabel_1);
		
		String[] listaTiposTransaccion = {"Deposito","Retiro"};
		EntradaTipoTransaccion = new JComboBox<String>(listaTiposTransaccion);
		EntradaTipoTransaccion.setFont(new Font("Courier New", Font.PLAIN, 13));
		EntradaTipoTransaccion.setBounds(219, 129, 205, 27);
		panelFondo.add(EntradaTipoTransaccion);
		
		JLabel lblNewLabel_1_1 = new JLabel("Monto:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(37, 180, 132, 16);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		panelFondo.add(lblNewLabel_1_1);
		
		EntradaMonto = new JTextField();
		EntradaMonto.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaMonto.setBounds(191, 177, 205, 26);
		panelFondo.add(EntradaMonto);
		EntradaMonto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(37, 213, 349, 16);
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		panelFondo.add(lblNewLabel_2);
		
		JButton BotonRealizarTransaccion = new JButton("ACEPTAR");
		BotonRealizarTransaccion.setOpaque(true);
		BotonRealizarTransaccion.setBackground(new Color(51, 152, 46));
		BotonRealizarTransaccion.setForeground(Color.BLACK);
		BotonRealizarTransaccion.setFocusPainted(false);
		BotonRealizarTransaccion.setBorderPainted(false);
		BotonRealizarTransaccion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonRealizarTransaccion.setIcon(new ImageIcon(RealizarTransaccion.class.getResource("/Imagenes/icono_realizar.png")));
		BotonRealizarTransaccion.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		BotonRealizarTransaccion.setBounds(200, 416, 154, 29);
		BotonRealizarTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionRealizarTransaccion();
			}
		});
		panelFondo.add(BotonRealizarTransaccion);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.BLACK);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setBounds(382, 458, 132, 32);
		BotonVolver.setIcon(new ImageIcon(RealizarTransaccion.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				MenuIngresarACuenta ventanMenuIngresarACuenta = new MenuIngresarACuenta(getNumeroCuenta());
				ventanMenuIngresarACuenta.setLocationRelativeTo(null);
				ventanMenuIngresarACuenta.setVisible(true);
				dispose();
			}
		});
		panelFondo.add(BotonVolver);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 449, 103, 50);
		lblNewLabel_3.setIcon(new ImageIcon(RealizarTransaccion.class.getResource("/Imagenes/2.jpg")));
		panelFondo.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Goliath National Bank");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(20, 20, 174, 13);
		panelRojo.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(436, 124, 45, 32);
		lblNewLabel_5.setIcon(new ImageIcon(RealizarTransaccion.class.getResource("/Imagenes/icono_transferencia2.0.jpg")));
		panelFondo.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(431, 175, 32, 29);
		lblNewLabel_6.setIcon(new ImageIcon(RealizarTransaccion.class.getResource("/Imagenes/icono_saldo.png")));
		panelFondo.add(lblNewLabel_6);
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
