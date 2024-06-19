package Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import Librerias.Libreria;
import Modelo.BaseDatos;
import javax.swing.ImageIcon;

public class ReporteCuentasAhorro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public BaseDatos base = new BaseDatos();
	public Libreria lib = new Libreria();
	private JTable table;

	public Object[][] datos;
	private JButton BotonVolver;

	public ReporteCuentasAhorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 581);
		setTitle("Reporte de Cuentas de Ahorro");

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 113)); // Fondo rosa bajito
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

		JLabel lblTitulo = new JLabel("REPORTE DE CUENTAS DE AHORRO\r\n");
		lblTitulo.setIcon(new ImageIcon(ReporteCuentasAhorro.class.getResource("/Imagenes/7.jpg")));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 24));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(114, 12, 596, 50);
		contentPane.add(lblTitulo);

		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(new Color(255, 255, 255));
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(10, 72, 814, 2);
		contentPane.add(separadorTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(254, 255, 255));
		scrollPane.setBackground(new Color(254, 255, 255));
		scrollPane.setBounds(10, 85, 814, 400);
		contentPane.add(scrollPane);

		String[] atributos = { "Número de cuenta", "Titular", "Tipo de cuenta", "Fecha de apertura",
				"Saldo disponible" };
		datos = LlenarTabla();
		table = new JTable(datos, atributos);
		scrollPane.setViewportView(table);

		JLabel separadorInferior = new JLabel();
		separadorInferior.setForeground(new Color(255, 255, 255));
		separadorInferior.setBackground(new Color(255, 255, 255));
		separadorInferior.setOpaque(true);
		separadorInferior.setBounds(10, 495, 814, 2);
		contentPane.add(separadorInferior);

		BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuOpcionesCuentaAhorro(),base);
				dispose();
			}
		});
		BotonVolver.setForeground(Color.WHITE);
		BotonVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		BotonVolver.setBackground(new Color(0, 102, 204)); // Azul
		BotonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonVolver.setBounds(363, 510, 117, 30);
		contentPane.add(BotonVolver);
	}

	public Object[][] LlenarTabla() {
		int n = NumeroTuplas();
		String query = "select CUENTAS_AHORRO.numeroCuenta,PERSONAS.nombre,PERSONAS.apellidoPaterno,PERSONAS.apellidoMaterno,TIPOS_CUENTA.nombre as Tipo,CUENTAS_AHORRO.fechaApertura,CUENTAS_AHORRO.saldo\n"+
				"FROM CUENTAS_AHORRO,TIPOS_CUENTA,PERSONAS\n" +
				"where CUENTAS_AHORRO.ciPersona = PERSONAS.ci and TIPOS_CUENTA.id=CUENTAS_AHORRO.tipo;";
		Object[][] tab = new Object[n][5];
		int f = 0;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				tab[f][0] = ejecutar.getString("numeroCuenta");
				tab[f][1] = ejecutar.getString("nombre") + " " + ejecutar.getString("apellidoPaterno") + " "
						+ ejecutar.getString("apellidoMaterno");
				tab[f][2] = ejecutar.getString("Tipo");
				tab[f][3] = ejecutar.getString("fechaApertura");
				tab[f][4] = ejecutar.getString("Saldo");
				f += 1;
				System.out.println(f);
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
		return tab;
	}

	public int NumeroTuplas() {
		int n = 0;
		String query = "select Count(0) " +
				"FROM CUENTAS_AHORRO,TIPOS_CUENTA,PERSONAS " +
				"where CUENTAS_AHORRO.ciPersona = PERSONAS.ci and TIPOS_CUENTA.id=CUENTAS_AHORRO.tipo";
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
