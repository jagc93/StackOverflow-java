package co.com.stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio {

	public static final Scanner SC = new Scanner (System.in);

	public static void main(String[] args) {
		try {
			int opcion;
			List<String> integrantes = new ArrayList<String>();
			List<Integer> fichas = new ArrayList<Integer>();
			Random random = new Random();
			boolean recorrer = true;
			System.out.println("::::::::::::::::::::::::::::::::::::::::::");

			do {
				System.out.println("Seleccione una opcion:");
				System.out.println("1. Ingresar participante\n2. Iniciar juego");
				opcion = SC.nextInt();

				if (opcion == 1) {
					System.out.println("Nombre del nuevo integrante:");
					String integrante = SC.next();
					integrantes.add(integrante);
					fichas.add(random.nextInt(499) + 1);
				} else if (opcion == 2) {
					recorrer = false;
				}
			} while (recorrer);

			System.out.println("Iniciamos el juego");
			System.out.println("integrantes => " + integrantes);
			System.out.println("fichas => " + fichas);

			int idx2 = 1;
			boolean isInicial = true;

			for(int idx = 0; idx < fichas.size(); idx++) {
				int ficha = fichas.get(idx);
				while(ficha > 0) {
					if(ficha % 2 == 0) {
						isInicial = false;
						for(; idx2 < integrantes.size(); idx2++) {
							if (validaGanador(integrantes)) {
								ficha = 0;
								idx = fichas.size();
								pintarGanador(integrantes);
								break;
							}
							if(integrantes.get(idx2) != null)  {
								ficha--;
							}

							if (ficha == 0) {
								if(!validaGanador(integrantes)) {
									idx = idx2 - 1;
									integrantes.set(idx2, null);
									idx2++;
									if(idx2 + 1 >= integrantes.size()) {
										idx2 = getIdx2(idx, fichas, true);
									}
								} else {
									idx = fichas.size();
								}
								break;
							}
							if(idx2 + 1 >= integrantes.size()) {
								idx2 = -1;
							}
						}
					} else {
						if(isInicial || idx2 < 0) {
							idx2 = integrantes.size() - 1;						
						}
						for(; idx2 >= 0; idx2--) {
							if (validaGanador(integrantes)) {
								ficha = 0;
								idx = fichas.size();
								pintarGanador(integrantes);
								break;
							}

							if(integrantes.get(idx2) != null)  {
								ficha--;
							}

							if (ficha == 0) {
								if(!validaGanador(integrantes)) {
									idx = idx2 - 1;
									integrantes.set(idx2, null);
									idx2 = getIdx2(idx, fichas, false);
									isInicial = false;
									if (idx2 >= integrantes.size()) {
										idx2 = 0;
									}
								} else {
									idx = fichas.size();
								}
								break;
							}
							
							if(idx2 - 1 < 0) {
								idx2 = integrantes.size();
							}
						}						
					}
				}
			}

			System.out.println(integrantes);
			System.out.println("::::::::::::::::::::::::::::::::::::::::::");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static int pintarGanador(List<String> integrantes) {
		List<String> integrantesTmp = new ArrayList<String>();
		for(int idx = 0; idx < integrantes.size(); idx++) {
			if (integrantes.get(idx) != null) {
				integrantesTmp.add(integrantes.get(idx));
			}

			if (idx == integrantes.size() - 1 && integrantesTmp.size() == 1) {
				System.out.println("El ganador es: " + integrantesTmp.get(0));
			}
		}

		return integrantesTmp.size();
	}

	private static boolean validaGanador(List<String> integrantes) {

		List<String> integrantesTmp = new ArrayList<String>();
		for(int idx = 0; idx < integrantes.size(); idx++) {
			if (integrantes.get(idx) != null) {
				integrantesTmp.add(integrantes.get(idx));
			}
		}

		return integrantesTmp.size() == 1;
	}

	private static int getIdx2(int idx, List<Integer> fichas, boolean option) {
		if(option) {
			if(fichas.get(idx + 1) % 2 == 0) {
				return idx + 1;
			} else {
				return idx;
			}			
		} else {
			if(fichas.get(idx + 1) % 2 == 0) {
				return idx + 2;
			} else {
				return idx;
			}
		}
	}
}
