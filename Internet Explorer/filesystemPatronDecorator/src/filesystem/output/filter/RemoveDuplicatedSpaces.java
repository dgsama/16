package filesystem.output.filter;

import java.io.IOException;

import filesystem.output.Output;

public class RemoveDuplicatedSpaces extends Filter
{
	private char previousCharacter;
	
	public RemoveDuplicatedSpaces(Output output)
	{
		super(output);
	}

	@Override
	public void send(char c) throws IOException 
	{
		if (previousCharacter == ' ' || c == ' ')
			return;
		previousCharacter = c;
		output.send(c);
	}
}
