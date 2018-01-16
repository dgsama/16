import java.io.*;

import poll.*;
import poll.observers.*;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");
		
		// Apartado 1
		//poll.addObserver(new PieChart());
		//poll.addObserver(new BarChart());
		poll.addObserver(new ResultSaver());
		// Apartado 2
		poll.addObserver(new StatusBar());
		// Apartados 4 y 5
		poll.addObserver(new MinimumVotesObserver(3, new BarChart()));
		poll.addObserver(new MinimumVotesObserver(4, new PieChart()));

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}

