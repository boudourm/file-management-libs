package Généréité.CustomExceptions;

public class FailedSavingFileUpdateException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public FailedSavingFileUpdateException(String file) 
	{
		super("Atempt to log exception in file <<"+file+">> failed.");
	}
	
}
