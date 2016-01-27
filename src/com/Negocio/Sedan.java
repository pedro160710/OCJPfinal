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
public class Sedan extends Vehiculo {
	protected double cilindraje;

	public Sedan(String placa, String marca, Colores color, String anio,
			int kilometraje, double costo, boolean disponible, double cilindraje,String modelo) {
		super(placa, marca, color, anio, kilometraje, costo, disponible, modelo);
		// TODO Auto-generated constructor stub

		this.setCilindraje(cilindraje);
	}

	/**
	 * @return the cilindraje
	 */
	public double getCilindraje() {
		return cilindraje;
	}

	/**
	 * @param cilindraje
	 *            the cilindraje to set
	 */
	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}

}
