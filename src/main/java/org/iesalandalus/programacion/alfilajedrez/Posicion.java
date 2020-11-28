package org.iesalandalus.programacion.alfilajedrez;

public class Posicion {
	private int fila;
	private char columna;

	public int getFila() {
		return fila;
	}

	private void setFila(int fila) {
		if (fila >= 1 && fila <= 8)
			this.fila = fila;
		else
			throw new IllegalArgumentException("ERROR: Fila no válida.");
	}

	public char getColumna() {
		return columna;
	}

	private void setColumna(char columna) {
		if (columna >= 'a' && columna <= 'h')
			this.columna = columna;
		else
			throw new IllegalArgumentException("ERROR: Columna no válida.");
	}

	public Posicion() {
		this.fila = 1;
		this.columna = 'a';
	}

	public Posicion(int fila, char columna) {

		this.setFila(fila);
		this.setColumna(columna);
	}

	public Posicion(Posicion posicion) {

		if (posicion == null) {
			throw new IllegalArgumentException("ERROR: No es posible copiar una posición nula.");
		}
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();

	}
}
