package Généréité;

import java.io.Serializable;

public class MethodData implements Serializable
{
	//attributes
	private String nomMethode;
	private String typeMethode;
	
	//Constructors
	public MethodData(String nomMethode, String typeMethode) {
		super();
		this.nomMethode = nomMethode;
		this.typeMethode = typeMethode;
	}
	
	public MethodData() {
		super();
		this.nomMethode = "";
		this.typeMethode = "";
	}

	
	//Getters & Setters
	public String getNomMethode() {
		return nomMethode;
	}

	public void setNomMethode(String nomMethode) {
		this.nomMethode = nomMethode;
	}

	public String getTypeMethode() {
		return typeMethode;
	}

	public void setTypeMethode(String typeMethode) {
		this.typeMethode = typeMethode;
	}


	//Instance Methods
	@Override
	public String toString() {
		return "methodData [nomMethode=" + nomMethode + ", typeMethode=" + typeMethode + "]";
	}
	
	
}
