package abstr;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class AppFiguras {
    public static void main(String[] args) {
        Figura f = new Cuadrado(8);
        Triangulo t = new Triangulo("Tiangulo 1", 4,4,4);

        System.out.println("Area de un cuadrado lado 8: " + f.calcularArea());
        System.out.println("Area de un triangulo lados 4: " + t.calcularArea());

        Triangulo f1 = t;

        System.out.println(((Triangulo) t).getLado1());

/*
        if (f1 instanceof Figura) {
            Triangulo triangulo = (Triangulo) t;
            System.out.println(triangulo.getLado1());
        }
*/
        Cuadrado c2 = new Cuadrado(100);
        Persona p1 = new Persona("Xavi", "Alonso");

        Escribible e1;
        e1 = c2;

        System.out.println(e1.escribir());

    }
}
