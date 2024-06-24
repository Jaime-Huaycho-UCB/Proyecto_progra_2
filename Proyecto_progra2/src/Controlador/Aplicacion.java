package Controlador;


import Librerias.Libreria;
import Modelo.BaseDatos;
import Vista.PantallaInicio;
public class Aplicacion {

    // pequeno cambio

    public static Libreria lib = new Libreria();
    public static BaseDatos base = new BaseDatos();

    public static void main(String[] args) {
        if (base.getConexion()!=null){
            base.CerrarConexion();
            IniciarPrograma();
        }
    }

    public static void IniciarPrograma(){
        PantallaInicio ventanaPantallaInicio = new PantallaInicio();
        lib.CambiarPantalla(ventanaPantallaInicio);
    }
}


