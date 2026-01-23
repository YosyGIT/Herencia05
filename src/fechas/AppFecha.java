package fechas;

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
    }

}
