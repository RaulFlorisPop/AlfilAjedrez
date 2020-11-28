package org.iesalandalus.programacion.alfilajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Alfil alfil = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void mostrarAlfil() {
		System.out.println(alfil);
	}

	private static void mostrarMenu() {
		System.out.println("\nEscoje una de las siguiente opciones: ");
		System.out.println("1. Crear un alfil por defecto.");
		System.out.println("2. Crear un alfil de un color. ");
		System.out.println("3. Crear un alfil de un color en una columna inicial dada ('c' o 'f')");
		System.out.println("4. Mover el alfil.");
		System.out.println("5. Salir.");

	}

	private static int elegirOpcion() {
		int opcion;
		System.out.println("Escoge una opción: ");
		opcion = Entrada.entero();
		while (opcion < 1 || opcion > 5) {
			System.out.println("Opción incorrecta.");
			System.out.println("\nEscoje una de las siguiente opciones: ");
			System.out.println("1. Crear un alfil por defecto.");
			System.out.println("2. Crear un alfil de un color. ");
			System.out.println("3. Crear un alfil de un color en una columna inicial dada ('c' o 'f')");
			System.out.println("4. Mover el alfil.");
			System.out.println("5. Salir.");
			System.out.println("Escoge una opción: ");
			opcion = Entrada.entero();
		}
		return opcion;
	}

	private static Color elegirColor() {
		System.out.println("\nEscoge un color para el alfil: ");
		System.out.println("1. Color Blanco.");
		System.out.println("2. Color Negro");
		System.out.println("Escoge una opción: ");

		int opcionColor = Entrada.entero();

		while (opcionColor < 1 || opcionColor > 2) {
			System.out.println("Color incorrecto. Vuelve a intentarlo.");
			System.out.println("\nEscoge un color para el alfil: ");
			System.out.println("1. Color Blanco.");
			System.out.println("2. Color Negro");
			System.out.println("Escoge una opción: ");
			opcionColor = Entrada.entero();
		}
		Color color = null;

		if (opcionColor == 1) {
			color = color.NEGRO;
		} else if (opcionColor == 2) {
			color = color.BLANCO;
		}
		return color;
	}

	private static char elegirColumnaInicial() {
		char columna = 0;

		System.out.println("\nElige la columna inicial para el alfil ('c' o 'f': ");
		System.out.println("Escoge una opción: ");
		columna = Entrada.caracter();

		while (columna != 'c' && columna != 'f') {
			System.out.println("Columna incorrecta. Vuelve a intentarlo.");
			System.out.println("\nElige la columna inicial para el alfil ('c' o 'f': ");
			System.out.println("Escoge una opción: ");
			columna = Entrada.caracter();
		}
		return columna;
	}

	private static void mostrarMenuDirecciones() {
		System.out.println("Los movimientos del alfil son los siguientes: ");
		System.out.println("1. ARRIBA_DERECHA");
		System.out.println("2. ABAJO_DERECHA");
		System.out.println("3. ABAJO_IZQUIERDA");
		System.out.println("4. ARRIBA_IZQUIERDA");
		
	}

}
