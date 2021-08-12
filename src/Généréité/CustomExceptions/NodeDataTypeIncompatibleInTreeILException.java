package Généréité.CustomExceptions;


public class NodeDataTypeIncompatibleInTreeILException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public NodeDataTypeIncompatibleInTreeILException(Class<?> nodeType) 
	{
		super("Node of data type <<"+nodeType.getClass()+
			  ">> can not be bound to the TreeIL.");
	}
	
}
