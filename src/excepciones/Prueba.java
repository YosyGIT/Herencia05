package excepciones;
import java.util.*;
public class Prueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        boolean exception = false;

        try{
            System.out.print("Introduce un numero: ");
            opcion = sc.nextInt();
        }catch (Exception e){
            System.out.println("Valor mal introducido");
            exception = true;
            sc.next();
        }

        if (exception){
            try{
                System.out.print("\nIntroduce un numero de nuevo: ");
                opcion= sc.nextInt();
            }catch (Exception e){
                System.out.println("Valor mal introducido otra vez");
            }
        }

    }
}
