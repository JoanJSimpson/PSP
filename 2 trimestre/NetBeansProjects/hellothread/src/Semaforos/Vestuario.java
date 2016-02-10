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
public class Vestuario {
    public static int acumulador = 0;
    
}
class Ocupado extends Thread {
    
    
    private Semaphore sem;
    private String nombre;
    private int paciente;
    private int medico;
    
    Ocupado(String nombre, int paciente, Semaphore sem){
        this.nombre=nombre;
        this.sem = sem;
        this.paciente = paciente;
    }
    Ocupado(int medico, Semaphore sem, int paciente){
        this.medico = medico;
        this.sem = sem;
        this.paciente=paciente;
    }
    public void SetPaciente(int id){
        this.paciente = id;
    }
    
 
    
    public void run(){
       
        try{
            //Vemos si esta libre (como solo puede tener 1 valor, o esta libre u ocupado)
            sem.acquire();
            //System.out.println("El vestuario esta ocupado por el paciente ["+numero+"] del médico: "+nombre);
            //System.out.println("El vestuario esta ocupado por el paciente ["+paciente+"] del médico ["+(medico+1)+"]");
            
            if (medico == 0){
                System.out.println("El vestuario esta ocupado por el paciente ["+paciente+"] del urólogo");
            }else if (medico ==1){
                System.out.println("El vestuario esta ocupado por el paciente ["+paciente+"] de la ginecóloga");
            } 
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //lo liberamos
        try{
            sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("El vestuario está libre");
        sem.release();
      
        
    }
}
