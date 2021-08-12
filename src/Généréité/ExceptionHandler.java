package Généréité;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExceptionHandler
{
	//Attributes
	private LocalDateTime date;
	private Class<?> classe;
	private Executable methode;
	private Exception exception;
	
	//Constructors
	public ExceptionHandler() {
		super();
	}
	public ExceptionHandler(LocalDateTime date, Class<?> classe, Method methode, Exception exception) {
		super();
		this.date = date;
		this.classe = classe;
		this.methode = methode;
		this.exception = exception;
	}
	
	//Getters & Setters
	public static String getExceptionsFileName() {return "src/Généréité/CustomExceptions/exceptions_log.txt";}
	public static String getExceptionsFileNameBis() {return "src/Généréité/CustomExceptions/exceptions_log_bis.txt";}
	public static String getSerializationExceptionsFileName() {return "src/Généréité/CustomExceptions/exceptions_log.ser";}
	public static String getSerializationExceptionsFileNameBis() {return "src/Généréité/CustomExceptions/exceptions_log_bis.ser";}

	public LocalDateTime getDate() {return date;}
	public void setDate(LocalDateTime date) {this.date = date;}
	public Class<?> getClasse() {return classe;}
	public void setClasse(Class<?> classe) {this.classe = classe;}
	public Executable getMethode() {return methode;}
	public void setMethode(Executable methode) {this.methode = methode;}
	public Exception getException() {return exception;}
	public void setException(Exception exception) {this.exception = exception;}
	
	//Instance Methods
	public String getExecutableSignature()
	{
		String m = "";
		if(this.methode instanceof Method)
		{
			
			Method methd = (Method) this.methode;
			//Signature
			m = m +  methd.toString().substring(0 ,
					 methd.toString().indexOf(
					 methd.getReturnType().getCanonicalName()))+
					 methd.getReturnType().getSimpleName()+" "+
					 methd.getName()+"(";
			
			//Parametres
			int i = methd.getParameterCount();
			if(i>0)
			{
				for (Class<?> parameter : methd.getParameterTypes())
				{
					m = m + parameter.getSimpleName();
					i--;
					if(i>0)
						m=m+" , ";
				}
			}
		}
		
		if(this.methode instanceof Constructor)
		{
			Constructor<?> cntrct = (Constructor<?>) this.methode;
			//Signature
			m=m+ 
					cntrct.toString().substring(0 ,
					cntrct.toString().indexOf("java.lang.String"))+
					cntrct.getDeclaringClass().getSimpleName()+"(";
			
			//Parametres
			int i = cntrct.getParameterCount();
			if(i>0)
			{
				for (Class<?> parameter : cntrct.getParameterTypes())
				{
					m=m+parameter.getSimpleName();
					i--;
					if(i>0)
						m=m+" , ";
				}
			}
		}
		return m+")";
		
	}
	
	public String errorText()
	{	
		return "\n################################################################################################################"+
	           "\n=> "+this.exception.toString()+
			   "\n=> "+this.date.toLocalDate()+" at "+this.date.toLocalTime()+
			   "\n=> In class : "+this.classe.getName()+
			   "\n=> Wihle running : "+this.getExecutableSignature();
	}
	
	
	public String getLoggedExceptions()
	{
	try 
		{
			return FileManager.readTextFromFile(ExceptionHandler.getExceptionsFileName());
		} 
		catch (Exception e) 
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return null;
		}

	}
	
	public ArrayList<String> getLoggedExceptionsBis()
	{
		ArrayList<Object> exceptionsBis = null;
		
		ArrayList<String> exceptionsBisTexts = new ArrayList<String>();
		try 
		{
			exceptionsBis = FileManager.deserializeMultipleObjectsFromFile(ExceptionHandler.getSerializationExceptionsFileNameBis());
			for (Object e : exceptionsBis) 
				exceptionsBisTexts.add(((ExceptionHandler) e).errorText());
		} 
		catch (Exception e) 
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();

		}
		finally
		{
			return exceptionsBisTexts;
		}
	}
	
	public void logException()
	{
		this.logExceptionAsText();
//		this.logExceptionAsObject();
	}
	
	public void logExceptionAsText()
	{
		ArrayList<ExceptionHandler> stack = new ArrayList<ExceptionHandler>();
		try 
		{
			FileManager.appendTextIntoFile(this.errorText(), ExceptionHandler.getExceptionsFileName());
		} 
		catch (Exception e) 
		{
			stack.add(this);
			stack.add(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e));

			while(!stack.isEmpty())
			{
				try
				{
					FileManager.appendTextIntoFile(stack.get(0).errorText(), ExceptionHandler.getExceptionsFileName());
					stack.remove(0);
				} 
				catch (Exception e2) 
				{
					stack.add(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e2));
					break;
				}
			}
			
			if(!stack.isEmpty())
			{
				String trace = "Error occured while trying to update both saving main and secondary exception log files. Here's the full set of raised exceptions :\n\n";
				while(!stack.isEmpty())
				{
					trace = trace + stack.get(0).errorText();
					stack.remove(0);
				}
				JOptionPane.showMessageDialog(new JFrame(), trace, "Dialog",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	@Override
	public String toString() {
		return this.errorText();
	}
	public String toXml()
	{
		try 
		{
			return Introspector.xmlStringFromObject(this, false);
		} 
		catch (Exception e) 
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return "<!-- error occured -->";
		}

	}
	
	public void saveXML()
	{
		try
		{
			FileManager.writeTextIntoFile(this.toXml(), "src\\Généréité\\xmlFiles\\exceptionhandler.xml");;
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
		}
	}
	
	public void logExceptionAsObject()
	{
		ArrayList<ExceptionHandler> stack = new ArrayList<ExceptionHandler>();
		try 
		{
				FileManager.serializeObjectIntoFile(this, ExceptionHandler.getSerializationExceptionsFileName());
		} 
		catch (Exception e) 
		{
			stack.add(this);
			stack.add(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e));

			while(!stack.isEmpty())
			{
				try
				{
					FileManager.serializeObjectIntoFile(stack.get(0), ExceptionHandler.getSerializationExceptionsFileName());
					stack.remove(0);
				} 
				catch (Exception e2) 
				{
					stack.add(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e2));
					break;
				}
			}
			
			if(!stack.isEmpty())
			{
				String trace = "Error occured while trying to update both saving main and secondary exception log files. Here's the full set of raised exceptions :\n\n";
				while(!stack.isEmpty())
				{
					trace = trace + stack.get(0).errorText();
					stack.remove(0);
				}
				JOptionPane.showMessageDialog(new JFrame(), trace, "Dialog",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public ArrayList<Map<String,String>> exceptionStackTrace()
	{
		Map<String,String> map = new HashMap<String,String>();
		ArrayList<Map<String,String>> st = new ArrayList<Map<String,String>>();
		for (StackTraceElement ste : this.getException().getStackTrace()) 
		{
			map.put("lineNumber", ste.getLineNumber()+"");
			map.put("className", ste.getClassName());
			map.put("methodName", ste.getMethodName());
			map.put("packageName", ste.getClass().getPackage().getName());
			st.add(map);
			map = new HashMap<String,String>();
		}
		return st;
	}
	
	public String stackTraceAsXml()
	{
		String  xml = "<StackTrace>\n";
		for (Map<String, String> map : this.exceptionStackTrace()) 
		{
			xml += "<StackTraceElement>\n";
			for (Map.Entry<String,String> entry : map.entrySet()) 
			{
				xml += "<"+entry.getKey()+">\n"
				     + 	entry.getValue()+"\n"
				     + "</"+entry.getKey()+">\n";
			}
			xml += "</StackTraceElement>\n";
		}
		xml += "</StackTrace>\n";
		
		return xml;
	}
	
	
	//Static Methods
	
}
