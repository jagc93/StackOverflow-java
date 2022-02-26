package question_429408;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		try {
			String correo = null;
			boolean correoInvalido = true;
			// Definimos la estructura del correo que requerimos
			String formatoCorreo = "([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+";

			// Patron para validar el correo
	        Pattern pattern = Pattern.compile(formatoCorreo);

			do {
				// Solicitamos el correo
				System.out.println("Ingresa tu correo electronico");
				correo = entrada.nextLine();

				// Validamos el correo ingresado
				Matcher mather = pattern.matcher(correo);
				// Obtenemos resultado de la validacion cuando es valido se obtiene true, y si no cumple los requisitos retorna false
				//Si retorna false, lo que se hace es realizar el proceso nuevamente
				correoInvalido = !mather.find();

			} while(correoInvalido);

			// Obtener el usuario
			String usuario = correo.split("@")[0];
			System.out.println(usuario);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entrada.close();
		}
	}
}
