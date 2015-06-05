package soru_5;
/*
 * ARIF
 *
 * Created on 5.Haz.2015, 15:14:23
 */

 //karmasıklık O(log n)
import java.util.Scanner;
import java.util.ArrayList;
 

class TSTNode
{
    char data;
    boolean isEnd;
    TSTNode left, middle, right;
 
    
    public TSTNode(char data)
    {
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }        
}
 

class TernarySearchTree
{
    private TSTNode root;
    private ArrayList<String> al;
 
    
    public TernarySearchTree()
    {
        root = null;
    }
    /** ağacın boş olup olmadıgını kontrol eden fonksiyon **/
    public boolean isEmpty()
    {
        return root == null;
    }
    /** ağacı silen fonksiyon **/
    public void makeEmpty()
    {
        root = null;
    }
    /** kelime ekleyen fonksiyon **/
    public void insert(String word)
    {
        root = insert(root, word.toCharArray(), 0);
    }
    
    public TSTNode insert(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            r = new TSTNode(word[ptr]);
 
        if (word[ptr] < r.data)
            r.left = insert(r.left, word, ptr);
        else if (word[ptr] > r.data)
            r.right = insert(r.right, word, ptr);
        else
        {
            if (ptr + 1 < word.length)
                r.middle = insert(r.middle, word, ptr + 1);
            else
                r.isEnd = true;
        }
        return r;
    }
 
    /** kelimeyi silen fonksiyon **/
    
    
 
    /** arama fonksiyonu  **/
    public boolean search(String word)
    {
        return search(root, word.toCharArray(), 0);
    }
    
    private boolean search(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return false;
 
        if (word[ptr] < r.data)
            return search(r.left, word, ptr);
        else if (word[ptr] > r.data)
            return search(r.right, word, ptr);
        else
        {
            if (r.isEnd && ptr == word.length - 1)
                return true;
            else if (ptr == word.length - 1)
                return false;
            else
                return search(r.middle, word, ptr + 1);
        }        
    }
    /** agacı yazdıran fonksiyon **/
    public String toString()
    {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : "+ al;
    }
    
    private void traverse(TSTNode r, String str)
    {
        if (r != null)
        {
            traverse(r.left, str);
 
            str = str + r.data;
            if (r.isEnd)
                al.add(str);
 
            traverse(r.middle, str);
            str = str.substring(0, str.length() - 1);
 
            traverse(r.right, str);
        }
    }
}
 

public class Soru_5
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
 
        
        TernarySearchTree tst = new TernarySearchTree(); 
        System.out.println("Ternary Search Tree Test\n"); 
 
        char ch;
        /*  Agacın fonksiyonları  */
        do    
        {
            
            System.out.println("1. kelime ekle");
            System.out.println("2. kelime ara");
            System.out.println("3. kelime sil");
            System.out.println("4. bosmu kontrol et");
           
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("kelime ekleyin");
                tst.insert( scan.next() );                     
                break;                          
            case 2 : 
                System.out.println("aranacak kelimeyi girin");
                System.out.println("Arama sonucları : "+ tst.search( scan.next() ));
                break; 
             
            case 4 : 
                System.out.println("Agacın durumu : "+ tst.isEmpty() );                
                break;    
            case 5 : 
                System.out.println("3 lu arama agacı temizlendi"); 
                tst.makeEmpty();               
                break;                                        
            default : 
                System.out.println("Yanlis girdi \n ");
                break;   
            }
            System.out.println(tst);
 
            System.out.println("\n devam etmek istiyo musunuz? (E ya da h) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'E'|| ch == 'e');        
    }
}