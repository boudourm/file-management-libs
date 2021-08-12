package G�n�r�it�.CustomExceptions;

import G�n�r�it�.Node;

public class OrphanNodeFoundException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public OrphanNodeFoundException(Node<?> node) 
	{
		super("Node object found in position "+node.getPosition()+
			  " of TReeIL vector with no parent.");

	}
	
}
