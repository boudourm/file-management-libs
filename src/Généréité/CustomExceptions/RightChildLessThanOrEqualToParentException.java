package Généréité.CustomExceptions;

import Généréité.Node;

public class RightChildLessThanOrEqualToParentException extends BinarySearchTreePropertyViolationException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	public RightChildLessThanOrEqualToParentException(Node<?> parent, Node<?> child) 
	{
		super("Right child data value (position "+child.getPosition()+
			  ") can not be less or equal to its parent data value (position "+parent.getPosition()+
			  ") , "+child.getData()+" is conventionnaly lower than "+parent.getData());
	}
	
}
