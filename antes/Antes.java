// ANTES: API del medidor corporal que SORPRENDE al usuario.
// Ejecutar: java Antes.java
public class Antes {

    // peso en kg, altura en METROS
    static double calcularImc(double peso, double altura) {
        return peso / (altura * altura);
    }

    // SORPRESA 1: el orden de los datos está al revés y la altura va en CENTÍMETROS
    static boolean esSaludable(double altura, double peso) {
        double metros = altura / 100;
        double imc = peso / (metros * metros);
        return imc >= 18.5 && imc < 25;
    }

    // SORPRESA 2: devuelve un número sin explicar qué significa
    static int clasificar(double imc) {
        if (imc < 18.5) {
            return 1;
        }
        if (imc < 25) {
            return 2;
        }
        return 3;
    }

    public static void main(String[] args) {
        double imc = calcularImc(70, 1.75);
        System.out.println("IMC: " + imc);

        // SORPRESA 1: usamos los mismos datos (70 kg, 1.75 m)
        System.out.println("¿Saludable? " + esSaludable(70, 1.75) + "   <- resultado incorrecto, sin error");

        // SORPRESA 2: ¿qué significa 2?
        System.out.println("Clasificación: " + clasificar(imc) + "   <- ¿2 es bueno o malo?");

        // SORPRESA 3: un dato inválido y el programa sigue como si nada
        System.out.println("IMC con altura 0: " + calcularImc(70, 0) + "   <- Infinity, sin aviso");
    }
}