/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

/**
 *
 * @author arif
 */
public class JavaApplication17 {

    public static void main(String[] args) {
        Nvezir n1 = new Nvezir();
        boolean b = n1.Vezir_yerlestir(0);
        System.out.println( b);
        n1.tahtayi_goruntule();
        boolean b2 = n1.tehditAltindaMi(1, 1);
        System.out.println(b2);

    }
}
