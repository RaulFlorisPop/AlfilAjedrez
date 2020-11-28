package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {

	private Color color;
	private Posicion posicion;
	private int fila;
	private int columna;

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
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();

	}

}
