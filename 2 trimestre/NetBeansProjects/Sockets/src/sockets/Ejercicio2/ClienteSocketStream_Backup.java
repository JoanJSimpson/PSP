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
public class ClienteSocketStream_Backup {
    public static void main(String args[]){
        try{
            System.out.println("Creando Socket Cliente");
            
            Socket clientSocket = new Socket();
            
            System.out.println("Estableciendo la conexion");
            
            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            clientSocket.connect(addr);
            
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            
            System.out.println("Enviando mensaje");
            
            Scanner tcl = new Scanner(System.in);
           
            Boolean valida = false;
            String frase ="";
            
            //====================================================
            //Bucle para comprobar que se introduce una pregunta
            //====================================================
            while (!valida){
                System.out.print("Introduce un mensaje: ");
                String mensaje = tcl.nextLine();
                for (int i=0; i<mensaje.length(); i++){
                    String caracter = String.valueOf(mensaje.charAt(i));
                    if(caracter.equals("?")){
                        frase = mensaje.substring(0,i+1);
                        valida = true;
                        //os.write(frase.getBytes());
                        //break;
                    }
                }
                if (!valida){
                    System.out.println("Tienes que hacer una pregunta y acabar con el simbolo --> ?");
                }
            }
            //Se envia el mensaje al servidor
            os.write(frase.getBytes());
            
            
            //====================================================
            //Recoger datos del servidor
            //====================================================
            
            byte[] mensajeDevuelto = new byte[50];
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
            System.out.println("=============================");
            System.out.println(respuesta);
            System.out.println("=============================");
            System.out.println("");
            
            //====================================================
            //Cerramos las conexiones
            //====================================================
            
            //System.out.println("Mensaje enviado");
            
            //System.out.println("Cerrando el socket cliente");
       
            clientSocket.close();
            
            System.out.println("Terminado");
        
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
