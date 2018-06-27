package photos.model.ajustes;

public class BrilloAjuste implements Ajuste {

    private int valor = 0;
    private boolean activado = false;

    @Override
    public void activar() {
	this.activado = true;
    }

    @Override
    public void setValor(int valor) {
	this.valor = valor;

    }

    @Override
    public void desactivar() {
	this.activado = false;
	this.valor = 0;
    }

    @Override
    public int valor() {
	return valor;
    }

    @Override
    public boolean isActivado() {
	return activado;
    }

    @Override
    public String formatString(String image) {
	return image + String.format("\nBrillo: %+d", valor);
    }

    @Override
    public Ajuste Clone() {
	Ajuste aux = new BrilloAjuste();
	aux.setValor(valor);
	if (isActivado()) {
	    aux.activar();
	    }
	return aux;
    }

}