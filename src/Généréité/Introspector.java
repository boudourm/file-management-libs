package Généréité;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Introspector 
{
	//Static Methods
	public static String superClassOf(Class<?> classe)
	{
		return "La superclasse de la Classe : "+
				   classe.getName() +" est la Classe : "+
				   classe.getSuperclass().getName() +" .";
	}
	
	public static String interfacesOf(Class<?> classe)
	{
		String result = "";
		Class<?>[] interfaces = classe.getInterfaces();
		result +="\nLa classe "+classe.getName()+
				           " implémente les interfaces suivantes :\n";
		for (Class<?> i : interfaces)
		{
			result += i.toString()+"\n";
		}
		return result;
	}
	
	public static String methodsOf(Class<?> classe)
	{
		String result = "";
		Method[] methods = classe.getMethods();
		
		result +="\nLa classe "+classe.getName()+" contient "+
						   methods.length+" méthodes : \n";
		for (Method method : methods)
		{
			//Signature
			result += 
							   method.toString().substring(0 ,
							   method.toString().indexOf(
							   method.getReturnType().getCanonicalName()))+
							   method.getReturnType().getSimpleName()+" "+
							   method.getName()+"(";
			
			//Parametres
			int i = method.getParameterCount();
			if(i>0)
			{
				for (Class parameter : method.getParameterTypes())
				{
					result +=parameter.getSimpleName();
					i--;
					if(i>0)
						result+=" , ";
				}
			}
			//Exception
			result+=") "+(method.getExceptionTypes().length >0 ?
									" throws " : "\n");
			i = method.getExceptionTypes().length ;
			if(i >0)
			{
				for (Class exception : method.getExceptionTypes())
				{
					result +=exception.getSimpleName();
					i--;
					result +=i>0 ? "," : "";
				}
				result +="\n";
			}
			
			
				
		}
		return result;
	}
	
	public static String declaredAttributesOf(Class<?> classe) 
	{
		String result = "";
		result +="\nla classe "+classe+" contient "+
				classe.getDeclaredFields().length
				+" attributs déclarés :\n";
		Field[] attributes = classe.getDeclaredFields();
		for (Field field : attributes)
		{
			result +=field.toString().substring(0,
					field.toString().indexOf(classe.getName()+"."+field.getName())) +
					field.getName()+"\n";
		}
		return result;
	}
	
	public static String constructorsOf(Class<?> classe)
	{
		String result = "";
		Constructor[] constructors = classe.getConstructors();
		result += "\nLa classe "+classe+" contient "+
							constructors.length+" constucteurs : \n";
		for (Constructor constructor : constructors) 
		{
			//Signature
			result +=  
					constructor.toString().substring(0 ,
					constructor.toString().indexOf(classe.getName()))+
					constructor.getDeclaringClass().getSimpleName()+"(";
			
			//Parametres
			int i = constructor.getParameterCount();
			if(i>0)
			{
				for (Class parameter : constructor.getParameterTypes())
				{
					result += parameter.getSimpleName();
					i--;
					if(i>0)
						result += " , ";
				}
			}
			//Exception
			result += ") "+(constructor.getExceptionTypes().length >0 ?
									" throws " : "\n");
			i = constructor.getExceptionTypes().length ;
			if(i >0)
			{
				for (Class exception : constructor.getExceptionTypes())
				{
					result += exception.getSimpleName();
					i--;
					result += i>0 ? "," : "";
				}
				result +=  "\n";
			}
		}
		
		return result;
	}
	
	public static Map<String, Object> getFieldNamesAndValues(Object obj, boolean publicOnly)
			throws IllegalArgumentException,IllegalAccessException
			{
			Class<? extends Object> c1 = obj.getClass();
			Map<String, Object> map = new HashMap<String, Object>();
			Field[] fields = c1.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			if (publicOnly) {
			if(Modifier.isPublic(fields[i].getModifiers())) {
			Object value = fields[i].get(obj);
			map.put(name, value);
			}
			}
			else {
			fields[i].setAccessible(true);
			Object value = fields[i].get(obj);
			map.put(name, value);
			}
			}
			return map;
			}
	
	public static String xmlStringFromObject(Object o,boolean publicOnly) throws IllegalArgumentException, IllegalAccessException 
	{
		Map<String,Object> map = Introspector.getFieldNamesAndValues(o, publicOnly);
		String classe = o.getClass().getSimpleName();
		String xml = "<"+classe+">\n";
		for (Map.Entry<String,Object> entry : map.entrySet()) 
		{
			xml += "<"+entry.getKey()+">\n"
			     + 	entry.getValue()+"\n"
			     + "</"+entry.getKey()+">\n";
		}
		xml += "</"+classe+">\n";
		
		return xml;
	}
	
	public static String xmlStringFromObject(List<Object> l,boolean publicOnly) throws IllegalArgumentException, IllegalAccessException 
	{
		String classe = l.getClass().getSimpleName();
		String xml = "<"+classe+">\n";
		for (Object o : l) 
		{
			xml += Introspector.xmlStringFromObject(o, publicOnly);
		}
		xml += "</"+classe+">\n";
		return xml;
	}
	
	

}
