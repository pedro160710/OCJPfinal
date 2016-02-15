/**
 * La siguiente clase extiende a la clase Vehiculo
 */
package com.Negocio;

import com.Padres.Colores;
import com.Padres.Vehiculo;

/**
 * @author Pedro
 *
 */
public class Buseta extends Vehiculo {
	protected int capacidadPersonas;

	public Buseta(String placa, String marca, Colores color, String anio,
			int kilometraje, double costo, boolean disponible,
			int capacidadPersonas, String modelo) {
		super(placa, marca, color, anio, kilometraje, costo, disponible, modelo);
		// TODO Auto-generated constructor stub

		this.setCapacidadPersonas(capacidadPersonas);
	}

	/**
	 * @return the capacidadPersonas
	 */
	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}

	/**
	 * @param capacidadPersonas
	 *            the capacidadPersonas to set
	 */
	public void setCapacidadPersonas(int capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}

	/**
	 * 
	 */

}
