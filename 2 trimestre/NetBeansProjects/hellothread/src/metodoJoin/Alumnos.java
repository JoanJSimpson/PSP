/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoJoin;

/**
 *
 * @author Joan
 */
public class Alumnos implements Runnable{
    String mensaje;
    public Alumnos(String nombre){
        mensaje = "Hola soy "+nombre+" y este es mi mensaje numero: ";
        
    }
    
    public void run(){
        for (int i=1;i<=10;i++){
            String msj = mensaje +i;
            System.out.println(msj);
        }
        System.out.println("Hilo en ejecucion: "+Thread.currentThread().getName());
    }

    public static void main (String args[]) throws InterruptedException{
        Thread juan = new Thread (new Alumnos("Juan"));
        Thread jorge = new Thread (new Alumnos("Jorge"));
        Thread pepe = new Thread (new Alumnos("pepe"));
        juan.setPriority(1);//damos prioridades, el 10 es el mas alto, el 1 el mas bajo
        jorge.setPriority(10);
        pepe.setPriority(5);
        
        juan.start();
        jorge.start();
        pepe.start();
        //juan.start();
        juan.setName("Juan");
        //juan.join();//hasta que no termina juan no empieza el siguiente
        //juan.sleep(2000);//cuando terminal el hilo se espera 2 segundos para que empiece el siguiente
        
        //pepe.start();
        pepe.setName("Pepe");
        //pepe.join();
        //pepe.sleep(2000);
        
        //jorge.start();
        jorge.setName("Jorge");
        //jorge.join();
        //jorge.sleep(2000);
    }
}
