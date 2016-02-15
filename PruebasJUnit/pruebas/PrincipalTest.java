package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Negocio.Cliente;
import com.Negocio.Prestamista;
import com.Principal.Principal;

public class PrincipalTest {
	public static Cliente clienteTest = new Cliente("Pedro", "Cuasqui","1722799226", 18);
	public static Prestamista principal =new Prestamista("Pedro", "Cuasqui","1722799226", 18);
	public String cedula= "1722799226"; 
	
	
	/**
	 * CrearCliente debe retornar un cliente
	 */
	@Test
	public void testCrearCliente() {
		Cliente clientePrincipal = Prestamista.crearCliente();
		assertEquals(clienteTest.getApellido(),(clientePrincipal.getApellido()));
		assertEquals(clienteTest.getCedula(),(clientePrincipal.getCedula()));
		assertEquals(clienteTest.getEdad(),(clientePrincipal.getEdad()));
		assertEquals(clienteTest.getNombre(),(clientePrincipal.getNombre()));
		
		
	}
/*	@Test
	public void testbuscarCliente(){
		assertEquals(0,(Principal.buscarCliente(cedula)));
	}*/

}

