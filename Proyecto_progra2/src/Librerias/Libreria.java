package Librerias;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Modelo.BaseDatos;

public class Libreria {
    // Inicio - Funciones cadena
    public String n(){
        return "\n";
    }
    public String t(){
        return "\t";
    }
    public String n(int numero){
        String nl="",n="\n";
        for (int i=0;i<numero;i++){
            nl+=n;
        }
        return nl;
    }
    public String t(int numero){
        String tab="",t="\t";
        for (int i=0;i<numero;i++){
            tab+=t;
        }
        return tab;
    }
    // Fin - Funciones cadena

    // Inicio - Salidas
    public void MostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void MostrarScroll(String mensaje) {
        JTextArea ob = new JTextArea(20,30);
        ob.setText(mensaje);
        JScrollPane ob1 = new JScrollPane(ob);
        JOptionPane.showMessageDialog(null, ob1);
    }
    // Fin - Salidas

    // Inicio - Entradas
    public int EntradaEntero(String mensaje){
        int numero=0;
        while (true) {
            try {
                numero=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                return numero;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Ingresar unicamente valores enteros");
            }
        }
    }
    public double EntradaDecimal(String mensaje){
        double numero=0.00;
        while (true) {
            try {
                numero=Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                return numero;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Ingrese unicamente valores enteros");
            }
        }
    }
    public String EntradaCadena(String mensaje){
        String numero="";
        numero=JOptionPane.showInputDialog(null, mensaje);
        return numero;
    }
    public String EntradaBotones(String mensaje, String[] botones) {
        int opcion = JOptionPane.showOptionDialog(
            null, 
            mensaje, 
            "Presione una opción", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            botones, 
            botones[0]
        );
        
        // Validar que se seleccionó una opción válida
        if (opcion >= 0 && opcion < botones.length) {
            return botones[opcion];
        } else {
            return null;
        }
    }
    // Fin - Entradas

    // Inicio - Funciones matematicas
    public int RandomEntero(int a,int b) {
        return (int)(Math.random() * (b - a + 1)) + a;
    }
    public double LimitarDecimales(double numero, int decimales) {
        double factor = Math.pow(10, decimales);
        double numeroRedondeado = Math.round(numero * factor) / factor;
        return numeroRedondeado;
    }
    // Fin - Funciones matematicas

    // Inicio - Funciones tiempo
    public int Fecha(int opcion) {
        LocalDate fecha = LocalDate.now();
        switch (opcion) {
            case 1:
                return fecha.getDayOfMonth();
            case 2:
                return fecha.getMonthValue();
            case 3:
                return fecha.getYear();
            default:
                return 0;
        }
    }
    public String Fecha(){
        String salidaFecha="";
        salidaFecha+=Fecha(3)+"-";
        salidaFecha+=Fecha(2)+"-";
        salidaFecha+=Fecha(1);
        return salidaFecha;
    }
    public int Tiempo(int opcion) {
        LocalTime tiempo = LocalTime.now();
        switch (opcion) {
            case 1:
                return tiempo.getHour();
            case 2:
                return tiempo.getMinute();
            case 3:
                return tiempo.getSecond();
            default:
                return 0;
        }
    }
    public String Tiempo(){
        String salidaTiempo="";
        salidaTiempo+=Tiempo(1)+":";
        salidaTiempo+=Tiempo(2)+":";
        salidaTiempo+=Tiempo(3);
        return salidaTiempo;
    }
    public String Mes(int mes){
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "";
        }
    }
    public int EntradaMes(String mensaje){
        int mes = 0;
        while (true) {
            mes = EntradaEntero(
            mensaje+n()+
            "1) Enero"+n()+
            "2) Febrero"+n()+
            "3) Marzo"+n()+
            "4) Abril"+n()+
            "5) Mayo"+n()+
            "6) Junio"+n()+
            "7) Julio"+n()+
            "8) Agosto"+n()+
            "9) Septiembre"+n()+
            "10) Octubre"+n()+
            "11) Noviembre"+n()+
            "12) Diciembre"
            );
            if (mes>=1 && mes<=12){
                return mes;
            }else{
                MostrarMensaje("Elija una opcion valida");
            }
        }
    }
    public int EntradaMes(String mensaje,int mesInferior,int mesSuperior){
        String[] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        int a=0,b=0;
        if (mesInferior<=mesSuperior){
            a=mesInferior-1;
            b=mesSuperior-1;
        }else{
            a=mesSuperior-1;
            b=mesInferior-1;
        }
        if (a<0){
            a=0;
        }
        if (a>11){
            a=11;
        }
        if (b<0){
            b=0;
        }
        if (b>11){
            b=11;
        }
        String salidaMeses=mensaje+n();
        int c=0;
        for (int i=a;i<=b;i++){
            salidaMeses+=(i-a+1)+") "+meses[i]+n();
            c+=1;
        }
        int mes=0;
        while (true) {
            mes = EntradaEntero(salidaMeses);
            if (mes>=1 && mes<=c){
                return (a+mes);
            }else{
                MostrarMensaje("Elija una opcion valida");
            }
        }
    }
    // Fin - Funciones tiempo

    public void CambiarPantalla(JFrame pantalla,BaseDatos conexion){
        conexion.CerrarConexion();
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }

    public void CambiarPantalla(JFrame pantalla){
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }
}
