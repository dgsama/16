package interpreter;

import interpreter.parser.Parser;
import interpreter.parser.ParserException;

import java.io.IOException;

public class Application 
{
	public static void main(String[] args) throws IOException, ParserException
	{
		Parser parser = new Parser();
		Interpreter interpreter = new Interpreter();
		
		try {			
			interpreter.executeProgram(parser.parse("factorial.txt"));
		} catch (ProgramException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(interpreter.getContext());
		}
	}
}
