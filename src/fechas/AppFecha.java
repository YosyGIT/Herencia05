package fechas;

import java.util.Scanner;

public class AppFecha {
    public static void main(String[] args) {
        Fecha hoy = new Fecha();
        Fecha cumple = new Fecha(12, 3, 2000);
        Fecha enero1 = new Fecha(1, 1, 2026);

        System.out.println("Hoy es : " + hoy);
        System.out.println("Mi cumpleaños es: " + cumple);
        System.out.println("Formato largo de hoy: " + hoy.formatoLargo());
        System.out.println("Formato largo de mi cumpleaños: " + cumple.formatoLargo());
        System.out.println("Han pasado " + enero1.diferenciaDias(hoy) + " días desde mi cumpleaños.");
        System.out.println("Tengo " + cumple.diferenciaAnios(hoy) + " años.");

        System.out.println("\n------------\n");

        Scanner sc = new Scanner(System.in);
        int cont = 0;
        String opcion = "", texto = "";
        String[] fecha = new String[3];
        Fecha fechaM = new Fecha();

        System.out.println("Formato para introducir las fechas (08/11/2001)");
        System.out.print("Introduce la fecha: ");
        texto = sc.nextLine().trim();

        while(!opcion.equalsIgnoreCase("S")){
            if (cont > 0){
                System.out.print("Quieres introducir otra fecha?: ");
                opcion = sc.nextLine().trim();
            }

            if(texto.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$")){
                System.out.print("Introduce la fecha: ");
                texto = sc.nextLine().trim();

                fecha = opcion.split("/");
                fecha[0] = fecha[0].trim();
                fecha[1] = fecha[1].trim();
                fecha[2] = fecha[2].trim();

                cont++;
            }else {
                System.out.print("Formato erroneo, introduce otra fecha valida(xx/xx/xxxx): ");
                texto = sc.nextLine().trim();
            }

        }
    }

}
