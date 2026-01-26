package atracciones;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Cliente extends Persona{
    protected double altura;
    protected LocalDate fechaNacimiento;
    protected String nombre;

    public Cliente(String nombre, LocalDate fechaNacimiento, double altura){
        super(nombre);
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getAltura(){
        return this.altura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public int getEdad(){
        return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

    @Override
    public String toString(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "CLIENTE [" + nombre + "]" +
                "\n-FECHA DE NACIMIENTO: " + fechaNacimiento.format(f) + "| EDAD: " + getEdad() +
                "\n-ALTURA: " + altura;
    }
}
