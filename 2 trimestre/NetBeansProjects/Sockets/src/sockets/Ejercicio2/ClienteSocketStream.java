/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.Ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Joan
 */
public class ClienteSocketStream {
    public static void pausa(int tiempo){ 
        try { 
            Thread.sleep(tiempo); 
        } catch (Exception ignored) {} 
    } 
    
    public static void main(String args[]){
        try{
            System.out.println("Aceptando conexiones entrantes.");
           
            Boolean terminado = false;
            
            Scanner tcl = new Scanner(System.in);
            System.out.println("");
            System.out.println("El juego funciona de la siguiente manera:");
            System.out.println("- Debes introducir una pregunta.");
            System.out.println("    - La pregunta puede empezar por ¿ u omitirlo.");
            System.out.println("    - La pregunta debe terminar por ?.");
            System.out.println("    - La pregunta puede ser formulada en mayúsculas o en minúsculas.");
            System.out.println("    - La pregunta puede contener acentos, aunque no es obligatorio.");
            System.out.println("    - Para terminar escriba la palabra salir seguida de un punto");
            
            while(!terminado){
                
            //System.out.println("Creando Socket Cliente");
                Socket clientSocket = new Socket();

                //System.out.println("Estableciendo la conexion");
                InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
                clientSocket.connect(addr);

                InputStream is = clientSocket.getInputStream();
                OutputStream os = clientSocket.getOutputStream();
                Boolean valida = false;

                String frase ="";
                
                //====================================================
                //Bucle para comprobar que se introduce una pregunta
                //====================================================
                while (!valida){
                    System.out.println("========================");
                    System.out.println("Preguntas y respuestas");
                    System.out.println("========================");
                    System.out.println("");
                    System.out.println("Introduce una pregunta");
                    System.out.print("Pregunta ---> ");
                    String mensaje = tcl.nextLine();
                    
                    if (mensaje.equals("Salir.") || mensaje.equals("salir.")){
                        frase = mensaje;
                        terminado = true;
                        valida = true;
                    }else{
                        for (int i=0; i<mensaje.length(); i++){
                            String caracter = String.valueOf(mensaje.charAt(i));
                            if(caracter.equals("?") || (caracter.equals("."))){
                                frase = mensaje.substring(0,i+1);
                                valida = true;
                                //os.write(frase.getBytes());
                                //break;
                            }
                        }
                        if (!valida){
                            System.out.println("Tienes que hacer una pregunta y acabar con el simbolo --> ? o .");
                            System.out.println("");
                        }
                    }
                }
                //Se envia el mensaje al servidor
                os.write(frase.getBytes());


                //====================================================
                //Recoger datos del servidor
                //====================================================

                byte[] mensajeDevuelto = new byte[150];
                is.read(mensajeDevuelto);
                String recogido = new String(mensajeDevuelto);
                String respuesta ="";
                //====================================================
                //Bucle para eliminar los bytes sobrantes
                //====================================================
                //System.out.println("Mensaje devuelto: "+recogido);
                for (int i=0; i<recogido.length(); i++){
                    String caracter = String.valueOf(recogido.charAt(i));
                    if(caracter.equals("?") || (caracter.equals("."))){
                        respuesta = recogido.substring(0,i+1);
                    }
                }
                System.out.println("Respuesta ---> "+respuesta);
                System.out.println("");
               
            //====================================================
            //Cerramos las conexiones
            //====================================================
                clientSocket.close();
                pausa(1000);
            }

            System.out.println("Terminado");
        
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
