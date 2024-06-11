package Modelo;

import java.sql.*;

import Librerias.Libreria;

public class BaseDatos {

    public Libreria lib = new Libreria();
    private final String url = "jdbc:mysql://127.0.0.1:3306/ProyectoProgra2";
    private final String usuario = "root";
    private final String contrasena = "";

    private Connection conexion=null;

    public BaseDatos() {
        EstablecerConexion();
    }

    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }    
    public String getUrl() {
        return url;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getContrasena() {
        return contrasena;
    }

    private void EstablecerConexion(){
        String opcion="";
        String mensaje="Hubo una excepcion: Error al establecer una conexion con la base de datos.\n";
        String[] botones = {"No","Si"};
        while (true) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                setConexion(DriverManager.getConnection(getUrl(), getUsuario(), getContrasena()));
                break;
            } catch (ClassNotFoundException a) {
                opcion=lib.EntradaBotones(mensaje + a.getMessage()+"\n"+"Desea reintentar?", botones);
            } catch (SQLException b) {
                opcion=lib.EntradaBotones(mensaje + b.getMessage()+"\n"+"Desea reintentar?", botones);
            } 
            if (opcion.equals("No")){
                break;
            }
        }
    }

    public void CerrarConexion(){
        String opcion="";
        String mensaje="Hubo una excepcion: Error al intentar cerrar conexion\n";
        String[] botones = {"No","Si"};
        while (true) {
            try {
                getConexion().close();
                setConexion(null);
                break;
            } catch (SQLException e) {
                opcion=lib.EntradaBotones(mensaje + e.getMessage()+"\n"+"Desea reintentar?", botones);
            }
            if (opcion.equals("No")){
                break;
            }
        }
    }
}
