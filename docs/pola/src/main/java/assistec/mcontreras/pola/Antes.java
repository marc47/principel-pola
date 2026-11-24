
package assistec.mcontreras.pola;

public class Antes {
    static double calcularImc(double peso, double altura) {
    return peso / (altura * altura);
    }
 
    
    //SORPRESA 1:
    static boolean saludable(double altura, double peso) {
        double metros = altura / 100;
        double imc = peso / (metros * metros);
        return imc >= 18.5 && imc < 25;
    }
    
    // SORPRESA 2;
    static int clasificar(double imc) {
        if (imc < 18.5) {
            return 1;          
        }
        if (imc < 25) {
            return 2;
        }
        return 3;
    }
    
}
