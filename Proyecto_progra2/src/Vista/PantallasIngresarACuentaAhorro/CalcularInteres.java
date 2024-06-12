package Vista.PantallasIngresarACuentaAhorro;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;

public class CalcularInteres extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField SalidaSaldoActual;
	private JTextField SalidaInteres;
	public JComboBox<String> EntradaMes;
	public JComboBox<String> EntradaAno;

	public BaseDatos base = new BaseDatos();
	public Libreria lib = new Libreria();

	public int numeroCuenta;
	private JButton BotonVolver;
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public CalcularInteres(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 610);
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
		
		JLabel lblNewLabel = new JLabel("Calcula tu interes");
		lblNewLabel.setBounds(195, 47, 307, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo actual:");
		lblNewLabel_1.setBounds(131, 158, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		SalidaSaldoActual = new JTextField();
		SalidaSaldoActual.setEditable(false);
		SalidaSaldoActual.setBounds(240, 153, 130, 26);
		contentPane.add(SalidaSaldoActual);
		SalidaSaldoActual.setColumns(10);
		
		EntradaMes = new JComboBox<String>();
		EntradaMes.setBounds(195, 238, 70, 27);
		contentPane.add(EntradaMes);
		
		EntradaAno = new JComboBox<String>();
		EntradaAno.setBounds(277, 238, 93, 27);
		EntradaAno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActualizarEntradaFecha();
            }
        });
		contentPane.add(EntradaAno);
		
		SalidaInteres = new JTextField();
		SalidaInteres.setEditable(false);
		SalidaInteres.setBounds(240, 333, 130, 26);
		contentPane.add(SalidaInteres);
		SalidaInteres.setColumns(10);
		
		JButton BotonCalcular = new JButton("Calcular");
		BotonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionCalcularInteres();
			}
		});
		BotonCalcular.setBounds(257, 429, 117, 29);
		contentPane.add(BotonCalcular);
		SalidaSaldoActual.setText(EncontrarSaldo()+"");
		
		BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				lib.CambiarPantalla(new MenuIngresarACuenta(getNumeroCuenta()));
				dispose();
			}
		});
		BotonVolver.setBounds(78, 408, 117, 29);
		contentPane.add(BotonVolver);
		for (int i=lib.Fecha(3);i<=lib.Fecha(3)+30;i++){
			EntradaAno.addItem(i+"");
		}
	}

	public void AccionCalcularInteres(){
		double saldo = EncontrarSaldo();
		double interes = ObtenerInteres();
		int numeroMeses = ObtenerNumeroMeses();
		System.out.println(numeroMeses);
		double interesCalculado = saldo+(numeroMeses*(saldo*interes));
		interesCalculado=lib.LimitarDecimales(interesCalculado, 2);
		SalidaInteres.setText(interesCalculado+"");
	}

	public int ObtenerNumeroMeses(){
		int ano = Integer.parseInt((String) EntradaAno.getSelectedItem());
		int meses = Integer.parseInt((String) EntradaMes.getSelectedItem());
		int mesesTotales=0;
		if ((ano-lib.Fecha(3))==0){
			mesesTotales=meses-lib.Fecha(2);
		}else if ((ano-lib.Fecha(3))==1){
			mesesTotales+=12-lib.Fecha(2);
			mesesTotales+=meses;
		}else{
			mesesTotales+=12-lib.Fecha(2);
			mesesTotales+=12*(ano-lib.Fecha(3)-1);
			mesesTotales+=meses;
		}
		return mesesTotales;
	}

	public double ObtenerInteres(){
		String query = "SELECT * FROM TIPOS_CUENTA,CUENTAS_AHORRO WHERE TIPOS_CUENTA.id=CUENTAS_AHORRO.tipo and CUENTAS_AHORRO.numeroCuenta="+getNumeroCuenta();
		double interes=0.00;
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = instruccion.executeQuery();
			while (ejecutar.next()) {
				double entrada = ejecutar.getDouble("interes");
				String tipo = ejecutar.getString("tipoInteres");
				if (tipo.equals("Anual")){
					interes=((entrada/100.00)/12.00);
				}else{
					interes =(entrada/100.00);
				}
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
		return interes;
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

	public void ActualizarEntradaFecha(){
		int ano = Integer.parseInt((String) EntradaAno.getSelectedItem());
		int anoActual = lib.Fecha(3);
		int mesActual= lib.Fecha(2);
		EntradaMes.removeAllItems();
		if (anoActual==ano){
			for (int i=mesActual;i<=12;i++){
				EntradaMes.addItem(i+"");
			}
		}else{
			for (int i=1;i<=12;i++){
				EntradaMes.addItem(i+"");
			}
		}
	}
}
