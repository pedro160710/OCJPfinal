/**
 * 
 */
package com.Negocio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.Padres.Colores;
import com.Padres.Persona;
import com.Padres.Vehiculo;

/**
 * @author Pedro
 *
 */
public class Prestamista extends Persona implements Runnable{
	
	static Prestamista p1= new Prestamista("Andres", "Cusme", "1721889425", 23);
	static Thread h1 = new Thread(p1,"Cliente 1");
	static int counter=0;
	
	public Prestamista(String nombre, String apellido, String cedula, int edad) {
		super(nombre, apellido, cedula, edad);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo para receptar un vehiculo, dentro de el se pedira al usuario que
	 * ingrese el numero de cedula del cliente
	 */
	public static void receptarVehiculo(List<Prestamo> listaPrestamos) {
		try {
			if (!listaPrestamos.isEmpty()) {
				//Creacion de fecha de recepci�n con formato
				Date fechaRecep =new Date();
				DateFormat fechaRecepcion = null;
				//Creaci�n de StringBuilder para almacenar fecha de recepcion
				StringBuilder fecha= new StringBuilder("Fecha de recepcion ");
				fecha.append(fechaRecepcion.getDateInstance(DateFormat.MEDIUM).format(fechaRecep));
				
				
				System.out.println("Ingrese el numero de c�dula del cliente: ");
				// ingresar el numero de cedula de la persona que rento el
				// vehiculo, para eso primero visualizar las rentas o buscar al
				// cliente
				Scanner scanCedula = new Scanner(System.in);
				String cedula = scanCedula.nextLine();
				// dado el numero de cedula encontrar la posicion del prestamo
				// en la lista
				if (buscarCliente(cedula, listaPrestamos) < listaPrestamos
						.size()) {
					int posicionCliente = buscarCliente(cedula, listaPrestamos);
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
					System.out.println(" "+ fecha);
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
	public static int buscarCliente(String cedula, List<Prestamo> listaPrestamos) {
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
	public static void mostrarPrestamos(List<Prestamo> listaPrestamos) {
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
	public static int numDias=0;
	public static int getNumDias() {
		return numDias;
	}

	@SuppressWarnings("deprecation")
	public static void rentarVehiculo(List<Prestamo> listaPrestamos,
			List<Vehiculo> listaVehiculos) {
		if(counter==0){
			h1.start();
			counter ++;
			}else {
				try {
					h1.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		// crear fecha de renta vehiculo
		Date fechaRenta = new Date();
		//creacion de StringBuilder
		StringBuffer fecha = new StringBuffer(fechaRenta.toString());
		fecha.append(" hora del alquiler: "+ fechaRenta.getHours()+":"+fechaRenta.getMinutes()+":" + fechaRenta.getSeconds());
		// crear al cliente
		Cliente cliente = crearCliente();
		// escoger el vehiculo
		if (cliente.getEdad() >= 18) {
			System.out
					.println("Escoja el numero del vehiculo que desea alquilar: del 0 al"
							+ (listaPrestamos.size() - 1));
			Scanner opcionVehiculo = new Scanner(System.in);
			int opcionVehiculoi = opcionVehiculo.nextInt();
			if (validarPrestamo(opcionVehiculoi, listaVehiculos)) {
				Vehiculo vehiculo = (Vehiculo) listaVehiculos
						.get(opcionVehiculoi);
				System.out
						.println("Escoja el numero de dias que desea alquilar el vehiculo:");
				Scanner scanNumDias = new Scanner(System.in);
				numDias = scanNumDias.nextInt();
				
				
				// crear una lista de prestamos y enviar como parametro al
				// cliente y
				// al vehiculo
				listaPrestamos.add(new Prestamo(vehiculo, cliente, numDias));
				vehiculo.setDisponible(false);
				//System.out.println("vehiculo prestado con exito");
				System.out.println("Su veh�culo ha sido rentado en la siguiente fecha :" + fecha);
			} else {
				System.out.println("el vehiculo no esta disponible");
			}
		} else {
			System.out.println("Ud. es menor de edad, vayase!!");
		}

	}

	/**
	 * Metodo que crea pide los datos de un cliente por consola para almacenarlo
	 * en una lista, el cliente solo se crea cuando se esta rentando un vehiculo
	 * 
	 * @return objeto de tipo cliente
	 */
	public static Cliente crearCliente() {
		Cliente cliente = null;
		if(p1!=null){
			cliente = new Cliente(p1.nombre, p1.apellido, p1.cedula, p1.edad);
		}else{
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
		cliente = new Cliente(nombre, apellido, cedula, edad);
		}
		return cliente;

	}

	/**
	 * Metodo que permite validar si un recurso ha sido o no prestado
	 * 
	 * @param respuestaRec
	 * @param respuestaUs
	 * @return
	 */
	private static boolean validarPrestamo(int indiceVehiculo,
			List<Vehiculo> listaVehiculos) {
		if (listaVehiculos.get(indiceVehiculo).isDisponible()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que permite buscar un vehiculo en una lista, no es necesario
	 * pasarle parametros, ya que este metodo se encarga de obtenerlo
	 */
	public static void buscarVehiculo(List<Vehiculo> listaVehiculos) {
		Scanner placaBuscada = new Scanner(System.in);
		String placaAEncontrar = placaBuscada.nextLine();

		for (int i = 0; i < listaVehiculos.size(); i++) {
			if (placaAEncontrar.toUpperCase().equals(
					listaVehiculos.get(i).getPlaca())) {
				System.out.println(i + ": "
						+ listaVehiculos.get(i).getClass().getSimpleName()
						+ " " + listaVehiculos.get(i).getMarca() + ": "
						+ listaVehiculos.get(i).getModelo() + "\nA�o: "
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
			} else if (i == listaVehiculos.size() - 1) {
				System.out.println("Vehiculo no encontrado");

			}

		}

	}

	/**
	 * Metodo para mostrar los datos de vehiculos en inventario
	 */
	public static void mostrarVehiculos(List<Vehiculo> listaVehiculos) {
		Locale localizacion = Locale.CANADA;
		NumberFormat formatoMoneda = NumberFormat
				.getCurrencyInstance(localizacion);
		for (int i = 0; i < listaVehiculos.size(); i++) {
			System.out.println(i + ": "
					+ listaVehiculos.get(i).getClass().getSimpleName() + " "
					+ listaVehiculos.get(i).getMarca() + ": "
					+ listaVehiculos.get(i).getModelo() + "/ Placa: "
					+ listaVehiculos.get(i).getPlaca() + "\n" + "Costo: "
					+ formatoMoneda.format(listaVehiculos.get(i).getCosto()));

			if (listaVehiculos.get(i).isDisponible()) {
				System.out.println("Estado: Disponible" + "\n");
			} else {
				System.out.println(" No Disponible" + "\n");
			}
		}
	}

	/**
	 * Metodo para crear vehiculos de distinta clase y almacenar en una Lista
	 */
	public static void crearListaVehiculos(List<Vehiculo> listaVehiculos) {
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

	public static void generarInforme(List<Prestamo> listaPrestamos)
			throws IOException {
		// try {
		FileOutputStream archivo = new FileOutputStream("reporte.txt");
		ObjectOutputStream escritor = new ObjectOutputStream(archivo);// aca es
																		// el
																		// error
																		// cuando
																		// no se
																		// serailiza
		escritor.writeObject(listaPrestamos);
		escritor.flush();
		escritor.close();

	}

	@Override
	public synchronized void run() {
		System.out.println("Thread en ejecucion: " + Thread.currentThread().getName());
	}

}
