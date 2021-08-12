package Généréité;

import java.time.LocalDateTime;
import java.util.Scanner;

import Exceptions.ILException;

public class TestGroupe02 
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
			(new ExceptionHandler(LocalDateTime.now(),TestGroupe02.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
		}
	}
	
	public static void Programme() throws Exception 
	{
		Class classe =  null;
		System.out.println("Class name example : "+ILException.class.getCanonicalName());
		System.out.println("Entrez le nom d'une Classe :");
		while(true)
		{
			try
			{
				classe = Class.forName(sc.next());
				break;
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("la Classe n'existe pas !  réessayez svp :");
			}
		}
		
		FileManager.writeTextIntoFile((new ClassData(classe)).toXml(), "src\\Généréité\\F.xml");
		
		System.out.println("Printing Done !\n");
		System.out.println("Display of F.xml content :");
		System.out.println(FileManager.readTextFromFile("src\\Généréité\\F.xml"));
		
	}
}
