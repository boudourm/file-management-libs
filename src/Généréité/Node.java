package Généréité;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import Généréité.CustomExceptions.DuplicateNodeException;



/*Akhdam*/

public class Node<Type extends Comparable<Type>> implements Serializable
{

	
	//Attributes
	private Type data;
	private Node<Type> leftChild;
	private Node<Type> rightChild;
	private Integer position;

	
	//Constructors
	public Node() {
		super();
		this.data = null;
		this.leftChild = null;
		this.rightChild = null;
		this.position = -1;
	}
	
	public Node(Type data) {
		super();
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public Node(Type data, Node<Type> leftChild, Node<Type> rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public Node(Type data, Node<Type> leftChild, Node<Type> rightChild, Integer position) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.position = position;
	}
	//Getters & Setters
	public Type getData() {
		return data;
	}
	public void setData(Type data) {
		this.data = data;
	}
	public Node<Type> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node<Type> leftChild) {
		this.leftChild = leftChild;
	}
	public Node<Type> getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node<Type> rightChild) {
		this.rightChild = rightChild;
	}	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	//Instance Methods

	public boolean insert(Node<Type> n, ArrayList<Node<Type>> browse) throws Exception
	{
		browse.add(this);
		try
		{
			for (Node<Type> node : browse)
			if(n.getData().equals(node.getData()))
				throw new DuplicateNodeException(n);
			
			if(n.getData().compareTo(this.getData())<=0)
			{	if(this.getLeftChild()==null)
					{this.setLeftChild(n);return true;}
				else
					{return this.getLeftChild().insert(n,browse);}
			}
			else
			{
				if(this.getRightChild()==null)
				{this.setRightChild(n);return true;}
				else
				return this.getRightChild().insert(n,browse);
			}
		}
		catch(Exception e)
		{
			if(e instanceof DuplicateNodeException)
				throw e;
			else
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return false;
		}
		
		
	}
	
	public Node<Type> find(Type val)
	{
		try
		{
			if(val.equals(this.getData())) return this;
			
			if(this.getLeftChild() != null) 
			{
				Node<Type> res = this.getLeftChild().find(val);
				if(res!= null) return res;
			}	
			if(this.getRightChild() != null) 
			{
				Node<Type> res = this.getRightChild().find(val);
				if(res!= null) return res;
			}
			
			return null;
		}
		catch(Exception e)
		{
			(new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),e)).logException();
			return null;
		}
		
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
			return "\n<!-- emply xml string -->\n";
		}

	}
	
	public String display() {
		return "Node [position = "+this.position+", data=" + this.getData() + ", leftChild =  " + ( this.getLeftChild() == null ? null : "in position"+this.getLeftChild().getPosition()) + ", rightChild = " + ( this.getRightChild() == null ? null : "in position"+this.getRightChild().getPosition()) + "]" ;
	}

	@Override
	public String toString() {
		return "Node [position = "+this.position+", data=" + this.getData() + ", leftChild =  " + ( this.getLeftChild() == null ? null : "in position"+this.getLeftChild().getPosition()) + ", rightChild = " + ( this.getRightChild() == null ? null : "in position"+this.getRightChild().getPosition()) + "]" ;
	}
	
	
	//Static Methods
}
