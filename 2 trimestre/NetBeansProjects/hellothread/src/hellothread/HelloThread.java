/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellothread;

/**
 *
 * @author Joan
 */
public class HelloThread implements Runnable {
    
    Thread t;
    HelloThread (int i) {
        t = new Thread(this, "Nuevo Thread");
        System.out.println("Creado hilo: "+i+" "+t);
        t.start(); //Arranca el nuevo hilo de ejecucion. Ejectua run
    }
    public void run(){
        
        System.out.println("Hola desde el hilo creado");
        System.out.println("Hilo finalizado.");
    }
 
}

class RunThread {
    public static void main (String args[]){
        System.out.println("Hola desde el hilo principal.");
        System.out.println("Proceso acabando.");
    
        for (int i=1; i<6; i++){
            new HelloThread(i); //Crea un nuevo hilo de ejecución
        }
        
    }
    
}