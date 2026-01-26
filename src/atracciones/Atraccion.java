package atracciones;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Atraccion {
    protected static int totalAtracciones = 0;
    protected String nombre;
    protected double precio;
    protected LocalDateTime fechaUltimoMantenimiento;
    protected TecnicoMantenimiento t;
    protected Cliente[] cola = new Cliente[100];
    protected int contCola = 0;

    public Atraccion(String nombre, double precio){
        this(nombre, precio, null, null);
    }

    public Atraccion(String nombre, double precio, TecnicoMantenimiento tecnicoMantenimiento){
        this(nombre, precio, tecnicoMantenimiento, null);
    }

    public Atraccion(String nombre, double precio, TecnicoMantenimiento tecnicoMantenimiento, LocalDateTime fechaUltimoMantenimiento){
        this.nombre = nombre;
        this.precio = precio;
        this.t = tecnicoMantenimiento;
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        totalAtracciones++;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public TecnicoMantenimiento getT(){
        return t;
    }

    public void setT(TecnicoMantenimiento t){
        this.t = t;
    }

    public LocalDateTime getFechaUltimoMantenimiento(){
        return this.fechaUltimoMantenimiento;
    }

    public void setFechaUltimoMantenimiento(LocalDateTime fechaUltimoMantenimiento){
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
    }

    public void anadirClienteCola(Cliente c){
        int cont = 0;
        for (Cliente cola: cola){
            if (cola != null && cola == c){
                cont++;
            }
        }
        if (cont == 0){
            for (int i = 0;  i < cola.length; i++){
                if (c != null){
                    cola[i] = c;
                    contCola ++;
                }
            }
        }
    }

    public void quitarClienteCola(Cliente c){
        int ultimaPosicion = 0;
        for (int i = 0; i < cola.length; i++){
            if (cola[i] == c){
                cola[i] = null;
                contCola --;
                ultimaPosicion ++;
            }
        }
        for (int i = ultimaPosicion; i < (cola.length - 1); i++){
            cola[i] = cola[i+1];
        }
    }

    public int getClientesEnCola(){
        return contCola;
    }

    public boolean yaEstaEnCola(Cliente c){
        for (Cliente cliente: cola){
            if (cliente == c){
                return true;
            }
        }
        return false;
    }
/**
    public static Duration calcularTiempoEspera(){
        Duration d = Duration.between(LocalDate.now(), )
        return 2.45;
    }**/
}
