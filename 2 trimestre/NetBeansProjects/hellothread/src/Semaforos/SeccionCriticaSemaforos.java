/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Joan
 */
public class SeccionCriticaSemaforos {
    
private static Ocupado ginecologa;
private static Ocupado urologo;
private static Semaphore semaphore = new Semaphore(1);
private static Ocupado medicos[];
    
    public static void main (String[] args){
       /*for (int i=1; i<=10; i++){
            ginecologa = new Ocupado("ginecologa",i, semaphore);
            urologo = new Ocupado("urologo",i, semaphore);

            ginecologa.start();
            urologo.start();
            
       }*/
        
        //solo dos medicos
        int numero = 2;
        //10 pacientes
        int paciente = 10;
       medicos = new Ocupado[numero];
       for (int i=0; i<numero; i++){
           for (int j=1; j<=paciente;j++){
           medicos[i]=new Ocupado (i,semaphore,j);
           medicos[i].start();
           }
           
           //medicos[i].start();
       }
        try{
            for (int i=0; i<numero; i++){
            medicos[i].join();
            }
        }catch(InterruptedException e){
            System.out.println("Hilo principal del proceso interrumpido");
        }
        System.out.println("Proceso acabando,");
       
        
    }
    
}
