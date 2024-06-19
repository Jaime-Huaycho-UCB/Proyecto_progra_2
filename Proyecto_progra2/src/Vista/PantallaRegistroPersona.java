package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta.CrearCuentaAhorro;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class PantallaRegistroPersona extends JFrame {

	public BaseDatos base = new BaseDatos();
	public Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaCarnet;
	private JTextField EntradaNombre;
	private JTextField EntradaApellidoPaterno;
	private JTextField EntradaApellidoMaterno;
	private JTextField EntradaDireccion;
	public JComboBox<String> EntradaDia;
    public JComboBox<String> EntradaMes;
    public JComboBox<String> EntradaAno;
    public JComboBox<String> EntradaGenero;
    public JComboBox<String> EntradaPais;
    public JComboBox<String> EntradaCiudad;

	public String[] dias = new String[1];
	public String[] meses=new String[1];
	public String[] anos=new String[1];

	public int n=0;
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}

	public PantallaRegistroPersona(int n) {
		this.n=n;
		InicializarFechas();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 583);
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
		
		JLabel lblNewLabel = new JLabel("Registro de personas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(6, 37, 905, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carnet de identidad");
		lblNewLabel_1.setBounds(94, 116, 141, 16);
		contentPane.add(lblNewLabel_1);
		
		EntradaCarnet = new JTextField();
		EntradaCarnet.setBounds(229, 111, 207, 26);
		contentPane.add(EntradaCarnet);
		EntradaCarnet.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres");
		lblNewLabel_1_1.setBounds(94, 174, 141, 16);
		contentPane.add(lblNewLabel_1_1);
		
		EntradaNombre = new JTextField();
		EntradaNombre.setColumns(10);
		EntradaNombre.setBounds(229, 169, 207, 26);
		contentPane.add(EntradaNombre);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Fecha de nacimiento");
		lblNewLabel_1_1_3.setBounds(486, 244, 141, 16);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Genero");
		lblNewLabel_1_1_4.setBounds(486, 310, 141, 16);
		contentPane.add(lblNewLabel_1_1_4);
		
		JButton BotonRegistrar = new JButton("Registrar");
		BotonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionRegistrarPersona();
			}
		});
		BotonRegistrar.setBounds(486, 429, 187, 70);
		contentPane.add(BotonRegistrar);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.CerrarConexion();
				if (getN()==1){
					CrearCuentaAhorro ventanCrearCuentaAhorro = new CrearCuentaAhorro();
					ventanCrearCuentaAhorro.setLocationRelativeTo(null);
					ventanCrearCuentaAhorro.setVisible(true);
					dispose();
				}else{
					
				}
			}
		});
		BotonVolver.setBounds(229, 429, 187, 70);
		contentPane.add(BotonVolver);
		
		EntradaDia = new JComboBox<String>(dias);
		EntradaDia.setBounds(621, 240, 72, 27);
		contentPane.add(EntradaDia);
		
		EntradaMes = new JComboBox<String>(meses);
		EntradaMes.setBounds(683, 240, 72, 27);
		contentPane.add(EntradaMes);
		EntradaMes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				EntradaDia.removeAllItems();
                ActualizarDias();
            }
        });
		
		EntradaAno = new JComboBox<String>(anos);
		EntradaAno.setBounds(747, 240, 95, 27);
		contentPane.add(EntradaAno);

		EntradaGenero = new JComboBox<String>();
		EntradaGenero.setBounds(621, 306, 221, 27);
		contentPane.add(EntradaGenero);

		EntradaPais = new JComboBox<String>();
		EntradaPais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActualizarListaCiudades();
            }
        });

		EntradaPais.setBounds(229, 241, 207, 27);
		contentPane.add(EntradaPais);
		
		EntradaCiudad = new JComboBox<String>();
		EntradaCiudad.setBounds(229, 307, 207, 27);
		contentPane.add(EntradaCiudad);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Apellido paterno");
		lblNewLabel_1_1_1_1.setBounds(486, 115, 141, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		EntradaApellidoPaterno = new JTextField();
		EntradaApellidoPaterno.setColumns(10);
		EntradaApellidoPaterno.setBounds(621, 110, 221, 26);
		contentPane.add(EntradaApellidoPaterno);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Apellido materno");
		lblNewLabel_1_1_2_1.setBounds(486, 174, 141, 16);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		EntradaApellidoMaterno = new JTextField();
		EntradaApellidoMaterno.setColumns(10);
		EntradaApellidoMaterno.setBounds(621, 169, 221, 26);
		contentPane.add(EntradaApellidoMaterno);
		
		JLabel lblNewLabel_1_1_5_1 = new JLabel("Pais");
		lblNewLabel_1_1_5_1.setBounds(94, 245, 141, 16);
		contentPane.add(lblNewLabel_1_1_5_1);
		
		JLabel lblNewLabel_1_1_5_2 = new JLabel("Ciudad");
		lblNewLabel_1_1_5_2.setBounds(94, 311, 141, 16);
		contentPane.add(lblNewLabel_1_1_5_2);
		
		JLabel lblNewLabel_1_1_5_3 = new JLabel("Direccion");
		lblNewLabel_1_1_5_3.setBounds(94, 382, 141, 16);
		contentPane.add(lblNewLabel_1_1_5_3);
		
		EntradaDireccion = new JTextField();
		EntradaDireccion.setColumns(10);
		EntradaDireccion.setBounds(229, 377, 613, 26);
		contentPane.add(EntradaDireccion);
		LLenarListaGeneros();
		ActualizarListaPaises();
		
	}

	public void AccionRegistrarPersona(){
		String query = "INSERT INTO PERSONAS (ci,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,idGenero,idPais,idCiudad,direccion) values (?,?,?,?,?,?,?,?,?)";
		try {
			int ci = Integer.parseInt(EntradaCarnet.getText());
			if (!(CiExistente(ci))){
				String nombre = Cadena(EntradaNombre);
				String apellidoPaterno = Cadena(EntradaApellidoPaterno);
				String apellidoMaterno = Cadena(EntradaApellidoMaterno);
				String direccion = Cadena(EntradaDireccion);
				if (nombre.length()!=0 && apellidoPaterno.length()!=0 && apellidoPaterno.length()!=0 && direccion.length()!=0){
					int dia = Integer.parseInt((String) EntradaDia.getSelectedItem());
					int mes = Integer.parseInt((String) EntradaMes.getSelectedItem());
					int ano = Integer.parseInt((String) EntradaAno.getSelectedItem());
					String fechaNacimiento = ano+"-"+(mes<10?"0":"")+mes+"-"+(dia<10?"0":"")+dia;
					int idGenero = EncontrarId((String) EntradaGenero.getSelectedItem(),"GENEROS");
					int idPais = EncontrarId((String) EntradaPais.getSelectedItem(),"PAISES");
					int idCiudad = EncontrarId((String) EntradaCiudad.getSelectedItem(),"CIUDADES");
					try {
						PreparedStatement consulta = base.getConexion().prepareStatement(query);
						consulta.setInt(1, ci);
						consulta.setString(2, nombre);
						consulta.setString(3, apellidoPaterno);
						consulta.setString(4, apellidoMaterno);
						consulta.setString(5, fechaNacimiento);
						consulta.setInt(6, idGenero);
						consulta.setInt(7, idPais);
						consulta.setInt(8, idCiudad);
						consulta.setString(9, direccion);
						int ingresado = consulta.executeUpdate();
						if (ingresado > 0) {
							lib.MostrarMensaje("Se completo el registro exitosamente");
						} else {
							lib.MostrarMensaje("Fallo al insertar los datos.");
						}
					} catch (Exception e) {
						lib.MostrarMensaje(e.getMessage());
					}	
				}else{
					lib.MostrarMensaje("ADVERTENCIA: No puede ingresar valores vacios");
				}
			}else{
				lib.MostrarMensaje("El carnet de identidad ingresado ya existe");
			}
		} catch (NumberFormatException a){
			lib.MostrarMensaje("Ingrese los datos en el formato correcto");
		}
	}

	public String Cadena(JTextField entrada){
		String salida = entrada.getText();
		if (salida.length()>0){
			return salida;
		}else{
			return "";
		}
	}
	
	public boolean CiExistente(int ci){
		String query = "SELECT Count(0) FROM PERSONAS WHERE ci = "+ci;
		try {
			Statement consulta = base.getConexion().createStatement();
			ResultSet ejecutar = consulta.executeQuery(query);
			if (ejecutar.next()){
				return (ejecutar.getInt(1)!=0? true : false);
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	public int EncontrarId(String atributo,String tabla){
		String query = "SELECT * FROM "+tabla+" WHERE nombre = ?";
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			consulta.setString(1, atributo);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				return ejecutar.getInt("id");
			}
		} catch (Exception e) {
			lib.MostrarMensaje("Error al encontrar genero");
		}
		return 0;
	}

	public void LLenarListaGeneros(){
		String query = "SELECT * FROM GENEROS";
		try {
			Statement declaracion = base.getConexion().createStatement();
			ResultSet consulta = declaracion.executeQuery(query);
			while (consulta.next()) {
				EntradaGenero.addItem(consulta.getString("nombre"));
			}
		} catch (Exception e) {
		}
	}

	public void ActualizarListaCiudades(){
		EntradaCiudad.removeAllItems();
		String query = "select PAISES.nombre As nombrePais,CIUDADES.nombre As nombreCiudad FROM CIUDADES_PAIS,PAISES,CIUDADES where CIUDADES_PAIS.idPAis=PAISES.id and CIUDADES_PAIS.idCiudad=CIUDADES.id and PAISES.id = ?";
		int idPais = EncontrarId((String) EntradaPais.getSelectedItem(),"PAISES");
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			consulta.setInt(1,idPais);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				EntradaCiudad.addItem(ejecutar.getString("nombreCiudad"));
				System.out.println("si");
			}
			System.out.println("ffffff");
		} catch (Exception e) {
			lib.MostrarMensaje("Error al encontrar");
		}
	}

	public void ActualizarListaPaises(){
		String query = "SELECT * FROM PAISES";
		try {
			Statement declaracion = base.getConexion().createStatement();
			ResultSet consulta = declaracion.executeQuery(query);
			while (consulta.next()) {
				EntradaPais.addItem(consulta.getString("nombre"));
			}
		} catch (Exception e) {
		}
	}

	public void InicializarFechas(){
		String[] meses2=new String[12];
		String[] anos2=new String[20];
		String[] dias2=new String[31];
		for (int i=0;i<31;i++){
			dias2[i]=""+(i+1);
		}
		this.dias=dias2;
		for (int i=0;i<12;i++){
			meses2[i]=""+(i+1);
		}
		for (int i=0;i<20;i++){
			anos2[i]=""+(lib.Fecha(3)-17-(i+1));
		}				
	    this.meses=meses2;
		this.anos=anos2;
		this.dias=dias2;
	}

	public void ActualizarDias(){
		int numMes = Integer.parseInt((String) EntradaMes.getSelectedItem());
		int n=0;
		if (numMes==1 || numMes==3 || numMes==5 || numMes==7 || numMes==8 || numMes==10 || numMes==12) {
			n=31;
		}else if (numMes==4 || numMes==6 || numMes==9 || numMes==11){
			n=30;
		}else{
			n=28;
		}
		for (int i=0;i<n;i++){
			EntradaDia.addItem(""+(i+1));
		}
	}
}
