/**
*
* @author Joan
*/

import java.io.*;
import java.util.*;

public class Mayusculas {
    
    public static void main(String[] args)throws IOException {
	

        try {
            
            String cadena="";
            Boolean haTerminado=false;
            //comprobamos que no ha escrito fin
            while (haTerminado==false){
                //creamos un scanner para introducir lo que se quiera pasar a mayusculas
                Scanner tcl = new Scanner (System.in);
                cadena = tcl.nextLine();
                //creamos el comando a ejecutar por el procesoHijo
                //String [] comando = {"java","cambio",cadena};
                String [] comando = {"java","cambio"};
                //creamos el procesoHijo
                Process procesoHijo= new ProcessBuilder(comando).start();

                //obtenemos el stdout del procesoHijo
                BufferedReader breader = new BufferedReader (new InputStreamReader(procesoHijo.getInputStream()));

                //obtenemos el stdint del procesoHijo
                BufferedWriter bwriter = new BufferedWriter (new OutputStreamWriter(procesoHijo.getOutputStream()));

                String line=null;

                //comprobamos que lo que ha metido es distinto de fin o terminará el programa 
                //poniendo haTerminado = true y cerrando los Buffereds

                if (!cadena.equals("fin")){
                    bwriter.write(cadena);
                    while ((line = breader.readLine()) !=null) {
                        System.out.println(line);
                    }

                }else{
                    haTerminado=true;
                    breader.close();
                    procesoHijo.destroy();
                    bwriter.close();
                }

            }
           
        }catch  (IOException e){
            System.out.println("Error ocurrió ejecutando el comando. Descripción: " + e.getMessage());
        }
        
    }
}
