/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadOverflow;

import static java.lang.Thread.sleep;

/**
 *
 * @author Joan
 */
public class threadOverflow extends Thread{

    
    static int cuenta=0;
    String nombre="";
    public threadOverflow(String n){
        this.nombre=n;
    }
    
    public void sumador(){
        cuenta++;
    }
    public void impresor(){
        System.out.println("Suma: "+cuenta);
    }
    
    public void run(){
        switch (nombre){
            case ("sumador"):
                sumador();
                break;
            case ("impresor"):
                impresor();
                break;
        }/*
        if (nombre.equals("sumador")){
            sumador();
            //System.out.println("entra en sumador");
            //cuenta++;
        }else if(nombre.equals("impresor")){
            impresor();
            //System.out.println("entra en impresor");
            //System.out.println(cuenta);
        }*/
        
        
    }

    public static void main (String args[]) throws InterruptedException{
        for (int i=0;i<10;i++){
            Thread sumador = new threadOverflow ("sumador");
            Thread impresor = new threadOverflow ("impresor");
            impresor.start();
            sumador.start(); 
        }
        
        
    }
}
