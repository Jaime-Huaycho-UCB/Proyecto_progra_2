package Modelo;

public class CuentaAhorro extends CuentaComun{
    public String titular;
    public String tipoCuenta;

    public CuentaAhorro(int numeroCuenta, String titular, String tipoCuenta, double saldo) {
        super(numeroCuenta, saldo);
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
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
