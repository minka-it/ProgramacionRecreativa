/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primosgemelos;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author dany
 */
public class PrimosGemelos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date inicio = Date.from(Instant.now());
        int n;
        for (int i = 1; i <= 20; i++) {
            // Codigo secuencial
            n = funcion(i);
            if (!isPrimo(n + 1) || !isPrimo(n - 1)) {
                System.out.println(i + ") N+1=" + (n + 1) + "  N-1=" + (n - 1));
            }
            
            // Ejectua en paralelo, pero necesita el la clase Calcular
            //new Calcular(i).start(); 
        }
        Date fin = Date.from(Instant.now());
        System.out.println("Tardo en ejecutar: " + (fin.getTime() - inicio.getTime()) + " milisegundos");
    }

    /**
     * Aplica la formula de A. H. Beiler para numeros primos gemelos.
     *
     * @param x valor para aplicar la formula
     * @return resultado de aplicar la formula.
     */
    static int funcion(int x) {
        return 30 * (2 * x - 27) * (x - 15);
    }

    /**
     * Funcion que determina si un numero es primo.
     *
     * @param num número que se desea determinar si es primo.
     * @return true si el valor es primo, false de lo contrario
     */
    static boolean isPrimo(int num) {
        boolean noEsPrimo;
        if (num <= 0) {
            noEsPrimo = true;
        } else if (num == 2) {
            noEsPrimo = false;
        } else {
            noEsPrimo = (num % 2) == 0;
            int i = 3;
            while (!noEsPrimo && i < (num / 2)) {
                noEsPrimo = (num % i) == 0;
                i = i + 2;
            }
        }
        return !noEsPrimo;
    }
}
