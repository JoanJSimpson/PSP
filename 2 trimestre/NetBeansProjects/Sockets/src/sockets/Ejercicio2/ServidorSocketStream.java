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
public class ServidorSocketStream {
    public static void main(String[] args) {
        try{
            
            int con =1;
            
            boolean terminado = false;
            //====================================================
            //Creamos socket Servidor y aceptamos conexiones
            //====================================================
            System.out.println("Esperando conexiones");
            System.out.println("Creando socket servidor");
            ServerSocket serverSocket = new ServerSocket();
            
            System.out.println("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            serverSocket.bind(addr);
            System.out.println("Aceptando conexiones");
            
            //Hasta que no llegue el mensaje de cierre de conexion (Salir.)
            while(!terminado){

                Socket newSocket = serverSocket.accept();

                System.out.println("Conexion recibida nº: "+con);

                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();
            
                //====================================================
                //Leemos los datos recibidos
                //====================================================
                byte[] mensaje = new byte[150];
                is.read(mensaje);
                String recogido = new String(mensaje);
                String pregunta ="";
                String respuesta ="";
                //====================================================
                //Bucle para eliminar los bytes sobrantes
                //====================================================
                for (int i=0; i<recogido.length(); i++){
                    String caracter = String.valueOf(recogido.charAt(i));
                    if(caracter.equals("?") || (caracter.equals("."))){
                        pregunta = recogido.substring(0,i+1);
                        System.out.println("Pregunta: "+pregunta);
                        pregunta = pregunta.toLowerCase();
                    }
                }

                if (pregunta.equals("Salir.".toLowerCase())){
                    terminado = true;
                    respuesta = "Programa terminado.";
                } else if (pregunta.equals("¿Como te llamas?".toLowerCase()) || pregunta.equals("¿Cómo te llamas?".toLowerCase())
                        || pregunta.equals("Cómo te llamas?".toLowerCase()) || pregunta.equals("Como te llamas?".toLowerCase())) {
                    //System.out.println("Me llamo Ejercicio 2");
                    respuesta = "Me llamo Ejercicio 2.";
                    //os.write(respuesta.getBytes());
                }else if(pregunta.equals("¿Quien es tu creador?".toLowerCase()) || pregunta.equals("¿Quién es tu creador?".toLowerCase())
                         || pregunta.equals("Quien es tu creador?".toLowerCase()) || pregunta.equals("Quién es tu creador".toLowerCase())       ){
                    respuesta = "Mi creador es Joan Piera Simó.";
                    //os.write(respuesta.getBytes());    
                }else if(pregunta.equals("¿Cuantas lineas de codigo tienes?".toLowerCase()) || pregunta.equals("¿Cuántas líneas de código tienes?".toLowerCase())
                         || pregunta.equals("Cuántas líneas de código tienes?".toLowerCase()) || pregunta.equals("Cuantas lineas de codigo tienes?".toLowerCase())       ){
                    //System.out.println("Tengo 65 líneas de codigo");
                    respuesta = "Tengo 110 líneas de codigo.";
                    //os.write(respuesta.getBytes());
                }else if(pregunta.equals("¿Quien es Miguelula?".toLowerCase()) || pregunta.equals("¿Quién es Miguelula?".toLowerCase())
                         || pregunta.equals("Quién es Miguelula?".toLowerCase())  || pregunta.equals("Quien es Miguelula?".toLowerCase())){
                    //System.out.println("¿Acaso tienes dudas?");
                    respuesta = "El peor jugador de la historia del curve.";
                    //os.write(respuesta.getBytes());
                }else{
                    //System.out.println("No he entendido la pregunta");
                    respuesta = "No he entendido la pregunta.";
                    //os.write(respuesta.getBytes());
                }
                System.out.println("Respuesta: " + respuesta);
                os.write(respuesta.getBytes());
                con++;
                System.out.println("");
                
                newSocket.close();
            }
            System.out.println("Terminado");
            //Cerramos el serverSocket
            serverSocket.close();
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}