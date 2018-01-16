package editor.actions;

import java.util.Stack;

public class ActionManager 
{
	private Stack<Action> undoableActions = new Stack<>();
	private Stack<Action> redoableActions = new Stack<>();
	
	public void executeAction(Action action)
	{
		action.execute();
		undoableActions.push(action);
	}
	
	/**
	 * Añade una operación, sin ejecutarla, a la colección de acciones que se
	 * pueden deshacer. Es útil cuando, como ocurre en el caso de los movimientos
	 * intermedios de una figura realizados con la herramienta de selección, sólo
	 * se quiere deshacer el resultado final de varias operaciones que ya se han
	 * ejecutado directamente.
	 * 
	 * @param action la acción a añadir a la colección de acciones que pueden ser
	 *               deshechas en un futuro
	 */
	public void addUndoableAction(Action action)
	{
		undoableActions.push(action);		
	}
	
	public boolean canBeUndone()
	{
		return !undoableActions.isEmpty();
	}
	
	public void undo()
	{
		if (!canBeUndone())
			throw new IllegalStateException("No hay acciones que deshacer");
		Action action = undoableActions.pop();
		action.undo();
		redoableActions.push(action);
	}
	
	public boolean canBeRedone()
	{
		return !redoableActions.isEmpty();
	}
	
	public void redo()
	{
		if (!canBeRedone())
			throw new IllegalStateException("No hay ninguna operación que repetir");
		Action action = redoableActions.pop();
		action.execute();
		undoableActions.push(action);
	}
}
