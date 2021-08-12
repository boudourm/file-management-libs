package G�n�r�it�.CustomExceptions;

import G�n�r�it�.Node;

public class LeftChildGreaterThanParentException extends BinarySearchTreePropertyViolationException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	public LeftChildGreaterThanParentException(Node<?> parent, Node<?> child) 
	{
		super("Left child data value (position "+child.getPosition()+
			  ") can not be greater than its parent data value (position "+parent.getPosition()+
			  ") , "+child.getData()+" is conventionnaly greater than "+parent.getData());
	}
	
}
