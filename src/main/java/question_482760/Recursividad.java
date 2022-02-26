package question_482760;

public class Recursividad {

	public static void main(String[] args) {
		try {
			System.out.println ("Recursividad");
		    System.out.println ("\n" + sumNumeros (4)); //Primera prueba
		    System.out.println ("\n" + sumNumeros (5)); //Primer ejercicio
		    System.out.println("\n" + sumaN1(5, 0));//Segundo ejercicio forma 1
		    System.out.println("\n" + suma1N(5, 0, 0));//Segundo ejercicio forma 2
		    multiplicar(5,10);//Tercer ejercicio
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/******************************************************************************/
	public static long sumNumeros (int n){
		if (n == 1){
			System.out.print(n+"=");
			return 1;
		}
		else{
			System.out.print (n + "*");
			return n + sumNumeros (n - 1);
		}
	}//Fin de la prueba

	//Comienzo del segundo ejercicio
	/******************************************************************************/
	//método recursivo para calcular la suma desde N hasta 1
	public static long sumaN1(int n, long suma){
		if(n > 1) {
			System.out.print (n + "+");
			suma += n;
			n--;
			return sumaN1(n, suma);
		} else {
			suma += n;
			System.out.print(n + "=");
			return suma;
		}
	}//Fin del segundo metodo 
	
	// Segunda forma
	// método recursivo para calcular la suma desde 1 hasta N
	public static long suma1N(int n, int i, long suma){
		if(n > 1) {
			i++;
			System.out.print (i + "+");
			suma += i;
			n--;
			return suma1N(n, i, suma);
		} else {
			i++;
			suma += i;
			System.out.print(i + "=");
			return suma;
		}
	}//Fin del segundo metodo 
	
	//Fin del segundo ejercicio 
	/******************************************************************************/
	//Comienzo del tercer ejercicio 
	public static void multiplicar (int iTabla, int iNumero){
		if (iNumero > 1)
			multiplicar (iTabla, iNumero - 1);
		System.out.println (iTabla + "x" + iNumero + "=" + iTabla * iNumero);
	}//Fin del metodo de las tablas
}
