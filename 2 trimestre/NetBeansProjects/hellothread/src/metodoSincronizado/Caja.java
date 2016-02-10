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
class Caja extends Thread{
        int id;
        String nombre;
        
        Caja(){
        }
        Caja(int id, String nombre){
            super();
            this.id = id;
            this.nombre = nombre;
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
        
        public void run(){
            Cola.esperar();
            
        }
        
        
        
       
        
    }

