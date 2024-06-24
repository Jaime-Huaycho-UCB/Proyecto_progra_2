package Vista.PantallasTreEnRaya;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Juego extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JButton A1;
	public JButton A2;
	public JButton A3;
	public JButton B1;
	public JButton B2;
	public JButton B3;
	public JButton C1;
	public JButton C2;
	public JButton C3;

	private Jugador jugador1;
	private Jugador jugador2;
	private int numeroRondas;
	private int ronda;
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
	public int getNumeroRondas() {
		return numeroRondas;
	}
	public void setNumeroRondas(int numeroRondas) {
		this.numeroRondas = numeroRondas;
	}
	public int getRonda() {
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	private Jugador turno;
	public Jugador getTurno() {
		return turno;
	}
	public void setTurno(Jugador turno) {
		this.turno = turno;
	}

	public String[][] tablero = new String[3][3];

	public int jugadas = 1;
	private JLabel SalidaTurno;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public Juego(Jugador jugador1,Jugador jugador2,int numeroRondas,int ronda) {
		this.jugador1=jugador1;
		this.jugador2=jugador2;
		this.numeroRondas=numeroRondas;
		this.ronda=ronda;

		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				tablero[i][j]="";
			}
		}

		setTurno(((lib.RandomEntero(1, 100)%2)==0)?getJugador1():getJugador2());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 902, 688);
		panelFondo.setBackground(new Color(67, 80, 169)); // Azul oscuro
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);

		JPanel panelRojo = new JPanel();
		panelRojo.setBounds(0, -11, 892, 111);
		panelRojo.setBackground(new Color(183, 0, 0));
		panelFondo.add(panelRojo);
		panelRojo.setLayout(null);

		JLabel separadorTitulo = new JLabel();
		separadorTitulo.setBackground(Color.WHITE);
		separadorTitulo.setOpaque(true);
		separadorTitulo.setBounds(10, 96, 872, 9);
		panelRojo.add(separadorTitulo);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				String[] botones = {"No","Si"};
				if (lib.EntradaBotones("Seguro que desea salir?\nNo se guardaran datos del la apuesta.", botones).equals("Si")){
					base.CerrarConexion();
					dispose();
				}
            }
        });
		
		A1 = new JButton("");
		A1.setFont(new Font("Courier New", Font.ITALIC, 70));
		A1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(A1, 0, 0);
			}
		});
		A1.setBounds(221, 105, 150, 150);
		panelFondo.add(A1);
		
		A2 = new JButton("");
		A2.setFont(new Font("Courier New", Font.ITALIC, 70));
		A2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(A2, 0, 1);
			}
		});
		A2.setBounds(383, 105, 150, 150);
		panelFondo.add(A2);
		
		A3 = new JButton("");
		A3.setFont(new Font("Courier New", Font.ITALIC, 70));
		A3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(A3, 0, 2);
			}
		});
		A3.setBounds(545, 105, 150, 150);
		panelFondo.add(A3);
		
		B1 = new JButton("");
		B1.setFont(new Font("Courier New", Font.ITALIC, 70));
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(B1, 1, 0);
			}
		});
		B1.setBounds(221, 267, 150, 150);
		panelFondo.add(B1);
		
		B2 = new JButton("");
		B2.setFont(new Font("Courier New", Font.ITALIC, 70));
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(B2, 1, 1);
			}
		});
		B2.setBounds(383, 267, 150, 150);
		panelFondo.add(B2);
		
		B3 = new JButton("");
		B3.setFont(new Font("Courier New", Font.ITALIC, 70));
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(B3, 1, 2);
			}
		});
		B3.setBounds(545, 267, 150, 150);
		panelFondo.add(B3);
		
		C1 = new JButton("");
		C1.setFont(new Font("Courier New", Font.ITALIC, 70));
		C1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(C1, 2, 0);
			}
		});
		C1.setBounds(221, 429, 150, 150);
		panelFondo.add(C1);
		
		C2 = new JButton("");
		C2.setFont(new Font("Courier New", Font.ITALIC, 70));
		C2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(C2, 2, 1);
			}
		});
		C2.setBounds(383, 429, 150, 150);
		panelFondo.add(C2);
		
		C3 = new JButton("");
		C3.setFont(new Font("Courier New", Font.ITALIC, 70));
		C3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionJugar(C3, 2, 2);
			}
		});
		C3.setBounds(545, 429, 150, 150);
		panelFondo.add(C3);
		
		JLabel SalidaMarcadorJuagador1 = new JLabel(jugador1.getAlias()+" : "+jugador1.getRondasGanadas());
		SalidaMarcadorJuagador1.setForeground(new Color(255, 255, 255));
		SalidaMarcadorJuagador1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 19));
		SalidaMarcadorJuagador1.setBounds(176, 49, 216, 16);
		panelRojo.add(SalidaMarcadorJuagador1);
		
		JLabel SalidaMarcadorJuagador2 = new JLabel(jugador2.getAlias()+" : "+jugador2.getRondasGanadas());
		SalidaMarcadorJuagador2.setForeground(new Color(255, 255, 255));
		SalidaMarcadorJuagador2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 19));
		SalidaMarcadorJuagador2.setBounds(585, 49, 153, 16);
		panelRojo.add(SalidaMarcadorJuagador2);
		
		lblNewLabel = new JLabel("VS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 46));
		lblNewLabel.setBounds(431, 38, 102, 46);
		panelRojo.add(lblNewLabel);
		
		SalidaTurno = new JLabel("Es el turno de "+getTurno().getAlias()+" con la ficha "+getTurno().getFicha());
		SalidaTurno.setHorizontalAlignment(SwingConstants.CENTER);
		SalidaTurno.setForeground(new Color(255, 255, 255));
		SalidaTurno.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 27));
		SalidaTurno.setBounds(43, 618, 849, 23);
		panelFondo.add(SalidaTurno);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/3.0.0.png")));
		lblNewLabel_2.setBounds(768, 285, 124, 86);
		panelFondo.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(54, 279, 124, 99);
		panelFondo.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/3.0.0.png")));
	}

	public void AccionJugar(JButton boton,int i,int j){
		boton.setText(getTurno().getFicha());
		tablero[i][j]=getTurno().getFicha();
		boton.setEnabled(false);
		if (ExisteGanador()){
			if (getTurno().getAlias().equals(getJugador1().getAlias())){
				getJugador1().AumentarRondasGano();
			}else{
				getJugador2().AumentarRondasGano();
			}
			VerificarFinPartida(1);
		}else if (jugadas==9){
			
			lib.MostrarMensaje("No existe ganador en esta ronda");
			VerificarFinPartida(0);
		}else{
			jugadas+=1;
		}
		System.out.println(jugadas);
		CambiarTurno();
		SalidaTurno.setText("Es el turno de "+getTurno().getAlias()+" con la ficha "+getTurno().getFicha());
	}
	
	public void VerificarFinPartida(int i){
		if (getNumeroRondas()==getRonda()){
			if (getJugador1().getRondasGanadas()==getJugador2().getRondasGanadas()){
				lib.MostrarMensaje("Nadie gano la apuesta, todos matienen su dinero");
			}else{
				if (getJugador1().getRondasGanadas()>getJugador2().getRondasGanadas()){
					TransferirDinero(jugador2, jugador1);
					DescontarDinero(jugador2);
				}else{
					TransferirDinero(jugador1, jugador2);
					DescontarDinero(jugador1);
				}
				lib.CambiarPantalla(new MenuJuego(),base);
				dispose();
			}
		}else{
			SiguienteRonda(i);
		}
	}

	public void DescontarDinero(Jugador jugador){
		String query = "UPDATE CUENTAS_AHORRO SET saldo = "+(jugador.getCuenta().getSaldo()-jugador.getApuesta())+" WHERE numeroCuenta = "+jugador.getCuenta().getNumeroCuenta();
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			int ejecutar = consulta.executeUpdate();
			if (ejecutar>0){

			}else{

			}
		} catch (Exception e) {
			lib.MostrarMensaje("Error: "+e.getMessage());
		}
	}

	public void TransferirDinero(Jugador jugador1,Jugador jugador2){
		String query = "UPDATE CUENTAS_AHORRO SET saldo = "+(jugador2.getCuenta().getSaldo()+jugador1.getApuesta())+" WHERE numeroCuenta = "+jugador2.getCuenta().getNumeroCuenta();
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			int ejecutar = consulta.executeUpdate();
			if (ejecutar>0){
				lib.MostrarMensaje(
					"El ganador del juego fue jugador "+jugador2.getAlias()+lib.n()+
					"Quien gano "+jugador2.getRondasGanadas()+" rondas de "+getNumeroRondas()+lib.n()+
					"Se le transfirio "+(jugador1.getApuesta())+" bs de la apuesta del jugador "+jugador1.getAlias()
				);
				IngresaNuevaTransferencia(jugador1.getCuenta().getNumeroCuenta(), jugador2.getCuenta().getNumeroCuenta(), lib.Fecha(),jugador1.getApuesta(), "Juego de Tres en Raya");
			}else{

			}
		} catch (Exception e) {
			lib.MostrarMensaje("Error: "+e.getMessage());
		}
	}

	public void IngresaNuevaTransferencia(int numeroCuenta,int cuentaReceptora,String fecha,double monto,String motivo){
		String query = "INSERT INTO TRANSFERENCIAS (cuentaEmisora,cuentaReceptora,fecha,monto,motivo) values (?,?,?,?,?)";
		try {
			PreparedStatement instruccion = base.getConexion().prepareStatement(query);
			instruccion.setInt(1, numeroCuenta);
			instruccion.setInt(2, cuentaReceptora);
			instruccion.setString(3, fecha);
			instruccion.setDouble(4, monto);
			instruccion.setString(5, motivo);
			int ejecutar = instruccion.executeUpdate();
			if (ejecutar > 0) {
				
			} else {
				lib.MostrarMensaje("Fallo al realizar la transferencia");
			}
		} catch (Exception e) {
			lib.MostrarMensaje(e.getMessage());
		}
	}

	public void SiguienteRonda(int i){
		if (i == 1){
			lib.MostrarMensaje("El ganador de esta ronda es "+getTurno().getAlias());
		}
		lib.CambiarPantalla(new Juego(getJugador1(), getJugador2(), getNumeroRondas(),getRonda()+1),base);
		dispose();
	}

	public void CambiarTurno(){
		if (getTurno().getAlias().equals(getJugador1().getAlias())){
			setTurno(getJugador2());
		}else{
			setTurno(getJugador1());
		}
	}

	public boolean ExisteGanador(){
		String ficha = getTurno().getFicha();
		int tamano=3;
		int c=0;
		for (int i=0;i<tamano;i++){
			c=0;
			for (int j=0;j<tamano;j++){
				if (tablero[i][j].equals(ficha)){
					c+=1;
				}
			}
			if (c==3){
				return true;
			}
		}
		c=0;
		for (int i=0;i<tamano;i++){
			c=0;
			for (int j=0;j<tamano;j++){
				if (tablero[j][i].equals(ficha)){
					c+=1;
				}
			}
			if (c==3){
				return true;
			}
		}
		c=0;
		for (int i=0;i<tamano;i++){
			if (tablero[i][i].equals(ficha)){
				c+=1;
			}
			if (c==3){
				return true;
			}
		}
		c=0;
		for (int i=0;i<tamano;i++){
			if (tablero[i][tamano-1-i].equals(ficha)){
				c+=1;
			}
			if (c==3){
				return true;
			}
		}
		return false;
	}

}
