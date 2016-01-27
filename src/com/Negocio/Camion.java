/**
 * La siguiente clase extiende a la clase Vehiculo
 */
package com.Negocio;

import com.Padres.Colores;
import com.Padres.Vehiculo;

public class Camion extends Vehiculo {

	protected int capacidadCarga; //en toneladas

	public Camion(String placa, String marca, Colores color, String anio,
			int kilometraje, double costo, boolean disponible,
			int capacidadCarga,String modelo) {
		super(placa, marca, color, anio, kilometraje, costo, disponible, modelo);
		// TODO Auto-generated constructor stub
		this.setCapacidadCarga(capacidadCarga);
	}

	/**
	 * @return the capacidadCarga
	 */
	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	/**
	 * @param capacidadCarga the capacidadCarga to set
	 */
	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}



}
