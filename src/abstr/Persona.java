package abstr;

public class Persona implements Escribible{
    protected String nombre;
    protected String apellidos;

    public Persona(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public String escribir(){
        return "NOMBRE: " + nombre +
                "\nAPELLIDOS: " + apellidos;
    }
}
