package Généréité.CustomExceptions;

public class BinarySearchTreePropertyViolationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributes
	private static final String defaultMessage = "A validity property specific to the definition of a binary serch tree is not respected.";
	
	//Constructors
	public BinarySearchTreePropertyViolationException()
	{
		super(defaultMessage);
	}
	
	public BinarySearchTreePropertyViolationException(String message)
	{
		super(defaultMessage+" "+message);
	}
}
