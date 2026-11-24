// DESPUÉS: la misma funcionalidad, aplicando POLA.
// Ejecutar: java Despues.java
public class Despues {

    enum Sexo { HOMBRE, MUJER }   // reemplaza el boolean ambiguo

    // Las unidades están en el nombre y los datos se validan al crear el objeto
    record Persona(double pesoKg, double alturaM, int edad, Sexo sexo) {
        Persona {
            if (pesoKg <= 0)
                throw new IllegalArgumentException("pesoKg debe ser > 0: " + pesoKg);
            if (alturaM <= 0 || alturaM > 2.5)
                throw new IllegalArgumentException("alturaM debe estar en metros (0-2.5): " + alturaM);
        }

        double imc() { return pesoKg / (alturaM * alturaM); }

        boolean esSaludable() { return imc() >= 18.5 && imc() < 25; }

        double porcentajeGrasa() {
            int esHombre = (sexo == Sexo.HOMBRE) ? 1 : 0;
            return 1.20 * imc() + 0.23 * edad - 10.8 * esHombre - 5.4;
        }
    }

    public static void main(String[] args) {
        Persona ana = new Persona(70, 1.75, 30, Sexo.HOMBRE);
        System.out.printf("IMC: %.2f%n", ana.imc());
        System.out.println("¿Saludable? " + ana.esSaludable());
        System.out.printf("Grasa: %.1f%%   <- se lee claro: Sexo.HOMBRE%n", ana.porcentajeGrasa());

        // Los errores ahora se ven de inmediato y dicen qué pasó
        try {
            new Persona(70, 175, 30, Sexo.HOMBRE);   // altura en cm por error
        } catch (IllegalArgumentException e) {
            System.out.println("Error claro: " + e.getMessage());
        }
    }
}
