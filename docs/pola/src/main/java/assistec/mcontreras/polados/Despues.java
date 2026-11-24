package assistec.mcontreras.polados;

// DESPUÉS: aplica POLA.
// Cada dato tiene un nombre claro con su unidad (Kg, M) y se valida al crear el usuario.
// Si un dato es incorrecto, el programa avisa con un mensaje claro en lugar de dar un resultado falso.

public class Despues {

    static class Usuario {
        private double pesoKg;
        private double estaturaM;
        private int edad;
        private String genero; // "masculino" o "femenino"

        // Constructor: aquí se validan los datos
        Usuario(double pesoKg, double estaturaM, int edad, String genero) {
            if (pesoKg <= 0) {
                throw new IllegalArgumentException("El peso debe ser mayor que 0. Recibido: " + pesoKg);
            }
            if (estaturaM <= 0 || estaturaM > 2.5) {
                throw new IllegalArgumentException("La estatura debe estar en metros (entre 0 y 2.5). Recibido: " + estaturaM);
            }
            if (edad <= 0 || edad > 120) {
                throw new IllegalArgumentException("La edad debe estar entre 1 y 120. Recibido: " + edad);
            }
            genero = genero.trim().toLowerCase();
            if (!genero.equals("masculino") && !genero.equals("femenino")) {
                throw new IllegalArgumentException("El género debe ser masculino o femenino. Recibido: " + genero);
            }

            this.pesoKg = pesoKg;
            this.estaturaM = estaturaM;
            this.edad = edad;
            this.genero = genero;
        }

        // IMC = peso / (estatura * estatura)
        double imc() {
            return pesoKg / (estaturaM * estaturaM);
        }

        // Devuelve true o false (un IMC normal está entre 18.5 y 25)
        boolean esSaludable() {
            double valorImc = imc();
            if (valorImc >= 18.5 && valorImc < 25) {
                return true;
            }
            return false;
        }

        // Fórmula estándar: 1.20 * IMC + 0.23 * edad - 10.8 * (1 si es hombre) - 5.4
        double porcentajeGrasa() {
            int hombre = 0;
            if (genero.equals("masculino")) {
                hombre = 1;
            }
            return 1.20 * imc() + 0.23 * edad - 10.8 * hombre - 5.4;
        }
    }
}


