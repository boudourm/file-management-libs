package Généréité.Tests;

import java.io.IOException;
import java.time.LocalDateTime;

import Généréité.ExceptionHandler;
import Généréité.FileManager;
import Généréité.CustomExceptions.FailedSavingFileUpdateException;

public class TestFileManager 
{
	public static void main(String[] args) 
	{
		try 
		{
			FileManager.appendTextIntoFile("CouCou\n", "C:\\Users\\Moflawer\\Desktop\\Dol_Gul_Dur\\WorkShop_Tree\\JAVA\\Work_Space\\TP_MODAL\\src\\Généréité\\Tests\\popo.txt");
		} 
		catch (Exception e) 
		{
			(new ExceptionHandler(LocalDateTime.now(),TestFileManager.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();;
		} 
	}
}
