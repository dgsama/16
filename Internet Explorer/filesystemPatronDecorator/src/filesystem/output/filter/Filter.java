package filesystem.output.filter;

import java.io.IOException;

import filesystem.output.Output;

public abstract class Filter implements Output
{
	protected Output output;
	
	public Filter(Output output)
	{
		if (output == null)
			throw new IllegalArgumentException("Se necesita la salida a la que añadir un filtro");
		this.output = output;
	}

	@Override
	public abstract void send(char c) throws IOException; 

	@Override
	public void close() throws IOException 
	{
		output.close();
	}
}
