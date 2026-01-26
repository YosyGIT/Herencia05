package atracciones;
import java.time.LocalDate;
import java.util.*;
public class AppAtracciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    crearCliente();
                break;

                case 2:
                    crearTecnico();
                break;
            }
        }
    }

    public static void crearCliente(){
        Scanner sc = new Scanner(System.in);
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
        System.out.println("-::Cliente creado correctamente::-" +
                "\n" + c.toString());
    }

    public static void crearTecnico(){
        Scanner sc = new Scanner(System.in);
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


}
