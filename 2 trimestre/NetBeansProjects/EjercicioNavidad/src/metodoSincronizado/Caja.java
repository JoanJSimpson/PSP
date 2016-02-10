/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoSincronizado;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;


/**
 *
 * @author Joan
 */
public class Caja {
        int id;
        String nombre;
        Random rnd = new Random();
        int ganado;
        int espera;
        
        
        public Caja(int id){
            super();
            this.id = id;
        }
        
        public void setId(int id){
            this.id = id;
        }
        public void setNombre(String nombre){
            this.nombre=nombre;
        }
        
        public long getId(){
            return id;
        }
        public String getNombre(){
            return nombre;
        }
    
    boolean ocupado;
    
    public Caja(){
        this.ocupado=true;
    }
    public synchronized void esperar(long id){
        try{
            //while ((ocupado==true) && (getId() == id)){
            if(getId() != id){
                //System.out.println("Caja: "+getId()+" ocupada");
                //System.out.println("Metodo esperar antes de wait");
                wait();
            }
            //System.out.println("Metodo esperar despues wait");
            //System.out.println("Caja: "+getId()+" libre");
            
            
            //ocupado=true;
            /*if (!ocupado){
                System.out.println("Ocupado = false");
                //hacer un random
                Resultados.ganancias++;
                Resultados.clientes_atendidos++;
                Resultados.tiempo_espera++;
                ocupado=true;
                notifyAll();
            }*/
            
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public synchronized void atender(long id) throws InterruptedException{
        //System.out.println("Metodo atender");
        this.ocupado=false;
        //notify();
        Resultados.clientes_atendidos++;
        
        
        ganado=(int)(rnd.nextDouble() * 100);
        espera=(int)(rnd.nextDouble()*10);
        System.out.println("Espera: "+espera);
        Resultados.tiempo_espera+=espera;
        Resultados.ganancias += ganado;
        
        //Resultados.ganancias++;
        //Resultados.tiempo_espera++;
        //wait();
        notify();
        //this.ocupado=false;
    
    }
}
