package editor.figures;

import editor.*;
import editor.tools.*;

public class TriangleCreationTool extends AbstractCreationTool implements Tool 
{	
	public TriangleCreationTool(Editor editor)
	{
		super(editor);
	}
	
	@Override
	protected Figure createFigure(BoundingBox boundingBox) 
	{
		return new Triangle(boundingBox);
	}

	@Override
	public String toString()
	{
		return "Triángulo (herramienta de creación de)";
	}
}
