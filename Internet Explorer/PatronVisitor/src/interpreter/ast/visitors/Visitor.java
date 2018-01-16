package interpreter.ast.visitors;

import interpreter.ast.nodes.*;

public interface Visitor 
{
	Object visit(Program program, Object param);
	
	Object visit(Assignment program, Object param);
	
	Object visit(Sum program, Object param);
	Object visit(Product program, Object param);
	Object visit(Division program, Object param);
	
	Object visit(Print program, Object param);
	Object visit(Read program, Object param);
	
	Object visit(Variable program, Object param);
	
	Object visit(IntegerLiteral program, Object param);
}
