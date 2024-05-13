package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

import model.Cliente;
import model.Inventario;
import model.Venta;
import pieza.Pieza;

public class ControllerCliente {
	
	private HashMap<String, Pieza> mapaPiezas;
	private Cliente cliente;
    private BaseDatosEmpresa datos; // debe haber unos datos asociados para trabajar
    private BaseDatosInventario datosInventario;
    private BaseDatosGaleria datosGaleria;
     
    
    //Constructor
    public ControllerCliente() {
	  this.cliente=null;
	  this.datos=null;
    }
    
    //METODOS
    //Get
    public Cliente getCliente() {
	   return cliente;
    }
    
	public void setDatosInventario(BaseDatosInventario datosInventario) {
		this.datosInventario=datosInventario;
	}
	
	public void setDatosGaleria(BaseDatosGaleria datosGaleria) {
		this.datosGaleria=datosGaleria;
	}

    public void logIn(String usuario,String contrasena) {
	   Cliente cliente = datos.getMapaClientes().get(usuario);
	    if(cliente!=null) {
	    	String contr=cliente.getContrasena();
		    if(contr.equals(contrasena)==true) {
			    this.cliente=cliente;
		    }
		    else {
			
		    }
          }	
	    else {
        }
       }

	/*
	 * METODOS DE LOS REQUERIMIENTOS DEL CLIENTE
	*/
    
    public void realizarCompraFija(String nombrePieza) {
    	HashMap<String,Pieza> mapaPiezas = datosInventario.getMapaPiezas();
    	HashMap<String,Venta> mapaVentas = datosGaleria.getMapaVentas(); 
    	for (Pieza pieza: mapaPiezas.values()) {
			if (pieza.getTitulo().equals(nombrePieza)&& pieza.getBloqueo()==false) {
				String esteUsuario=cliente.getUsuario();
				String estaPieza = pieza.getTitulo();
				int esteValorPieza = pieza.getValorFijo();
				String esteTipoCompra = "fijo";
				boolean estaConfirmada = false; 
				Venta estaVenta= new Venta(esteUsuario, estaPieza, esteValorPieza, esteTipoCompra, estaConfirmada);
				mapaVentas.put(cliente.getUsuario(), estaVenta);
			}
    	}
    }
    
    
    
    
	

    public void actualizarDatos() throws IOException {
	    //datosGaleria.cargarDatosVentas();
    }

}