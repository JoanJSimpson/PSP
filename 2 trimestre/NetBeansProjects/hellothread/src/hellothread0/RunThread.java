/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellothread0;

import hellothread.HelloThread;

/**
 *
 * @author Joan
 */
public class RunThread extends Thread {
    int numeroHilo;
    
    public RunThread(int numeroHilo){
        this.numeroHilo=numeroHilo;
    }
    
    @Override
    public void run(){
        System.out.println("Hola desde el hilo creado "+numeroHilo);
        System.out.println("Fin del hilo: "+numeroHilo);
    }
}
class PrincipalThread {
    public static void main (String args[]){
        System.out.println("Hola desde el hilo principal.");
        System.out.println("Proceso acabando.");
    
        for (int i=1; i<6; i++){
            new RunThread(i); //Crea un nuevo hilo de ejecución
        }
        
    }
    
}
//public class RunBucle
