/**
 * La siguiente clase mantiene los elementos que intervienen en
 * una transación como son al vehiculo y el cliente, además del 
 * número de dias que se renta un vehículo.
 */
package com.Negocio;

import java.io.Serializable;

import com.Padres.Vehiculo;

/**
 * @author Pedro
 *
 */
public class Prestamo implements Serializable{

	protected Vehiculo vehiculo;
	protected Cliente cliente;
	protected int numDias;

	public Prestamo(Vehiculo vehiculo, Cliente cliente, int numDias) {
		this.setCliente(cliente);
		this.setVehiculo(vehiculo);
		this.setNumDias(numDias);
	}

	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the numDias
	 */
	public int getNumDias() {
		return numDias;
	}

	/**
	 * @param numDias the numDias to set
	 */
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}



}
