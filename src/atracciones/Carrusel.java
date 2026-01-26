package atracciones;
import java.time.*;
public class Carrusel extends Atraccion{

    public Carrusel(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public boolean cumpleRequisitos(Cliente cliente) {
        if (cliente.getEdad() >= 3){
            return true;
        }
        return false;
    }
    @Override
    public String getRequisitos() {
        return "-::REQUISITOS::-" +
                "\nEDAD: 3 años | ALTURA: No importa";
    }

    @Override
    public Duration calcularTiempoEspera(){
        Duration d = Duration.ofSeconds(12);
        return d.multipliedBy(getClientesEnCola());
    }
}
