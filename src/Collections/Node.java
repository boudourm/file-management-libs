package Collections;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;





public class Node implements Serializable
{

	//Attributes
	private Integer data;
	private Node leftChild;
	private Node rightChild;
	private Integer position;

	
	//Constructors
	public Node() {
		super();
		this.data = 0;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public Node(Integer data) {
		super();
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public Node(Integer data, Node leftChild, Node rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	//Getters & Setters
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}	
	//Instance Methods

	public boolean insert(Node n)
	{
		
		if(n.getData()<=this.getData())
		{	if(this.getLeftChild()==null)
				{this.setLeftChild(n);return true;}
			else
				{return this.getLeftChild().insert(n);}
		}
		else
		{
			if(this.getRightChild()==null)
			{this.setRightChild(n);return true;}
			else
			return this.getRightChild().insert(n);
		}
		
	}
	
	public Node find(Integer val)
	{
		if(val==this.getData()) return this;
		
		if(this.getLeftChild() != null) 
		{
			Node res = this.getLeftChild().find(val);
			if(res!= null) return res;
		}	
		if(this.getRightChild() != null) 
		{
			Node res = this.getRightChild().find(val);
			if(res!= null) return res;
		}
		
		return null;
		
	}
	
	
	
	public String disp() {
		return "Node [data=" + this.getData() + ", leftChild=" + this.getLeftChild() + ", rightChild=" + this.getRightChild() + "]" +this;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
	
	
	//Static Methods
}
