package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

import model.Cliente;
import model.Pieza;
import model.Inventario;

public class ControllerCliente {
private Cliente cliente;
private BaseDatosEmpresa datos; // debe haber unos datos asociados para trabajar
private BaseDatosInventario datosInventario;

// Métodos
//contructor
public ControllerCliente() {
	this.cliente=null;
	this.datos=null;
	
}
//Get
public Cliente getCliente() {
	return this.cliente;
}
public void setDatos(BaseDatosEmpresa datos) {
	this.datos=datos;
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
public double realizarCompra(String nombrePieza) {
	HashMap<String,Pieza> mapaCarros=datos.getMapaPiezas();
	//Vamos a iterar el inventario hasta encontrar la primer
	//Pieza que cumple las características y lo vamos a reservar
	//si se hace la reserva retornamos true y si se itera toda la lista 
	//sin éxito retornamos false

	for(Pieza pieza:mapaPiezas.values()) {
		LocalDateTime fechadisp=carro.getFechaDispCons();
		if(fechadisp!=null && fechadisp.plusDays(2).isAfter(fechaPed1)) {
			continue; //descartamos el carro por fecha disponibilidad
		}
		if (pieza.getUsoActual()!=null) {
		LocalDateTime entregaAlquiler=carro.getUsoActual().getFechaDeb();
	
		if(entregaAlquiler.isAfter(fechaPed1))  {
				
			continue; //descartamos el carro por estar alquilado
		}
		}

	}
	return 0;
}
	
	

public void actualizarDatos() throws IOException {
	datos.cargarTodosLosDatos();
}

}