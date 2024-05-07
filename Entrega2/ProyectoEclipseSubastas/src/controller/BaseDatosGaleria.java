package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import model.Administrador;
import model.Cliente;
import model.Empleado;
import model.Venta;
import pieza.Pieza;

public class BaseDatosGaleria {
   /*Estructuras de los usuarios que ya estan en la subasta (mapaParticipantes..),
    *las piezas disponibles para comprar o subastar(mapaPiezasSubasta) y un 
    *registro de los usuarios que hallan realizado compras(mapaCompradores) */
	
	
	private HashMap<String,Cliente> mapaParticipantesSubasta; 
	private HashMap<String,Venta> mapaVentas; 
	
	public BaseDatosGaleria() {
		this.mapaParticipantesSubasta=new HashMap<>();
		this.mapaVentas=new HashMap<>();
	}
	
	public HashMap<String, Cliente> getMapaParticipantesSubasta(){
		return mapaParticipantesSubasta;
	}
	
	public HashMap<String, Venta> getMapaVentas(){
		return mapaVentas;
	}
	
	//READ : DESCARGAR LOS PARTICIPANTES
	private void crearMapaClientesSubasta() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/participantesSubasta.txt"));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String usuario = partes[0];
			
			Cliente cliente= descomprimirClienteSubasta(linea);
			mapaParticipantesSubasta.put(usuario, cliente);
			linea = br.readLine();
		}
	    br.close();
	  }
	
    //READ CLIENTES DENTRO DE LA SUBASTA
	public Cliente descomprimirClienteSubasta(String linea) {
		String[] partes = linea.split(";");
		String usuario = partes[0];
		String contrasena = partes[1];
		String nombre=partes[2];
		Cliente clienteSubasta= new Cliente(usuario, contrasena, nombre);
		return clienteSubasta;
	}
	
	//EL WRITE MAPA PARTICIPANTES
	private String generarTextoClientesSubasta(){
		String texto="";
		for(Cliente cliente:mapaParticipantesSubasta.values()) {
			texto+=comprimirClienteSubasta(cliente);
			texto+="\n";
		}
		return texto;
	}
	
	public void actualizarArchivoParticipantesSubasta() throws IOException {
		String texto=generarTextoClientesSubasta();
		FileWriter fichero = new FileWriter("data/participantesSubasta.txt");
		fichero.write(texto);
		fichero.close();
	}
	
	// CLIENTES DENTRO DE LA SUBASTA
	public String comprimirClienteSubasta(Cliente cliente) {
			String usuario = cliente.getUsuario();
			String contrasena = cliente.getContrasena();
			String nombre = cliente.getNombre();
			return usuario + ";" + contrasena + ";" + nombre + ";";
	}
	
    
	//EL READ MAPA DE VENTAS EN LA GALERIA
	private void crearMapaVentas() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("data/ventasGaleria.txt"));
			String linea = br.readLine();
			while (linea != null) {
				String[] partes = linea.split(";");
				String usuario = partes[0];
				
				Venta venta= descomprimirVentas(linea);
				mapaVentas.put(usuario, venta);
				linea = br.readLine();
			}
		    br.close();
	}
	//READ CLIENTES DENTRO DE LA SUBASTA
	public Venta descomprimirVentas(String linea) {
			String[] partes = linea.split(";");
			String usuario = partes[0];
			String tituloPieza = partes[1];
			int valor = Integer.parseInt(partes[2]);
			String tipoVenta=partes[3];
			Boolean ventaConfirmada= Boolean.parseBoolean(partes[4]);
			Venta ventaSubasta= new Venta(usuario, tituloPieza, valor, tipoVenta, ventaConfirmada);
			return ventaSubasta;
	}
		
	private String generarTextoVentas(){
			String texto="";
			for(Venta venta:mapaVentas.values()) {
				texto+=comprimirVenta(venta);
			}
			return texto;
	}
		
	public void actualizarArchivoVenta() throws IOException {
			String texto=generarTextoVentas();
			FileWriter fichero = new FileWriter("data/ventasGaleria.txt");
			fichero.write(texto);
			fichero.close();
	}
		
	// CLIENTES DENTRO DE LA SUBASTA
	public String comprimirVenta(Venta venta) {
				String usuario = venta.getUsuario();
				String titulo = venta.getTituloPieza();
				String valor = String.valueOf(venta.getValorPieza());
				String tipoVenta = venta.getTipoVenta();
				String confirmacion = String.valueOf(venta.getVentaConfirmada());
				return usuario + ";" + titulo + ";" + valor + ";" + tipoVenta + ";" + confirmacion;
			}
	    

	public void descargarDatosGaleria() throws IOException {
			crearMapaClientesSubasta();
			crearMapaVentas();
		}
	public void cargarDatosGaleria() throws IOException {

			actualizarArchivoParticipantesSubasta();
			actualizarArchivoVenta();
	}

	
	
}
