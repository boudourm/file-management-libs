package Collections;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Date;

public class TreeIL extends ArrayList<Node> implements Serializable
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
	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}
	
	//Instance Methods
	public Node rootNode(){return this.get(this.getRoot());}
	
	public boolean hasRoot() {return this.root != null;}
	

	public boolean insert(Integer x)
	{
		Node newNode = new Node(x);
		newNode.setPosition(this.size());
		this.add(newNode);
		if(!this.hasRoot())this.setRoot(0);
		
		boolean bn =  this.rootNode().insert(newNode);
		newNode.setLeftChild(null); newNode.setRightChild(null);
		return bn;
	}
	
	public Integer find(Integer x)
	{
		if(this.isEmpty()) return null;
		return this.indexOf(this.rootNode().find(x));
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
			for (Node n : this) {
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
	
	public void readElements()
	{

		ObjectInputStream ois = null;
		ArrayList<Node> al = new ArrayList<Node>();
		
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
						al.add((Node) o);i++;
						o = ois.readObject();
					}
					catch(EOFException e)
					{
						break;
					}
				}
				
			}
			catch(ClassNotFoundException e)
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
				if(ois != null)
					ois.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			//Ajout dans la TreeIL
			this.addAll(al);
		}
	}
	
	public void display()
	{
		System.out.println("DISPLAY OF TREEIL : \n");
		for (Node n : this) System.out.println(""+n.disp());
	}
	
	public  void saveTree()
	{
ObjectOutputStream oos = null;
		
		try
		{
			//Ouverture du Flux ObjectOutputStream
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("src/tree.txt"))));
			
			//Sérialisons quelques Objets
			
				oos.writeObject(this);
			
			
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
	
	public static TreeIL readTree()
	{

		ObjectInputStream ois = null;
		TreeIL til = new TreeIL();
		
		try
		{
			//Affichage des Données #Déserialisation
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new	FileInputStream(
							new File("src/tree.txt"))));
			//La Déserialisation peut engendrer une ClassNotFoundException
			try
			{
				
				Object o = ois.readObject();
				til = (TreeIL) o;
				
			}
			catch(ClassNotFoundException e)
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
				if(ois != null)
					ois.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			//Ajout dans la TreeIL
			return til;
		}
	}
	
	public String toXml()
	{
		String xml = "<treeIl>\n\n";
		for (Node node : this) 
		{
			int left=0,right=0;
			if(node.getLeftChild() == null) left = -1;
			else left = node.getLeftChild().getPosition();
			if(node.getRightChild() == null) right = -1;
			else right = node.getRightChild().getPosition();
			
			xml = xml + "<node>	\n<leftChild>"+left+""
					+ "\n</leftChild>\n <rightChild>\n"+right+""
							+ "\n</rightChild>\n<data>\n"+node.getData()+"\n"
									+ "</data>\n</node>\n\n";
		}
		xml = xml + "</treeIl>";
		return xml;
		
	}
	
	public void saveXml()
	{
		File f = null;
		try {
			f = new File("src/essai.xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));

				try {
					bw.append(this.toXml());

				} catch (Exception e) {
					// TODO: handle exception
					
				}
						
			bw.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}


}
