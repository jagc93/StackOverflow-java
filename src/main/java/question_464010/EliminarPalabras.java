package question_464010;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EliminarPalabras {

	public static void main(String[] args) {

		Scanner entrada = new Scanner (System.in);

		try {
			System.out.println("Ingrese la cadena: ");
			String cadena = entrada.nextLine();

			cadena = newString(cadena);
			System.out.println(cadena);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entrada.close();
		}
	}

	private static String newString(String text) {

		if (text == null) {
			return text;
		}

		Pattern p = Pattern.compile("^(.*)\\s(c|C)+(.*)");
	    Matcher m = p.matcher(text);

		if (m.matches()) {
			text = (text.replace(m.group(1), "")).trim();

			return newString(text);
		}

		return text;
	}
}
