/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoSincronizado;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Joan
 */
public class SuperMarket {
    boolean ocupado;
    
    public SuperMarket(){
        this.ocupado=false;
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
    
    /*class Caja extends Thread{
        /*SuperMarket supr;
        public Caja(SuperMarket supr){
            this.supr = supr;
        }
        public void run(){
            //supr.esperar();
            esperar();
        }
        
    }*/
    
    class Cliente extends Thread{
        int i;
        Caja caja;
        public Cliente(int i, Caja caja){
            this.caja=caja;
            this.i=i;
        }
    
        public void run(){
            //System.out.println("Cliente "+i);
            try{
               Thread.sleep(1000);
               System.out.println("Despues Esperar");
               atender();
               System.out.println("Despues atender");
               //caja.esperar();
               //System.out.println("Despues esperar");
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        Scanner tcl = new Scanner(System.in);
        System.out.print("Introduce el numero de cajas: ");
        int N=tcl.nextInt();
        tcl.nextLine();
        System.out.print("Introduce el numero de clientes: ");
        int M=tcl.nextInt();
        //int N = Integer.parseInt (args[0]);
        int j;
        Caja cajas[] = new Caja[N]; 
        for (int i= 0; i < N; i++){
            cajas[i]= new Caja();
        }
        //int M = Integer.parseInt (args[1]); 
        Cliente clientes[] = new Cliente[M]; 
        for (int i= 0; i < M; i++){
        // Seleccionamos ya en qué caja se situara
            j = new Random().nextInt(N);
            clientes[i]= new Cliente(i,cajas[j]);
            clientes[i].start(); 
            System.out.println("Cliente: "+i+" a caja: "+j);
        }
        try {
            for (int i= 0; i < M; i++){
                clientes[i].join(); 
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido."); 
        }
        System.out.println("Supermercado cerrado.");
        System.out.println("Ganancias: " + Resultados.ganancias); 
        System.out.println("Tiempo medio de espera: " +(Resultados.tiempo_espera / Resultados.clientes_atendidos));
    } 
}

