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
public class Limusina extends Vehiculo {
	protected int capacidad;// capacida de personas

	public Limusina(String placa, String marca, Colores color, String anio,
			int kilometraje, double costo, boolean disponible, int capacidad,String modelo) {
		super(placa, marca, color, anio, kilometraje, costo, disponible, modelo);
		// TODO Auto-generated constructor stub

		this.setCapacidad(capacidad);
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


}
