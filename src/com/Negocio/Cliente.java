/**
 * La siguiente Clase extiende a la clase persona
 */
package com.Negocio;

import java.io.Serializable;

import com.Padres.Persona;

/**
 * @author Pedro
 *
 */
public class Cliente extends Persona implements Serializable{

	public Cliente(String nombre, String apellido, String cedula, int edad) {
		super(nombre, apellido, cedula, edad);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */

}
