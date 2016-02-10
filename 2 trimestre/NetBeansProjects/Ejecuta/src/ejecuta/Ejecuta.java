/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecuta;

/**
 *
 * @author Joan
 */

import java.io.*;
  import java.util.*;
   
  public class Ejecuta {
    public static void main(String args[]) throws IOException {
 
      if (args.length <= 0) {
        System.err.println("Necesito un comando para ejecutar ");
        System.exit(-1);
      }
 
      Runtime runtime = Runtime.getRuntime();
      Process process = runtime.exec(args);
      //InputStream is = process.getInputStream();
      //InputStreamReader isr = new InputStreamReader(is);
      //BufferedReader br = new BufferedReader(isr);
      BufferedReader berr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
      String line;
      
      System.out.println("Error of running %s is:" + Arrays.toString(args));
 
      //System.out.printf("La salida que se esta ejecutando %s es:", 
        //  Arrays.toString(args));
 
      while ((line = berr.readLine()) != null) {
        System.out.println(line);
      }
 
    }
   } 
    

