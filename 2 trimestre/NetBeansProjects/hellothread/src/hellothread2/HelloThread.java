/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellothread2;

/**
 *
 * @author Joan
 */
public class HelloThread extends Thread {
    
    public void run(){
        System.out.println("Hola desde el hilo creado!");
    }
    
}
class RunThread{
    public static void main (String args[]){
        
        new HelloThread().start();//Crea y arranca un nuevo hilo de ejecucion
            System.out.println("Hola desde el hilo principal");
            System.out.println("Hola Proceso acabando.");
    }
}
