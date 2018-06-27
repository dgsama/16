package photos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import photos.model.ajustes.Ajuste;

public class Editor {
    private List<Photo> library = new ArrayList<>();
    // la foto que está actualmente abierta en el editor
    private Photo current;

    /** AÑADIDO si hay que copiar valor y activacion */
    /*
     * private List<Propiedad> propiedadesCopiadas;
     * 
     * public List<Propiedad> getPropiedades() { if (propiedadesCopiadas == null) {
     * propiedadesCopiadas = new ArrayList<>(); propiedadesCopiadas.add(new
     * Propiedad("brightness", 0, false)); propiedadesCopiadas.add(new
     * Propiedad("contrast", 0, false)); return propiedadesCopiadas; } else { return
     * propiedadesCopiadas; } }
     */
    /** ------------------------------------------------------------------- */

    /** AÑADIDO si hay que copiar solo el valor */
    private Map<String, Ajuste> propiedadesCopiadas = new HashMap<>();

    public Map<String, Ajuste> getPropiedadesCopiadas() {
	return propiedadesCopiadas;
    }

    public void setPropiedadesCopiedades(Map<String, Ajuste> propiedades) {
	propiedadesCopiadas.clear();
	for (Map.Entry<String, Ajuste> entry : propiedades.entrySet()) {
	    propiedadesCopiadas.put(entry.getKey(), (entry.getValue().Clone()));
	}
    }

    /** ------------------------------------------------------------------- */

    public void addPhoto(Photo photo) {
	library.add(photo);
    }

    public void open(int index) {
	current = getPhoto(index);
    }

    public Photo getCurrentPhoto() {
	return current;
    }

    public List<Photo> getAllPhotos() {
	return Collections.unmodifiableList(library);
    }

    // -- Métodos auxiliares

    private Photo getPhoto(int index) {
	checkPhotoIndex(index);
	return library.get(index - 1);
    }

    private void checkPhotoIndex(int index) {
	if (index < 1 || index > library.size())
	    throw new IllegalArgumentException(
		    String.format("%d no es un número de foto válido: (%d-%d)", index, 1, library.size()));
    }

    @Override
    public String toString() {
	return String.format("Editor: %d fotos - foto abierta: %s", library.size(), current);
    }
}
