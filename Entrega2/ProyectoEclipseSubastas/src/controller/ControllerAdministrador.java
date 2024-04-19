package controller;

import java.io.IOException;

import model.Administrador;
import model.Cliente;
//import java.util.HashMap;
//import controller.BaseDatos;
import model.Empleado;
import model.Pieza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



public class ControllerAdministrador {
	
	private Administrador administrador;
	private BaseDatosInventario datosInventario;
	//private BaseDatosSubastas datosSubastas;
	private BaseDatosEmpresa datosEmpresa;
	//

	public ControllerAdministrador() {
		this.administrador=null;
		this.datosInventario=null;
		
	}
	
	public Administrador getAdministrador() {
		
		return this.administrador;
	}
	
	public void setDatos(BaseDatosEmpresa datos) {
		this.datosEmpresa=datos;
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
	 * setters 
	 * 
	*/
	
	


	
	public static void agregarPieza(String titulo, String año, String tipo ,String propietario) throws Exception {
		agregarPieza(titulo, año, tipo, propietario);
	}
	

	
	public static String crearLineaEmpleado(String id, String nombre, String usuario, String contrasena, String email, String sede) {

		return id + ";" + nombre + ";" + usuario + ";" + contrasena + ";" + email + ";"+ sede;
	}
	
	public String crearLineaPieza(Pieza pieza) {
		String titulo = pieza.getTitulo();
		String anoCreacion = pieza.getAnoCreacion();
		String tipo = pieza.getTipo();
		String propietario = pieza.getPropietario();
		// Aqui van los condicionales que indican segun el TIPO de pieza, que informacion perdile al admin
		String dimension = pieza.getDimension();
		String material = pieza.getMaterial();
		String peso = pieza.getPeso();
		String electricidad = pieza.getElectricidad();
		String detalles = pieza.getDetalles();
		String str = titulo + ";" + anoCreacion + ";" + tipo + ";" + propietario + ";" + dimension + ";"
				+ material + ";" + peso + ";" + electricidad + ";" + detalles;
		return str;
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
    
    public static void eliminarLineaPiezas(String archivo, String titulo) {
        try {
            // Abre el archivo original y un archivo temporal para escritura
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/tempPiezas.txt"));
            String lineaActual;

            // Lee l�nea por l�nea y copia todas las l�neas excepto las que contienen el fragmento
            while ((lineaActual = reader.readLine()) != null) {
                if (!lineaActual.contains(titulo)) {
                    writer.write(lineaActual + System.getProperty("line.separator"));
                }
            }

            // Cierra los archivos
            reader.close();
            writer.close();

            // Borra el archivo original y renombra el archivo temporal
            if (new File(archivo).delete()) {
                new File("data/tempPiezas.txt").renameTo(new File(archivo));
                System.out.println("Carro eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar la Pieza");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
	public void actualizarDatos() throws IOException {
		// los datos de todas las calses BasesDatos... :
		datosEmpresa.cargarDatosEmpresa();
	}
    
    

}
