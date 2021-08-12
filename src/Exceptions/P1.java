package Exceptions;

import java.sql.Date;


public class P1 {
	int x=20;
	int y=30;
	
	//Constructor 
	public P1(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//Getters and Setters
	public int getY(){
		return this.y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public static void main(String[] args) {
		
		int a=5;
		int b=7;
		int k;
			for (int i=0;i<= 10;i++){
				try {
					k = a/(b-i);
					System.out.println(i);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
					System.out.println(e.getMessage());
					System.out.println("24/02/2019  \n"+e.toString()+" \n P1.Main.Exception e");
				}
			}
			
			
		
		
		
		
		
	}

}
