package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

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

	public void mover(Direccion direccion) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un movimiento nulo.");
		}
		switch (direccion) {
		case ARRIBA_IZQUIERDA:
			try {
				this.posicion = new Posicion((posicion.getFila() + 1), (char) (posicion.getColumna() - 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException exception) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ARRIBA_DERECHA:
			try {
				this.posicion = new Posicion((posicion.getFila() + 1), (char) (posicion.getColumna() + 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;

		case ABAJO_IZQUIERDA:
			try {
				this.posicion = new Posicion((posicion.getFila() - 1), (char) (posicion.getColumna() - 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO_DERECHA:
			try {
				this.posicion = new Posicion((posicion.getFila() - 1), (char) (posicion.getColumna() + 1));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;

		default:
			break;
		}
	}

}
