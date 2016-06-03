/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primosgemelos;

/**
 *
 * @author dany
 */
public class Calcular extends Thread {

    private int id;
    
    public Calcular(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        int n = funcion(id);
        if (!isPrimo(n + 1) || !isPrimo(n - 1)) {
            System.out.println(id + ") N+1=" + (n + 1) + "  N-1=" + (n - 1));
        }
    }

    /**
     * Aplica la formula de A. H. Beiler para numeros primos gemelos.
     *
     * @param x valor para aplicar la formula
     * @return resultado de aplicar la formula.
     */
    private int funcion(int x) {
        return 30 * (2 * x - 27) * (x - 15);
    }

    /**
     * Funcion que determina si un numero es primo.
     *
     * @param num número que se desea determinar si es primo.
     * @return true si el valor es primo, false de lo contrario
     */
    private boolean isPrimo(int num) {
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
