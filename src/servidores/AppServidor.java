package servidores;
import java.util.*;
public class AppServidor {
    private static Ordenador[] pcLista = new Ordenador[1024];
    private static int indice = 0;
    private static Red[] redesLista =  new Red[1024];
    private static int redes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Red red = null;
        Servidor serv = null;
        Ordenador pc = null;
        String nombreRed, nombrePC;
        int crearOrd, opcion = -1, opcionRed = -1, opcionServ = -1, opcionPC = -1, tipoServ;

        while (opcion != 4) {
            System.out.println("\t\t\tMENU");
            System.out.println("1. Redes");
            System.out.println("2. Servidores");
            System.out.println("3. Ordenadores");
            System.out.println("4. Salir");
            System.out.print("->");
            opcion = sc.nextInt();

            while (opcion < 0 || opcion > 4) {
                System.out.print("::ERROR:: VALOR FUERA DEL RANGO\n " +
                        "-Intentelo de nuevo: ");
                opcion = sc.nextInt();
            }

            switch (opcion) {
                case 1:
                    while (opcionRed != 8) {
                        System.out.println("\n\t\t\tMENU REDES");
                        System.out.println("1. Crear red");
                        System.out.println("2. Eliminar red");
                        System.out.println("3. Agregar ordenador/es");
                        System.out.println("4. Eliminar ordenador/es");
                        System.out.println("5. Asigar servicios");
                        System.out.println("6. Mostrar ordenadores");
                        System.out.println("7. Mostar host y red");
                        System.out.println("8. Salir");
                        System.out.print("->");
                        opcion = sc.nextInt();

                        while (opcion < 0 || opcion > 8) {
                            System.out.print("::ERROR:: VALOR FUERA DEL RANGO\n " +
                                    "-Intentelo de nuevo: ");
                            opcion = sc.nextInt();
                        }

                        switch (opcionRed) {
                            case 1:
                                crearRed();
                            break;

                            case 2:

                            break;
                        }
                    }
                    break;

                case 2:
                    while (opcionServ != 3) {
                        System.out.println("\n\t\t\tMENU SERVIDOR");
                        System.out.println("1. Crear red");
                        System.out.println("2. Eliminar red");
                        System.out.println("3. Salir");
                        System.out.print("->");
                        opcionServ = sc.nextInt();

                        while (opcionServ < 0 || opcionServ > 3) {
                            System.out.print("::ERROR:: VALOR FUERA DEL RANGO\n " +
                                    "-Intentelo de nuevo: ");
                            opcionServ = sc.nextInt();
                        }

                        switch (opcionServ) {
                            case 1:
                                serv = crearServidor();
                            break;

                            case 2:
                                System.out.print("Introduce el tipo de servidor al que deseas cambiar(1: Windows | 2: Linux): ");
                                tipoServ = sc.nextInt();

                                while (tipoServ < 1 || tipoServ > 2) {
                                    System.out.print("::ERROR:: VALOR FUERA DEL RANGO\n " +
                                            "-Intentelo de nuevo: ");
                                    tipoServ = sc.nextInt();
                                }
                                serv.setTipo(tipoServ);
                            break;
                        }
                    }
                    break;

                case 3:
                    while (opcionPC != 4) {
                        System.out.println("\n\t\t\tMENU ORDENADOR");
                        System.out.println("1. Crear ordenador");
                        System.out.println("2. Mostar host y red");
                        System.out.println("3. Mostrar datos");
                        System.out.println("4. Salir");
                        System.out.print("->");
                        opcionPC = sc.nextInt();

                        while (opcionPC < 0 || opcionPC > 4) {
                            System.out.print("::ERROR:: VALOR FUERA DEL RANGO\n " +
                                    "-Intentelo de nuevo: ");
                            opcionPC = sc.nextInt();
                        }

                        switch (opcionPC) {
                            case 1:
                                System.out.println("\n\t\t-::CREACIÓN DE ORDENADORES::-");

                                if(redes > 0){
                                    System.out.print("¿Deseas agregarlos a una red?: ");
                                    nombreRed = sc.nextLine().trim();

                                    for (Red r : redesLista) {
                                        if (r.getNombre().equals(nombreRed)) {
                                            red = r;
                                        }
                                    }
                                }

                                System.out.print("\t-Cuantos deseas crear: ");
                                crearOrd = sc.nextInt();

                                while(crearOrd < 1 || crearOrd > indice) {
                                    System.out.println("\t::ERROR:: VALOR FUERA DEL RANGO\n " +
                                            "\t-Intentelo de nuevo: ");
                                    crearOrd = sc.nextInt();
                                }

                                crearOrdenadores(red, crearOrd);
                            break;

                            case 2:
                                if (indice > 0){
                                    System.out.print("Introduce el nombre del dispositivo: ");
                                    nombrePC = sc.nextLine().trim();

                                    for (Ordenador o : pcLista){
                                        if (o.getNombre().equalsIgnoreCase(nombrePC)) {
                                            pc = o;
                                        }
                                    }
                                    System.out.println(pc.toString());
                                }else {
                                    System.out.println("-::NO HAY DISPOSITIVOS CREADOS::-");
                                }
                            break;

                            case 3:

                            break;
                        }
                    }
                break;

                case 4:
                    System.out.println("-::CERRANDO PROGRAMA::-");
                break;

            }




        }
    }

    public static boolean comprobarIp(String ip){
        if (ip.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$")){
            return true;
        }
        return false;
    }

    public static void crearOrdenadores(Red red, int nOrd){
        Scanner sc = new Scanner(System.in);
        int ip1 = -1, ip2 = -1, ip3 = -1, ip4 = -1, bi = -1;
        boolean verificado = false;
        String ip, bits, nombre, opcion;

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

            System.out.print("\t\tIntroduce el nombre del ordenador: ");
            nombre = sc.nextLine().trim();

            pcLista[indice] = new Ordenador(ip1, ip2, ip3, ip4, bi, nombre);

            System.out.println(red.comprobarOrd(pcLista[indice])?"\t\tCreado correctamente":"\t\t::ERROR:: Ya existe en la red");
            if (red.comprobarOrd(pcLista[indice])){
                indice++;
            }else {
                pcLista[indice] = null;
                nOrd++;
            }
        }

        System.out.print("\t\t¿Deseas agregar los equipos en alguna red?(S/N): ");
        opcion = sc.nextLine().trim();

        while(!opcion.matches("[SNsn]]")){
            System.out.print("\t\t::ERROR:: Debes introducir (S) para confirmar o (N) para negar: ");
            opcion = sc.nextLine().trim();
        }

        if (opcion.equals("S")) {

        }else if (opcion.equals("N")) {

        }
    }

    public static Red crearRed() {
        Scanner sc = new Scanner(System.in);
        int ip1 = -1, ip2 = -1, ip3 = -1, ip4 = -1, bi = -1;
        boolean verificado = false;
        String ip, bits, nombre, opcion;

        System.out.print("\t\tIntroduce la IP: ");
        ip = sc.nextLine().trim();
        String[] partes = ip.split("\\.");

        while (!comprobarIp(ip) && UtilBin.confirmarIp(ip1, ip2, ip3, ip4)) {
            System.out.print("\t\t::ERROR:: Introduce de nuevo la IP: ");
            ip = sc.nextLine().trim();
            ip1 = Integer.parseInt(partes[0]);
            ip2 = Integer.parseInt(partes[1]);
            ip3 = Integer.parseInt(partes[2]);
            ip4 = Integer.parseInt(partes[3]);
        }

        System.out.print("\t\tIntroduce los Bits d red: ");
        bits = sc.nextLine().trim();

        while (!verificado) {
            System.out.print("\t\tIntroduce de nuevo los Bits d red (0-32): ");
            bits = sc.nextLine().trim();

            if (bits.matches("[0-9]{1,2}")) {
                bi = Integer.parseInt(bits);
                if (bi >= 0 && bi <= 32) {
                    verificado = true;
                } else {
                    System.out.println("\t\t::ERROR:: El rango debe ser de 0 a 32.");
                }
            } else {
                System.out.println("\t\t::ERROR:: Formato incorrecto. Introduce solo números.");
            }
        }

        System.out.print("\t\tIntroduce el nombre del ordenador: ");
        nombre = sc.nextLine().trim();

        return new Red(ip1, ip2, ip3, ip4, bi, nombre);
    }

    public static Servidor crearServidor() {
        Scanner sc = new Scanner(System.in);
        int ip1 = -1, ip2 = -1, ip3 = -1, ip4 = -1, bi = -1;
        boolean verificado = false;
        String ip, bits, nombre, opcion;

        System.out.print("\t\tIntroduce la IP: ");
        ip = sc.nextLine().trim();
        String[] partes = ip.split("\\.");

        while (!comprobarIp(ip) && UtilBin.confirmarIp(ip1, ip2, ip3, ip4)) {
            System.out.print("\t\t::ERROR:: Introduce de nuevo la IP: ");
            ip = sc.nextLine().trim();
            ip1 = Integer.parseInt(partes[0]);
            ip2 = Integer.parseInt(partes[1]);
            ip3 = Integer.parseInt(partes[2]);
            ip4 = Integer.parseInt(partes[3]);
        }

        System.out.print("\t\tIntroduce los Bits d red: ");
        bits = sc.nextLine().trim();

        while (!verificado) {
            System.out.print("\t\tIntroduce de nuevo los Bits d red (0-32): ");
            bits = sc.nextLine().trim();

            if (bits.matches("[0-9]{1,2}")) {
                bi = Integer.parseInt(bits);
                if (bi >= 0 && bi <= 32) {
                    verificado = true;
                } else {
                    System.out.println("\t\t::ERROR:: El rango debe ser de 0 a 32.");
                }
            } else {
                System.out.println("\t\t::ERROR:: Formato incorrecto. Introduce solo números.");
            }
        }

        System.out.print("\t\tIntroduce el nombre del ordenador: ");
        nombre = sc.nextLine().trim();

        return new Servidor(ip1, ip2, ip3, ip4, bi, nombre);
    }

    public static void listarRedes(){
        int cont = 0;
        for (Red r : redesLista){
            if (r != null){
                System.out.println("----------------");
                System.out.println(cont + ") " + r.toString());
                System.out.println("----------------");
                cont++;
            }
        }
    }

    public static void listarOrdenadores(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int cont = 0, lista;

        System.out.print("Deseas ver la lista de una red especifica(S/N): ");
        opcion = sc.nextLine().trim();

        while(opcion.matches("[SNsn]")){
            System.out.print("\t::ERROR:: FORMATO INCORRECTO\n " +
                    "\t-Intentelo de nuevo: ");
            opcion = sc.nextLine().trim();
        }

        if (opcion.equalsIgnoreCase("S")){
            listarRedes();
            System.out.print("Introduce el numero de la red: ");
            lista = sc.nextInt();
            for (String o : redesLista[lista].mostarOrdenadores()){
                System.out.println("----------------");
                System.out.println(cont + ") " + o.toString());
                System.out.println("----------------");
                cont++;
            }
        }else if (opcion.equalsIgnoreCase("N")){
            for (Ordenador o : pcLista){
                if (o != null){
                    System.out.println("----------------");
                    System.out.println(cont + ") " + o.toString());
                    System.out.println("----------------");
                    cont++;
                }
            }
        }
    }
}
