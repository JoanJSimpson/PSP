/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp1;
import java.util.*;
/**
 *
 * @author Joan
 */
public class PSP1 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void funTira (String tira){
        int result;
        List<Integer> numeros = new ArrayList<>();
        List<Character> letras = new ArrayList<>();
        int resultado=0;
        char[] toCharArray= tira.toCharArray();
        for (int i=0; i<tira.length(); i++){
            char caracter = toCharArray[i];
            if (Character.isDigit(caracter)){
                numeros.add(Character.getNumericValue(caracter));
                //numeros.add((int)caracter-48);
                resultado = resultado+(Character.getNumericValue(caracter));
            }
            else {
                if (Character.isLetter(caracter)){
                    letras.add(caracter);
                }
            }
        }
        System.out.println("La tira numerica es: "+numeros);
        System.out.println("El resultado de la tira numerica es: "+resultado);
        System.out.println("La tira de caracteres es: "+letras);
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tcl = new Scanner(System.in);
        String nombre = "Joan Piera Simo";
        System.out.println("\t\t\t"+nombre);
        String con="n";
        while (con.equals("N") || con.equals("n")){
            
            System.out.print("Introduce una cadena: ");
            String tira_alfa = tcl.next();
            funTira(tira_alfa);
            System.out.println("¿Desea salir?: (S/N)");
            con=tcl.next();
        }
        
        
        
    }
    
   
    
}
