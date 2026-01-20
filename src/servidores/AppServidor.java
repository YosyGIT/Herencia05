package servidores;
import java.util.*;
public class AppServidor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ordenador[] lista = new Ordenador[1024];
        int crearOrd, ip1, ip2, ip3, ip4;
        String ip;

        System.out.println("-::CREACIÓN DE ORDENADORES::-");
        System.out.print("\t-Cuantos deseas introducir a la red: ");
        crearOrd = sc.nextInt();

        for (int i = 0; i < crearOrd; i++) {
            System.out.println("\t\tIntroduce la IP: ");
            ip = sc.nextLine().trim();
            while(!comprobarIp(ip)) {
                System.out.println("\t\t::ERROR:: Introduce de nuevo la IP: ");
                ip = sc.nextLine().trim();
            }
            ip1 = ip.substring(0, ip.indexOf(".")).hashCode();
            ip2 = ip.substring(4, ip.indexOf(".")).hashCode();
            ip3 = ip.substring(8, ip.indexOf(".")).hashCode();
            ip4 = ip.substring(6, ip.length()).hashCode();


        }
    }

    public static boolean comprobarIp(String ip){
        if (ip.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\b){4}$!")){
            return true;
        }
        return false;
    }
}
