/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

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
            System.out.print("Introduce un mensaje: ");
            String mensaje = tcl.nextLine();
            //String mensaje = "mensaje desde el cliente";
            os.write(mensaje.getBytes());
            
            System.out.println("Mensaje enviado");
            
            System.out.println("Cerrando el socket cliente");
       
            clientSocket.close();
            
            System.out.println("Terminado");
        
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
