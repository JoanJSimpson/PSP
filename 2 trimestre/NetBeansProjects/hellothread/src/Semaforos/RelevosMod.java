/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joan
 */
class TestigoMod {
    private int siguiente;
    
    TestigoMod (){
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

class CorredorMod extends Thread{
    private static final int MAX_DELAY = 1000;
    private int id;
    private static int cont =1;
    private TestigoMod testigo;
    private int orden[];
    Scanner tcl = new Scanner (System.in);
    
    
    CorredorMod (int id, TestigoMod t, int[] orden){
        this.id = id;
        this. testigo = t;
        this.orden = orden;
    }
    
    public void run(){
        try {
            testigo.check(id);
            System.out.println("Soy el thread "+id+ ". Corriendo ....");
            Thread.sleep((int)Math.random()*MAX_DELAY);
            
            if(cont <orden.length){
                int receptor = orden[cont];
                //System.out.println("Cont: "+cont);
                System.out.println("Teminé. Paso el testigo al hilo "+receptor);
                testigo.next(receptor);
                cont++;
            }else{
                System.out.println("Terminé");
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}



public class RelevosMod {
    public static void main (String args[]){
        //Modificar para que se le pasen los turnos a mano
        TestigoMod testigo = new TestigoMod();
        CorredorMod corredores[] = new CorredorMod[4];
        Scanner tcl = new Scanner(System.in);
        int orden[]=new int[4];
        System.out.print("Introduce el dorsal del primer corredor: ");
        orden[0]= tcl.nextInt();
        System.out.print("Introduce el dorsal del segundo corredor: ");
        orden[1]= tcl.nextInt();
        System.out.print("Introduce el dorsal del tercer corredor: ");
        orden[2]= tcl.nextInt();
        System.out.print("Introduce el dorsal del cuarto corredor: ");
        orden[3]= tcl.nextInt();
        
        for (int i=0; i<4; i++){
            corredores[i] = new CorredorMod(i+1,testigo, orden);
            corredores[i].start();
        }
        System.out.println("Todos los hilos creados.");
     
        testigo.next(orden[0]);
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

