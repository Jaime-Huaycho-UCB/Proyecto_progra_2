package Controlador;

import javax.swing.JOptionPane;

import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallaInicio;
public class Aplicacion {

    public static Libreria lib = new Libreria();
    public static BaseDatos base = new BaseDatos();

    public static void main(String[] args) {
        if (base.getConexion()!=null){
            base.CerrarConexion();
            IniciarPrograma();
        }
    }

    public static void IniciarPrograma(){
        //JOptionPane.showMessageDialog(null,"ihfbdisjnkl");
        PantallaInicio ventanaPantallaInicio = new PantallaInicio();
        ventanaPantallaInicio.setLocationRelativeTo(null);
        ventanaPantallaInicio.setVisible(true);
    }
}


