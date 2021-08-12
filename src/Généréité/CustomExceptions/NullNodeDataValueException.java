package Généréité.CustomExceptions;


public class NullNodeDataValueException extends BinarySearchTreePropertyViolationException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public NullNodeDataValueException() 
	{
		super("Node with null data value can not be bound to a TreeIL structure.");
	}
}
