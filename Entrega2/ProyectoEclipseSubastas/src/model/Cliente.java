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
	//private Boolean Propietario;
	//
	
	
	public Cliente(String usuario, String contrasena, String nombre) {
		this.contrasena=contrasena;
		this.nombre=nombre;
		this.usuario=usuario;
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

	

    
}
	
	
	
	
	

