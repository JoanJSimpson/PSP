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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Joan
 */
public class ServidorSocketStream_Backup {
    public static void main(String[] args) {
        try{
            System.out.println("Creando socket servidor");
            
            ServerSocket serverSocket = new ServerSocket();
            
            System.out.println("Realizando el bind");
            
            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            serverSocket.bind(addr);
            
            System.out.println("Aceptando conexiones");
            
            Socket newSocket = serverSocket.accept();
            
            System.out.println("Conexion recibida");
            
            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();
            
            //====================================================
            //Leemos los datos recibidos
            //====================================================
            byte[] mensaje = new byte[50];
            is.read(mensaje);
            String recogido = new String(mensaje);
            String pregunta ="";
            String respuesta ="";
            //====================================================
            //Bucle para eliminar los bytes sobrantes
            //====================================================
            for (int i=0; i<recogido.length(); i++){
                String caracter = String.valueOf(recogido.charAt(i));
                if(caracter.equals("?")){
                    pregunta = recogido.substring(0,i+1);
                }
            }
            
            //tiene que enviarlo al socket cliente con os
            if(pregunta.equals("¿Cómo te llamas?")){
                //System.out.println("Me llamo Ejercicio 2");
                respuesta = "Me llamo Ejercicio 2";
                os.write(respuesta.getBytes());
            }else if(pregunta.equals("¿Cuántas líneas de código tienes?")){
                //System.out.println("Tengo 65 líneas de codigo");
                respuesta="Tengo 65 líneas de codigo";
                os.write(respuesta.getBytes());
            }else if(pregunta.equals("¿Es Miguelula homosexual?")){
                //System.out.println("¿Acaso tienes dudas?");
                respuesta = "¿Acaso tienes dudas?";
                os.write(respuesta.getBytes());
            }else{
                //System.out.println("No he entendido la pregunta");
                respuesta = "No he entendido la pregunta.";
                os.write(respuesta.getBytes());
            }
            
            //====================================================
            //Cerramos las conexiones
            //====================================================
            System.out.println("Cerrando el nuevo socket");
            
            newSocket.close();
            
            System.out.println("Cerrando el socket servidor");
            
            serverSocket.close();
            
            System.out.println("Terminado");
         
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
