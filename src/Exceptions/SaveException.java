package Exceptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SaveException implements Serializable{

	//Attributes
	private static String exceptionsFileName = "C:\\DocumeSettings\\TITOUCHE\\workspace\\TP_MODAL\\exception.txt" /*= new File("C:\\Documents and Settings\\TITOUCHE\\workspace\\TP_MODAL\\exception.txt")*/;
	private static String exceptionsFileNameBis = "C:\\Documents and Settings\\TITOUCHE\\workspace\\TP_MODAL\\exceptionBis.txt" /*= new File("C:\\Documents and Settings\\TITOUCHE\\workspace\\TP_MODAL\\exception.txt")*/;
	private Date date;
	private String classe;
	private String methode;
	private String exception;
	
	//Constructors
	public SaveException() {
		super();
	}
	
	public SaveException(Date date, String classe, String methode,
			String exception) {
		super();
		this.date = date;
		this.classe = classe;
		this.methode = methode;
		this.exception = exception;
	}
	
	//Getters & Setters 
	public static String getExceptionsFileName() {
		return exceptionsFileName;
	}
	public static void setExceptionsFileName(String exceptionsFileName) {
		SaveException.exceptionsFileName = exceptionsFileName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getMethode() {
		return methode;
	}
	public void setMethode(String methode) {
		this.methode = methode;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	
	//Instance Method
	
	@SuppressWarnings("static-access")
	public void save()
	{
		
		try {
			FileOutputStream fos = new FileOutputStream(SaveException.getExceptionsFileName());
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(this);
			
			
			os.close();
			
		} catch (Exception e) {
			SaveException se = new SaveException(new Date() , "SaveException","save",e.toString());
			se.save("C:\\Documents and Settings\\TITOUCHE\\workspace\\TP_MODAL\\exceptionBis.txt");
		}
	}

	
	public void save(String emergency)
	{
		
		try {
			FileOutputStream fos = new FileOutputStream(emergency);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(this);
			
			
			os.close();
			
		} catch (Exception e) {
			SaveException se = new SaveException(new Date() , "SaveException","save",e.toString());
			se.save("C:\\Documents and Settings\\TITOUCHE\\workspace\\TP_MODAL\\exceptionBis.txt");
		}
	}
	public static void setExceptionsFileNameBis(String exceptionsFileNameBis) {
		SaveException.exceptionsFileNameBis = exceptionsFileNameBis;
	}

	public static String getExceptionsFileNameBis() {
		return exceptionsFileNameBis;
	}
	
	

}
