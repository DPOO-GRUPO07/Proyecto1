package controller;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Pieza;

public class BaseDatosInventario {
	private HashMap<String, Pieza> mapaPiezas;
	
	public BaseDatosInventario() {
	    this.mapaPiezas= new HashMap<>();
	}
	
	public HashMap<String, Pieza> getMapaPiezas(){
		return mapaPiezas;
	}
	
	//Inventario
	//READ: Descargar todas las reservas

	private void crearMapaPiezas() throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("data/piezas.txt"));

	String linea = br.readLine();

	while (linea != null) {
		String[] partes = linea.split(";");
		String titulo = partes[0];
		Pieza pieza = descomprimirPieza(linea);
		mapaPiezas.put(titulo,pieza);
		linea = br.readLine();
	}
	br.close();
	}
	
	public Pieza descomprimirPieza(String linea) {
		String[] partes = linea.split(";");
		String titulo = partes[0];
		String anoCreacion = partes[1];
		String lugarCreacion = partes[2];
		String propietario = partes[3];
		String tipo=partes[4];
		String dimension=partes[5];
		String material=partes[6];
		String peso=partes[7];
		String necesitaElectricidad=partes[8];
		String detalles=partes[9];
		
		Pieza pieza = new Pieza(titulo, anoCreacion, lugarCreacion, propietario ,tipo, dimension, material, peso, necesitaElectricidad, detalles);

		return pieza;
	}
	
	//Write: Actualizar archivo, reescribirlo.

	private String generarTextoCarros(){
		String texto="";
		for(Pieza carro:mapaPiezas.values()) {
			texto+=comprimirCarro(carro);
			texto+="\n";
		}
		return texto;
	}
	
	public String comprimirCarro(Pieza pieza) {
		String titulo = pieza.getTitulo();
		String anoCreacion = pieza.getAnoCreacion();
		String lugarCreacion = pieza.getLugarCreacion();
		String tipo = pieza.getTipo();
		String propietario = pieza.getPropietario();
		String dimension = pieza.getDimension();
		String material = pieza.getMaterial();
		String peso = pieza.getPeso();
		String necesitaElectricidad = pieza.getElectricidad();
		String detalles = pieza.getDetalles();
	
		String str = titulo + ";" + anoCreacion + ";" + lugarCreacion + ";" + tipo + ";" + propietario + ";"
				+ propietario + ";" + dimension + ";" + dimension + ";" + material+";" 
				+ peso + ";" + necesitaElectricidad + ";" + detalles;
		return str;

	}
	
	
	private void actualizarArchivoPiezas() throws IOException {
		String texto=generarTextoCarros();
		FileWriter fichero = new FileWriter("data/piezas.txt");
		fichero.write(texto);
		fichero.close();
	}
	
	public void descargarInventario() throws IOException {
		crearMapaPiezas();// Incompleto

	}
	
	public void cargarTodosLosDatos() throws IOException {
		actualizarArchivoPiezas();

		//actualizarArchivoFacturas();
		
	}
	
	
}
