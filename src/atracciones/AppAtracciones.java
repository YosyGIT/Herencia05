package atracciones;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class AppAtracciones {
    private static TecnicoMantenimiento[] listTecnicos = new TecnicoMantenimiento[5];
    private static Cliente[] listClientes = new Cliente[100];
    private static int contadorTecnicos = 0;
    private static int contadorClientes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrusel carrusel  = new Carrusel("Carrusel infantil", 2.5);
        MontanaRusa montana = new  MontanaRusa("Montana Rusa Extrema", 5);
        TecnicoMantenimiento tec;
        Cliente cliente;
        int opcionNum, contCola;
        String opcion = "", opcionAtraccion = "";

        while(!opcion.matches("[8]")){
            System.out.println("\n\t\tMENU PRINCIPAL");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear Técnico de atracción");
            System.out.println("3. Asignar técnico a atracción");
            System.out.println("4. Hacer mantenimiento a atracción");
            System.out.println("5. Mostrar información de atracciones");
            System.out.println("6. Añadir cliente a la cola de atracción ");
            System.out.println("7. Quitar cliente de la cola de atracción");
            System.out.println("8. Salir");
            System.out.print("->");
            opcion = sc.nextLine().trim();

            while(!opcion.matches("[12345678]")){
                System.out.print("\n::ERROR:: Formato erroneo \nIntroduce una opcion de nuevo: ");
                opcion = sc.nextLine();
            }
            opcionNum = Integer.parseInt(opcion);

            switch (opcionNum){
                case 1:
                    crearCliente(sc);
                break;

                case 2:
                    crearTecnico(sc);
                break;

                case 3:
                    opcionAtraccion = listarAtracciones(sc);
                    tec = listarTecnicos(sc);
                    if (opcionAtraccion.matches("[1]")){
                        asignarAtraccion(opcionAtraccion, tec, montana);
                    }else if (opcionAtraccion.matches("[2]")){
                        asignarAtraccion(opcionAtraccion, tec, carrusel);
                    }
                break;

                case 4:
                    opcionAtraccion = listarAtracciones(sc);
                    if (opcionAtraccion.matches("[1]")){
                        hacerMantenimiento(sc, montana);
                    }else if (opcionAtraccion.matches("[2]")){
                        hacerMantenimiento(sc, carrusel);
                    }
                break;

                case 5:
                    opcionAtraccion = listarAtracciones(sc);
                    if (opcionAtraccion.matches("[1]")){
                        System.out.println(mostrarInformacionAtracciones(montana));
                        System.out.println("\nClientes en cola: ");
                        listarClientesAtraccion(montana);
                    }else if (opcionAtraccion.matches("[2]")){
                        System.out.println(mostrarInformacionAtracciones(carrusel));
                        System.out.println("\nClientes en cola: ");
                        listarClientesAtraccion(carrusel);
                    }
                break;

                case 6:
                    opcionAtraccion = listarAtracciones(sc);
                    if (opcionAtraccion.matches("[1]")){
                        cliente = listarClientesAtraccion(sc, montana);

                        if (!montana.yaEstaEnCola(cliente) && cliente.getEdad() >= 12 && cliente.getAltura() >= 1.4){
                            montana.anadirClienteCola(cliente);
                        }else {
                            System.out.println("El cliente no cumple con los requisitos.");
                        }

                    } else if (opcionAtraccion.matches("[2]")) {
                        cliente = listarClientesAtraccion(sc, carrusel);
                        if (!carrusel.yaEstaEnCola(cliente) && cliente.getEdad() >= 3){
                            carrusel.anadirClienteCola(cliente);
                        }else {
                            System.out.println("El cliente no cumple con los requisitos.");
                        }
                    }
                    sc.nextLine();
                break;

                case 7:
                    opcionAtraccion = listarAtracciones(sc);
                    if (opcionAtraccion.matches("[1]")){
                        cliente = listarClientesAtraccion(sc, montana);
                        if (montana.yaEstaEnCola(cliente)){
                            montana.quitarClienteCola(cliente);
                            System.out.println("Se ha quitado correctamente de la cola.");
                        }else {
                            System.out.println("El cliente no se encuentra en la cola de esta atracción.");
                        }
                    } else if (opcionAtraccion.matches("[2]")) {
                        cliente = listarClientesAtraccion(sc, carrusel);
                        if (!carrusel.yaEstaEnCola(cliente)){
                            carrusel.quitarClienteCola(cliente);
                            System.out.println("Se ha quitado correctamente de la cola.");
                        }else {
                            System.out.println("El cliente no se encuentra en la cola de esta atracción.");
                        }
                    }
                    sc.nextLine();
                    break;
            }
        }
    }

    public static void crearCliente(Scanner sc){
        String fechaNacimiento, nombre, altura;
        String[] digitos = new String[3];
        LocalDate fecha;
        int anio, mes, dia;
        double alt;

        if(contadorClientes < 100){
            System.out.print("\n-Ingrese el nombre del cliente: ");
            nombre = sc.nextLine().trim();

            System.out.print("-Ingrese el fecha de nacimiento del cliente (xx/xx/xxxx): ");
            fechaNacimiento = sc.nextLine().trim();
            while(!fechaNacimiento.matches("^([1-9]|0[1-9]|[12][1-9]|3[01])/(1[012]|0[1-9]|[1-9])/\\d{4}$")){
                System.out.print("\n::ERROR:: Formato erroneo \n-Introduce la decha de nacimiento del cliente (xx/xx/xxxx): ");
                fechaNacimiento = sc.nextLine().trim();
            }
            digitos = fechaNacimiento.split("/");
            anio = Integer.parseInt(digitos[2]);
            mes = Integer.parseInt(digitos[1]);
            dia = Integer.parseInt(digitos[0]);
            fecha = LocalDate.of(anio, mes,dia);

            System.out.print("-Introduce la altura del cliente: ");
            altura = sc.nextLine().trim();
            while (!altura.matches("[0-9].[0-9]*")){
                System.out.print("\n::ERROR:: Formato erroneo \n-Introduce la altura del cliente: ");
                altura = sc.nextLine().trim();
            }
            alt = Double.parseDouble(altura);

            Cliente c = new Cliente(nombre,fecha, alt);
            listClientes[contadorClientes] = c;
            contadorClientes++;
            System.out.println("\n-::Cliente creado correctamente::-" +
                    "\n" + c.toString());
        }else {
            System.out.println("La lista de clientes esta completa");
        }
    }

    public static void crearTecnico(Scanner sc){
        String nombre, fechaAntiguedad;
        String[] digitos = new String[3];
        LocalDate fecha;
        int anio, mes, dia;

        if (contadorTecnicos < 5){
            System.out.print("\n-Ingrese el nombre del Tecnico: ");
            nombre = sc.nextLine().trim();

            System.out.print("-Ingrese la fecha de antigüedad del tecnico (xx/xx/xxxx): ");
            fechaAntiguedad = sc.nextLine().trim();
            while(!fechaAntiguedad.matches("^([1-9]|0[1-9]|[12][1-9]|3[01])/(1[012]|0[1-9]|[1-9])/\\d{4}$")){
                System.out.print("\n::ERROR:: Formato erroneo \n-Introduce la decha de nacimiento del tecnico (xx/xx/xxxx): ");
                fechaAntiguedad = sc.nextLine().trim();
            }
            digitos = fechaAntiguedad.split("/");
            anio = Integer.parseInt(digitos[2]);
            mes = Integer.parseInt(digitos[1]);
            dia = Integer.parseInt(digitos[0]);
            fecha = LocalDate.of(anio, mes,dia);

            TecnicoMantenimiento t = new TecnicoMantenimiento(nombre, fecha);
            System.out.println("\n-::Tecnico creado correctamente::-" +
                    "\n" + t.toString());
            listTecnicos[contadorTecnicos] = t;
            contadorTecnicos++;
        }else {
            System.out.println("La lista de tecnicos esta completa");
        }
    }

    public static void asignarAtraccion(String opcion, TecnicoMantenimiento t, Atraccion a){
        if (opcion.matches("[1]")){
            a.setT(t);
        } else if (opcion.matches("[2]")) {
            a.setT(t);
        }
    }

    public static String listarAtracciones(Scanner sc){
        String opcion;

        System.out.println("\nSeleccione la atracción" +
                "\n1) Montaña Rusa Extrema" +
                "\n2) Carrusel Infantil");
        System.out.print("->");
        opcion = sc.nextLine().trim();

        while(!opcion.matches("[12]")){
            System.out.print("\n::ERROR:: Formato erroneo \n-Introduce una atracción(1 o 2): ");
            opcion = sc.nextLine().trim();
        }

        return opcion;
    }

    public static TecnicoMantenimiento listarTecnicos(Scanner sc){
        int cont = 1, opcion;

        if (contadorTecnicos > 0){
            for (int i = 0; i < listTecnicos.length; i++){
                if (listTecnicos[i] != null){
                    System.out.println(cont + ") " + listTecnicos[i].toString());
                    cont++;
                }
            }
            System.out.print("Elije un tecnico: ");
            opcion = sc.nextInt();

            return listTecnicos[opcion - 1];
        }
        System.out.println("No hay tecnicos registrados en los datos");
        return null;

    }

    public static void listarClientesAtraccion(Atraccion a){
        int cont = 1;
        if (a.getContCola() != 0){
            for (Cliente c : a.getCola()){
                if (c != null){
                    System.out.println(cont + ") " + c.toString());
                    cont++;
                }
            }
        }else {
            System.out.println("No hay clientes a la espera");
        }

    }

    public static Cliente listarClientesAtraccion(Scanner sc, Atraccion a){
        int cont = 1, opcion;
        for (Cliente c : listClientes){
            if (c != null){
                System.out.println(cont + ") " + c.toString());
                cont++;
            }
        }
        System.out.print("Elije un cliente: ");
        opcion = sc.nextInt();
        return listClientes[opcion - 1];
    }

    public static void hacerMantenimiento(Scanner sc, Atraccion a){
        if (a.getT()!=null){
            LocalDateTime fecha = LocalDateTime.now();
            a.setFechaUltimoMantenimiento(fecha);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println("Tecnico responsable: " + a.getT().toString() +
                    "\nFecha de Mantenimiento: " + a.getFechaUltimoMantenimiento().format(formato));
        }else {
            System.out.println("No hay tecnicos agregados para esta atracción.");
        }

    }

    public static String mostrarInformacionAtracciones(Atraccion a){
        return a.toString();
    }
}
