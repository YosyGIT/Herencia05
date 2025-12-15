package animales;

public class Perro extends Mamifero{

    public Perro(){
        super("Perro");
    }

    public String hacerRuido(){
        return super.hacerRuido("Guau");
    }

    @Override
    public String hacerRuido(String ruido){
        return super.hacerRuido("guau");
    }
}
