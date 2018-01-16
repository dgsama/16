package filesystem.output.filter;

import java.io.IOException;

import filesystem.output.Output;

public class Counter extends Filter 
{
	private int numberOfSentCharacters = 0;
	
	public Counter(Output output) 
	{
		super(output);
	}
	
	public int getNumberOfSentCharacters()
	{
		return numberOfSentCharacters;
	}

	@Override
	public void send(char c) throws IOException 
	{
		numberOfSentCharacters++;
		output.send(c);
	}
}
