package G�n�r�it�;

import java.io.File;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TestGroupe01 
{

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		try
		{
			Programme();
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),TestGroupe03.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
		}
	}
	
	public static void Programme() throws Exception 
	{
		Class classe = null;
		System.out.println("Enter the Class name you want to treat :");
		while(true)
		{
			try
			{
				classe = Class.forName(sc.next());
				break;
			}
			catch (ClassNotFoundException e) 
			{
				System.out.println("Class does not exist please enter an other one !");
			}
		}
		
		Integer numMethod = Integer.valueOf(FileManager.readTextFromFile("src\\G�n�r�it�\\ordre.txt"));

		for (Method method : classe.getMethods()) 
		{
			numMethod++;
			FileManager.appendTextIntoFile(numMethod+" "+method.getName()
										   +" Class "+classe.getSimpleName()+" Package "+
										   classe.getPackage().getName()+"\n", "src\\G�n�r�it�\\F.txt");
		}
		
		FileManager.writeTextIntoFile(numMethod.toString(), "src\\G�n�r�it�\\ordre.txt");
		System.out.println("Printing Done ! \n");
		
		System.out.println("Display of F.txt content : ");
		System.out.println(FileManager.readTextFromFile("src\\G�n�r�it�\\F.txt"));
	}
}
