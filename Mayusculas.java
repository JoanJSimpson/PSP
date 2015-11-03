/**
*
* @author Joan
*/

import java.io.*;
import java.util.*;

public class Mayusculas {
    
    public static void main(String[] args)throws IOException {
	//creamos los procesos        
	
	//le pasamos los argumentos
        //String [] p1 = {"ls", "-l"};
        //ProcessBuilder pb1 = new ProcessBuilder("ls", "-la");
        //String [] p2 = {"tr", "d", "D"};
        //ProcessBuilder pb2 = new ProcessBuilder("tr","d","D");
        boolean haTerminado=false;
        try {
            String cadena =null;
            Scanner tcl = new Scanner (System.in);
            while (haTerminado ==false){
                cadena = tcl.nextLine();

                if(!cadena.equals("fin")){

                    Process proceso1 = new ProcessBuilder("echo",cadena).start();
                    Process proceso2 = new ProcessBuilder("tr", "[:lower:]", "[:upper:]").start();

                    //creamos un buffer donde guardar la salida del proceso1
                    BufferedReader breader = new BufferedReader (new InputStreamReader(proceso1.getInputStream()));

                    BufferedWriter bwriter = new BufferedWriter (new OutputStreamWriter(proceso2.getOutputStream()));


                    //creamos la variables line
                    String line = null;

                    //bucle para poner la salida del proceso1 en el proceso2
                    //recorremos todas las lineas para que ejecute el proceso1
                    while ((line = breader.readLine()) !=null) {
                            bwriter.write(line + "\n");
                    }

                    //cerramos el bwriter y breader
                    bwriter.close();
                    breader.close();
                    

                    BufferedReader breader2 = new BufferedReader (new InputStreamReader(proceso2.getInputStream()));

                    while ((line = breader2.readLine()) != null){
                            System.out.println(line);
                    }
                    //cerramos el resto
                    breader2.close();
                    proceso1.destroy();
                }else{
                    haTerminado=true;
                }
                
            }
		
            
        }
        
        catch  (IOException e){
            System.out.println(e.getMessage());
        }
        
    
        
        
    }       
                
}
