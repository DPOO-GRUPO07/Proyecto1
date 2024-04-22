package model;

public class Pieza {
    private String titulo;
    private String anoCreacion;
    private String lugarCreacion;
    private String tipo;
    private String propietario;
    private String dimension;
    private String material;
    private String peso;
    private String necesitaElectricidad;
    private String detalles;

    public Pieza(String titulo, String anoCreacion, String lugarCreacion, String tipo, String propietario, String dimension, String material, String peso, String necesitaElectricidad, String detalles) {
        this.titulo = titulo;
        this.anoCreacion = anoCreacion;
        this.lugarCreacion = lugarCreacion;
        this.tipo = tipo;
        this.propietario = propietario;
        this.dimension = dimension;
        this.material = material;
        this.peso = peso;
        this.necesitaElectricidad = necesitaElectricidad;
        this.detalles = detalles;
    }

    // Getters y Setters
    // 
    
	public String getTitulo() {
		return this.titulo;
	}
	public String getAnoCreacion() {
		return anoCreacion;
	}
	public String getLugarCreacion() {
		return this.lugarCreacion;
	}

	
	public String getTipo() {
		return tipo;
	}
	
	public String getPropietario() {
		return this.propietario;
	}
	
	public String getDimension() {
		return this.dimension;
	}
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getPeso() {
		return this.peso;
	}
	
	public String getElectricidad() {
		return this.necesitaElectricidad;
	}
	
	public String getDetalles() {
		return this.detalles;
	}
	
	public Cliente cambiarPropietario(Cliente nuevoPropietario) {
		return null;
	}



 

}
