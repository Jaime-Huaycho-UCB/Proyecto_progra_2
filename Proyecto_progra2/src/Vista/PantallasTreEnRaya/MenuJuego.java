package Vista.PantallasTreEnRaya;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Modelo.CuentaComun;
import Modelo.Jugador;
import Vista.PantallaInicio;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.*;

public class MenuJuego extends JFrame {

	public Libreria lib = new Libreria();
	public BaseDatos base = new BaseDatos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EntradaAliasJugador1;
	private JTextField EntradaCuenta1;
	private JTextField EntradaApuesta1;
	private JTextField EntradaAliasJugador2;
	private JTextField EntradaCuenta2;
	private JTextField EntradaApuesta2;
	private JTextField EntradaRondas;

	public MenuJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 580);
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
		
		JLabel lblNewLabel = new JLabel("Bievenido al juego de Tres en Raya");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 46, 813, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alias:");
		lblNewLabel_1.setBounds(77, 185, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		EntradaAliasJugador1 = new JTextField();
		EntradaAliasJugador1.setBounds(150, 180, 130, 26);
		contentPane.add(EntradaAliasJugador1);
		EntradaAliasJugador1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cuenta:");
		lblNewLabel_1_1.setBounds(77, 254, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		EntradaCuenta1 = new JTextField();
		EntradaCuenta1.setColumns(10);
		EntradaCuenta1.setBounds(150, 249, 130, 26);
		contentPane.add(EntradaCuenta1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apuesta:");
		lblNewLabel_1_2.setBounds(77, 323, 61, 16);
		contentPane.add(lblNewLabel_1_2);
		
		EntradaApuesta1 = new JTextField();
		EntradaApuesta1.setColumns(10);
		EntradaApuesta1.setBounds(150, 318, 130, 26);
		contentPane.add(EntradaApuesta1);
		
		JLabel lblNewLabel_2_1 = new JLabel("VS");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(314, 210, 187, 93);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Alias:");
		lblNewLabel_1_3.setBounds(534, 185, 61, 16);
		contentPane.add(lblNewLabel_1_3);
		
		EntradaAliasJugador2 = new JTextField();
		EntradaAliasJugador2.setColumns(10);
		EntradaAliasJugador2.setBounds(607, 180, 130, 26);
		contentPane.add(EntradaAliasJugador2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cuenta:");
		lblNewLabel_1_1_1.setBounds(534, 254, 61, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		EntradaCuenta2 = new JTextField();
		EntradaCuenta2.setColumns(10);
		EntradaCuenta2.setBounds(607, 249, 130, 26);
		contentPane.add(EntradaCuenta2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Apuesta:");
		lblNewLabel_1_2_1.setBounds(534, 323, 61, 16);
		contentPane.add(lblNewLabel_1_2_1);
		
		EntradaApuesta2 = new JTextField();
		EntradaApuesta2.setColumns(10);
		EntradaApuesta2.setBounds(607, 318, 130, 26);
		contentPane.add(EntradaApuesta2);
		
		JButton BotonEmpezarJuego = new JButton("Iniciar juego");
		BotonEmpezarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionIniciarJuego();
			}	
		});
		BotonEmpezarJuego.setBounds(478, 433, 117, 29);
		contentPane.add(BotonEmpezarJuego);
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lib.CambiarPantalla(new PantallaInicio(),base);
				dispose();
			}
		});
		BotonVolver.setBounds(221, 433, 117, 29);
		contentPane.add(BotonVolver);
		
		EntradaRondas = new JTextField();
		EntradaRondas.setBounds(420, 380, 130, 26);
		contentPane.add(EntradaRondas);
		EntradaRondas.setColumns(10);
		
		JLabel texto = new JLabel("Numero de rondas:");
		texto.setBounds(284, 385, 130, 16);
		contentPane.add(texto);
	}

	public void AccionIniciarJuego(){
		String alias1 = EntradaAliasJugador1.getText();
		String alias2 = EntradaAliasJugador2.getText();
		if (alias1.length()>0 && alias2.length()>0){
			int numeroCuenta1 = Integer.parseInt(EntradaCuenta1.getText());
			int numeroCuenta2 = Integer.parseInt(EntradaCuenta2.getText());
			if (ExisteCuenta(numeroCuenta1) && ExisteCuenta(numeroCuenta2)){
				CuentaComun cuenta1 = ObtenerCuenta(numeroCuenta1);
				CuentaComun cuenta2 = ObtenerCuenta(numeroCuenta2);
				double apuesta1 = Double.parseDouble(EntradaApuesta1.getText());
				double apuesta2 = Double.parseDouble(EntradaApuesta2.getText());
				if (ApuestaValida(cuenta1, apuesta1) && ApuestaValida(cuenta2, apuesta2)){
					int numeroRondas = Integer.parseInt(EntradaRondas.getText());
					if (numeroRondas>0){
						Jugador jugador1 = new Jugador(alias1, cuenta1, apuesta1);
						Jugador jugador2 = new Jugador(alias2, cuenta2, apuesta2);
						IniciarJuego(jugador1, jugador2,numeroRondas);
					}else{
						lib.MostrarMensaje("Ingrese un numeor de rondas valido");
					}
				}
			}
		}else{
			lib.MostrarMensaje("Los alias no deben estar vacios");
		}
	}

	public void IniciarJuego(Jugador jugador1,Jugador jugador2,int numeroRondas){
		int iniciaJugador = lib.RandomEntero(1, 2);
		jugador1.setFicha("X");
		jugador2.setFicha("O");
		if (iniciaJugador==1){
			lib.CambiarPantalla(new Juego(jugador1, jugador2, numeroRondas,1), base);
			dispose();
		}else{
			lib.CambiarPantalla(new Juego(jugador2, jugador1, numeroRondas,1), base);
			dispose();
		}
	}

	public boolean ApuestaValida(CuentaComun cuenta,double apuesta){
		if (apuesta<=cuenta.getSaldo()){
			return true;
		}else{
			lib.MostrarMensaje("La cuanta "+cuenta.getNumeroCuenta()+" no puedes apostar "+apuesta+" bs.\nPorque la cuenta solo tiene "+cuenta.getSaldo()+" bs de saldo.");
			return false;
		}
	}

	public boolean ExisteCuenta(int numeroCuenta){
		String query = "SELECT Count(0) FROM CUENTAS_AHORRO WHERE numeroCuenta = "+numeroCuenta;
		try {
			Statement consulta = base.getConexion().createStatement();
			ResultSet ejecutar = consulta.executeQuery(query);
			if (ejecutar.next()){
				return (ejecutar.getInt(1)!=0? true : false);
			}
		} catch (Exception e) {
			
		}
		lib.MostrarMensaje("El numero de cuenta "+numeroCuenta+" no existe como cuenta de ahorro.");
		return false;
	}

	public CuentaComun ObtenerCuenta(int numeroCuenta){
		String query = "SELECT saldo FROM CUENTAS_AHORRO WHERE numeroCuenta = "+numeroCuenta;
		CuentaComun cuenta = null;
		try {
			PreparedStatement consulta = base.getConexion().prepareStatement(query);
			ResultSet ejecutar = consulta.executeQuery();
			while (ejecutar.next()) {
				double saldo = ejecutar.getDouble("saldo");
				cuenta = new CuentaComun(numeroCuenta, saldo);
				return cuenta;
			}
		} catch (Exception e) {
			lib.MostrarMensaje("Error: "+e.getMessage());
		}
		return null;
	}
}
