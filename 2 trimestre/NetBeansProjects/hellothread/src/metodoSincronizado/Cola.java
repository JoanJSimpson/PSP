/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoSincronizado;

/**
 *
 * @author Joan
 */
public class Cola {
    boolean ocupado;
    public Cola(){
        this.ocupado=true;
    }
    public synchronized void esperar(){
        try{
            while (ocupado==true){
                System.out.println("Ocupado");
                System.out.println("Metodo esperar antes de wait");
                wait();
            }
                System.out.println("Metodo esperar despues wait");
            System.out.println("Libre");
            
            
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
    public synchronized void atender() throws InterruptedException{
        System.out.println("Metodo atender");
        this.ocupado=false;
        //notify();
        Resultados.clientes_atendidos++;
        Resultados.ganancias++;
        Resultados.tiempo_espera++;
        //wait();
        notify();
        //this.ocupado=false;
    
    }
}
