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
	
	
private Temporada encontrarTemporada(LocalDateTime fecha) {
	for(Temporada temp:datos.getMapaTemporadas().values()) {
		LocalDateTime in=temp.getInicioTemporada();
		LocalDateTime fin=temp.getFinTemporada();
		if (hayFechaEnIntervalo(fecha,in,fin)==true) {
			return temp;
		}	
	}
	return null;
}
private boolean hayReservasEnIntervalo(Carro carro,LocalDateTime fecha1,LocalDateTime fecha2) {
	ArrayList<Reserva> reservas=carro.getReservas();
	for (int i=0;i<reservas.size();i++) {
		Reserva reserva=reservas.get(i);
		//Para que no haya reservas en intervalo no debe haber ni una sola interseccion
		boolean inters=hayInterseccionIntervaloReservaConFechas(reserva,
				fecha1,fecha2);
		if(inters==true) {
			return true;
		}
	}
	return false;
}
private boolean hayInterseccionIntervaloReservaConFechas(Reserva reserva,
		LocalDateTime fecha1,LocalDateTime fecha2) {
	LocalDateTime in=reserva.getFechaYHoraInicio();
	// anadimos 2 días a fin
	LocalDateTime fin=reserva.getFechaYHoraFin().plusDays(2);
	//deben pasar 4 cosas y cumplirse siempre
	//1 el inicio del intervalo no debe estar en el intervaloReserva
	if(hayFechaEnIntervalo(fecha1,in,fin)==true) {
		return true;
	}
	//2 el fin del intervalo no debe estar en el intervaloReserva
	if(hayFechaEnIntervalo(fecha2,in,fin)==true) {
		return true;}

// 3 el inicio del intervaloReserva no debe estar en el intervalo
	if(hayFechaEnIntervalo(in,fecha1,fecha2)==true) {
		return true;
	}
	// 4 el fin del intervaloReserva no debe estar en el intervalo
	if(hayFechaEnIntervalo(fin,fecha1,fecha2)==true) {
		return true;
		
	}
	else {
		return false;
	}
}
private boolean hayFechaEnIntervalo(LocalDateTime fecha, LocalDateTime fecha1,
		LocalDateTime fecha2) {
	if(fecha.isAfter(fecha1) && fecha.isBefore(fecha2)) {
		return true;
	}
	else {
		return false;
	}
}
public void actualizarDatos() throws IOException {
	datos.cargarTodosLosDatos();
}

}