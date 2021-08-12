package Généréité;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassData 
{
	//attributes
	private String nom;
	private String paquet;
	private Integer nombreMethode;
	private Method[] methods;
	
	
	//Constructors
	public ClassData(String nom, String paquet, Integer nombreMethode, Method[] methods) {
		super();
		this.nom = nom;
		this.paquet = paquet;
		this.nombreMethode = nombreMethode;
		this.methods = methods;
	}
	
	public ClassData() {
		super();
		this.nom = null;
		this.paquet = null;
		this.nombreMethode = null;
		this.methods = null;
	}
	
	public ClassData(Class c) {
		super();
		this.nom = c.getSimpleName();
		this.paquet = c.getPackage().getName();
		this.nombreMethode = c.getMethods().length;
		this.methods = c.getMethods();
	}

	
	
	//Getters & Setters 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPaquet() {
		return paquet;
	}

	public void setPaquet(String paquet) {
		this.paquet = paquet;
	}

	public Integer getNombreMethode() {
		return nombreMethode;
	}

	public void setNombreMethode(Integer nombreMethode) {
		this.nombreMethode = nombreMethode;
	}

	public Method[] getMethods() {
		return methods;
	}

	public void setMethods(Method[] methods) {
		this.methods = methods;
	}
	
	//Instance Methods
	@Override
	public String toString() {
		return "ClassData [nom=" + nom + ", paquet=" + paquet + ", nombreMethode=" + nombreMethode + ", methods="
				+ Arrays.toString(methods) + "]";
	}
	
	public String toXml()
	{
		String xml =  "<Class>\n"
				+"<Name>\n"+this.nom+"\n</Name>\n"
				+"<Package>\n"+this.paquet+"\n</Package>\n"
				+"<Methods NombreMethode = "+this.nombreMethode+">\n";
		for (Method method : methods) 
		{
			xml += "<Method>\n"+method.getName()+"\n</Method>\n";
		}
		xml += "</Methods>\n";
		
		return xml+"</Class>";
	}
	
}
