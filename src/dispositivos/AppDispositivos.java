package dispositivos;

import javax.sound.sampled.Port;
import java.util.Arrays;

public class AppDispositivos {
    public static void main(String[] args) {
        Empresa emp1 = new Empresa("InfoValladolid S.A.");

        String nombrePC, nombreMB;
        int contadorLista = 1, nombreSegTanda = 26;
        boolean creacion = false;

        System.out.println("-::CREANDO FICHA DE ORDENADORES Y PORTATILES::-");
        for (int i = 1; i <= 25; i++) {
            nombrePC = "PC" + i;
            Ordenador nuevoPC;

            if (i % 2 != 0) {
                nuevoPC = new Portatil(nombrePC, 16, 1024, "i5", 3);
            } else {
                nuevoPC = new Ordenador(nombrePC, 16, 1024, "i5");
            }

            creacion = emp1.addOrdenador(nuevoPC);
            System.out.println("- Dispositivo nº [" + i + "] " + (creacion ? "añadido correctamente" : "error: almacén lleno"));
        }

        System.out.println("\n-::CREANDO FICHA DE SMARTPHONES::-");
        for (int i = 1; i <= 50; i++) {
            nombreMB = "MB" + i;
            Movil nuevoMB = new Movil(nombreMB, 8, 256, "Snapdragon 8 Gen 2", "5G", 2.2, 12, "Carl Zeiss");
            creacion = emp1.addOrdenador(nuevoMB);
            System.out.println("- Dispositivo nº [" + i + "] " + (creacion ? "añadido correctamente" : "error: almacén lleno"));
        }

        System.out.println("\n-::LISTA DE DISPOSITIVOS DE LA EMPRESA::-");
        for (Ordenador o: emp1.getOrdenadores()){
            if (o != null){
                System.out.println("DISPOSITIVO [" + contadorLista + "]");
                System.out.println(o.escribir());
                contadorLista++;
                System.out.println("----------------------------------");
            }
        }

        for (Ordenador o: emp1.getOrdenadores()){
            if (o != null){
                if (o.nombre.matches("PC[0-9]{1,2}")){
                    o.encender();
                }
            }
        }

        System.out.println("\n-::ELIMINANDO ORDENADORES::-");
        for (int i = 1; i <= 25; i++){
            if (i % 2 != 0 && emp1.getOrdenadores()[i] != null){
                emp1.retirarOrdenador(emp1.getOrdenadores()[i]);
                System.out.println("- Dispositivo eliminado correctamente");
            }
        }

        System.out.println("\n-::CREANDO FICHA DE PORTATILES::-");
        for (int i = 1; i <= 20; i++){
            nombrePC = "PC" + nombreSegTanda;
            Portatil nuevoPC = new Portatil(nombrePC, 16, 1024, "i5", 3);
            nombreSegTanda++;
            creacion = emp1.addOrdenador(nuevoPC);
            System.out.println("- Dispositivo nº [" + i + "] " + (creacion ? "añadido correctamente" : "error: almacén lleno"));
        }

        emp1.revolver();
        contadorLista = 1;
        System.out.println("\n-::LISTA DE DISPOSITIVOS DE LA EMPRESA::-");
        for (Ordenador o: emp1.getOrdenadores()){
            if (o != null){
                System.out.println("DISPOSITIVO [" + contadorLista + "]");
                System.out.println(o.escribir());
                contadorLista++;
                System.out.println("----------------------------------");
            }
        }

        for (int i = 0; i < emp1.getOrdenadores().length; i++){
            Portatil nuevoPC = (Portatil) emp1.getOrdenadores()[i];
            if (emp1.getOrdenadores()[i] != null && emp1.getOrdenadores()[i] == nuevoPC){
                emp1.getOrdenadores()[i].setRam(2048);
            }
        }
    }
}
