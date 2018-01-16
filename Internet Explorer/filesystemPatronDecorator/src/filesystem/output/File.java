package filesystem.output;

import java.io.FileWriter;
import java.io.IOException;

public class File implements Output 
{
	private String name;
	private FileWriter output;
	
	public File(String filename) throws IOException
	{
		if (filename == null || filename.trim().length() == 0)
			throw new IllegalArgumentException("Se necesita el nombre del fichero de destino");
		this.name = filename;
		output = new FileWriter(filename);
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public void send(char c) throws IOException 
	{
		output.append(c);
	}

	@Override
	public void close() throws IOException 
	{
		output.close();
	}
}