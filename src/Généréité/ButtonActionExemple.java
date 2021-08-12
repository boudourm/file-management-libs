package Généréité;

import java.util.List;

public class ButtonActionExemple  implements ButtonAction, Comparable<ButtonActionExemple>
{

	private String popo;
	private String pipi;
	private String puetpuet;
	
	public String getPopo() {
		return popo;
	}

	public void setPopo(String popo) {
		this.popo = popo;
	}
	


	@Override
	public List<Object> perform(Object... outputs) {
		System.out.println("IT WORKS !");
		return null;
	}

	public String getPipi() {
		return pipi;
	}

	public void setPipi(String pipi) {
		this.pipi = pipi;
	}

	public String getPuetpuet() {
		return puetpuet;
	}

	public void setPuetpuet(String puetpuet) {
		this.puetpuet = puetpuet;
	}



	@Override
	public String toString() {
		return "ButtonActionExemple [popo=" + popo + ", pipi=" + pipi + ", puetpuet=" + puetpuet + "]";
	}

	@Override
	public int compareTo(ButtonActionExemple o) {

			return this.getPopo().compareTo(((ButtonActionExemple) o).getPopo());


	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pipi == null) ? 0 : pipi.hashCode());
		result = prime * result + ((popo == null) ? 0 : popo.hashCode());
		result = prime * result + ((puetpuet == null) ? 0 : puetpuet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ButtonActionExemple other = (ButtonActionExemple) obj;
		if (popo == null) {
			if (other.popo != null)
				return false;
		} else if (!popo.equals(other.popo))
			return false;
		
		return true;
	}

	public ButtonActionExemple(String popo) {
		super();
		this.popo = popo;
	}
	
	




	
	

}
