package Généréité;

import java.awt.DisplayMode;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TestGroupe03 
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
		System.out.println("Entrez le nom d'une Classe svp :");
		while(true)
		{
			try
			{
				 classe = Class. forName(sc.next());
				 break;
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("Cette Classe n'existe pas ! réessayez svp : ");
				
			}
		}
			
		for (Method method : classe.getMethods()) 
		{
			MethodData md = new MethodData(method.getName(),method.getReturnType().getSimpleName());
			FileManager.serializeObjectIntoFile(md, "src\\Généréité\\F.ser");
		}
		
		System.out.println("Serialization Done ! \n");
		
		System.out.println("Display of the serialization : ");
		for (Object  method : FileManager.deserializeMultipleObjectsFromFile("src\\Généréité\\F.ser")) 
		{
			System.out.println(method);
		}
	}
}
