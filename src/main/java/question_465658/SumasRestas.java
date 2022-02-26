package question_465658;

import java.util.Arrays;
import java.util.Random;

public class SumasRestas {

	private static int[] array = new int[5];

	public static void main(String[] args) {
		try {
			llenaArreglo();
			System.out.println("Arreglo: " + Arrays.toString(array));
			System.out.println(sumayResta(array));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Se recorre el arreglo y se le asignan valores random
	 */
	public static void llenaArreglo(){
		for (int i=0;i<array.length;i++){
			array[i] = getRandom(null);
		}
	}

	/**
	 * El parametro es nulo cuando se desea llenar el arreglo con valores,
	 * es diferente de nulo cuando se desea retornar una posicion random del arreglo.
	 * @param array
	 * @return
	 */
	public static int getRandom(int[] array) { //Obtiene un número aleatorio del arreglo

		if (array == null) {
			return new Random().nextInt(30) + 1; // De esta manera hacemos que retorne el valor rando entre el 1 y el 30
		} else {
			return new Random().nextInt(array.length); // De esta manera hacemos que se retorne la posicion del arreglo
		}
	}

	/**
	 * Retorna los numeros mayores y menores a X
	 * @param array
	 * @return
	 */
	public static String sumayResta(int[] array) {

		int x = array[getRandom(array)]; // Obtenemos el valor x, accediendo a la posicion random que se retorna en la funcion getRandom
		int suma = 0;
		int resta = 0;
		String cadena = "";

		for (int i=0;i<array.length;i++) {
			if (array[i] > x) // Si es mayor que x, se suman los valores
				suma += array[i];
			else if (array[i] < x) // Si es menor que x, se restan los valores
				resta -= array[i];
		}
		cadena = "X: " + x + "\nSuma: "+suma+"\nResta: "+resta;
		return cadena; 
	}
}
