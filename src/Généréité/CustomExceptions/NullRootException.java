package Généréité.CustomExceptions;


public class NullRootException extends BinarySearchTreePropertyViolationException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public NullRootException(Integer position) 
	{
		super("Null pointer found in root node position ("+position+").");
	}
}
