package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta.CrearCuentaAhorro;
import Vista.PantallasIngresarACuentaAhorro.SeleccionCuenta;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
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
		setBounds(100, 100, 868, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 924, 605);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBackground(new Color(183, 0, 0)); // Rojo oscuro
		panelRojo.setBounds(0, -11, 924, 127);
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);
		
		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(5, 113, 900, 2);
		panelRojo.add(separadorTitulo);


		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				base.CerrarConexion();
				dispose();
            }
        });
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE PERSONAS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(PantallaRegistroPersona.class.getResource("/Imagenes/4.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(0, 52, 905, 49);
		panelRojo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DOC. IDENTIDAD:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(52, 151, 141, 16);
		panelFondo.add(lblNewLabel_1);
		
		EntradaCarnet = new JTextField();
		EntradaCarnet.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaCarnet.setBounds(205, 146, 207, 26);
		panelFondo.add(EntradaCarnet);
		EntradaCarnet.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRES:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(52, 209, 141, 16);
		panelFondo.add(lblNewLabel_1_1);
		
		EntradaNombre = new JTextField();
		EntradaNombre.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaNombre.setColumns(10);
		EntradaNombre.setBounds(205, 204, 207, 26);
		panelFondo.add(EntradaNombre);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("F. NACIMIENTO:");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_3.setBounds(444, 268, 141, 16);
		panelFondo.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("GENERO:");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1_1_4.setBounds(444, 328, 141, 16);
		panelFondo.add(lblNewLabel_1_1_4);
		
		JButton BotonRegistrar = new JButton("Registrar");
		BotonRegistrar.setOpaque(true);
		BotonRegistrar.setBackground(Color.GREEN);
		BotonRegistrar.setForeground(Color.BLACK);
		BotonRegistrar.setFocusPainted(false);
		BotonRegistrar.setBorderPainted(false);
		BotonRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonRegistrar.setIcon(new ImageIcon(PantallaRegistroPersona.class.getResource("/Imagenes/10.png")));
		BotonRegistrar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
		BotonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionRegistrarPersona();
			}
		});
		BotonRegistrar.setBounds(508, 447, 187, 70);
		panelFondo.add(BotonRegistrar);
		
		JButton BotonVolver = new JButton("VOLVER");
		BotonVolver.setOpaque(true);
		BotonVolver.setBackground(new Color(192, 57, 43));
		BotonVolver.setForeground(Color.BLACK);
		BotonVolver.setFocusPainted(false);
		BotonVolver.setBorderPainted(false);
		BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BotonVolver.setIcon(new ImageIcon(SeleccionCuenta.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setIcon(new ImageIcon(PantallaRegistroPersona.class.getResource("/Imagenes/8.1.png")));
		BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
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
		BotonVolver.setBounds(189, 447, 187, 70);
		panelFondo.add(BotonVolver);
		
		EntradaDia = new JComboBox<String>(dias);
		EntradaDia.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaDia.setBounds(582, 264, 72, 27);
		panelFondo.add(EntradaDia);
		
		EntradaMes = new JComboBox<String>(meses);
		EntradaMes.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaMes.setBounds(646, 264, 72, 27);
		panelFondo.add(EntradaMes);
		EntradaMes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				EntradaDia.removeAllItems();
                ActualizarDias();
            }
        });
		
		EntradaAno = new JComboBox<String>(anos);
		EntradaAno.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaAno.setBounds(708, 264, 95, 27);
		panelFondo.add(EntradaAno);

		EntradaGenero = new JComboBox<String>();
		EntradaGenero.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaGenero.setBounds(582, 324, 221, 27);
		panelFondo.add(EntradaGenero);

		EntradaPais = new JComboBox<String>();
		EntradaPais.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaPais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActualizarListaCiudades();
            }
        });

		EntradaPais.setBounds(205, 268, 207, 27);
		panelFondo.add(EntradaPais);
		
		EntradaCiudad = new JComboBox<String>();
		EntradaCiudad.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaCiudad.setBounds(205, 324, 207, 27);
		panelFondo.add(EntradaCiudad);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("PATERNO:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_1_1.setBounds(444, 151, 141, 16);
		panelFondo.add(lblNewLabel_1_1_1_1);
		
		EntradaApellidoPaterno = new JTextField();
		EntradaApellidoPaterno.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaApellidoPaterno.setColumns(10);
		EntradaApellidoPaterno.setBounds(582, 147, 221, 26);
		panelFondo.add(EntradaApellidoPaterno);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("MATERNO:");
		lblNewLabel_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_2_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_2_1.setBounds(444, 209, 141, 16);
		panelFondo.add(lblNewLabel_1_1_2_1);
		
		EntradaApellidoMaterno = new JTextField();
		EntradaApellidoMaterno.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaApellidoMaterno.setColumns(10);
		EntradaApellidoMaterno.setBounds(582, 204, 221, 26);
		panelFondo.add(EntradaApellidoMaterno);
		
		JLabel lblNewLabel_1_1_5_1 = new JLabel("PAIS ORIGEN:");
		lblNewLabel_1_1_5_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_5_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_5_1.setBounds(52, 272, 141, 16);
		panelFondo.add(lblNewLabel_1_1_5_1);
		
		JLabel lblNewLabel_1_1_5_2 = new JLabel("CUIDAD:");
		lblNewLabel_1_1_5_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_5_2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_5_2.setBounds(52, 328, 141, 16);
		panelFondo.add(lblNewLabel_1_1_5_2);
		
		JLabel lblNewLabel_1_1_5_3 = new JLabel("DIRECCION:");
		lblNewLabel_1_1_5_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_5_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1_5_3.setBounds(52, 388, 141, 16);
		panelFondo.add(lblNewLabel_1_1_5_3);
		
		EntradaDireccion = new JTextField();
		EntradaDireccion.setFont(new Font("Courier New", Font.ITALIC, 13));
		EntradaDireccion.setColumns(10);
		EntradaDireccion.setBounds(205, 383, 598, 26);
		panelFondo.add(EntradaDireccion);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PantallaRegistroPersona.class.getResource("/Imagenes/2.jpg")));
		lblNewLabel_2.setBounds(758, 26, 104, 40);
		panelRojo.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Goliath National Bank");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(20, 22, 252, 23);
		panelRojo.add(lblNewLabel_3);
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
