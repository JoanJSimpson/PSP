/**
*
* @author Joan
*/

import java.io.*;
import java.util.*;

public class casoPracticoJoan {
    
    public static void main(String[] args)throws IOException {
	//creamos los procesos        
	
	//le pasamos los argumentos
        //String [] p1 = {"ls", "-l"};
        //ProcessBuilder pb1 = new ProcessBuilder("ls", "-la");
        //String [] p2 = {"tr", "d", "D"};
        //ProcessBuilder pb2 = new ProcessBuilder("tr","d","D");
        ProcessBuilder pb1 = new ProcessBuilder("ls", "-la");
        ProcessBuilder pb2 = new ProcessBuilder("tr","d","D");

        try {
            	Process proceso1 = pb1.start();
            	Process proceso2 = pb2.start();

		
        
       		//creamos un buffer donde guardar la salida del proceso1
        	BufferedReader breader = new BufferedReader (new InputStreamReader(proceso1.getInputStream()));
                
		BufferedWriter bwriter = new BufferedWriter (new OutputStreamWriter(proceso2.getOutputStream()));

                /*OutputStream os = proceso2.getOutputStream();
                PrintStream ps = new PrintStream(os);
                String line;
                while ((line=breader.readLine())!=null){
                    ps.print(line);
                }
                ps.close();
                */
        
        	//creamos la variables line y line2
        	String line = null;
                String line2 = null;

        	//bucle para poner la salida del proceso1 en el procesoq
		//recorremos todas las lineas para que ejecute ls -l
        	while ((line = breader.readLine()) !=null) {
            		bwriter.write(line + "\n");
        	}
                
                //cerramos el bwriter
		bwriter.close();

		BufferedReader breader2 = new BufferedReader (new InputStreamReader(proceso2.getInputStream()));

		while ((line2 = breader2.readLine()) != null){
			System.out.println(line2);
		}
                //cerramos el resto
		breader2.close();
		
            
        }
        
        catch  (IOException e){
            System.out.println(e.getMessage());
        }
        
    
        
        
    }
}
