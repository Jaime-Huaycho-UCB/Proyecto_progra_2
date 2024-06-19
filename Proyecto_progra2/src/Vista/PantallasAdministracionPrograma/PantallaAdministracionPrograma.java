package Vista.PantallasAdministracionPrograma;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Librerias.Libreria;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Vista.PantallaInicio;
import Vista.PantallasAdministracionPrograma.PantallasOpcionesCuenta.MenuOpcionesCuentaAhorro;
import Vista.PantallasAdministracionPrograma.PantallasTIposCuenta.MenuTipoCuenta;


public class PantallaAdministracionPrograma extends JFrame {

    public Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public PantallaAdministracionPrograma() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 782, 372);
        setResizable(false); // Evita que la ventana se pueda redimensionar
        setTitle("Administración del Programa");
        ImageIcon icono = new ImageIcon("C:\\Users\\PC SAMC\\Downloads\\2.jpg"); // Ruta a tu logo
        setIconImage(icono.getImage());

        contentPane = new JPanel();
        contentPane.setBackground(new Color(52, 73, 94)); // Color de fondo más llamativo
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Logo de la aplicación
        JLabel lblLogo = new JLabel(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/2.jpg")); // Ruta a tu logo
        lblLogo.setBounds(6, 235, 120, 120);
        contentPane.add(lblLogo);

        // Título de la pantalla
        JLabel lblTitulo = new JLabel("ADMINISTRACION DEL PROGRAMA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 28));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(122, 38, 520, 50);
        contentPane.add(lblTitulo);

        // Separador debajo del título
        JLabel separadorTitulo = new JLabel();
        separadorTitulo.setBackground(Color.WHITE);
        separadorTitulo.setOpaque(true);
        separadorTitulo.setBounds(122, 79, 520, 2);
        contentPane.add(separadorTitulo);

        // Botón para Tipos de Cuenta
        JButton BotonTiposCuenta = new JButton("Tipos de Cuenta");
        BotonTiposCuenta.setOpaque(true);
        BotonTiposCuenta.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/7.jpg"));
        BotonTiposCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuTipoCuenta ventanaMenuTipoCuenta = new MenuTipoCuenta();
                ventanaMenuTipoCuenta.setLocationRelativeTo(null);
                ventanaMenuTipoCuenta.setVisible(true);
                dispose();
            }
        });
        BotonTiposCuenta.setForeground(new Color(15, 0, 15));
        BotonTiposCuenta.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
        BotonTiposCuenta.setBackground(new Color(255, 255, 255));
        BotonTiposCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BotonTiposCuenta.setBounds(58, 119, 280, 80);
        contentPane.add(BotonTiposCuenta);

        // Línea separadora 1
        JLabel separador1 = new JLabel();
        separador1.setBackground(Color.WHITE);
        separador1.setOpaque(true);
        separador1.setBounds(58, 223, 280, 2);
        contentPane.add(separador1);

        // Botón para Cuentas de Ahorro
        JButton BotonCuentasAhorro = new JButton("Cuentas de Ahorro");
        BotonCuentasAhorro.setOpaque(true);
        BotonCuentasAhorro.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/5.2.jpg"));
        BotonCuentasAhorro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lib.CambiarPantalla(new MenuOpcionesCuentaAhorro());
                dispose();
            }
        });
        BotonCuentasAhorro.setForeground(new Color(23, 0, 23));
        BotonCuentasAhorro.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
        BotonCuentasAhorro.setBackground(new Color(254, 255, 255));
        BotonCuentasAhorro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BotonCuentasAhorro.setBounds(418, 119, 306, 80);
        contentPane.add(BotonCuentasAhorro);

        // Línea separadora 2
        JLabel separador2 = new JLabel();
        separador2.setBackground(Color.WHITE);
        separador2.setOpaque(true);
        separador2.setBounds(418, 223, 306, 2);
        contentPane.add(separador2);

        // Botón para Volver (ahora en color rojo)
        JButton BotonVolver = new JButton("Volver");
        BotonVolver.setOpaque(true);
        BotonVolver.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/9.1.png"));
        BotonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lib.CambiarPantalla(new PantallaInicio());
                dispose();
            }
        });
        BotonVolver.setForeground(new Color(0, 0, 0));
        BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
        BotonVolver.setBackground(new Color(254, 255, 255)); // Color rojo
        BotonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BotonVolver.setBounds(657, 10, 120, 42);
        contentPane.add(BotonVolver);
        
        // Pie de página
        JLabel lblNewLabel = new JLabel("Goliath National Bank");
        lblNewLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 26));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(432, 259, 345, 50);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PC SAMC\\Downloads\\6.1.jpg"));
        lblNewLabel_1.setBounds(28, 10, 100, 70);
        contentPane.add(lblNewLabel_1);
    }
}
