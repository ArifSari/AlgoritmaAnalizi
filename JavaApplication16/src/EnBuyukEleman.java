/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

public class EnBuyukEleman {
    public static void main(String[] args) {
        Random rand = new Random();
        int ElemanSayisi = rand.nextInt(25) + 1;
        int dizi[] = new int[ElemanSayisi];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = rand.nextInt(100) + 1;

        }
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + "/");
        }
        System.out.println("");
        enBuyukEleman(dizi);
    }
    
    
    public static void enBuyukEleman(int C[]){
        try {
            int e1=0 , e2=0;
            for (int i = 0; i < C.length; i++) {
                e1=C[i];
                if(e1>e2){
                    e2=e1;
                }
            }
            System.out.println("en buyuk eleman : "+e2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    } 
}
