package dispositivos;

public class Empresa {
    public String nombre;
    private Ordenador[] ordenadores;
    private int nOrdenadores = 0;

    public Empresa(String nombre){
        this.nombre = nombre;
        this.ordenadores = new Ordenador[500];
    }

    public void addOrdenador(Ordenador pc){
        for (Ordenador o: ordenadores){
            if (nOrdenadores < 500 && o == null){
                o = pc;
                nOrdenadores++;
            }
        }
    }

    public void retirarOrdenador(Ordenador pc){
        for (Ordenador o: ordenadores){
            if (o == pc){
                o = null;
                nOrdenadores--;
            }
        }
    }

    public void retirarOrdenador(String nombrePc){
        for (int i = 0; i < ordenadores.length; i++){
            if (ordenadores[i].nombre.equals(nombrePc)){
                ordenadores[i] = null;
                nOrdenadores--;
            }
        }
    }

    public String escribir(){
        return "NOMBRE: " + nombre;
    }
}
