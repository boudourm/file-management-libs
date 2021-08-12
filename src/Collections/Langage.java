package Collections;



public enum Langage
{
	//Objects
	JAVA("Langage Java" , "Eclipse"),
	C("Langage C" , "Code Blocks"),
	CPlus("Langage C++" , "Visual Studio"),
	PHP("Lanagae PHP" , "PS Pad");
	
	//Attributes
	private String name = "" ;
	private String editor = "" ;
	
	//Constructor
	Langage(String name , String editor)
	{
		this.name =  name ;
		this.editor = editor ;
	}
	
	//Getters & Setters
	public String getName() { return this.name ;}
	public void setName(String name) {this.name = name ;}
	public String getEditor() { return "Editeur : "+this.editor ; }
	public void seteditor() { this.editor = editor ; }
	//Intance Methods
	@Override
	public String toString()
	{
		return name ;
	}
}
