package atracciones;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TecnicoMantenimiento extends Persona{
    protected LocalDate fechaAntiguedad;

    public TecnicoMantenimiento(String nombre, LocalDate fechaAntiguedad){
        super(nombre);
        this.fechaAntiguedad = fechaAntiguedad;
    }

    public String getNombre(){
        return super.getNombre();
    }

    public LocalDate getFechaAntiguedad(){
        return this.fechaAntiguedad;
    }

    public void setFechaAntiguedad(LocalDate fechaAntiguedad){
        this.fechaAntiguedad = fechaAntiguedad;
    }

    @Override
    public String toString(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() +
                "\nFECHA DE ANTIGÜEDAD: " + this.fechaAntiguedad.format(f);
    }
}
