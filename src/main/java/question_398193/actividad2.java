package question_398193;

import java.util.Scanner;

public class actividad2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombre = "";
		int edad = 0;
		double salario = 0.0;
		double salario_final = 0.0;
		double descuento = 0.0;
		double porcentaje_descuento = 0.15;
		double transporte = 0.0;
		double salario_minimo = 1961314;

		Scanner entrada = new Scanner (System.in);

		System.out.println("Digite su nombre");
		nombre=entrada.nextLine();
		System.out.println("Digite su salario");
		salario=entrada.nextDouble();
		System.out.println("Digite su edad");
		edad=entrada.nextInt();

		if(salario<= salario_minimo*2) {
			transporte = 80000;

		}
		else {
			transporte = 0;

		}
		descuento= salario * porcentaje_descuento;
		salario_final= salario + transporte - descuento;
		System.out.println("el valor del saldo es: "+salario_final);



	}

}
