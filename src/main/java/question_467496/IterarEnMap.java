package question_467496;

import java.util.HashMap;
import java.util.Map;

public class IterarEnMap {

	public static void main(String[] args) {
		try {
			Map<String, String[]> nombreAlumnos = new HashMap<String, String[]>();
			String[] primero = { "Rodrigo", "Maria", "Paola" };
			String[] segundo = { "Daniela", "Amelia", "Santiago" };
			nombreAlumnos.put("primero", primero);
			nombreAlumnos.put("segundo", segundo);

			for (Map.Entry<String, String[]> entry : nombreAlumnos.entrySet()) {
				System.out.println("key = " + entry.getKey() + ", Value = " + entry.getValue());

				/**
				 * Aqui hacemos el recorrido de lo que venemos en el getValue().
				 * Se hace mediante un for para obtener todas las posiciones dado que
				 * como lo especificaste en un comienzo es de tipo String[]
				 */
				for (String value : entry.getValue()) {
					System.out.println(value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
