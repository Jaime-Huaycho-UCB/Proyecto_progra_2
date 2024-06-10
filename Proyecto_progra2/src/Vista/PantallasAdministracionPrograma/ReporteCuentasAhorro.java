package Vista.PantallasAdministracionPrograma;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.*;

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
		scrollPane.setBounds(98, 132, 668, 315);
		contentPane.add(scrollPane);
		
		String[] atributos = {"Numero de cuenta", "Titular", "Tipo de cuenta","Fecha de apertura","Saldo disponible"};
		datos = LlenarTabla(); 
		table = new JTable(datos,atributos);
		scrollPane.setViewportView(table);
		
		BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				PantallaAdministracionPrograma ventanaPantallaAdministracionPrograma = new PantallaAdministracionPrograma();
				ventanaPantallaAdministracionPrograma.setLocationRelativeTo(null);
				ventanaPantallaAdministracionPrograma.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(362, 486, 117, 29);
		contentPane.add(BotonVolver);
	}

	public Object[][] LlenarTabla(){
		int n =NumeroTuplas();
		String query = "select CUENTAS_AHORRO.numeroCuenta,PERSONAS.nombre,PERSONAS.apellidoPaterno,PERSONAS.apellidoMaterno,TIPOS_CUENTA.nombre as Tipo,CUENTAS_AHORRO.fechaApertura,CUENTAS_AHORRO.saldo\n" + //
						"FROM CUENTAS_AHORRO,TIPOS_CUENTA,PERSONAS\n" + //
						"where CUENTAS_AHORRO.ciPersona = PERSONAS.ci and TIPOS_CUENTA.id=CUENTAS_AHORRO.tipo;";
		Object[][] tab = new Object[n][5];
		int f=0;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				tab[f][0]=ejecutar.getString("numeroCuenta");
				tab[f][1]=ejecutar.getString("nombre")+" "+ejecutar.getString("apellidoPaterno")+" "+ejecutar.getString("apellidoMaterno");
				tab[f][2]=ejecutar.getString("Tipo");
				tab[f][3]=ejecutar.getString("fechaApertura");
				tab[f][4]=ejecutar.getString("Saldo");
				f+=1;
				System.out.println(f);
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage()+"111111");
		}
		return tab;
	}
	public int NumeroTuplas(){
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
