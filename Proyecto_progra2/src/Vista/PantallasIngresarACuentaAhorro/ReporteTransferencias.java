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
		setBounds(100, 100, 710, 664);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 82, 565, 219);
		contentPane.add(scrollPane);
		
		String[] atributos = {"De","Para","Fecha","Monto","Motivo"};

		Recibidos = LlenarTabla(1);
		TablaRecibidos = new JTable(Recibidos,atributos);
		scrollPane.setViewportView(TablaRecibidos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(76, 331, 565, 219);
		contentPane.add(scrollPane_1);
		
		Enviados=LlenarTabla(2);
		TablaEnviados = new JTable(Enviados,atributos);
		scrollPane_1.setViewportView(TablaEnviados);
		
		JLabel lblRecibidos = new JLabel("Recibidos");
		lblRecibidos.setBounds(327, 54, 61, 16);
		contentPane.add(lblRecibidos);
		
		JLabel lblEnviados = new JLabel("Enviados");
		lblEnviados.setBounds(327, 313, 61, 16);
		contentPane.add(lblEnviados);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new MenuIngresarACuenta(getNumeroCuenta()),base);
				dispose();
			}
		});
		BotonVolver.setBounds(327, 578, 117, 29);
		contentPane.add(BotonVolver);
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
