package model;
import java.io.*;
import java.util.ArrayList;

public class Cliente implements Usuario {

	
	//Atributos
	//login
	private String usuario;
	private String contrasena;
	//datos generales:
	private String nombre;
	private String email;
	private String nacionalidad;
	private String rutaImagenID;	//
	
	
	public Cliente(String usuario, String contrasena, String nombre,
			String email, String nacionalidad, String rutaImagenID) {
		this.contrasena=contrasena;
		this.email=email;
		this.nacionalidad=nacionalidad;
		this.nombre=nombre;
		this.rutaImagenID=rutaImagenID;
		this.usuario=usuario;
		this.licencia=null;
		this.tarjeta=null;
	}
	
	
	public void setLicencia(Licencia licencia) {
		this.licencia=licencia;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta=tarjeta;
	}
	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {

		return contrasena;
	}

	public String getNombre() {

		return nombre;
	}

	public String getEmail() {
		return email;
	}
	public String getNacionalidad() {
		return nacionalidad;
		
	}
	public String getRutaImagenID() {
		return rutaImagenID;
}
	public Licencia getLicencia() {
		return licencia;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	

    
}
	
	
	
	
	

