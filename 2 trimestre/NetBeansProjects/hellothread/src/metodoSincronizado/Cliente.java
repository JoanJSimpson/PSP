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
class Cliente extends Thread{
        int id;
        
        Caja caja;
        Cliente(int id, Caja caja){
            super();
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
            //System.out.println("Cliente "+i);
            int gasto = new Random().nextInt(100);
            Resultados.ganancias +=gasto;
            System.out.println("Cliente "+id+ ": "+gasto + "€.");
            
            //System.out.println("Cliente "+i);
            try{
               Thread.sleep(1000);
               System.out.println("Despues Esperar");
               Cola.atender();
               System.out.println("Despues atender");
               //caja.esperar();
               //System.out.println("Despues esperar");
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        
        
        
    }
