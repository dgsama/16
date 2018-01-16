import java.io.IOException;

import filesystem.FileSystem;
import filesystem.output.*;
import filesystem.output.filter.*;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem fileSystem = new FileSystem();

		// Mejorar el diseño inicial
		// Cambios: añadir tres clases, una para cada tipo de salida: File, Internet y Bluetooth 
		fileSystem.copy("privado.txt", new File("copia.txt"));
		fileSystem.copy("privado.txt", new Internet("156.17.11.196"));
		fileSystem.copy("privado.txt", new Bluetooth("iPhone de César"));
		
		// Ampliación: normalizar y cifrar
		// Crear una clase abstracta Filter y dos filtros concretos, Normalize, Encrypt y RemoveDuplicatedSpaces
		fileSystem.copy("privado.txt", new Normalize(new File("copia.txt")));
		fileSystem.copy("privado.txt", new Encrypt(new Internet("156.17.11.196")));
		fileSystem.copy("privado.txt", new Encrypt(new Normalize(new Bluetooth("iPhone de César"))));
		
		// Modificación 1: permitir, además de normalizar, cifrar o no los ficheros
		// Cambios: añadir una clase abstracta Filter y dos filtros concretos, Encrypt y Normalize
		fileSystem.copy("privado.txt", new Normalize(new File("a.txt")));
		fileSystem.copy("privado.txt", new Encrypt(new Normalize(new File("b.txt"))));
		
		// Modificación 2: en internet, además de cifrar, permitir normalizar o eliminar espacios repetidos (o ambas cosas)
		// Cambios: añadir un nuevo filtro, RemoveDuplicatedSpaces
		fileSystem.copy("privado.txt", new Encrypt(new Internet("156.17.11.196")));
		fileSystem.copy("privado.txt", new Normalize(new Internet("156.17.11.196")));
		fileSystem.copy("privado.txt", new RemoveDuplicatedSpaces(new Internet("156.17.11.196")));
		fileSystem.copy("privado.txt", new Normalize(new RemoveDuplicatedSpaces(new Internet("156.17.11.196"))));
		
		// Modificación 3: saber el número de caracteres copiados
		// Cambios: añadir un nuevo filtro, Counter
		Counter counter = new Counter(new Internet("156.17.11.196"));
		fileSystem.copy("privado.txt", new Normalize(counter));
		System.out.println("Modificación nº 3 (a): " + counter.getNumberOfSentCharacters() + " caracteres copiados");
		
		// Otra forma de hacerlo
		fileSystem.copy("privado.txt", new Normalize(counter = new Counter(new Internet("156.17.11.196"))));
		System.out.println("Modificacion nº 3 (b): " + counter.getNumberOfSentCharacters());

		// Modificación 4: contar caracteres antes y después de normalizar y eliminar espacios
		// Cambios: ninguno
		Counter after = new Counter(new Internet("156.17.11.196"));
		Counter before = new Counter(new Normalize(after));
		fileSystem.copy("privado.txt", before);
		System.out.println("Modificación nº 4 (a):");
		System.out.println(before.getNumberOfSentCharacters() + " caracteres antes de normalizar");
		System.out.println(after.getNumberOfSentCharacters() + " caracteres después de normalizar");
		
		// Otra forma de hacerlo
		fileSystem.copy("privado.txt", before = new Counter(new Normalize(after = new Counter(new Internet("156.17.11.196")))));
		System.out.println("Modificacion nº 3 (b): " + counter.getNumberOfSentCharacters());
		
		// Modificación 5: permitir cifrar a la vez en dos flujos de salida
		// Cambios: añadir un nuevo filtro, especial, Fork, que afecte a dos salidas en vez de a una sola
		fileSystem.copy("privado.txt", new Encrypt(new Fork(new Internet("156.17.11.196"), new Bluetooth("iPhone de César"))));
	}
}
