package atracciones;
import java.time.Duration;
public class MontanaRusa extends Atraccion{

    public MontanaRusa(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public boolean cumpleRequisitos(Cliente c) {
        if (c.getAltura() >= 1.40 && c.getEdad() >= 12){
            return true;
        }
        return false;
    }

    @Override
    public String getRequisitos() {
        return "-::REQUISITOS::-" +
                "\nEDAD: 12 años | ALTURA: 1,40m";
    }

    @Override
    public Duration calcularTiempoEspera(){
        Duration d = Duration.ofSeconds(30);
        return d.multipliedBy(getClientesEnCola());
    }
}
