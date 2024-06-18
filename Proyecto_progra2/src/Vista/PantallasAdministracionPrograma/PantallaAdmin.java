package Vista.PantallasAdministracionPrograma;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Librerias.Libreria;
import Vista.PantallaInicio;
import Vista.PantallasCrearCuentaAhorro.CrearCuentaAhorro;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
public class PantallaAdmin extends JFrame {
	
	public Libreria lib = new Libreria();

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public PantallaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450);

        // Crear un JPanel con un borde rojo grueso
        JPanel borderPanel = new JPanel();
        borderPanel.setBackground(new Color(255, 255, 255));
        borderPanel.setBorder(new LineBorder(new Color(255, 255, 255), 5)); // Borde rojo grueso
        borderPanel.setLayout(new BorderLayout());
        setContentPane(borderPanel);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(52, 73, 94)); // Color de fondo más oscuro
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        borderPanel.add(contentPane, BorderLayout.CENTER);
        contentPane.setLayout(null);

        // Agregar logo y nombre de la aplicación en la parte superior
        JLabel lblLogo = new JLabel(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/2.jpg")); // Ruta a la imagen del logo
        lblLogo.setBounds(10, 326, 100, 80);
        contentPane.add(lblLogo);

        JLabel lblNombreApp = new JLabel("GOLIATH NATIONAL BANK");
        lblNombreApp.setForeground(new Color(236, 240, 241));
        lblNombreApp.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 21));
        lblNombreApp.setBounds(10, 10, 310, 30);
        contentPane.add(lblNombreApp);

        // Título de la sección
        JLabel lblTitulo = new JLabel("ADMINISTRADOR");
        lblTitulo.setForeground(new Color(236, 240, 241));
        lblTitulo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 27));
        lblTitulo.setBounds(191, 62, 263, 30);
        contentPane.add(lblTitulo);

        // Línea separadora debajo del título
        JSeparator separatorTitulo = new JSeparator();
        separatorTitulo.setForeground(Color.WHITE);
        separatorTitulo.setBounds(10, 100, 574, 10);
        contentPane.add(separatorTitulo);

        // Botón para crear cuenta de ahorro con icono
        JButton BotonCrearCuenta = new JButton("Crear cuenta de ahorro");
        BotonCrearCuenta.setOpaque(true);
        BotonCrearCuenta.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
        BotonCrearCuenta.setBackground(new Color(41, 128, 185));
        BotonCrearCuenta.setForeground(Color.WHITE);
        BotonCrearCuenta.setFocusPainted(false);
        BotonCrearCuenta.setBorderPainted(false);
        BotonCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BotonCrearCuenta.setIcon(new ImageIcon("C:\\Users\\PC SAMC\\Downloads\\icono_cuenta.png")); // Ruta al icono
        BotonCrearCuenta.setBounds(147, 131, 350, 60);
        BotonCrearCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearCuentaAhorro ventanCrearCuentaAhorro = new CrearCuentaAhorro();
                lib.CambiarPantalla(ventanCrearCuentaAhorro);
                dispose();
            }
        });
        contentPane.add(BotonCrearCuenta);

        // Línea separadora debajo del primer botón
        JSeparator separatorCuenta = new JSeparator();
        separatorCuenta.setForeground(Color.WHITE);
        separatorCuenta.setBounds(10, 220, 574, 10);
        contentPane.add(separatorCuenta);

        // Botón para administrar programa con icono
        JButton BotonAdministrar = new JButton("Administrar Programa");
        BotonAdministrar.setOpaque(true);
        BotonAdministrar.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
        BotonAdministrar.setBackground(new Color(41, 128, 185));
        BotonAdministrar.setForeground(Color.WHITE);
        BotonAdministrar.setFocusPainted(false);
        BotonAdministrar.setBorderPainted(false);
        BotonAdministrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BotonAdministrar.setIcon(new ImageIcon("C:\\Users\\PC SAMC\\Downloads\\icono_administrar.png")); // Ruta al icono
        BotonAdministrar.setBounds(147, 242, 350, 60);
        BotonAdministrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaAdministracionPrograma ventanaPantallaAdministracionPrograma = new PantallaAdministracionPrograma();
                lib.CambiarPantalla(ventanaPantallaAdministracionPrograma);
                dispose();
            }
        });
        contentPane.add(BotonAdministrar);

        // Línea separadora debajo del segundo botón
        JSeparator separatorAdmin = new JSeparator();
        separatorAdmin.setForeground(Color.WHITE);
        separatorAdmin.setBounds(10, 320, 574, 10);
        contentPane.add(separatorAdmin);

        // Botón para volver con icono
        JButton BotonVolver = new JButton("Volver");
        BotonVolver.setOpaque(true);
        BotonVolver.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
        BotonVolver.setBackground(new Color(192, 57, 43));
        BotonVolver.setForeground(Color.WHITE);
        BotonVolver.setFocusPainted(false);
        BotonVolver.setBorderPainted(false);
        BotonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BotonVolver.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/8.1.png")); // Ruta al icono
        BotonVolver.setBounds(446, 342, 127, 45);
        BotonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaInicio ventanCrearCuentaAhorro = new PantallaInicio();
                lib.CambiarPantalla(ventanCrearCuentaAhorro);
                dispose();
            }
        });
        contentPane.add(BotonVolver);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/5.2.jpg"));
        lblNewLabel.setBounds(65, 135, 61, 53);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("/Users/jaimehuaycho/Desktop/Proyecto_progra_2/Proyecto_progra2/src/recursos/Imagenes/6.1.jpg"));
        lblNewLabel_1.setBounds(65, 247, 61, 50);
        contentPane.add(lblNewLabel_1);
    }
}

