package abstr;

public abstract class Figura {
    protected String nombre;

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    abstract public double calcularArea();
}
