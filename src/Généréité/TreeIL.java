package Généréité;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Généréité.CustomExceptions.DuplicateNodeException;
import Généréité.CustomExceptions.GreaterValueFoundInLeftSubTreeILException;
import Généréité.CustomExceptions.LeftChildGreaterThanParentException;
import Généréité.CustomExceptions.LessThanOrEqualValueFoundInRightSubtreeILException;
import Généréité.CustomExceptions.NodeDataTypeIncompatibleInTreeILException;
import Généréité.CustomExceptions.NullNodeDataValueException;
import Généréité.CustomExceptions.NullRootException;
import Généréité.CustomExceptions.OrphanNodeFoundException;
import Généréité.CustomExceptions.RightChildLessThanOrEqualToParentException;

public class TreeIL<Type extends Comparable<Type>> extends ArrayList<Node<Type>> implements Serializable
{
	//Attributes
	private Integer root;
	
	//Constructors
	public TreeIL(Integer val) {
		super();
		this.root = val;
	}
	public TreeIL() {
		super();
		this.root = null;
	}

	//Getters & Setters
	public Integer getRoot() {return root;}
	public void setRoot(Integer root) {this.root = root;}
	
	//Instance Methods
	public Node<Type> rootNode()
	{
		if(this.isEmpty()) return null;
		return this.get(this.getRoot());
	}
	
	public boolean hasRoot() {return this.root != null;}

