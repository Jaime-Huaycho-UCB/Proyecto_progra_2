package Vista.PantallasIngresarACuentaAhorro;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallasAdministracionPrograma.PantallasTIposCuenta.MenuTipoCuenta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public CalcularInteres(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 689, 429);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBackground(new Color(183, 0, 0)); // Rojo oscuro
		panelRojo.setBounds(0, -11, 689, 111);
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(10, 99, 650, 2);
		panelRojo.add(separadorTitulo);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("CALCULA TU INTERES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(194, 30, 307, 65);
		panelRojo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo actual:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(144, 114, 97, 16);
		panelFondo.add(lblNewLabel_1);
		
		SalidaSaldoActual = new JTextField();
		SalidaSaldoActual.setBackground(Color.WHITE);
		SalidaSaldoActual.setEditable(false);
		SalidaSaldoActual.setBounds(277, 112, 202, 26);
		panelFondo.add(SalidaSaldoActual);
		SalidaSaldoActual.setColumns(10);
		
		EntradaMes = new JComboBox<String>();
		EntradaMes.setBounds(277, 164, 202, 27);
		panelFondo.add(EntradaMes);
		
		EntradaAno = new JComboBox<String>();
		EntradaAno.setBounds(277, 217, 202, 27);
		EntradaAno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActualizarEntradaFecha();
            }
        });
		panelFondo.add(EntradaAno);
		
		SalidaInteres = new JTextField();
		SalidaInteres.setBackground(Color.WHITE);
		SalidaInteres.setEditable(false);
		SalidaInteres.setBounds(172, 277, 291, 26);
		panelFondo.add(SalidaInteres);
		SalidaInteres.setColumns(10);
		
		JButton BotonCalcular = new JButton("Calcular");
		BotonCalcular.setOpaque(true);
		BotonCalcular.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonCalcular.setBackground(Color.GREEN);
		BotonCalcular.setForeground(Color.BLACK);
		BotonCalcular.setFocusPainted(false);
		BotonCalcular.setBorderPainted(false);
		BotonCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));

		BotonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionCalcularInteres();
			}
		});
		BotonCalcular.setBounds(251, 319, 117, 29);
		panelFondo.add(BotonCalcular);
		SalidaSaldoActual.setText(EncontrarSaldo()+"");
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.BLACK);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(CalcularInteres.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				lib.CambiarPantalla(new MenuIngresarACuenta(getNumeroCuenta()));
				dispose();
			}
		});
		BotonVolver.setBounds(499, 342, 150, 39);
		panelFondo.add(BotonVolver);
		
		lblNewLabel_2 = new JLabel("MES");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(144, 169, 45, 13);
		panelFondo.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ANO");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(144, 222, 45, 13);
		panelFondo.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(CalcularInteres.class.getResource("/Imagenes/2.jpg")));
		lblNewLabel_4.setBounds(545, 12, 101, 48);
		panelRojo.add(lblNewLabel_4);
		
		lblNewLabel_9 = new JLabel("Goliath National Bank");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_9.setBounds(22, 28, 162, 13);
		panelRojo.add(lblNewLabel_9);
		
		lblNewLabel_5 = new JLabel("Goliath National Bank");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 10, 179, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(CalcularInteres.class.getResource("/Imagenes/icono_saldo1.png")));
		lblNewLabel_6.setBounds(489, 102, 45, 29);
		panelFondo.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(CalcularInteres.class.getResource("/Imagenes/42614320-calendario-icono-de-la-línea-de-arte-mes-para-aplicaciones-y-sitios-web.jpg")));
		lblNewLabel_7.setBounds(489, 164, 45, 27);
		panelFondo.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(CalcularInteres.class.getResource("/Imagenes/42614320-calendario-icono-de-la-línea-de-arte-mes-para-aplicaciones-y-sitios-web.jpg")));
		lblNewLabel_8.setBounds(489, 217, 45, 27);
		panelFondo.add(lblNewLabel_8);
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
