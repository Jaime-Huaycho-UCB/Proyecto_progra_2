package Modelo;

public class TipoCuenta {
    private int id;
    private String nombre;
    private String tipoInteres;
    private double interes;
    
    public TipoCuenta(int id, String nombre, String tipoInteres, double interes) {
        this.id = id;
        this.nombre = nombre;
        this.tipoInteres = tipoInteres;
        this.interes = interes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(String tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String toString(){
        return "Nombre: "+getNombre()+" - Tipo interes: "+getTipoInteres()+" - Interes: "+getInteres();
    }

    public String toString2(){
        return "Nombre: "+getNombre()+" - Interes: "+getInteres()+"%";
    }

}
