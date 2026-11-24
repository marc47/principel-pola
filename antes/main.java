
package assistec.mcontreras.pola;

import static assistec.mcontreras.pola.Antes.calcularImc;
import static assistec.mcontreras.pola.Antes.clasificar;
import static assistec.mcontreras.pola.Antes.saludable;
import java.util.Scanner;
public class Pola {

    public static void main(String[] args) {
        System.out.println("Hello Campuslands Team");
        Scanner esc = new Scanner(System.in);
        double imc = 0;
        double altura = 0;
        double peso = 0;
        
        System.out.println("Ingrese su estatura en metros: ");
        altura = esc.nextDouble();
        System.out.println("Ingrese su peso en Kilogramos: ");
        peso = esc.nextDouble();
        imc = calcularImc(peso, altura);
        System.out.println("IMC: " + imc);
        
        // SORPRESA 1: usamos los mismos datos (70 kg, 1.75 m)
        System.out.println("¿Saludable? " + saludable(altura, peso) + "   <- resultado incorrecto, sin error");

        // SORPRESA 2: ¿qué significa 2?
        System.out.println("Clasificación: " + clasificar(imc) + "   <- ¿2 es bueno o malo?");

        // SORPRESA 3: un dato inválido y el programa sigue como si nada
        System.out.println("IMC con altura 0: " + calcularImc(altura, peso) + "   <- Infinity, sin aviso");
        
    }
}
