package Exceptions;


public class TestException {
	
	public void AffichePair(int n) throws ILException {
		if (n == 0) throw new ILException("Le 0 n'est ni pair ni impair");
		for (int i=2;i<=n;i++){
			if(i%2 ==0) System.out.println(i);
		}
	}
	
	public static void main(String[] args) throws ILException {
		/*try {
			//1er bloc
			int n=0;
			TestException exp = new TestException();
			exp.AffichePair(n);
		} catch (ILException e) {
			//
			// TODO: handle exception
			System.out.println(e.getMessage());
		}*/

			int n=0;
			TestException exp = new TestException();
			exp.AffichePair(n);
		
			
		
	}

}
