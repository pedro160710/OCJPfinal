/**
 * Clase Padre Vehiculo que contiene la información
 * general para cualquier vehículo
 */
package com.Padres;

/**
 * @author Pedro
 *
 */
public abstract class Vehiculo implements Disponible {

	protected String placa = "";
	protected String marca = "";
	protected Colores color;
	protected String anio = "";
	protected int kilometraje;
	protected double costo;
	protected boolean disponible;
	protected String modelo = "";

	/**
	 * 
	 */
	public Vehiculo(String placa, String marca, Colores color, String anio,
			int kilometraje, double costo, boolean disponible, String modelo) {
		this.setPlaca(placa);
		this.setMarca(marca);
		this.setColor(color);
		this.setAnio(anio);
		this.setKilometraje(kilometraje);
		this.setCosto(costo);
		this.setDisponible(disponible);
		this.setModelo(modelo);
	}

	@Override
	public void rentar() {
		this.setDisponible(false);

	}

	@Override
	public void receptar() {
		this.setDisponible(true);
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the color
	 */
	public Colores getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Colores color) {
		this.color = color;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the kilometraje
	 */
	public int getKilometraje() {
		return kilometraje;
	}

	/**
	 * @param kilometraje
	 *            the kilometraje to set
	 */
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	/**
	 * @return the costo
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * @param costo
	 *            the costo to set
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}

	/**
	 * @return the disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * @param disponible
	 *            the disponible to set
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
