/**
*
* @author Joan
*/

import java.io.*;
import java.util.*;

public class suma {
    
    public static void main(String[] args) throws IOException{
       
        ArrayList<Integer> array = new ArrayList <>();
        Scanner tcl = new Scanner(System.in);
        String str;
        str=tcl.nextLine();
        for (int i=0;i<str.length();i++){
            array.add(Integer.parseInt(""+ str.charAt(i)));
        }
        int resultado=0;
        for (int i=0;i<array.size();i++){
            resultado=resultado+array.get(i);
        }
        System.out.println("Resultado: "+resultado);
    }
}
