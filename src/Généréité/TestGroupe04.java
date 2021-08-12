package Généréité;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TestGroupe04 
{
	public static void main(String[] args) 
	{
		try
		{
			Programme();
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),TestGroupe04.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
		}
	}
	
	public static void Programme() throws Exception 
	{
		//Read From G.txt
		String text = FileManager.readTextFromFile("src\\Généréité\\G.txt");
		
		System.out.println("size = "+ text.length()+"\n"+text+"\n");
		
		//Remove Begin End
		text = text.substring(text.indexOf("Begin")+"Begin".length(), text.indexOf("End"));
		System.out.println("size = "+ text.length()+"\n"+text+"\n");

		//Split(#)
		String[] list = text.split("#");
		System.out.println("size = "+ list.length);
		for (String string : list) {
			System.out.println(string);
		}
		
		
		//Split the splits
		ArrayList<ArrayList<String>> al= new ArrayList<ArrayList<String>>();
		
		
		for (int i = 0; i < list.length; i++) 
		{
			ArrayList<String> subal = new ArrayList<String>(Arrays.asList(list[i].split("\n")));
			subal.remove(0);
			al.add(subal);
		}
		
		for (int i = 0; i < al.size(); i++) 
			for (int j = 0; j < al.get(i).size(); j++) 
			{
				al.get(i).set(j, al.get(i).get(j).replace("\n", ""));
			}
		
		ArrayList<String> subal = al.get(al.size()-1);
		String phrase = subal.get(subal.size()-1);
		subal.remove(subal.size()-1);
		System.out.println("size = "+ al.size());
		for (ArrayList<String> string : al) {
			System.out.println("size = "+string.get(0).length()+" element = "+string);
		}
		phrase  = phrase.replace(".", "");
		System.out.println("phrase = "+phrase);
		
		ArrayList<String> phraseAl = new ArrayList<String>(Arrays.asList(phrase.split(" ")));
		
		System.out.println("size = "+ phraseAl.size());
		for (String string : phraseAl) {
			System.out.println("element = "+string);
		}
		
		//Print Result
		String xml = "<file>\n";
		for (ArrayList<String> method : al) 
		{
			xml += "<method name = \""+method.get(0)+"\">\n";
			for (int i = 1; i < method.size(); i++) 
			{
				xml += "<param>\n"+method.get(i)+"</param>\n";
			}
			xml +=	  "</method>\n";
		}
		
		xml += "<niveau>\n"+phraseAl.get(0)+"</niveau>\n";
		xml += "<spec>\n"+phraseAl.get(1)+"</spec>\n";
		xml += "<univ>\n"+phraseAl.get(2)+"</univ>\n";
		xml += "<year>\n"+phraseAl.get(3)+"</year>\n";
		
		xml += "</file>";
		
		FileManager.writeTextIntoFile(xml, "src\\Généréité\\F.xml");
		
		System.out.println("Done !");
		
	}
}
