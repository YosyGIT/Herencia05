package dispositivos;

public class Movil extends Ordenador{
    private String tipo;
    private Camara cam;

    public Movil (String nombre, int ram, int hd, String procesador, String tipo, double apertura, int megapixeles, String marca){
        super(nombre, ram, hd, procesador);
        this.tipo = tipo;
        cam = new Camara(apertura, megapixeles, marca);
    }

    public String escribir(){
        return super.escribir() + "\nTIPO: " + tipo;
    }
}
