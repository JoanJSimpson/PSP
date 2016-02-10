
import java.util.concurrent.Semaphore;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joan
 */
public class Orden extends Thread {
    private Semaphore sem;
    private int hilo;
    Orden (int hilo, Semaphore sem){
        this.sem = sem;
        this.hilo= hilo;
    }
    
    public void run(){
            //si el hilo que entra es el 1, ponemos el semaforo en wait hasta q se libere
            if (hilo==1){
                try{
                    sem.acquire();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Hola, soy el thread numero "+hilo);
            if (hilo==2){
                //si el hilo que entra es el 2, liberamos el semaforo
                //System.out.println("Hola, soy el thread numero "+hilo);
                sem.release();
            }
        }
    }
    
class SeccionCriticaSemaforos {

    public static void main (String[] args){
        Semaphore sem = new Semaphore(0);
        Orden t1 = new Orden(1,sem);
        Orden t2 = new Orden(2,sem);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println("Hilo principal del proceso interrumpido");
        }
        System.out.println("Hilos, yo soy vuestro padre. Proceso acabando.");
            
        }
            
    }

