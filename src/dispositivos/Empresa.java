package dispositivos;

import java.util.Arrays;

public class Empresa {
    public String nombre;
    private Ordenador[] ordenadores;
    private int nOrdenadores = 0;

    public Empresa(String nombre){
        this.nombre = nombre;
        this.ordenadores = new Ordenador[500];
    }

    public Ordenador[] getOrdenadores() {
        return ordenadores;
    }

    public boolean addOrdenador(Ordenador pc){
        boolean proceso = false;

        if (nOrdenadores < ordenadores.length) {
            for (int i = 0; i < ordenadores.length; i++) {
                if (ordenadores[i] == null) {
                    ordenadores[i] = pc;
                    nOrdenadores++;
                    proceso = true;
                    return proceso;
                }
            }
        }
        return proceso;
    }

    public void retirarOrdenador(Ordenador pc){
        for (int i = 0; i < ordenadores.length; i++){
            if (ordenadores[i] != null && ordenadores[i] == pc){
                ordenadores[i] = null;
                nOrdenadores--;
                break;
            }
        }
    }

    public void retirarOrdenador(String nombrePc){
        for (int i = 0; i < ordenadores.length; i++){
            if (ordenadores[i] != null && ordenadores[i].nombre.equals(nombrePc)){
                ordenadores[i] = null;
                nOrdenadores--;
                break;
            }
        }
    }

    public void revolver(){
        String nombre;
        int posAleatoria;

        for (int i = 0; i < ordenadores.length; i++){
            if (ordenadores[i] != null){
                nombre = "COMP" + (i+1);
                ordenadores[i].nombre = nombre;
            }
        }

        for (int i = 0; i < ordenadores.length; i++) {
            posAleatoria = (int) (Math.random() * ordenadores.length);

            Ordenador temp = ordenadores[i];
            ordenadores[i] = ordenadores[posAleatoria];
            ordenadores[posAleatoria] = temp;
        }
    }

    public String escribir(){
        return "NOMBRE: " + nombre +
                "\nNUMERO DE DISPOSITIVOS: " + nOrdenadores +
                "\n----------DISPOSITIVOS-----------" +
                "\n" + Arrays.toString(ordenadores);
    }
}
