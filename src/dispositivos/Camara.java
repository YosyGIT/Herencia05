package dispositivos;

public class Camara {
    public double apertura;
    public int megapixeles;
    public String marca;

    public Camara(double apertura, int megapixeles, String marca){
        this.apertura = apertura;
        this.megapixeles = megapixeles;
        this.marca = marca;
    }

    public String escribir() {
        return "-::CAMARA::-" +
                "\nAPERTURA: " + apertura +
                "\nMEGAPIXELES: " + megapixeles +
                "\nMARCA: " + marca;
    }
}
