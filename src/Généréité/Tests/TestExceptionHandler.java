package G�n�r�it�.Tests;

import java.time.LocalDateTime;

import javax.management.modelmbean.DescriptorSupport;

import G�n�r�it�.ExceptionHandler;

public class TestExceptionHandler 
{
	public static void main(String[] args) 
	{
		ExceptionHandler eh = new TestExceptionHandler().newExceptionHandler(0, 0, null, null);
		eh.logException();
		System.out.println("done");
	}
	
	
	public ExceptionHandler newExceptionHandler(int a,Integer b,Object c , DescriptorSupport dsk)
	{
		return new ExceptionHandler(LocalDateTime.now(),this.getClass(),(new Object() {}).getClass().getEnclosingMethod(),new Exception());
		
	}
}
