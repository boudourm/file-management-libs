package Généréité;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Généréité.CustomExceptions.FailedSavingFileUpdateException;



public class FileManager 
{
	
	//Static Methods
	public static void appendTextIntoFile(String text, String file) throws Exception
	{
		BufferedWriter bw = null;
		FileWriter fr = null;
		
		try {
			File f = new File(file);
			if(!f.exists()) 
			{
				throw new FailedSavingFileUpdateException(file);
			}
			fr = new FileWriter(file,true);
			bw = new BufferedWriter(fr);

			bw.append(text);
			
		}
		catch (Exception e) {throw e;}
		finally
		{
			try 
			{
				bw.close();
			} 
			catch (Exception e) {throw e;}	
		}
	}
	
	public static void writeTextIntoFile(String text, String file) throws Exception
	{
		File f = null;
		BufferedWriter bw = null;
		FileWriter fr = null;
		
		try {
			f = new File(file);
			fr = new FileWriter(f);
			bw = new BufferedWriter(fr);

			bw.write(text);
			
		}
		catch (Exception e) { throw e; }
		finally
		{
			try 
			{
				bw.close();
			} 
			catch (Exception e) { throw e; }	
		}
	}
	
	public static void initSerialisationFile(String file) throws Exception
	{
		ObjectOutputStream oos = null;
		
		try
		{
			//Ouverture du Flux ObjectOutputStream
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File(file))));
			
			//Sérialisons quelques Objets
			
				oos.writeObject(new TreeIL<>());
		}
		catch(Exception e)
		{
			throw e;
		}

		finally
		{
			try
			{
				if(oos != null)
					oos.close();
			}
			catch(Exception e)
			{
				throw e;
			}
		}
	}
	
	public static void serializeObjectIntoFile(Object object, String file) throws Exception
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ArrayList<Object> firstObjects = new ArrayList<Object>();
		
		//Affichage des Données #Déserialisation
		try
		{
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new	FileInputStream(
							new File(file))));
			
			
			while(true)
			{
				try {firstObjects.add(ois.readObject());}
				catch(EOFException e) {break;}
			}
		}
		catch(EOFException e)
		{
			(new ExceptionHandler(LocalDateTime.now(),FileManager.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
		}
		finally
		{
			if(ois != null)
			ois.close();
		}

		//Ouverture du Flux ObjectOutputStream
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File(file))));
			//Sérialisons quelques Objets
			while(!firstObjects.isEmpty())
			{
				oos.writeObject(firstObjects.get(0));
				firstObjects.remove(0);
			}
				oos.writeObject(object);		
			//Fermeture du Flux De Sortie
				if(oos != null)
					oos.close();
				
	}
	
	public static Object deserializeObjectFromFile(String file) throws Exception
	{
		ObjectInputStream ois = null;
		Object o = null;
		
		try
		{
			//Affichage des Données #Déserialisation
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new	FileInputStream(
							new File(file))));
			//La Déserialisation peut engendrer une ClassNotFoundException
			try
			{
				
				o = ois.readObject();
				
			}
			catch(Exception e)
			{
				throw e;
			}
		}
		catch(Exception e)
		{
			throw e;
		}

		finally
		{
			try
			{
				if(ois != null)
					ois.close();
			}
			catch( Exception e)
			{
				throw e ;
			}
			
			
		}
		
		return o;
	}
	
	public static String readTextFromFile(String file) throws Exception

	{
		File fichier = new File(file);
		FileReader  fr = null ;
		try
		{
			//Ouverture du Flux de Lecture
			fr = new FileReader(fichier);
			
			//Lecture
			String str = "";
			int i ;
			while((i = fr.read()) != -1)
				str += (char) i ;
			
			//Affichage de La Lecture
			return str;
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				fr.close();
			}
			catch(Exception e)
			{
				throw e;
			}
		}
	}

	public static ArrayList<Object> deserializeMultipleObjectsFromFile(String file) throws Exception
	{
		
		ObjectInputStream ois = null;
		ArrayList<Object> objectsList = new ArrayList<Object>();
		try
		{		
			//Affichage des Données #Déserialisation
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new	FileInputStream(
							new File(file))));
			 while(true){
				   try
				   {
					   
					   Object obj = ois.readObject();
					   objectsList.add(obj);
					 
				   }
				   catch(EOFException e)
				   {
					   break;
				   }
			   }
			 
			 return objectsList;
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),FileManager.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return new ArrayList<Object>();
		}
		finally
		{
			try
			{
				if(ois != null)
					ois.close();
			}
			catch(Exception e)
			{
				throw e;
			}
		}
	}
	
}
