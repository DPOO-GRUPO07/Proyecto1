package model;

public class Pieza {
    private String titulo;
    private int añoCreacion;
    private String lugarCreacion;
    private String tipo;
    private String propietario;
    private String dimension;
    private String material;
    private String peso;
    private boolean necesitaElectricidad;
    private String detalles;

    public Pieza(String titulo, int añoCreacion, String lugarCreacion, String tipo, String propietario, String dimension, String material, String peso, boolean necesitaElectricidad, String detalles) {
        this.titulo = titulo;
        this.añoCreacion = añoCreacion;
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

    

}
