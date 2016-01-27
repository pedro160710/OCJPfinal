/**
 * Esta clase contiene valores que heredan a 
 * cualquier persona.
 */
package com.Padres;

/**
 * @author Pedro
 *
 */
public abstract class Persona {

	protected String nombre = "";
	protected String apellido = "";
	protected String cedula = "";
	protected int edad;

	/**
	 * 
	 */
	public Persona(String nombre, String apellido, String cedula, int edad) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setEdad(edad);

	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

}
