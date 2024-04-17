package controller;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Administrador;
import model.Cliente;
import model.Empleado;
//import model.Pieza;


public class BaseDatosEmpresa{
	
	private HashMap<String,Cliente> mapaClientes; //mapa clientes por login
	private HashMap<String,Administrador> mapaAdministradores;
	private HashMap<String,Empleado> mapaEmpleados; //mapa empleados por login
	//private HashMap<String,Pieza> mapaPiezas; //mapa empleados por login
	
	public BaseDatosEmpresa() {
		this.mapaClientes=new HashMap<>();
	    this.mapaEmpleados=new HashMap<>();
	    this.mapaAdministradores= new HashMap<>();
	    //this.mapaPiezas= new HashMap<>();
	}
	
	public HashMap<String, Cliente> getMapaClientes(){
		return mapaClientes;
	}
	
	public HashMap<String, Empleado> getMapaEmpleados(){
		return mapaEmpleados;
	}
	
	//READ: Descargar todas las clientes

	private void crearMapaClientes() throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("data/clientes.txt"));

	String linea = br.readLine();

	while (linea != null) {
		String[] partes = linea.split(";");
		String usuario = partes[0];
		ArrayList<Object> lista=descomprimirCliente(linea);
		Cliente cliente =(Cliente) lista.get(0);
		
		//Se agregan los objetos anteriores a cliente
		//cliente.setLicencia(mapaLicencias.get(numLic));
		//cliente.setTarjeta(mapaTarjetas.get(numTar));
		mapaClientes.put(usuario,cliente);
		linea = br.readLine();
	}
	br.close();
	}
	
	// CLIENTE 
	//Retornamos una lista de objetos porque necesitamos añadirle a cliente
	//una pieza o varias piezas asociadas
	public ArrayList<Object> descomprimirCliente(String linea) {
		String[] partes = linea.split(";");
		String usuario = partes[0];
		String contrasena = partes[1];
		String nombre=partes[2];

		Cliente cliente = new Cliente(usuario, contrasena, nombre);
		ArrayList<Object> lista=new ArrayList<Object>();
		lista.add(cliente);
		return lista;
	}
	
	//Write: Actualizar archivo, reescribirlo.
	private String generarTextoClientes(){
		String texto="";
		for(Cliente cliente:mapaClientes.values()) {
			texto+=comprimirCliente(cliente);
			texto+="\n";
		}
		return texto;
	}
	public void actualizarArchivoClientes() throws IOException {
		String texto=generarTextoClientes();
		FileWriter fichero = new FileWriter("data/clientes.txt");
		fichero.write(texto);
		fichero.close();
	}
	
	// Cliente
	public String comprimirCliente(Cliente cliente) {
		    String usuario = cliente.getUsuario();
		    String nombre = cliente.getNombre();
			String contrasena = cliente.getContrasena();
			return usuario + ";" + contrasena + ";" + nombre ;
		}
	
	
	
	public void descargarDatosEmpresa() throws IOException {

		crearMapaClientes();// Incompleto
		//crearMapaEmpleados();// Falta
		//crearMapaAdministradores(); // Falta
		
		
	}
	
		
	
}

