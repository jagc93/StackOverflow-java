package question_465677;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PromedioNotasPeso {

	public static void main(String[] args) {
		try {

			// Declaramos las variables
			double notaA;
			double notaB;
			double promedio = 0d;
			// Declaramos e inicializamos los valores de los porcentajes de cada nota
			double pesoA = 3.5d;
			double pesoB = 7.5d;
			double sumaPesos = pesoA + pesoB;

			Scanner key = new Scanner(System.in);

			notaA = key.nextDouble();
			notaB = key.nextDouble();

			/**
			 * Si la suma de los pesos es mayor a 1, la formula a aplicar es ((nota1*peso1)+(notaN*pesoN))/(peso1+pesoN)
			 * Si la suma de los pesos es 1, la formula a aplicar es (nota1*peso1)+(notaN*pesoN)
			 */
			if (sumaPesos > 1d) {
				promedio = ((notaA * pesoA) + (notaB * pesoB))/(pesoA + pesoB);				
			} else if(sumaPesos == 1d) {
				promedio = (notaA * pesoA) + (notaB * pesoB);
			}

			/**
			 * Se hace que imprima siempre el promedio con 1 decimal 
			 */

			/*
			 * alternativa 1 con DecimalFormat
			 */
			DecimalFormat df = new DecimalFormat("#.0");

			System.out.println("Media = " + df.format(promedio));

			/*
			 * Alternativa 2 con operaciones matematicas
			 * usando el Math.round
			 */
			promedio = Math.round(promedio * 10) / 10d;
			System.out.println("Media = " + promedio);

			/*
			 * Alternativa 3 con BigDecimal
			 */
			BigDecimal bigDecimal = BigDecimal.valueOf(promedio).setScale(1, RoundingMode.UP);
			promedio = bigDecimal.doubleValue();

			System.out.println("Media = " + promedio);

			key.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
