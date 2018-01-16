package filesystem.output;

import java.io.IOException;
import java.io.StringWriter;

public class Bluetooth implements Output 
{
	private StringWriter output;
	private String device;
	
	public Bluetooth(String device)
	{
		if (device == null || device.trim().length() == 0)
			throw new IllegalArgumentException("Se necesita el nombre del dispositivo");
		this.device = device;
		output = new StringWriter();
		output.append("\n--- START Bluetooth [" + device + "]\n");
	}

	public String getDevice()
	{
		return device;
	}
	
	@Override
	public void send(char c) throws IOException 
	{
		output.append(c);
	}

	@Override
	public void close() throws IOException 
	{
		System.out.print(output.toString());
		System.out.println("\n--- END   Bluetooth");		
	}
}
