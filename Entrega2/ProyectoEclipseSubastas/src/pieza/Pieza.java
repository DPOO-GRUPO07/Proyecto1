package pieza;

import java.util.ArrayList;
import java.util.List;

public class Pieza {
    private String titulo;
    private int anoCreacion;
    private String artista;
    private String lugarCreacion;
    private String propietario;
    private int valorFijo; 
    private boolean disponibleEnSubasta;
    private String tipo;
    private boolean bloqueada;
    
    private List<String> historialTransacciones;   // prueba para req nuevo

    public Pieza(String titulo, int anoCreacion,String artista, String lugarCreacion, String propietario, int valorFijo, Boolean disponibleEnSubasta, String tipo, boolean bloqueada) {
        this.titulo = titulo;
        this.anoCreacion = anoCreacion;
        this.artista = artista;
        this.lugarCreacion = lugarCreacion;
        this.propietario = propietario;
        this.valorFijo = valorFijo;
        this.disponibleEnSubasta = disponibleEnSubasta;
        this.tipo = tipo;
        this.bloqueada = bloqueada;
        this.historialTransacciones = new ArrayList<>();  // samee
    }

    // Getters y Setters
    // 
    
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}
	public int getAnoCreacion() {
		return anoCreacion;
	}
	public String getLugarCreacion() {
		return this.lugarCreacion;
	}

	
	public String getPropietario() {
		return this.propietario;
	}
	
	public int getValorFijo() {
		return this.valorFijo;
	}
	
	public boolean getDisponibleSubasta() {
		return this.disponibleEnSubasta;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public boolean getBloqueo() {
		return bloqueada;
	}
	

	//Setters
	
	
	public String setTitulo(String nuevoTitulo) {
		return nuevoTitulo;
	}
	
	public String setAnoCreacion(String nuevoAno) {
		return nuevoAno;
	}
	
	public String setTipo(String nuevoTipo) {
		return nuevoTipo;
	}
	
	public String serPropietario(String nuevoPropietario) {
		return nuevoPropietario;
	}


	// Método para obtener el historial de transacciones
    public List<String> getHistorialTransacciones() {
        return historialTransacciones;
    }

    // Método para agregar una nueva transacción al historial
    public void agregarTransaccion(String transaccion) {
        historialTransacciones.add(transaccion);
    }
 

}
