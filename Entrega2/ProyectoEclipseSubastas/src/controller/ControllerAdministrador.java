package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

import model.Administrador;
import model.Cliente;
//import java.util.HashMap;
//import controller.BaseDatos;
import model.Empleado;
import model.Galeria;
import model.Subasta;
import model.Venta;
import pieza.Pieza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



public class ControllerAdministrador {
	
	private HashMap<String, Pieza> mapaPiezas;
	private Administrador administrador;
	private BaseDatosInventario datosInventario;
	private BaseDatosGaleria datosGaleria;
	private BaseDatosEmpresa datosEmpresa;
	//

	public ControllerAdministrador() {
		
	}
	
	public Administrador getAdministrador() {	
		return this.administrador;
	}
	
	public void setDatosEmpresa(BaseDatosEmpresa datos) {
		this.datosEmpresa=datos;
	}
	
	public void setDatosGaleria(BaseDatosGaleria datosGaleria) {
		this.datosGaleria=datosGaleria;
	}
	
	public void LogIn(String usuario,String contrasena) {
		
		Administrador administrador = datosEmpresa.getMapaAdministradores().get(usuario);
		
		if(administrador.getUsuario().equals(usuario)&& administrador.getContrasena().equals(contrasena)) {
			this.administrador=administrador;
		}
		else {
			System.out.println("Error al ingresar");
		}
	}
	
	
	/*
	 * Getters and Setters
	 * 
	*/
	
	//LOGICA GALERIA
	
	public boolean verificarComprador(String nombreCliente){
		HashMap<String,Cliente> mapaParticipantesSubasta = datosGaleria.getMapaParticipantesSubasta();
		HashMap<String,Cliente> mapaClientes = datosEmpresa.getMapaClientes();
		boolean verificador=false;
		for(Cliente cliente:mapaClientes.values()) {
			if (cliente.getNombre().equals(nombreCliente)==false) {
				verificador = true;
				mapaParticipantesSubasta.put(nombreCliente, cliente);
			}
		}
		return verificador;
	}
	
	public boolean ConfirmarVenta(String name, String nombrePieza) throws IOException 
	{
		HashMap<String,Venta> mapaVentas = datosGaleria.getMapaVentas();
		
		Boolean estadoVenta=false;
		for(Venta venta : mapaVentas.values()) {
			if (venta.getUsuario().equals(name)==true && venta.getTituloPieza().equals(nombrePieza)==true ) {
				venta.setVentaConfirmada(true);
				datosGaleria.getMapaVentas().replace(venta.getUsuario(), venta);
				estadoVenta=true;
				datosGaleria.actualizarArchivoVenta();
			}
		}
		return estadoVenta;
		 
	}
	
	public void crearSubasta(Subasta subasta) throws Exception {
		
	}
	
	//Despues de verificar el comprador se ejecuta:
	public int maximoCompras(Cliente cliente) {
		HashMap<String,Cliente> mapaParticipantesSubasta = datosGaleria.getMapaParticipantesSubasta();
		return 0;
	}
	
	public static void agregarPiezaAGaleria(Pieza pieza, Galeria galeria) {
		
	}
		
	//LOGICA INVENTARIO
	
	public static void agregarPiezaAInventario(Pieza pieza) {
		
	}
	
	
	
    
    public static void agregarLineaEmpleados(String archivo, String nuevaLinea) {
        try {
            // Abre el archivo en modo de adicion
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
            
            // Escribe la nueva linea en el archivo
            writer.write(nuevaLinea + System.getProperty("line.separator"));
            
            writer.close();
            
            System.out.println("Nueva l�nea agregada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
	public void actualizarDatos() throws IOException {
		// los datos de todas las calses BasesDatos... :
		datosEmpresa.cargarDatosEmpresa();
	}
    

}
