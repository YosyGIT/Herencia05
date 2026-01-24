package fechas;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
public class Fecha implements Comparable<Fecha>{
    private LocalDate fecha;

    public Fecha(){
        this.fecha = LocalDate.now();
    }

    public Fecha(int dia, int mes, int anio){
        this.fecha = LocalDate.of(anio,mes,dia);
    }

    @Override
    public String toString() {
        DateTimeFormatter  formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.fecha.format(formato);    }

    //domingo, 12 de marzo de 2026
    public String formatoLargo(){
        DateTimeFormatter  formato = DateTimeFormatter.ofPattern("EEEE" + ", " + "dd" + " de " + "MMMM" + " de " + "yyyy");
        return this.fecha.format(formato);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fecha f) {
            return fecha.isEqual(f.fecha);
        }
        else return false;
    }

    public long diferenciaDias(Fecha f){
        long p = ChronoUnit.DAYS.between(this.fecha, f.fecha);
        return p;
    }

    public long diferenciaMeses(Fecha f){
        long p = ChronoUnit.MONTHS.between(this.fecha, f.fecha);
        return p;
    }

    public long diferenciaAnios(Fecha f){
        long p = ChronoUnit.YEARS.between(this.fecha, f.fecha);
        return p;
    }

    @Override
    public int compareTo(Fecha f){
        if (f == null) return 1;
        return this.fecha.compareTo(f.fecha);
    }
}
