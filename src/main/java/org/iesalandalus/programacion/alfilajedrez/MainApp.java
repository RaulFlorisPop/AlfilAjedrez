package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Alfil alfil = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Juego de mover un alfil en un tablero de ajedrez.");
		mostrarMenu();
		
	}
	
	private static void mostrarAlfil() {
		System.out.println(alfil);
	}

	private static void mostrarMenu() {
		System.out.println("Opciones Posibles: ");
		System.out.println("1. Crear un alfil por defecto.");
		System.out.println("2. Crear un alfil de un color. ");
		System.out.println("3. Crear un alfil de un color en una columna inicial dada ('c' o 'f').");
		System.out.println("4. Mover el alfil.");
		System.out.println("5. Salir.");
		ejecutarOpcion(elegirOpcion());

	}

	private static int elegirOpcion() {
		int opcion;
		System.out.println("Elija una opción: ");
		opcion = Entrada.entero();
		while (opcion < 1 || opcion > 5) {
			System.out.println("Opción incorrecta.");
			System.out.println("Escoje una de las siguiente opciones:");
			System.out.println("1. Crear un alfil por defecto.");
			System.out.println("2. Crear un alfil de un color.");
			System.out.println("3. Crear un alfil de un color en una columna inicial dada ('c' o 'f').");
			System.out.println("4. Mover el alfil.");
			System.out.println("5. Salir.");
			System.out.println("Escoge una opción:");
			opcion = Entrada.entero();
		}
		return opcion;
	}

	private static Color elegirColor() {
		System.out.println("Escoge un color para el alfil:");
		System.out.println("1. Color Negro.");
		System.out.println("2. Color Blanco.");
		System.out.println("Escoge una opción:");

		int opcionColor = Entrada.entero();

		while (opcionColor < 1 || opcionColor > 2) {
			System.out.println("Color incorrecto. Vuelve a intentarlo.");
			System.out.println("Escoge un color para el alfil: ");
			System.out.println("1. Color Blanco.");
			System.out.println("2. Color Negro");
			System.out.println("Escoge una opción:");
			opcionColor = Entrada.entero();
		}
		Color color = null;

		if (opcionColor == 1) {
			color = Color.NEGRO;
		} else if (opcionColor == 2) {
			color = Color.BLANCO;
		}
		return color;
	}

	private static char elegirColumnaInicial() {
		char columna = 0;

		System.out.println("Elige la columna inicial para el alfil ('c' o 'f': ).");
		System.out.println("Escoge una opción: ");
		columna = Entrada.caracter();

		while (columna != 'c' && columna != 'f') {
			System.out.println("Columna incorrecta. Vuelve a intentarlo.");
			System.out.println("Elige la columna inicial para el alfil ('c' o 'f': ).");
			System.out.println("Escoge una opción: ");
			columna = Entrada.caracter();
		}
		return columna;
	}

	private static void mostrarMenuDirecciones() {
		System.out.println("Escoja opción");
		System.out.println("1. ARRIBA_DERECHA");
		System.out.println("2. ABAJO_DERECHA");
		System.out.println("3. ABAJO_IZQUIERDA");
		System.out.println("4. ARRIBA_IZQUIERDA");
		mover();

	}

	private static Direccion elegirDireccion() {
		Direccion movimiento = null;
		int mover;

		do {
			System.out.println("Escoge el movimiento de tu alfil:");
			mover = Entrada.entero();
		} while (mover < 1 || mover > 4);

		if (mover == 1) {
			movimiento = Direccion.ARRIBA_DERECHA;
		} else if (mover == 2) {
			movimiento = Direccion.ABAJO_DERECHA;
		} else if (mover == 3) {
			movimiento = Direccion.ABAJO_IZQUIERDA;
		} else {
			movimiento = Direccion.ARRIBA_IZQUIERDA;
		}
		return movimiento;
	}

	private static void crearAlfilDefecto() {
		alfil = new Alfil();
		System.out.println("Se ha creado un nuevo alfil por defecto " + alfil);
	}

	private static void crearAlfilColor() {
		alfil = new Alfil(elegirColor());
		System.out.println("Se ha creado un nuevo alfil con el color elegido " + alfil);
	}

	private static void crearAlfilColorColumna() {
		alfil = new Alfil(elegirColor(), elegirColumnaInicial());
		System.out.println("Se ha creado un nuevo alfil con el color y columna elegida " + alfil);
	}

	private static void mover() {
		try {
			Direccion direccion = elegirDireccion();
			System.out.println("Indica cuantos pasos quieres dar en esa dirección: ");
			int pasos = Entrada.entero();
			alfil.mover(direccion, pasos);
			System.out.println("El alfil se ha movido " + alfil);
			mostrarMenu();
		} catch (OperationNotSupportedException e) {
			System.out.println("ERROR: Movimiento no válido");
		}
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			crearAlfilDefecto();
			mostrarMenu();
			break;
		case 2:
			crearAlfilColor();
			mostrarMenu();
			break;
		case 3:
			crearAlfilColorColumna();
			mostrarMenu();
			break;
		case 4:
			mostrarMenuDirecciones();
			break;
		case 5:
			System.out.println("El programa se a cerrado.");
			System.exit(0);
			break;
		}
	}

} 
