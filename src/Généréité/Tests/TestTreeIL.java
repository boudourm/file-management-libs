package Généréité.Tests;

import Généréité.ButtonActionExemple;
import Généréité.MenuGenerator;
import Généréité.TreeIL;

public class TestTreeIL 
{
	public static void main(String[] args) 
	{
		//INSERT
		TreeIL<Integer> til = new TreeIL<Integer>();
		
		for (int i = 0; i < 11; i++) {
			System.out.println(til.insert(i));
		}
		
	/*	Node<Integer> noead = new Node<Integer>(12,null,null,til.size());
		til.add(noead);
		til.get(0).setLeftChild(noead);
	//	til.display();
		for (Node<Integer> node : til.treeBrowse()) {
			System.out.println(node.display());
		}
		
		System.out.println(til.isValidTreeIL());
		*/
		
		//til.display();
	/*
		Node<Integer> noead = new Node<Integer>(-10,null,null,til.size());
		til.add(noead);
		til.get(6).setLeftChild(noead);
		System.out.println(til.minValue());
		System.out.println(til.isValidTreeIL());
	
	*/
		/*
		til.insert(-1);
		Node<Integer> noead = new Node<Integer>(45,null,null,til.size());
		til.get(til.size()-1).setRightChild(noead);
		til.add(noead);

		
		System.out.println(til.minValue());
		System.out.println(til.isValidTreeIL());
*/
/*		
		System.out.println("SER ! ");
		til.saveTree();
		
		til.readTree().display();
	*/
		/*
		System.out.println(til.toXml());*/
		
		/*
		til.saveXml();
		*/
		
		/*System.out.println(Introspector.constructorsOf(TreeIL.class));
		System.out.println(Introspector.interfacesOf(TreeIL.class));
		System.out.println(Introspector.declaredAttributesOf(TreeIL.class));
		System.out.println(Introspector.methodsOf(TreeIL.class));
		System.out.println(Introspector.superClassOf(TreeIL.class));
		*/
		//System.out.println(TreeIL.class.getName());
		/*
		System.out.println("INSERT OF DUPLICATE VALUE : ");
		til.insert(6);
		til.display();
		*/
		/*
		try {
			System.out.println(FileManager.readTextFromFile("src\\Généréité\\CustomExceptions\\exceptions_log.txt"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		for (Node<Integer> node : til)
		{	try {
				System.out.println("\n"+Introspector.xmlStringFromObject(node, false));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		/*
		TreeIL<Integer> til2 = new TreeIL<Integer>();
		til2 = til;
		
		try {
			
			System.out.println("SERIALISATION 1! ");
			FileManager.serializeObjectIntoFile(til, "src\\tree.ser");
			System.out.println("DESERIALISATION 1! ");
			ArrayList<Object> al = FileManager.deserializeMultipleObjectsFromFile("src\\tree.ser");
			for (Object tree : al) {
				((TreeIL<?>) tree).display();
			}
			System.out.println("SERIALISATION 2! ");
			FileManager.serializeObjectIntoFile(til2, "src\\tree.ser");
			System.out.println("DESERIALISATION 2! ");
			for (Object tree : FileManager.deserializeMultipleObjectsFromFile("src\\tree.ser")) {
				((TreeIL<?>) tree).display();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		try {
			int x = 12/0;
		}
		catch(Exception e) 
		{
			ExceptionHandler eh = new ExceptionHandler(LocalDateTime.now(),TestTreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e);
			try {
				System.out.println(Introspector.xmlStringFromObject(eh, false));
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		*/
		/*
		try {
			m4(12,0);
		}
		catch(Exception e) 
		{
			for (StackTraceElement ste : e.getStackTrace()) 
			{
				System.out.println(Introspector.xmlStringFromObject(ste, false));
				System.out.println(ste);
				System.out.println("\t"+ste.getLineNumber()+"\n"+
						           "\t"+ste.getClassName()+"\n"+
						           "\t"+ste.getMethodName()+"\n"+
						           "\t"+ste.getClass().getPackage().getName());
			}
			*/
		/*
		try {
			m4(12,0);
		}
		catch(Exception e) 
		{
			ExceptionHandler eh = new ExceptionHandler(LocalDateTime.now(),TestTreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e);
			System.out.println(eh.stackTraceAsXml());
		}
		*/
		
		/*
		for (Node<Integer> node : til)
		{	try {
				System.out.println("\n"+Introspector.xmlStringFromObject(node, false));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		/*
		try {
			m4(12,0);
		}
		catch(Exception e) 
		{
			ExceptionHandler eh = new ExceptionHandler(LocalDateTime.now(),TestTreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e);
			System.out.println(eh.stackTraceAsXml());
			eh.logException();
			System.out.println(eh.getLoggedExceptions());
		}

		*/
		
		/*
		try {
			
			MenuGenerator.formFromClass(ButtonActionExemple.class).setVisible(true);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	
	public static void m1(int a,int b) {int x = a/b;}
	public static void m2(int a,int b) {m1(a,b);}
	public static void m3(int a,int b) {m2(a,b);}
	public static void m4(int a,int b) {m3(a,b);int x = a/b;}
	
}
