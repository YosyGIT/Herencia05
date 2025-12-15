package animales;

public class Mamifero extends Animal{


    public Mamifero(String nombre) {
        super(nombre);
    }

    public String hacerRuido(String ruido){
        return "El " + this.getNombre().toLowerCase() + " hace " + ruido + ".";
    }
}
