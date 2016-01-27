/**
 * La clase Principal en donde se ejecutan
 * toda la funcionalidad de visualización del sistema.
 */
package com.Principal;

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

	public static List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	public static List<Prestamo> listaPrestamos = new ArrayList<Prestamo>();

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		crearListaVehiculos();

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
		Scanner opcionMenu = new Scanner(System.in);
		switch (opcionMenu.nextInt()) {
		case 1:
			System.out
					.println("BUSQUEDA VEHICULO\nIngrese la placa del vehiculo: ");
			buscarVehiculo();
			break;
		case 2:
			if (!listaPrestamos.isEmpty()) {
				System.out
						.println("BUSQUEDA CLIENTE \nIngrese la cedula a buscar: ");
				Scanner scanCedula = new Scanner(System.in);
				String cedula = scanCedula.nextLine();

				if (buscarCliente(cedula) < listaPrestamos.size()) {
					System.out.println("Cliente: "
							+ listaPrestamos.get(buscarCliente(cedula))
									.getCliente().getApellido()
							+ " "
							+ listaPrestamos.get(buscarCliente(cedula))
									.getCliente().getNombre());
				} else {
					System.out.println("No existe el cliente");
				}
			} else {
				System.out.println("Aun no existen registros");
			}
			break;
		case 3:
			System.out.println("INVENTARIO: ");
			mostrarVehiculos();
			break;
		case 4:
			System.out.println("PRESTAMOS:");
			mostrarPrestamos();
			break;
		case 5:
			System.out.println("RENTAR VEHICULO:");
			rentarVehiculo();
			break;
		case 6:
			System.out.println("RECEPCION DE VEHICULO:");
			receptarVehiculo();
			break;
		default:
			System.out.println("No existe tal opcion");
		}

	}

	/**
	 * Metodo para receptar un vehiculo, dentro de el se pedira al usuario que
	 * ingrese el numero de cedula del cliente
	 */
	private static void receptarVehiculo() {
		try {
			if (!listaPrestamos.isEmpty()) {
				System.out.println("Ingrese el numero de cedula del cliente: ");
				// ingresar el numero de cedula de la persona que rento el
				// vehiculo, para eso primero visualizar las rentas o buscar al
				// cliente
				Scanner scanCedula = new Scanner(System.in);
				String cedula = scanCedula.nextLine();
				// dado el numero de cedula encontrar la posicion del prestamo
				// en la lista
				if (buscarCliente(cedula) < listaPrestamos.size()) {
					int posicionCliente = buscarCliente(cedula);
					// debe retornar la
					// posicion en la
					// que se encuentra
					// dentor de la
					// listaPrestamos
					// obtener el vehiculo prestado y usar el metodo de receptar
					listaPrestamos.get(posicionCliente).getVehiculo()
							.receptar();
					// finalmente setear a null el elemento vehiculo en esa
					// posicion
					// de la listaPrestamos
					listaPrestamos.get(posicionCliente).setVehiculo(null);
					System.out.println("vehiculo retornado con exito");
				} else {
					System.out.println("No existe el cliente");
				}
			} else {
				System.out.println("No existen prestamos aun");
			}

		} catch (Exception e) {
			System.out.println("error: " + e);

		}

	}

	/**
	 * Clase que permite encontrar la ubicacion de un elemento dentro de un
	 * objeto List, y retorna su posicion.
	 * 
	 * @param cedula
	 *            : string correspondiente a la cedula del cliente
	 * @return int: posicion de un el cliente dentro de la lista
	 */
	public static int buscarCliente(String cedula) {
		// int respuesta=0;
		for (int i = 0; i < listaPrestamos.size(); i++) {
			// System.out.println(listaPrestamos.get(i).getCliente().getCedula());
			if (cedula.equals(listaPrestamos.get(i).getCliente().getCedula())) {
				return i;

			}/*
			 * else { System.out.println("No existe el cliente"); return 0; }
			 */
		}
		System.out.println("No existe el cliente");
		return listaPrestamos.size();// mejorar esta linea de codigo ya que si
		// se necesita esta
		// busqueda en el futuro puede dar errores
	}

	/**
	 * Metodo que muestra las transacciones de renta realizadas
	 */
	private static void mostrarPrestamos() {
		for (int i = 0; i < listaPrestamos.size(); i++) {
			System.out.println("CLIENTE: "
					+ listaPrestamos.get(i).getCliente().getApellido() + " "
					+ listaPrestamos.get(i).getCliente().getNombre());
			if (listaPrestamos.get(i).getVehiculo() != null) {
				System.out.println("\nVEHICULO: "
						+ listaPrestamos.get(i).getVehiculo().getClass()
								.getSimpleName() + " "
						+ listaPrestamos.get(i).getVehiculo().getMarca() + " "
						+ listaPrestamos.get(i).getVehiculo().getModelo() + " "
						+ listaPrestamos.get(i).getVehiculo().getPlaca() + " "
						+ "\nNUMERO DE DIAS: "
						+ listaPrestamos.get(i).getNumDias());
			}
		}

	}

	/**
	 * Metodo que toma los datos necesarios para rentar un vehiculo inluyendo
	 * los lados del usuario
	 */
	private static void rentarVehiculo() {
		// crear al cliente
		Cliente cliente = crearCliente();
		// escoger el vehiculo
		if (cliente.getEdad() >= 18) {
			System.out
					.println("Escoja el numero del vehiculo que desea alquilar: del 0 al"
							+ (listaPrestamos.size() - 1));
			Scanner opcionVehiculo = new Scanner(System.in);
			int opcionVehiculoi = opcionVehiculo.nextInt();
			if (validarPrestamo(opcionVehiculoi)) {
				Vehiculo vehiculo = (Vehiculo) listaVehiculos
						.get(opcionVehiculoi);
				System.out
						.println("Escoja el numero de dias que desea alquilar el vehiculo:");
				Scanner scanNumDias = new Scanner(System.in);
				int numDias = scanNumDias.nextInt();
				// crear una lista de prestamos y enviar como parametro al
				// cliente y
				// al vehiculo
				listaPrestamos.add(new Prestamo(vehiculo, cliente, numDias));
				vehiculo.setDisponible(false);
				System.out.println("vehiculo prestado con exito");
			} else {
				System.out.println("el vehiculo no esta disponible");
			}
		} else {
			System.out.println("Ud. es menor de edad, vayase!!");
		}

	}

	/**
	 * Metodo que permite validar si un recurso ha sido o no prestado
	 * 
	 * @param respuestaRec
	 * @param respuestaUs
	 * @return
	 */
	private static boolean validarPrestamo(int indiceVehiculo) {
		if (listaVehiculos.get(indiceVehiculo).isDisponible()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que crea pide los datos de un cliente por consola para almacenarlo
	 * en una lista, el cliente solo se crea cuando se esta rentando un vehiculo
	 * 
	 * @return objeto de tipo cliente
	 */
	public static Cliente crearCliente() {
		System.out.println("Ingrese sus datos personales:\n");
		Scanner scanDatosCliente = new Scanner(System.in);
		System.out.println("Nombre: ");
		String nombre = scanDatosCliente.nextLine();
		System.out.println("Apellido: ");
		String apellido = scanDatosCliente.nextLine();
		System.out.println("Cedula: ");
		String cedula = scanDatosCliente.nextLine();
		System.out.println("Edad: ");
		int edad = scanDatosCliente.nextInt();
		Cliente cliente = new Cliente(nombre, apellido, cedula, edad);

		return cliente;

	}

	/**
	 * Metodo que permite buscar un vehiculo en una lista, no es necesario
	 * pasarle parametros, ya que este metodo se encarga de obtenerlo
	 */
	private static void buscarVehiculo() {
		Scanner placaBuscada = new Scanner(System.in);
		String placaAEncontrar = placaBuscada.nextLine();

		for (int i = 0; i < listaVehiculos.size(); i++) {
			if (placaAEncontrar.toUpperCase().equals(
					listaVehiculos.get(i).getPlaca())) {
				System.out.println(i + ": "
						+ listaVehiculos.get(i).getClass().getSimpleName()
						+ " " + listaVehiculos.get(i).getMarca() + ": "
						+ listaVehiculos.get(i).getModelo() + "\nAño: "
						+ listaVehiculos.get(i).getAnio() + "\nCosto/dia: "
						+ listaVehiculos.get(i).getCosto() + "\nKilometraje: "
						+ listaVehiculos.get(i).getKilometraje() + "\nPlaca: "
						+ listaVehiculos.get(i).getPlaca() + "\nDisponible: "
						+ listaVehiculos.get(i).isDisponible() + "\nColor: "
						+ listaVehiculos.get(i).getColor());
				if ("Buseta".equals(listaVehiculos.get(i).getClass()
						.getSimpleName())) {
					Buseta buseta = (Buseta) listaVehiculos.get(i);
					System.out.println("Capacidad de personas: "
							+ buseta.getCapacidadPersonas());
				} else if ("Camion".equals(listaVehiculos.get(i).getClass()
						.getSimpleName())) {
					Camion camion = (Camion) listaVehiculos.get(i);
					System.out.println("Capacidad de carga: "
							+ camion.getCapacidadCarga());
				} else if ("Limusina".equals(listaVehiculos.get(i).getClass()
						.getSimpleName())) {
					Limusina limusina = (Limusina) listaVehiculos.get(i);
					System.out.println("Capacidad de personas: "
							+ limusina.getCapacidad());
				} else if ("Sedan".equals(listaVehiculos.get(i).getClass()
						.getSimpleName())) {
					Sedan sedan = (Sedan) listaVehiculos.get(i);
					System.out.println("Cilindraje: " + sedan.getCilindraje());
				}
				break;
			} else if (i == 5) {
				System.out.println("Vehiculo no encontrado");

			}

		}

	}

	/**
	 * Metodo para mostrar los datos de vehiculos en inventario
	 */
	public static void mostrarVehiculos() {
		for (int i = 0; i < listaVehiculos.size(); i++) {
			System.out.println(i + ": "
					+ listaVehiculos.get(i).getClass().getSimpleName() + " "
					+ listaVehiculos.get(i).getMarca() + ": "
					+ listaVehiculos.get(i).getModelo()+ "/ Placa: "
					+ listaVehiculos.get(i).getPlaca());

			if (listaVehiculos.get(i).isDisponible()) {
				System.out.println(" Disponible" + "\n");
			} else {
				System.out.println(" No Disponible" + "\n");
			}
		}
	}

	/**
	 * Metodo para crear vehiculos de distinta clase y almacenar en una Lista
	 */
	private static void crearListaVehiculos() {
		/*
		 * Buseta(String placa, String marca, Colores color, String anio, int
		 * kilometraje, double costo, boolean disponible, int capacidadPersonas
		 */
		listaVehiculos.add(new Buseta("PBW-5068", "Renault", Colores.AZUL,
				"2014", 10000, 120, true, 40, "Master"));
		listaVehiculos.add(new Buseta("PAS-4510", "Toyota", Colores.BLANCO,
				"2015", 15000, 120, true, 30, "Hiace"));
		/*
		 * Camion(String placa, String marca, Colores color, String anio, int
		 * kilometraje, double costo, boolean disponible, int capacidadCarga
		 */
		listaVehiculos.add(new Camion("PGB-1234", "Hino", Colores.PLATEADO,
				"2008", 110000, 200, false, 20, "FG"));
		/*
		 * Camioneta(String placa, String marca, Colores color, String anio, int
		 * kilometraje, double costo, boolean disponible
		 */
		listaVehiculos.add(new Camioneta("ATG-5678", "Toyota",
				Colores.CONCHO_DE_VINO, "2009", 68251, 48.50, true, "Hilux"));
		listaVehiculos.add(new Camioneta("IGB-1256", "Mazda", Colores.ROJO,
				"2015", 58221, 68.58, true, "BT50"));
		/*
		 * String placa, String marca, Colores color, String anio, int
		 * kilometraje, double costo, boolean disponible, int capacidad
		 */
		listaVehiculos.add(new Limusina("PSE-4567", "Chevrolet", Colores.CREMA,
				"2014", 25450, 150.45, true, 10, "malibu"));

		listaVehiculos.add(new PickUp("PWR-4510", "Ford", Colores.VERDE,
				"2015", 10589, 86.52, true, "F-150"));
		listaVehiculos.add(new PickUp("PHJ-4810", "Chevrolet", Colores.NEGRO,
				"2011", 196000, 90, true, "D-max"));

		listaVehiculos.add(new Sedan("XDF-6543", "Kia", Colores.PLATEADO,
				"2000", 269520, 45, true, 1.6, "Cerato"));
		listaVehiculos.add(new Sedan("PHP-0562", "Hiunday", Colores.ROJO,
				"2006", 198454, 68, true, 1.6, "Elantra"));
	}

}
