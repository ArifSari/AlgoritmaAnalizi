/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci_recursive;

/**
 *
 * @author arif
 */
public class Fibonacci_Recursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int fib_degerleri[] = {10, 20, 30, 40, 50, 60, 70};
        long sure[] = new long[7];
        long olusan_degerler[] = new long[7];
        for(int i=0; i<=fib_degerleri.length; i++){
            long baslangıc_zamani = System.currentTimeMillis();
            olusan_degerler[i] = fib(fib_degerleri[i]);
            long bitis_zamani = System.currentTimeMillis();
            sure[i] = bitis_zamani - baslangıc_zamani;
            System.out.println(fib_degerleri[i] + " inci eleman : "+ olusan_degerler[i] + " üretim süresi" + sure[i]);
        }
    }
    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
