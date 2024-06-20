package Vista.PantallasIngresarACuentaAhorro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ReporteTransferencias extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable TablaEnviados;
	private JTable TablaRecibidos;

	public Object[][] Recibidos;
	public Object[][] Enviados;

	public int numeroCuenta;
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public ReporteTransferencias(int numeroCuenta) {
		this.numeroCuenta=numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(6, 0, 698, 726);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 698, 111);
		panelRojo.setBackground(new Color(183, 0, 0));
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);

		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(10, 99, 650, 2);
		panelRojo.add(separadorTitulo);
		
		JLabel lblNewLabel = new JLabel("REPORTE DE TRANFERENCIAS");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel.setBounds(182, 55, 379, 32);
		panelRojo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Goliath National Bank");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 22, 174, 16);
		panelRojo.add(lblNewLabel_1);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 147, 565, 219);
		panelFondo.add(scrollPane);
		
		String[] atributos = {"De","Para","Fecha","Monto","Motivo"};

		Recibidos = LlenarTabla(1);
		TablaRecibidos = new JTable(Recibidos,atributos);
		scrollPane.setViewportView(TablaRecibidos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(76, 410, 565, 219);
		panelFondo.add(scrollPane_1);
		
		Enviados=LlenarTabla(2);
		TablaEnviados = new JTable(Enviados,atributos);
		scrollPane_1.setViewportView(TablaEnviados);
		
		JLabel lblRecibidos = new JLabel("RECIBIDOS\r\n");
		lblRecibidos.setBounds(316, 121, 105, 16);
		lblRecibidos.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelFondo.add(lblRecibidos);
		
		JLabel lblEnviados = new JLabel("Enviados");
		lblEnviados.setBounds(327, 384, 61, 16);
		panelFondo.add(lblEnviados);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setBounds(569, 684, 117, 29);
		BotonVolver.setOpaque(true);
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.BLACK);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(ReporteTransferencias.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuIngresarACuenta(getNumeroCuenta()),base);
				dispose();
			}
		});
		panelFondo.add(BotonVolver);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(6, 664, 117, 41);
		lblNewLabel_2.setIcon(new ImageIcon(ReporteTransferencias.class.getResource("/Imagenes/2.jpg")));
		panelFondo.add(lblNewLabel_2);
	}

	public Object[][] LlenarTabla(int tipo){
		int n =NumeroTuplas(tipo);
		String query = "";
		if (tipo==1){
			query="SELECT * FROM TRANSFERENCIAS WHERE cuentaReceptora = "+getNumeroCuenta();
		}else{
			query="SELECT * FROM TRANSFERENCIAS WHERE cuentaEmisora = "+getNumeroCuenta();
		}
		Object[][] tab = new Object[n][5];
		int f=0;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				tab[f][0]=ejecutar.getInt("cuentaEmisora");
				tab[f][1]=ejecutar.getInt("cuentaReceptora");
				tab[f][2]=ejecutar.getString("fecha");
				tab[f][3]=ejecutar.getDouble("monto");
				tab[f][4]=ejecutar.getString("motivo");
				f+=1;
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage()+"111111");
		}
		return tab;
	}

	public int NumeroTuplas(int tipo){
        int n = 0;
		String query = "";
		if (tipo==1){
			query="SELECT Count(0) FROM TRANSFERENCIAS WHERE cuentaReceptora = "+getNumeroCuenta();
		}else{
			query="SELECT Count(0) FROM TRANSFERENCIAS WHERE cuentaEmisora = "+getNumeroCuenta();
		}
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
