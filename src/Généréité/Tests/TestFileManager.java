package G�n�r�it�.Tests;

import java.io.IOException;
import java.time.LocalDateTime;

import G�n�r�it�.ExceptionHandler;
import G�n�r�it�.FileManager;
import G�n�r�it�.CustomExceptions.FailedSavingFileUpdateException;

public class TestFileManager 
{
	public static void main(String[] args) 
	{
		try 
		{
			FileManager.appendTextIntoFile("CouCou\n", "C:\\Users\\Moflawer\\Desktop\\Dol_Gul_Dur\\WorkShop_Tree\\JAVA\\Work_Space\\TP_MODAL\\src\\G�n�r�it�\\Tests\\popo.txt");
		} 
		catch (Exception e) 
		{
			(new ExceptionHandler(LocalDateTime.now(),TestFileManager.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();;
		} 
	}
}
