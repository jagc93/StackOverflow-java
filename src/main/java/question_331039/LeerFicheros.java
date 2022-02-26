package question_331039;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class LeerFicheros {

	public static final Scanner SC = new Scanner (System.in);
	
	public static void main(String[] args) {
		leerFichero();
	}
	
	public static void leerFichero() {
	    try {
	        String ruta;
	        System.out.println("Introduzca la ruta del fichero que desea leer");
	        ruta = SC.nextLine();
	        System.out.println(ruta);
	        ruta = ruta.trim().replace("'", "");
	        BufferedReader br = new BufferedReader(new FileReader(ruta));
	        String linea = "";
	        while (linea != null) {
	            linea = br.readLine();
	            if (linea != null) {
	                System.out.println(linea);
	            }
	        }
	        br.close();
	    } catch (Exception ex) {
	        System.out.println("No se ha encontrado el archivo." + ex);
	    }
	}
}
