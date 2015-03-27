/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

/**
 *
 * @author arif
 */
public class Nvezir {
    public static final int TAHTA_BOYUTU = 8; //satir ve sutün sayisi
    boolean[][] tahta;
    public static final boolean BOS = false; //boş kareyi gösterir
    public static final boolean VEZIR = true; //Vezir iceren kareyi gösterir
    public static final int HAREKET = 4; 
    int[] yatay; // yatay hareketler
    int[] dikey; //dikey hareketler
    public int vezir = 0; 
    public Nvezir(){
        // yapıcıda boş tahta olusturuldu
        tahta = new boolean[TAHTA_BOYUTU][TAHTA_BOYUTU];
        for(int satir = 0 ; satir<tahta.length ; satir++){
            for(int sut=0; sut<tahta.length;sut++){
                tahta[satir][sut] = BOS;
            }
        }
        yatay = new int[HAREKET];
        dikey = new int[HAREKET];
        //sag ust
        yatay[0]= -1;
        dikey[0]= 1;
        //sol alt
        yatay[1] = 1;
        dikey[1] = -1;
        //sol üst
        yatay[2] = -1;
        dikey[2] = -1;
        //sag alt
        yatay[3] = 1;
        dikey[3] = 1;
    }
    public boolean Vezir_yerlestir(int sutun){
        if(sutun>=TAHTA_BOYUTU){
            return true;
        }else{
            boolean vezirYerlestir = false;
            int satir = 0;
            while(!vezirYerlestir && satir<TAHTA_BOYUTU){
                if(tehditAltindaMi(satir,sutun)){
                    ++satir;
                }else{
                    vezir_Yerlestir(satir, sutun);
                    vezirYerlestir = Vezir_yerlestir(sutun+1);
                    if(!vezirYerlestir){
                        vezir_Cikar(satir,sutun);
                        satir++;
                    }
                }
            }
            return vezirYerlestir;
        }
    }
    private void vezir_Cikar(int satir, int sutun){
        tahta[satir][sutun] = BOS;
        System.out.printf("[%d][%d] den vezir cikarildi \n", satir, sutun);
        --vezir;    
    }
    private void vezir_Yerlestir(int satir, int sutun){
        tahta[satir][sutun] = VEZIR;
        System.out.printf("[%d][%d] ye vezir yerlestirildi \n",satir,sutun);
        ++vezir;
    }
    public boolean tehditAltindaMi(int satir, int sut){
        boolean kosul = false;
        //satir kontrolü
        for(int sutun = 0 ; sutun<TAHTA_BOYUTU ; sutun++){
            if((tahta[satir][sutun] == true)){
                kosul = true;
            }
        }
        // sutun kontrolu
        for(int sat=0; sat <tahta.length; sat++){
            if((tahta[sat][sut]== true)){
                kosul = true;
            }
        }
        // diagonal kontrol
        for(int sat_ = satir, sut_ = sut; sat_>=0 && sut_ <8; sat_ += yatay[0], sut_ += dikey[0]){
            if(tahta[sat_][sut_]==true){
                kosul = true;
            }
        }
        for(int sat_ = satir, sut_ = sut; sat_<8 && sut_>=0; sat_ += yatay[1], sut_ += dikey[1]){
           if(tahta[sat_][sut_]==true){
               kosul= true;
           } 
        }
        for(int sat_ = satir, sut_ = sut; sat_>=0 && sut_>=0; sat_ +=yatay[2], sut_ +=dikey[2]){
           if(tahta[sat_][sut_]==true){
               kosul= true;
           } 
        }
        for(int sat_ = satir, sut_ = sut; sat_<8 && sut_ <8; sat_ += yatay[3], sut_ += dikey[3]){
            if(tahta[sat_][sut_]==true){
                kosul = true;
            }
        }
        return kosul;
    }
    public void tahtayi_goruntule(){
        int sayac =0;
        for(int satir =0; satir< tahta.length;satir++ ){
            for(int sut=0; sut<tahta[satir].length; sut++){
                if(tahta[satir][sut]==true){
                    System.out.printf("|%s|", "x");
                    sayac++;
                }else{
                    System.out.printf("|%s|", "o");
                }
            }
            System.out.println();
        }
        System.out.printf("%d vezir tahtaya yerlestirildi\n", sayac);
    }
}
