package assistec.mcontreras.polados;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner esc = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombre = esc.nextLine();

        System.out.println("Ingrese su estatura en metros: ");
        double estaturaM = esc.nextDouble();

        System.out.println("Ingrese su peso en kg: ");
        double pesoKg = esc.nextDouble();

        System.out.println("Ingrese su edad: ");
        int edad = esc.nextInt();

        System.out.println("Ingrese su género (masculino/femenino): ");
        String genero = esc.next();

        try {
            Despues.Usuario usuario = new Despues.Usuario(pesoKg, estaturaM, edad, genero);

            System.out.printf("IMC de %s: %.2f%n", nombre, usuario.imc());
            System.out.println("¿Saludable? " + usuario.esSaludable());
            System.out.printf("Grasa: %.1f%%%n", usuario.porcentajeGrasa());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
