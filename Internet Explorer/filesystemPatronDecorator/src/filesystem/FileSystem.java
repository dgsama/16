package filesystem;

import java.io.*;

import filesystem.output.Output;

public class FileSystem 
{
	public void copy(String filename, Output output) throws IOException
	{
		try {
			FileReader reader = new FileReader(filename);

			int c;
			while ((c = reader.read()) != -1)
				output.send((char) c);

			reader.close();
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
