package Exceptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.Date;



public class LectureEcritureFichierTextTest {
	
	public static void main(String[] args) {
		
		File f = null;
		try {
			f = new File("C:\\Documents and Settings\\TITOUCHE\\workspace\\TP_MODAL\\exception.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			//bw.append("Exceptions File :\n\n");
			
			int a=5;
			int b=7;
			int k;
			for (int i=0;i<= 10;i++){
				try {
					k = a/(b-i);
					System.out.println(i);
				} catch (Exception e) {
					// TODO: handle exception
					bw.append(e.toString()+"  "+new Date()+"  public static void LectureEcritureFichierTextTest.Main");
				}
			}
			
			System.out.println(OperatingSystemMXBean.class.getName());;
			
			bw.close();
			
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
