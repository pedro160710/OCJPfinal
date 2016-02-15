/**
 * La clase Principal en donde se ejecutan
 * toda la funcionalidad de visualización del sistema.
 */
package com.Principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Negocio.*;
import com.Padres.*;

/**
 * @author Pedro, Andres
 * 
 */
public class Principal {
	/* lista que contiene el stock de vehiculos */
	public static List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	/* lista de objetos de tipo Prestamo */
	public static List<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
	/* tiempo de renta de vehiculo*/
	
	 
		
		
	public Principal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Prestamista.crearListaVehiculos(listaVehiculos);

		String continuar = "S";
		Scanner scanContinuar = new Scanner(System.in);
		do {
			menu();
			System.out.println("Desea Continuar? \"s\" o  \"S\"");
			continuar = scanContinuar.nextLine();
		} while (continuar.equals("s") || continuar.equalsIgnoreCase("s"));

	}

	/**
	 * metodo que muestra el menu principal de la aplicacion
	 */
	private static void menu() {
		System.out.println("RENT A CAR ");
		System.out.println("Escoja una opcion:");
		System.out.println("1 Buscar Vehiculo por placa");
		System.out.println("2 Buscar Cliente por cedula");
		System.out.println("3 Mostrar Inventario");
		System.out.println("4 Mostrar Rentados");
		System.out.println("5 Rentar Vehiculo");
		System.out.println("6 Receptar Vehiculo");
		System.out.println("7 Generar informe de vehiculos rentados");
		System.out.println("8 Salir");
		Scanner opcionMenu = new Scanner(System.in);
		switch (opcionMenu.nextInt()) {
		case 1:
			System.out
					.println("BUSQUEDA VEHICULO\nIngrese la placa del vehiculo: ");
			Prestamista.buscarVehiculo(listaVehiculos);
			break;
		case 2:
			if (!listaPrestamos.isEmpty()) {
				System.out
						.println("BUSQUEDA CLIENTE \nIngrese la cedula a buscar: ");
				Scanner scanCedula = new Scanner(System.in);
				String cedula = scanCedula.nextLine();

				if (Prestamista.buscarCliente(cedula, listaPrestamos) < listaPrestamos
						.size()) {
					System.out.println("Cliente: "
							+ listaPrestamos
									.get(Prestamista.buscarCliente(cedula,
											listaPrestamos)).getCliente()
									.getApellido()
							+ " "
							+ listaPrestamos
									.get(Prestamista.buscarCliente(cedula,
											listaPrestamos)).getCliente()
									.getNombre());
				} else {
					System.out.println("No existe el cliente");
				}
			} else {
				System.out.println("Aun no existen registros");
			}
			break;
		case 3:
			System.out.println("INVENTARIO: ");
			Prestamista.mostrarVehiculos(listaVehiculos);
			break;
		case 4:
			System.out.println("PRESTAMOS:");
			Prestamista.mostrarPrestamos(listaPrestamos);
			break;
		case 5:
			System.out.println("RENTAR VEHICULO:");
			Prestamista.rentarVehiculo(listaPrestamos, listaVehiculos);
			
			break;
		case 6:
			System.out.println("RECEPCION DE VEHICULO:");
			Prestamista.receptarVehiculo(listaPrestamos);
			break;
		case 7:
			System.out.println("GENRAR INFORME:");
			try {
				Prestamista.generarInforme(listaPrestamos);
			} catch (FileNotFoundException e) {
				System.out.println("Algo salio mal ");
			} catch (IOException e) {
				System.out.println("Algo salio mal con la lectura");
			} finally {
				System.out
						.println("el archivo se gaurdará en el directorio del proyecto");
			}
			break;
		case 8:
			System.out.println("Gracias por visitar RENT A CAR");
			System.exit(0);
		default:
			System.out.println("No existe tal opcion");
		}
	}

}
