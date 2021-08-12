package Collections;



public class Main
{
	public static void main(String[] args)
	{
		for (Langage l : Langage.values())
		{
			if(l.equals(Langage.JAVA))
				System.out.println("J'aime le : "+l);
			else
				System.out.println(l);
			System.out.println(l.getEditor());
		}
	}
}
