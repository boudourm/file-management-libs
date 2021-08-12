package Généréité.CustomExceptions;

import Généréité.Node;

public class LessThanOrEqualValueFoundInRightSubtreeILException extends BinarySearchTreePropertyViolationException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public LessThanOrEqualValueFoundInRightSubtreeILException(Node<?> node, Object minValue) 
	{
		super("Right subtreeIL contains a node in position "+node.getPosition()+
			  " with data value less or equal to its parent data value, "+node.getData()+" is conventionnaly lower than "+minValue+".");
	}
}
