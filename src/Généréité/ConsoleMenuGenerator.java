package Généréité;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConsoleMenuGenerator 
{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException 
	{
		
		TreeIL til = new TreeIL();
		boolean b = true;
		//EVERY MENU EVER
			while(b)
			{
				//Title
				System.out.println("TREEIL MINI APP MENU\n");
				System.out.println("[1] INSERTION .\n"+
								   "[2] FIND .\n"+
								   "[3] SERIALIZE .\n"+
								   "[4] SAVE XML .\n"+
								   "[5] DISPLAY TREE .\n"+
								   "[6] INTROSPECTION .\n"+
								   "[7] DESERIALIZE .\n");
				
				int i = sc.nextInt();
				sc.nextLine();
				
				switch (i) {
					case 1:
						//Insertion =============================================
						System.out.println("INSERTION d'un Noeud:\n");
						Class classe = null;/* CLAAAAAAAAAAAAASSSSSS  */
						Object o = classe.getDeclaredConstructor(null).newInstance();
						Field[] fields = classe.getDeclaredFields();
						Map<String,Field> map = new HashMap<String,Field>();
						for (int i1 = 0; i1 < fields.length; i1++) 
						{
							String name = fields[i1].getName();
							map.put(name, fields[i1]);
						}
						System.out.println("Entrez les attributs : \n");
						for (Map.Entry<String,Field> entry : map.entrySet())
						{
							entry.getValue().setAccessible(true);
							try 
							{
								System.out.println(entry.getKey()+" : ");
								entry.getValue().set(o,sc.nextLine());
								sc.nextLine();
							} 
							catch (Exception e) 
							{
								(new ExceptionHandler(LocalDateTime.now(),MenuGenerator.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();

							} 
						}
						
						til.insert(o);
						
						//========================================================

						break;
					case 2:
						
						//FIND==================================================
						System.out.println("FIND : \n");
						System.out.println("Entrez l'attribut Clé : ");
						Integer integ = til.find(sc.nextLine());
						if (integ == null) {
							JOptionPane.showMessageDialog(new JFrame(), "Recherche infructueuse", "Dialog",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							System.out.println(til.get(integ));
						}
						
						//========================================================
						break;
					
					case 3:
						//SERIALIZE==================================================
						til.saveTree();
						System.out.println("GO check the File :  src\\\\tree.ser");
						//=======================================================
						
						break;
					case 4:
						//SAVE XML==================================================
						til.saveXml();
						System.out.println("\nGO check the File :  xmlFiles\\\\treeil.xml");
						//=======================================================
						break;
					case 5:
						//Display==================================================
						til.display();
						System.out.println("\n");
						//=======================================================
						break;
					case 6:
						//INTROSPECTION==================================================
						til.saveTree();
						System.out.println("Introspection Info,");
						//=======================================================
						break;
						
					case 7:
						//DESERIALIZE==================================================
						System.out.println("DESERIALIZATION:");
						til = til.readTree();
						til.display();
						//=======================================================
						break;	
						
						
						
						
						
						
					default: b = false;
						break;
				}
								
			}
	}
}
