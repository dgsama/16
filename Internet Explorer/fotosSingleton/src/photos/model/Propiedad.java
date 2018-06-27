package photos.model;

public class Propiedad {
    
    private String nombre;
    private int valor;
    private boolean activado;
    
    public Propiedad(String nombre, int valor, boolean activado) {
	super();
	this.nombre = nombre;
	this.valor = valor;
	this.activado = activado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }
    
    
   

}
