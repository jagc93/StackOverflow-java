package question_494578;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Ciudades c1=new Ciudades();
		Scanner leer=new Scanner (System.in);

		System.out.print("Digite el nombre de la Ciudad:\n");
		c1.setNomCiudad(leer.nextLine());
		System.out.println("Digite el nombre del País:");
		c1.setPais(leer.nextLine()); 

		c1.mensaje(c1.getNomCiudad(),c1.getPais());

		leer.close();
	}

}
