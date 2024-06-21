package Modelo;

public class Jugador {
    private String alias;
    private CuentaComun cuenta;
    private double apuesta;
    private String ficha = "";
    private int rondasGanadas = 0;

    public Jugador(String alias,CuentaComun cuenta,double apuesta){
        this.alias=alias;
        this.cuenta=cuenta;
        this.apuesta=apuesta;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public CuentaComun getCuenta() {
        return cuenta;
    }
    public void setCuenta(CuentaComun cuenta) {
        this.cuenta = cuenta;
    }
    public double getApuesta() {
        return apuesta;
    }
    public void setApuesta(double apuesta) {
        this.apuesta = apuesta;
    }
    public String getFicha() {
        return ficha;
    }
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }
    public int getRondasGanadas() {
        return rondasGanadas;
    }
    public void setRondasGanadas(int rondasGanadas) {
        this.rondasGanadas = rondasGanadas;
    }

    public void AumentarRondasGano(){
        setRondasGanadas(getRondasGanadas()+1);
    }
}
