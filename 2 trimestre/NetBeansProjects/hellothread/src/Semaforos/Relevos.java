/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joan
 */
class Testigo {
    private int siguiente;
    
    Testigo (){
        //inicializamos a 0 para que todos se queden parados al inicio
        this.siguiente = 0;
    }
    
    synchronized public void next (int id){
        this.siguiente = id;
        //Despertamos a todos los threads
        notifyAll();
    }
    
    synchronized public void check (int id) throws InterruptedException{
        while (siguiente != id){
            //Bloqueamos a todos hasta que llegue su turno
            wait();
        }
    }
    
}

class Corredor extends Thread{
    private static final int MAX_DELAY = 1000;
    private int id;
    private Testigo testigo;
    
    
    Corredor (int id, Testigo t){
        this.id = id;
        this. testigo = t;
    }
    
    public void run(){
        try {
            testigo.check(id);
            System.out.println("Soy el thread "+id+ ". Corriendo ....");
            Thread.sleep((int)Math.random()*MAX_DELAY);

            if(id !=4){
                int receptor = id+1;
                System.out.println("Teminé. Paso el testigo al hilo "+receptor);
                testigo.next(receptor);
            }else{
                System.out.println("Terminé");
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}



public class Relevos {
    public static void main (String args[]){
        Testigo testigo = new Testigo();
        
        Corredor corredores[] = new Corredor[4];
        for (int i=0; i<4; i++){
            corredores[i] = new Corredor(i+1,testigo);
            corredores[i].start();
        }
        System.out.println("Todos los hilos creados.");
        testigo.next(1);
        System.out.println("Doy la salida");
        
        try{
            for (int i=0; i<4;i++){
                corredores[i].join();
            }
        }catch (InterruptedException e){
            System.out.println("Hilo principal interrumpido");
        }
    }
}

