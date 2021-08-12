package Exceptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;



public class SaveExceptionTest implements Serializable{

public static void main(String[] args) {
		
		File f = null;
		try {
			

			
			int a=5;
			int b=7;
			int k;
			for (int i=0;i<= 10;i++){
				try {
					k = a/(b-i);
					System.out.println(i);
				} catch (Exception e) {
					// TODO: handle exception
					//bw.append(e.toString()+"  "+new Date()+"  public static void LectureEcritureFichierTextTest.Main");
					SaveException se = new SaveException(new Date() , "LectureEcritureFichierTextTest","Main",e.toString());
					se.save();
				}
			}
			
			
			

			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

}
