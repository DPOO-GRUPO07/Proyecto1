package controller;

import java.util.HashMap;

import pieza.Pieza;
import pieza.PiezaEscultura;
import pieza.PiezaFotografia;
import pieza.PiezaPintura;
import pieza.PiezaVideo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BaseDatosInventario {
	private HashMap<String, Pieza> mapaPiezas;
	
	public BaseDatosInventario() {
	    this.mapaPiezas= new HashMap<>();
	}
	
	public HashMap<String, Pieza> getMapaPiezas(){
		return mapaPiezas;
	}
	
	//Inventario
	//READ: Descargar todas las piezas

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
		int anoCreacion = Integer.parseInt(partes[1]);
		String lugarCreacion = partes[2];
		String propietario = partes[3];
		int valorFijo=Integer.parseInt(partes[4]);
		Boolean disponibleEnSubasta= Boolean.parseBoolean(partes[5]);
		String tipo=partes[6];
		boolean bloqueada = Boolean.parseBoolean(partes[7]);
		Pieza pieza = new Pieza(titulo, anoCreacion, lugarCreacion, propietario, valorFijo, disponibleEnSubasta, tipo, bloqueada);
		if (tipo=="pintura") {
			String tipoPintura=partes[8];
			String dimensiones=partes[9];
			String detalles=partes[10];
			pieza = new PiezaPintura(titulo, anoCreacion, lugarCreacion, propietario, valorFijo, disponibleEnSubasta, tipo, bloqueada, tipoPintura, dimensiones, detalles);
		}
		else if (tipo=="escultura") {
			float alto=Float.parseFloat(partes[8]);
			float ancho=Float.parseFloat(partes[9]);
			float profundidad=Float.parseFloat(partes[10]);
			String material=partes[11];
			float peso=Float.parseFloat(partes[12]);
			Boolean necesitaElectricidad = Boolean.parseBoolean(partes[13]);
			String detallesInstalacion=partes[14];
			pieza=new PiezaEscultura(titulo, anoCreacion, lugarCreacion, propietario, valorFijo, disponibleEnSubasta, tipo, bloqueada,alto, ancho, profundidad, material, peso, necesitaElectricidad, detallesInstalacion);
		}
		else if (tipo=="fotografia") {
			float alto = Float.parseFloat(partes[8]);
			float largo = Float.parseFloat(partes[9]);
			String color = partes[10];
			pieza = new PiezaFotografia(titulo, anoCreacion, lugarCreacion, propietario, valorFijo, disponibleEnSubasta, tipo, bloqueada, alto, largo, color);
			
		}
		else if (tipo=="video") {
			float duracion = Float.parseFloat(partes[8]);
			String largo = partes[9];
			pieza = new PiezaVideo(titulo, anoCreacion, lugarCreacion, propietario, valorFijo, disponibleEnSubasta, tipo, bloqueada,duracion, largo);
		}

		

		return pieza;
	}
	
	//Write: Actualizar archivo, reescribirlo.

	private String generarTextoCarros(){
		String texto="";
		for(Pieza pieza:mapaPiezas.values()) {
			texto+=comprimirPieza(pieza);
			texto+="\n";
		}
		return texto;
	}
	
	public String comprimirPieza(Pieza pieza) {
		String titulo = pieza.getTitulo();
		String anoCreacion = String.valueOf(pieza.getAnoCreacion());
		String lugarCreacion = pieza.getLugarCreacion();
		String propietario = pieza.getPropietario();
	    String valorFijo = String.valueOf(pieza.getValorFijo()); 
	    String disponibleEnSubasta = String.valueOf(pieza.getDisponibleSubasta());
		String tipo = pieza.getTipo();
		String str = titulo + ";" + anoCreacion + ";" + lugarCreacion + ";" + propietario + ";"
				+ propietario + ";" + valorFijo + ";" + disponibleEnSubasta + ";" + tipo ;
		if(tipo=="pintura") {
			PiezaPintura piezaPintura = (PiezaPintura) pieza;
			String tipoPintura = piezaPintura.getTipoPintura();
			String dimensiones = piezaPintura.getDimensiones();
			String detalles = piezaPintura.getDetalles();
			
			str = titulo + ";" + anoCreacion + ";" + lugarCreacion + ";" + propietario + ";"
					+ propietario + ";" + valorFijo + ";" + disponibleEnSubasta + ";" + tipo + ";" + tipoPintura + ";" + dimensiones + ";" + detalles; 
			
		}
		else if (tipo=="escultura") {
			PiezaEscultura piezaEscultura = (PiezaEscultura) pieza;
			String alto = String.valueOf(piezaEscultura.getAlto());
			String ancho = String.valueOf(piezaEscultura.getAncho());
			String profundidad = String.valueOf(piezaEscultura.getProfundidad());
			String material = piezaEscultura.getMaterial();
			String peso = String.valueOf(piezaEscultura.getPeso());
			String necesitaElectricidad= String.valueOf(piezaEscultura.getNecesitaElectricidad());
			String detallesInstalacion = piezaEscultura.getDetallesInstalacion();
			
			str=titulo + ";" + anoCreacion + ";" + lugarCreacion + ";" + propietario + ";"
					+ propietario + ";" + valorFijo + ";" + disponibleEnSubasta + ";" + tipo + ";" + ";" + alto + ";" + 
					ancho + ";" + profundidad + ";" + material + ";" + peso + ";" + necesitaElectricidad + ";" + detallesInstalacion;
					
		}
		
		else if (tipo=="fotografia") {
			PiezaFotografia piezaFotografia = (PiezaFotografia) pieza;
			String alto = String.valueOf(piezaFotografia.getAlto());
			String ancho = String.valueOf(piezaFotografia.getLargo());
			String profundidad = String.valueOf(piezaFotografia.getColor());
			str=titulo + ";" + anoCreacion + ";" + lugarCreacion + ";" + propietario + ";"
					+ propietario + ";" + valorFijo + ";" + disponibleEnSubasta + ";" + tipo + ";" + alto + ";" + ancho + ";" + profundidad;
		}

		return str;

	}
	
	
	private void actualizarArchivoPiezas() throws IOException {
		String texto=generarTextoCarros();
		FileWriter fichero = new FileWriter("data/piezas.txt");
		fichero.write(texto);
		fichero.close();
	}
	
	public void descargarDatosInventario() throws IOException {
		crearMapaPiezas();// Incompleto

	}
	
	public void cargarTodosLosDatos() throws IOException {
		actualizarArchivoPiezas();

		
	}
	
	
}
