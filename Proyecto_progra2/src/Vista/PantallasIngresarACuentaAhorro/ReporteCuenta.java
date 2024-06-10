package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class ReporteCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField SalidaNumeroCuenta;
	private JTextField SalidaCi;
	private JTextField SalidaTipoCuenta;
	private JTextField SalidaTipoInteres;
	private JTextField SalidaFechaApertura;
	private JTextField SalidaInteres;
	private JTextField SalidaSaldo;
	private JTable TablaDepositos;
	private JTable TablaRetiros;

	public BaseDatos base = new BaseDatos();
	public Libreria lib = new Libreria();

	public Object[][] depositos;
	public Object[][] retiros;

	public int numeroCuenta;
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public ReporteCuenta(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 734);
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
		
		JLabel lblNewLabel = new JLabel("Reporte de cuenta");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 18, 817, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de cuenta:");
		lblNewLabel_1.setBounds(120, 126, 141, 16);
		contentPane.add(lblNewLabel_1);
		
		SalidaNumeroCuenta = new JTextField();
		SalidaNumeroCuenta.setEditable(false);
		SalidaNumeroCuenta.setBounds(273, 121, 130, 26);
		contentPane.add(SalidaNumeroCuenta);
		SalidaNumeroCuenta.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CI:");
		lblNewLabel_1_1.setBounds(436, 126, 141, 16);
		contentPane.add(lblNewLabel_1_1);
		
		SalidaCi = new JTextField();
		SalidaCi.setEditable(false);
		SalidaCi.setColumns(10);
		SalidaCi.setBounds(589, 121, 130, 26);
		contentPane.add(SalidaCi);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tipo de cuenta:");
		lblNewLabel_1_2.setBounds(120, 185, 141, 16);
		contentPane.add(lblNewLabel_1_2);
		
		SalidaTipoCuenta = new JTextField();
		SalidaTipoCuenta.setEditable(false);
		SalidaTipoCuenta.setColumns(10);
		SalidaTipoCuenta.setBounds(273, 180, 130, 26);
		contentPane.add(SalidaTipoCuenta);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo de interes:");
		lblNewLabel_1_1_1.setBounds(436, 185, 141, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		SalidaTipoInteres = new JTextField();
		SalidaTipoInteres.setEditable(false);
		SalidaTipoInteres.setColumns(10);
		SalidaTipoInteres.setBounds(589, 180, 130, 26);
		contentPane.add(SalidaTipoInteres);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha de apertura");
		lblNewLabel_1_3.setBounds(120, 252, 141, 16);
		contentPane.add(lblNewLabel_1_3);
		
		SalidaFechaApertura = new JTextField();
		SalidaFechaApertura.setEditable(false);
		SalidaFechaApertura.setColumns(10);
		SalidaFechaApertura.setBounds(273, 247, 130, 26);
		contentPane.add(SalidaFechaApertura);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Interes:");
		lblNewLabel_1_1_2.setBounds(436, 252, 141, 16);
		contentPane.add(lblNewLabel_1_1_2);
		
		SalidaInteres = new JTextField();
		SalidaInteres.setEditable(false);
		SalidaInteres.setColumns(10);
		SalidaInteres.setBounds(589, 247, 130, 26);
		contentPane.add(SalidaInteres);
		
		JLabel lblNewLabel_1_4 = new JLabel("Saldo");
		lblNewLabel_1_4.setBounds(120, 320, 141, 16);
		contentPane.add(lblNewLabel_1_4);
		
		SalidaSaldo = new JTextField();
		SalidaSaldo.setEditable(false);
		SalidaSaldo.setColumns(10);
		SalidaSaldo.setBounds(273, 315, 130, 26);
		contentPane.add(SalidaSaldo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 417, 293, 170);
		contentPane.add(scrollPane);
		
		String[] atributoDepositos = {"Fecha transaccion", "Monto", "Descripcion"};
		depositos = LlenarTabla(1);    

		TablaDepositos = new JTable(depositos,atributoDepositos);
		scrollPane.setViewportView(TablaDepositos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(426, 417, 293, 170);
		contentPane.add(scrollPane_1);
		
		String[] atributoRetiros = {"Fecha transaccion", "Monto", "Descripcion"};
		retiros = LlenarTabla(2);  

		TablaRetiros = new JTable(retiros,atributoRetiros);
		scrollPane_1.setViewportView(TablaRetiros);
		
		JLabel lblNewLabel_2 = new JLabel("Depositos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(120, 389, 293, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Retiros");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(426, 389, 293, 16);
		contentPane.add(lblNewLabel_2_1);
		
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
		BotonVolver.setBounds(360, 617, 117, 29);
		contentPane.add(BotonVolver);
		LlenarDatos();
	}

	public void LlenarDatos(){
		System.out.println("fase 1");
		String query = "select PERSONAS.nombre,PERSONAS.apellidoPaterno,PERSONAS.apellidoMaterno,CUENTAS_AHORRO.numeroCuenta,PERSONAS.ci,TIPOS_CUENTA.nombre as nombreTipoCuenta,TIPOS_CUENTA.tipoInteres,CUENTAS_AHORRO.fechaApertura,TIPOS_CUENTA.interes,CUENTAS_AHORRO.saldo "+
					"from CUENTAS_AHORRO,PERSONAS,TIPOS_CUENTA "+
					"where CUENTAS_AHORRO.ciPersona=PERSONAS.ci and CUENTAS_AHORRO.numeroCuenta="+getNumeroCuenta();
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {

				SalidaNumeroCuenta.setText(""+ejecutar.getInt("numeroCuenta"));
				SalidaCi.setText(""+ejecutar.getInt("ci"));
				SalidaTipoCuenta.setText(""+ejecutar.getString("nombreTipoCuenta"));
				SalidaTipoInteres.setText(""+ejecutar.getString("tipoInteres"));
				SalidaFechaApertura.setText(""+ejecutar.getString("fechaApertura"));
				SalidaInteres.setText(""+ejecutar.getDouble("interes"));
				SalidaSaldo.setText(""+ejecutar.getDouble("saldo"));
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
			e.printStackTrace();
		}
	}

	public Object[][] LlenarTabla(int tipo){
		int n =NumeroTuplas(tipo);
		String query = "SELECT * FROM  TRANSACCIONES_CUENTA WHERE TRANSACCIONES_CUENTA.tipo="+tipo+" and TRANSACCIONES_CUENTA.numeroCuenta="+getNumeroCuenta();
		Object[][] tab = new Object[n][3];
		int f=0;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				tab[f][0]=ejecutar.getString("fecha");
				tab[f][1]=ejecutar.getDouble("monto");
				tab[f][2]=ejecutar.getString("descripcion");
				f+=1;
				System.out.println(f);
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage()+"111111");
		}
		return tab;
	}
	public int NumeroTuplas(int tipo){
        int n = 0;
		String query = "SELECT Count(0) FROM TRANSACCIONES_CUENTA WHERE TRANSACCIONES_CUENTA.tipo="+tipo+" and TRANSACCIONES_CUENTA.numeroCuenta="+getNumeroCuenta();
        try {
			Statement consulta = base.getConexion().createStatement();
            ResultSet ejecutar = consulta.executeQuery(query);
            if (ejecutar.next()) {
                n = ejecutar.getInt(1);
            }
        } catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
        }
        return n;
    }	
}
