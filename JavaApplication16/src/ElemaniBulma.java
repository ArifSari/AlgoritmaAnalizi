/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;
public class ElemaniBulma {
    public static void main(String[] args) {

        ElemaniAra();

    }
    
    public static void ElemaniAra(){
    System.out.println("dizi boyutunu girin");
    Scanner diziBoyutu = new Scanner(System.in);
    int boyut = diziBoyutu.nextInt();
    System.out.println("buyukten kucuge için '1' , kucukten buyuge için '2' ye basın");
    int sirala = diziBoyutu.nextInt();
    System.out.println(" indexi girin ");
    int index = diziBoyutu.nextInt();
    Random rast = new Random();
    int dizi[] = new int[boyut];
    for(int i=0; i < dizi.length ; i++){
        dizi[i] = rast.nextInt(50)+1;
    }
    System.out.println("olusturulan dizi");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print("/" + dizi[i]);
    }
    System.out.println("");
    int gecici; 
    for (int i = 1; i < dizi.length; i++) {
            for (int j = 0; j < dizi.length - i; j++) {

                if (dizi[j] > dizi[j + 1]) {
                    gecici = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = gecici;

                }
            }
    }        
    System.out.println("dizinin sirali hali");
    for (int i = 0; i < dizi.length; i++) {
           System.out.print("/" + dizi[i]);

        }
        System.out.println("");
        if (sirala == 1) {
            System.out.println("dizinin en büyük  " + index + " inci elemanı " + dizi[dizi.length - index]);
        }else if (sirala == 2) {
            System.out.println("dizinin en kucuk  " + index + " inci elemanı " + dizi[index]);
        } else {
            System.out.println("1 ya da 2 girin");
        }

    }
}

