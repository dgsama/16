package filesystem.output.filter;

import java.io.IOException;

import filesystem.output.Output;

public class Fork extends Filter
{
	private Output output2;
	
	public Fork(Output output1, Output output2)
	{
		super(output1);
		if (output2 == null)
			throw new IllegalArgumentException("Una operación fork requiere una segunda salida");
		this.output2 = output2;
	}

	@Override
	public void send(char c) throws IOException 
	{
		output.send(c);
		output2.send(c);
	}

	@Override
	public void close() throws IOException 
	{
		super.close();
		output2.close();
	}
}
