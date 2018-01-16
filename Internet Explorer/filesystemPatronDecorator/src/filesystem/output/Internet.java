package filesystem.output;

import java.io.IOException;
import java.io.StringWriter;

public class Internet implements Output
{
	private StringWriter output;
	private String url;
	
	public Internet(String url)
	{
		if (url == null || url.trim().length() == 0)
			throw new IllegalArgumentException("Se necesita el URL de destino");
		this.url = url;
		output = new StringWriter();
		output.append("\n--- START Internet [" + url + "]\n");
	}
	
	public String getUrl()
	{
		return url;
	}

	@Override
	public void send(char c) throws IOException 
	{
		output.append(c);
	}

	@Override
	public void close() throws IOException 
	{
		System.out.println(output.toString());
		System.out.println("--- END   Internet");
	}
}
