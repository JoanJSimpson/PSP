/**
*
* @author Joan
*/

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Mayusculas {
    
    public static void main(String[] args)throws IOException {
	

        try {
            
            String line="";
            String line2="";
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            String [] comando = {"java","cambio"};
            //creamos el procesoHijo
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process procesoHijo;
            //obtenemos el stdout del procesoHijo
            BufferedReader br;
            //obtenemos el stdin del procesoHijo
            PrintStream ps;
            //comprobamos que no ha escrito fin
            while ((line=(in.readLine())).compareTo("fin") !=0){
                //arrancamos el procesoHijo
                procesoHijo = pb.start();
                //creamos ps y br
                ps = new PrintStream (procesoHijo.getOutputStream());
                br = new BufferedReader (new InputStreamReader(procesoHijo.getInputStream()));
                
                //enviamos a la entrada del procesoHijo lo pasado por teclado
                ps.println(line);
                //cerramos ps
                ps.close();
                //Sacamos por la salida estandar la salida del proceso hijo
                if ((line2=(br.readLine()))!=null){
                    System.out.println(line2+"\n");
                //cerramos br, y destruimos el hijo
                br.close();
                procesoHijo.destroy();
                
                }
            }
           
           
        }catch  (IOException e){
            System.out.println("Error ocurrió ejecutando el comando. Descripción: " + e.getMessage());
        }
        
    }
}
