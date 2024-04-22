package pieza;

public class PiezaEscultura extends Pieza{
	
	private float alto;
	private float ancho;
	private float profundidad;
	private String material;
	private float peso;
	private boolean necesitaElectricidad;
	private String detallesInstalacion;

	public PiezaEscultura(String titulo, int anoCreacion, String lugarCreacion, String propietario,
			int valorFijo, Boolean disponibleEnSubasta, String tipo, boolean bloqueada, float alto, float ancho, float profundidad, String material, float peso, boolean necesitaElectricidad, String detallesInstalacion) {
		super(titulo, anoCreacion, lugarCreacion, propietario, valorFijo, disponibleEnSubasta, tipo, bloqueada);
		// TODO Auto-generated constructor stub
		this.alto=alto;
		this.ancho=ancho;
		this.profundidad=profundidad;
		this.material=material;
		this.peso=peso;
		this.necesitaElectricidad=necesitaElectricidad;
		this.detallesInstalacion=detallesInstalacion;
	}
	
	
	/*
	 * GETTER AND SETTERS
	 * 
	 * */
	public float getAlto() {
		return alto;
	}
	public float getAncho() {
		return ancho;
	}
	public float getProfundidad() {
		return profundidad;
	}

	public String getMaterial() {
		return material;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public boolean getNecesitaElectricidad() {
		return necesitaElectricidad;
	}
	
	public String getDetallesInstalacion() {
		return detallesInstalacion;
	}
	

	//Setters
	
	
	public float setAltura(float altura) {
		return altura;
	}
	
	public float setAncho(float ancho) {
		return ancho;
	}
	
	public float setProfundidad(float profundidad) {
		return profundidad;
	}
	
	public String setMaterial(String nuevoPropietario) {
		return nuevoPropietario;
	}
	

}
