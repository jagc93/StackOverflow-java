package co.com.stackoverflow;

import java.util.Iterator;
import java.util.Stack;

import question_331039.LeerFicheros;

/**
 * Hello world!
 *
 */
public class App 
{
	static String cadena = "{()}()";
	static Stack<Character> stackLetras = new Stack<Character>();
	static Stack<Character> caracteres = new Stack<Character>();

	public static void main( String[] args )
	{
		// LeerFicheros.leerFichero()

		try {
			caracteres.push('{');
			caracteres.push('}');
			caracteres.push('(');
			caracteres.push(')');
			
			char[] arrayLetras = cadena.toCharArray(); 
			char a = 'a';
			for (int i = 0; i < arrayLetras.length; i++) {
				if (i % 2 == 0) {
					a = obtenerCaracter(arrayLetras[i], false);
				} else {
					a = obtenerCaracter(a, true);
				}
				System.out.println(a);
				if ((i % 2 == 0 && arrayLetras[i] == a) || (arrayLetras[i] == arrayLetras[i - 1])) {
					stackLetras.push(arrayLetras[i]);
				} else if (arrayLetras[i] == a && !stackLetras.isEmpty() && stackLetras.peek() != a) {
					stackLetras.pop();
				} else if (!stackLetras.isEmpty()) {
					break;	
				}
			}

			System.out.println(stackLetras.isEmpty());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static char obtenerCaracter(char letra, boolean nextChar) {
		
		Iterator<Character> iterator = caracteres.iterator();
		
		while(iterator.hasNext()) {
			Character caracter = iterator.next();
			if (caracter == letra) {
				if (!nextChar) {
					return caracter;					
				} else if (iterator.hasNext()) {
					return iterator.next();
				}
			}
		}
		
		return letra;
	}
}
