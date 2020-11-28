package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {

	private Color color;
	private Posicion posicion;


	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No es posible un color nulo.");
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {

		if (posicion == null) {
			throw new IllegalArgumentException("ERROR: No es posible una posición nula.");
		}
		this.posicion = posicion;
	

	}

	public Alfil() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'f');
	}

	public Alfil(Color color) {
		this();
		setColor(color);
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'f');
		} else if (color == Color.NEGRO) {
			posicion = new Posicion(8, 'f');
		}
	}

	public Alfil(Color color, char columna) {
		setColor(color);
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		if (columna != 'c' & columna != 'f') {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, columna);
		} else if (color == Color.NEGRO) {
			posicion = new Posicion(8, columna);
		}
	}

}
