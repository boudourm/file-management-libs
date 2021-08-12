package Généréité.CustomExceptions;

import Généréité.Node;

public class DuplicateNodeException extends BinarySearchTreePropertyViolationException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public DuplicateNodeException(Node<?> node) 
	{
		super("Node object already existing in position"+node.getPosition()+
			  ", a binary search tree node can not be chained to itself.");
	}
}
