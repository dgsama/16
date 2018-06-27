package photos.model.ajustes;

public interface Ajuste {

    public void activar();

    public void setValor(int valor);

    public void desactivar();

    public int valor();

    public boolean isActivado();

    public String formatString(String image);

    public Ajuste Clone();

}
