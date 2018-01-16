package filesystem.output.filter;

import java.io.IOException;

import filesystem.output.Output;

public class Encrypt extends Filter
{
	public Encrypt(Output output)
	{
		super(output);
	}

	@Override
	public void send(char c) throws IOException 
	{
		if (Character.isLetter(c) || Character.isDigit(c))
			output.send((char) (c + 1));
		else
			output.send(c);
	}
}
