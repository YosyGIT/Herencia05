package servidores;
import java.util.*;
public class AppServidor {
    private static Ordenador[] lista = new Ordenador[1024];
    private static int indice = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int crearOrd, opcion = -1;

        System.out.println("-::CREACIÓN DE ORDENADORES::-");
        System.out.print("\t-Cuantos deseas introducir a la red: ");
        crearOrd = sc.nextInt();


    }

    public static boolean comprobarIp(String ip){
        if (ip.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\b){4}$!")){
            return true;
        }
        return false;
    }

    public static void crearOrdenadores(Red red, int nOrd){
        Scanner sc = new Scanner(System.in);
        int ip1 = -1, ip2 = -1, ip3 = -1, ip4 = -1, bi = -1;
        boolean verificado = false;
        String ip, bits, nombre;

        for (int i = 0; i < nOrd; i++) {
            System.out.print("\t\tIntroduce la IP: ");
            ip = sc.nextLine().trim();
            String[] partes = ip.split("\\.");

            while(!comprobarIp(ip) && UtilBin.confirmarIp(ip1,ip2,ip3,ip4)) {
                System.out.print("\t\t::ERROR:: Introduce de nuevo la IP: ");
                ip = sc.nextLine().trim();
                ip1 = Integer.parseInt(partes[0]);
                ip2 = Integer.parseInt(partes[1]);
                ip3 = Integer.parseInt(partes[2]);
                ip4 = Integer.parseInt(partes[3]);
            }

            System.out.print("\t\tIntroduce los Bits d red: ");
            bits = sc.nextLine().trim();

            while(!verificado) {
                System.out.print("\t\tIntroduce de nuevo los Bits d red (0-32): ");
                bits = sc.nextLine().trim();

                if (bits.matches("[0-9]{1,2}")) {
                    bi = Integer.parseInt(bits);
                    if (bi >= 0 && bi <= 32) {
                        verificado = true;
                    }else {
                        System.out.println("\t\t::ERROR:: El rango debe ser de 0 a 32.");
                    }
                }else {
                    System.out.println("\t\t::ERROR:: Formato incorrecto. Introduce solo números.");
                }
            }

            System.out.print("\\tIntroduce el nombre del ordenador: ");
            nombre = sc.nextLine().trim();

            lista[indice] = new Ordenador(ip1, ip2, ip3, ip4, bi, nombre);

            System.out.println(red.comprobarOrd(lista[indice])?"Creado correctamente":"::ERROR:: Ya existe en la red");
            if (red.comprobarOrd(lista[indice])){
                indice++;
            }else {
                lista[indice] = null;
                nOrd++;
            }
        }
    }
}
