package Généréité.CustomExceptions;

import Généréité.Node;

public class GreaterValueFoundInLeftSubTreeILException extends BinarySearchTreePropertyViolationException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public GreaterValueFoundInLeftSubTreeILException(Node<?> node, Object maxValue) 
	{
		super("Left subtreeIL contains a node in position "+node.getPosition()+
			  " with data value greater than its parent data value, "+node.getData()+" is conventionnaly greater than "+maxValue+".");
	}
	
}
