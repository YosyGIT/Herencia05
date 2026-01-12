package dispositivos;

public class Portatil extends  Ordenador{
    protected double peso;

    public Portatil(String nombre){
        super(nombre);
        this.peso = 3;
    }

    public Portatil(String nombre, int ram, int hd, String procesador, double peso){
        super(nombre, ram, hd, procesador);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String escribir(){
        return super.escribir() + "\nPESO: " + peso;
    }
}
