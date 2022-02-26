package question_465677;

import java.util.Scanner;

public class PromedioNotasPorcentaje {

	public static void main(String[] args) {
		try {

			// Declaramos las variables
			double notaA;
			double notaB;
			double promedio;
			// Declaramos e inicializamos los valores de los porcentajes de cada nota
			double porcentajeA = 25.0/100; // Porcentaje Nota A 3.5%
			double porcentajeB = 75.0/100; // Prcentaje Nota B 7.5%

			Scanner key = new Scanner(System.in);

			notaA = key.nextDouble();
			notaB = key.nextDouble();

			/**
			 * Para el calculo del promedio se multiplica la nota con su respectivo porcentaje
			 * Luego se suman los resultados y ese es el promedio.
			 */
			promedio = (notaA * porcentajeA) + (notaB * porcentajeB);

			System.out.println("Media = " + promedio);
			key.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
