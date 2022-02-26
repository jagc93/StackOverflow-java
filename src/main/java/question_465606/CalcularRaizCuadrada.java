package question_465606;

import lombok.var;

public class CalcularRaizCuadrada {
	
	public static void main(String[] args) {

		String saltoLinea = System.getProperty("line.separator");
		int numero = 4;
		System.out.println("La raiz de " + numero + " es: " + calcularRaizCuadrada(numero));
		
		System.out.println(saltoLinea + ":::::::::::: FORMA 1 usando calcularRaizCuadradaNewtonArreglo ::::::::::::");
		System.out.println(saltoLinea);
		
		int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		// Ejecutar forma 1
		calcularRaizCuadradaNewtonArreglo(array);
		
		System.out.println(saltoLinea + ":::::::::::: FIN ::::::::::::");
		System.out.println(":::::::::::: FORMA 2 usando calcularRaizCuadradaNewtonArreglo2 ::::::::::::" + saltoLinea);
		
		// Ejecutar forma 2
		double[] res = calcularRaizCuadradaNewtonArreglo2(array);
		for (int i = 0; i < res.length; i++) {
			System.out.println("La raiz de " + array[i] + " es: " + res[i]);
		}
		
		System.out.println(saltoLinea + ":::::::::::: FIN ::::::::::::");
		System.out.println(":::::::::::: FORMA 3 usando calcularRaizCuadrada ::::::::::::" + saltoLinea);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("La raiz de " + array[i] + " es: " + calcularRaizCuadrada(array[i]));
		}
		
		System.out.println(saltoLinea + ":::::::::::: FIN ::::::::::::");
	}

	/**
	 * Ejecucion funcion en la forma 3 del ejemplo
	 * @param x
	 * @return
	 */
	public static double calcularRaizCuadrada(int x) {
		var estimacion = x / 2.0;
		var cociente = x / estimacion;

		return (cociente + estimacion) / 2.0;
	}

	/**
	 * Ejecucion metodo en la forma 1 del ejemplo
	 * @param x
	 */
	public static void calcularRaizCuadradaNewtonArreglo(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.println("La raiz de " + x[i] + " es: " + calcularRaizCuadrada(x[i]));
		}
	}

	/**
	 * Ejecucion funcion en la forma 2 del ejemplo
	 * @param x
	 * @return
	 */
	public static double[] calcularRaizCuadradaNewtonArreglo2(int[] x) {

		double[] res = new double[x.length];

		for(int i = 0; i < x.length; i++) {
			res[i] = calcularRaizCuadrada(x[i]);
		}

		return res;
	}
}
