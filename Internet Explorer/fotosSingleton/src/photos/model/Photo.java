package photos.model;

import java.util.HashMap;
import java.util.Map;

import photos.model.ajustes.Ajuste;
import photos.model.ajustes.BrilloAjuste;
import photos.model.ajustes.ContrasteAjuste;
import photos.model.ajustes.Degradado;
import photos.model.ajustes.Nitidez;

public class Photo {
    private String image;

    // valores de los ajustes predefinidos, inicializados a sus valores por
    // omisión
    // private int brightness = 0, contrast = 0;
    // si se han aplicado o no a la foto
    // private boolean isBrightnessEnabled, isContrastEnabled;

    public Map<String, Ajuste> propiedades;

    public Photo(String filename) {
	image = new String(filename);
	propiedades = new HashMap<>();
	propiedades.put("brillo", new BrilloAjuste());
	propiedades.put("contraste", new ContrasteAjuste());
	propiedades.put("nitidez", new Nitidez());
	propiedades.put("degradado", new Degradado());
    }

    /**
     * Devuelve una copia de la imagen que representa esta fotografía a la que se le
     * han aplicado todos los ajustes realizados en la foto. Nótese que este método
     * no modifica la imagen original, sino que crea una copia de la misma que es
     * sobre la que se aplican los ajustes y la que finalmente se devuelve.
     * 
     * @return un objeto {@code String} que representa la imagen generada resultante
     *         de aplicar los ajustes realizados a esta fotografía
     */
    public String outputImage() {
	String result = new String(image);
	result = applyAdjustments(result);
	return result;
    }

    // -- Ajustes

    private String applyAdjustments(String image) {
	String result = image;
	if (propiedades.get("brillo").isActivado())
	    result = propiedades.get("brillo").formatString(result);
	if (propiedades.get("contraste").isActivado())
	    result = propiedades.get("contraste").formatString(result);
	if (propiedades.get("nitidez").isActivado())
	    result = propiedades.get("nitidez").formatString(result);
	if (propiedades.get("degradado").isActivado())
	    result = propiedades.get("degradado").formatString(result);
	return result;
    }

    @Override
    public String toString() {
	return String.format(image);
    }
    /*
     * public void enableAdjustment(String adjustmentName) { if
     * (adjustmentName.equalsIgnoreCase("brillo")) isBrightnessEnabled = true; else
     * if (adjustmentName.equalsIgnoreCase("contraste")) isContrastEnabled = true;
     * else throw new IllegalArgumentException("Nombre de ajuste desconocido"); }
     * 
     * public void setAdjustment(String adjustmentName, int value) { if
     * (adjustmentName.equalsIgnoreCase("brillo")) { brightness = value;
     * isBrightnessEnabled = true; } else if
     * (adjustmentName.equalsIgnoreCase("contraste")) { contrast = value;
     * isContrastEnabled = true; } else throw new
     * IllegalArgumentException("Nombre de ajuste desconocido"); }
     * 
     * public void disableAdjustment(String adjustmentName) { if
     * (adjustmentName.equalsIgnoreCase("brillo")) { isBrightnessEnabled = false;
     * brightness = 0; } else if (adjustmentName.equalsIgnoreCase("contraste")) {
     * isContrastEnabled = false; contrast = 0; } else throw new
     * IllegalArgumentException("Nombre de ajuste desconocido"); }
     * 
     * 
     * 
     * // -- Otros métodos
     * 
     * @Override public String toString() { return String.format(image); }
     * 
     * // -- Getters
     * 
     * public int getBrightness() { return brightness; }
     * 
     * public int getContrast() { return contrast; }
     * 
     * public boolean isBrightnessEnabled() { return isBrightnessEnabled; }
     * 
     * public boolean isContrastEnabled() { return isContrastEnabled; }
     * 
     * // -- Setters public void setBrightness(int brightness) { this.brightness =
     * brightness; }
     * 
     * public void setContrast(int contrast) { this.contrast = contrast; }
     * 
     * public void setBrightnessEnabled(boolean isBrightnessEnabled) {
     * this.isBrightnessEnabled = isBrightnessEnabled; }
     * 
     * public void setContrastEnabled(boolean isContrastEnabled) {
     * this.isContrastEnabled = isContrastEnabled; }
     */

}
