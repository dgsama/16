package filesystem.output.filter;

import java.io.IOException;

import filesystem.output.Output;

public class Normalize extends Filter
{
	public Normalize(Output output)
	{
		super(output);
	}

	@Override
	public void send(char c) throws IOException 
	{
		if (c == '\r')
			return;
		output.send(c);
	}
}
