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
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
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
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, columna);
		} else if (color == Color.NEGRO) {
			posicion = new Posicion(8, columna);
		}
	}

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (pasos <= 0) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		}
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		switch (direccion) {
		case ARRIBA_DERECHA:
			try {
				posicion = new Posicion((posicion.getFila() + pasos), (char) (posicion.getColumna() + pasos));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		case ARRIBA_IZQUIERDA:
			try {
				posicion = new Posicion((posicion.getFila() + pasos), (char) (posicion.getColumna() - pasos));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		case ABAJO_DERECHA:
			try {
				posicion = new Posicion((posicion.getFila() - pasos), (char) (posicion.getColumna() + pasos));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		case ABAJO_IZQUIERDA:
			try {
				posicion = new Posicion((posicion.getFila() - pasos), (char) (posicion.getColumna() - pasos));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
			}
			break;
		default:
			break;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alfil other = (Alfil) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return posicion + ", color=" + color;
	}

}
