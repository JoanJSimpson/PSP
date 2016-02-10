/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoSincronizado;

import java.util.Random;

/**
 *
 * @author Joan
 */
public class Cliente extends Thread{
    int id;
    Caja caja;
    Random rnd;
    public Cliente(int id, Caja caja){
        this.caja=caja;
        this.id=id;
    }
    
    public void setId(int id){
            this.id = id;
        }
        public void setCaja(Caja caja){
            this.caja=caja;
        }
        
        public long getId(){
            return id;
        }
        public Caja getCaja(){
            return caja;
        }
    
    public void run(){
        //System.out.println("Cliente "+id);
        try{
            
           //System.out.println("Caja "+getCaja().getId());
           
           //long s = System.currentTimeMillis();
           caja.atender(getCaja().getId());
           caja.esperar(getCaja().getId());
           
           //Resultados.tiempo_espera+=(System.currentTimeMillis()-s);
          
           
           
           System.out.println("Atendiendo a cliente: "+(getId()+1) +" en caja: "+(getCaja().getId()+1));
           Thread.sleep(1000);
           //caja.esperar();
           //System.out.println("Despues Esperar");
           
           //System.out.println("Despues atender");
           //caja.esperar();
           //System.out.println("Despues esperar");
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
    
}