	public boolean insert(Object x)
	{
		
		try
		{

				@SuppressWarnings("unchecked")
				Node<Type> newNode = new Node<Type>((Type)x);
				newNode.setPosition(this.size());
				this.add(newNode);
				if(!this.hasRoot()) {this.setRoot(0);System.out.println("\nINSERTION\n");this.display(); return true;}
				
				boolean bn =  this.rootNode().insert(newNode,new ArrayList<Node<Type>>());
				newNode.setLeftChild(null); newNode.setRightChild(null);
				System.out.println("\nINSERTION\n");this.display();
				return bn;


			
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			if(e instanceof DuplicateNodeException)
				this.remove(this.size()-1);
			return false;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Integer find(Object x)
	{
		try
		{
				if(this.isEmpty()) return null;
				return this.indexOf(this.rootNode().find((Type)x));	
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			if(e instanceof ClassCastException)
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),new NodeDataTypeIncompatibleInTreeILException(x.getClass()))).logException();
			return null;
		}
		
	}
	
	public Type maxValue()
	{
		Node<Type> node = this.rootNode();
		if(node != null) 
		{
			while(node.getRightChild()!=null) 
				node = node.getRightChild();
			return node.getData();
		}
		else return null;
	}
	
	public Type minValue()
	{
		Node<Type> node = this.rootNode();
		if(node != null) 
		{
			while(node.getLeftChild()!=null) 
				node = node.getLeftChild();
			return node.getData();
		}
		else return null;
	}
	
	public ArrayList<Node<Type>> treeBrowse()
	{
		return treeBrowse(this.rootNode(), new ArrayList<Node<Type>>()) ;	
	}
	
	public ArrayList<Node<Type>> treeBrowse(Node<Type> root, ArrayList<Node<Type>> browse)
	{
		browse.add(root);
		if(root.getLeftChild()!=null)  browse = this.treeBrowse(root.getLeftChild(),browse);
		if(root.getRightChild()!=null) browse = this.treeBrowse(root.getRightChild(),browse);
		return browse;
	}
	
	public boolean isValidTreeIL()
	{
		try
		{
			ArrayList<Node<Type>> treeBrowse = this.treeBrowse();
			for (Node<Type> node : this) 
			{
				if(node.getData()==null) throw new NullNodeDataValueException();
				if(!treeBrowse.contains(node)) throw new OrphanNodeFoundException(node);
			}
			
			if(this.rootNode()!=null)
			{
				return isValidTreeIL(this.rootNode(), this.minValue(), this.maxValue());
			}
			else
			{
				throw new NullRootException(this.getRoot());
			}

		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();;
			return false;
		}
		
	}
	
	public boolean isValidTreeIL(Node<Type> root, Type min,Type max) 
	{
		
		if(root == null) return true;
		try
		{
		
			if(root.getData().compareTo(min) <0)
			{
				throw new LessThanOrEqualValueFoundInRightSubtreeILException(root, min);
			}
			if(root.getData().compareTo(max) >0)
			{
				throw new GreaterValueFoundInLeftSubTreeILException(root, max);
			}
			
			if(root.getLeftChild()==null && root.getRightChild()==null)
			{	
				return true;}
			
			if(root.getLeftChild()!=null)
				if(root.getData().compareTo(root.getLeftChild().getData())<0)
					throw new LeftChildGreaterThanParentException(root, root.getLeftChild());
			
			if(root.getRightChild()!=null)
				if(root.getData().compareTo(root.getRightChild().getData())>0)
					throw new RightChildLessThanOrEqualToParentException(root, root.getRightChild());
			
			
			boolean leftBst=true,rightBst=true;
			if(root.getLeftChild()!=null)
				{ 
				
				leftBst = isValidTreeIL(root.getLeftChild(), min, root.getData());
				
				}
			if(root.getRightChild()!=null)
				{
				rightBst = isValidTreeIL(root.getRightChild(), root.getData(), max);
				
				}
			
			return leftBst && rightBst;
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return false;
		} 

	}
	
	public void saveElements()
	{
		ObjectOutputStream oos = null;
		
		try
		{
			//Ouverture du Flux ObjectOutputStream
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("src/nodes.txt"))));
			
			//Sérialisons quelques Objets
			for (Node<Type> n : this) {
				oos.writeObject(n);
			}
			
			//Fermeture du Flux De Sortie
			try
			{
				if(oos != null)
					oos.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(oos != null)
					oos.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public  void saveTree()
		{
	ObjectOutputStream oos = null;
			
			try
			{
				FileManager.serializeObjectIntoFile(this, "src\\tree.ser");
			}
			catch(Exception e)
			{
				(new ExceptionHandler(LocalDateTime.now(),TreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			}

		}
	
	@SuppressWarnings("unchecked")
	public void readElements()
	{

		ObjectInputStream ois = null;
		ArrayList<Node<Type>> al = new ArrayList<Node<Type>>();
		
		try
		{
			//Affichage des Données #Déserialisation
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new	FileInputStream(
							new File("src/nodes.txt"))));
			//La Déserialisation peut engendrer une ClassNotFoundException
			try
			{
				
				Object o = ois.readObject();
				int i = 0;
				while(true)
				{
					try
					{
						al.add((Node<Type>) o);i++;
						o = ois.readObject();
					}
					catch(EOFException e)
					{
						(new ExceptionHandler(LocalDateTime.now(),TreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
						break;
					}
				}
				
			}
			catch(ClassNotFoundException e)
			{
				(new ExceptionHandler(LocalDateTime.now(),TreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			}
		}
		catch(FileNotFoundException e)
		{
			(new ExceptionHandler(LocalDateTime.now(),TreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();

		}
		catch(IOException e)
		{
			(new ExceptionHandler(LocalDateTime.now(),TreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();

		}
		finally
		{
			try
			{
				if(ois != null)
					ois.close();
			}
			catch(IOException e)
			{
				(new ExceptionHandler(LocalDateTime.now(),TreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();

			}
			
			//Ajout dans la TreeIL
			this.addAll(al);
		}
	}
	
	@SuppressWarnings("finally")
	public static TreeIL<?> readTree()
	{
	
		TreeIL<?> til = new TreeIL();
		
		try
		{
			til = (TreeIL<?>) FileManager.deserializeObjectFromFile("src\\tree.ser");
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),TreeIL.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
		}

		return til;
		
	}
	
	public String toXml()
	{

		try
		{
			return Introspector.xmlStringFromObject(this, false);
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return "<!-- error ocured -->";
		}

	}
	
	public void saveXml()
	{
		try {
				FileManager.appendTextIntoFile(this.toXml(), "src\\Généréité\\xmlFiles\\treeil.xml");	
			} 
		catch (Exception e) 
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
		}
	}
		
	@Override
	public String toString() 
	{
		try
		{
			if(this.isEmpty()) return "TreeIL (empty)\n";
			this.setRoot(0);
			String str =  "TreeIL [root=" + this.get(0).display() + "]\n";
			for (int i = 1; i < this.size(); i++) str = str + "\t" +this.get(i).display() + "\n";
			return str;	
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return "TreeIL (unabee to be diplayed)";
		}
		
		
			
	}
	
	public void display()
	{
		System.out.println("DISPLAY OF TREEIL : \n"+this.toString());
	}
	
	//Introspection
	//Menu 
	/*public void introspectiveMenu()
	{
		sysout
	}*/


}
