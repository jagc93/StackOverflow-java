package question_460494;

public class CaracteresRepetidos {

	public static void main(String[] args) {

		String cadena = "ffeeddaaf";
        System.out.println ("Original: " + cadena);
        cadena = cadena.replaceAll("(.)\\1", "$1");// "(.)\\1"
        System.out.println ("Resultado: " + cadena);
        System.out.println ("Resultado2: " + newString(cadena, cadena.length() - 1));
	}

	private static String newString(String text, int pos) {

		if (pos > 0) {
			if (text.indexOf(text.substring(pos, pos + 1)) != text.lastIndexOf(text.substring(pos, pos + 1))) {
				text = text.substring(0, pos) + text.substring(pos + 1);
				pos = text.length() - 1;
			} else {
				pos--;
			}
		} else {
			return text;
		}

		return newString(text, pos);
	}
}
