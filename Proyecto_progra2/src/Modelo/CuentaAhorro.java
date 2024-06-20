package Modelo;

public class CuentaAhorro {
    public int numeroCuenta;
    public String titular;
    public String tipoCuenta;
    public double saldo;

    public CuentaAhorro(int numeroCuenta, String titular, String tipoCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    @Override
    public String toString(){
        String salida = "";
        salida+="Numero de cuenta: "+getNumeroCuenta()+"\n";
        salida+="Titular: "+getTitular()+"\n";
        salida+="Tipo de cuenta: "+getTipoCuenta()+"\n";
        salida+="Saldo: "+getSaldo()+"\n";
        return salida;
    }
}
