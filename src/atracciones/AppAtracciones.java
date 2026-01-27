package atracciones;
import java.time.LocalDate;
import java.util.*;
public class AppAtracciones {
    private static TecnicoMantenimiento[] listTecnicos = new TecnicoMantenimiento[5];
    private static Cliente[] listCliente = new Cliente[100];
    private static int contadorClientes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrusel carrusel;
        MontanaRusa montana;
        int opcionNum;
        String opcion = "";

        while(!opcion.matches("[8]")){
            System.out.println("\t\tMENU PRINCIPAL");
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
                    /**
                    asignarTecnico(sc, (Atraccion) Carrusel);**/
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

        System.out.print("-Ingrese el nombre del cliente: ");
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
        while (!altura.matches("[A-ZÑa-zñ]+")){
            System.out.print("\n::ERROR:: Formato erroneo \n-Introduce la altura del cliente: ");
            altura = sc.nextLine().trim();
        }
        alt = Double.parseDouble(altura);

        Cliente c = new Cliente(nombre,fecha, alt);
        contadorClientes++;
        System.out.println("-::Cliente creado correctamente::-" +
                "\n" + c.toString());
    }

    public static void crearTecnico(Scanner sc){
        String nombre, fechaAntiguedad;
        String[] digitos = new String[3];
        LocalDate fecha;
        int anio, mes, dia;

        System.out.println("-Ingrese el nombre del Tecnico");
        nombre = sc.nextLine().trim();

        System.out.print("-Ingrese el fecha de nacimiento del cliente (xx/xx/xxxx): ");
        fechaAntiguedad = sc.nextLine().trim();
        while(!fechaAntiguedad.matches("^([1-9]|0[1-9]|[12][1-9]|3[01])/(1[012]|0[1-9]|[1-9])/\\d{4}$")){
            System.out.print("\n::ERROR:: Formato erroneo \n-Introduce la decha de nacimiento del cliente (xx/xx/xxxx): ");
            fechaAntiguedad = sc.nextLine().trim();
        }
        digitos = fechaAntiguedad.split("/");
        anio = Integer.parseInt(digitos[2]);
        mes = Integer.parseInt(digitos[1]);
        dia = Integer.parseInt(digitos[0]);
        fecha = LocalDate.of(anio, mes,dia);

        TecnicoMantenimiento t = new TecnicoMantenimiento(nombre, fecha);
        System.out.println("-::Tecnico creado correctamente::-" +
                "\n" + t.toString());
    }

    public static void asignarTecnico(Scanner sc, Atraccion a){
        String opcion;
        TecnicoMantenimiento tecnico;

        System.out.println("Seleccione la atracción" +
                "\n1) Montaña Rusa Extrema" +
                "\n2) Carrusel Infantil");
        System.out.print("->");
        opcion = sc.nextLine().trim();

        while(!opcion.matches("[12]")){
            System.out.print("\n::ERROR:: Formato erroneo \n-Introduce una atracción(1 o 2): ");
            opcion = sc.nextLine().trim();
        }

        asignarAtraccion(opcion, listarTecnicos(sc), a);
    }

    public static void asignarAtraccion(String opcion, TecnicoMantenimiento t, Atraccion a){
        if (opcion.matches("[1]")){
            a.setT(t);
        } else if (opcion.matches("[2]")) {
            a.setT(t);
        }
    }

    public void asignarAtraccion(String opcion, Cliente c, Atraccion a, Atraccion a2){
        if (opcion.matches("[1]")){

        } else if (opcion.matches("[2]")) {

        }
    }

    public static TecnicoMantenimiento listarTecnicos(Scanner sc){
        int cont = 1, opcion;

        for (int i = 0; i < listTecnicos.length; i++){
            if (listTecnicos[i] != null){
                System.out.println(cont + listTecnicos[i].toString());
                cont++;
            }
        }
        System.out.print("Elije un tecnico: ");
        opcion = sc.nextInt();

        return listTecnicos[opcion - 1];
    }
}
