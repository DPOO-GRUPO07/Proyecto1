package pieza;

public class PiezaVideo extends Pieza{
	
	private float duracion;
	private String formato;

	public PiezaVideo(String titulo, int anoCreacion, String artista, String lugarCreacion, String propietario,
			int valorFijo, Boolean disponibleEnSubasta, String tipo, boolean bloqueada,float duracion, String formato) {
		super(titulo, anoCreacion, artista,lugarCreacion, propietario, valorFijo, disponibleEnSubasta, tipo, bloqueada);
		// TODO Auto-generated constructor stub
	}

}
