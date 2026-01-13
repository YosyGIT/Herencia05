package abstr;

public class Cuadrado extends Figura implements Escribible{
    private double lado;

    public Cuadrado(double lado){
       this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea(){
        return this.lado * this.lado;
    }

    @Override
    public String escribir(){
        return "\n\t[CUADRADO]" +
                "\nLADO: " + lado +
                "\nAREA:" + calcularArea();
    }
}
