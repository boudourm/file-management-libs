package Collections;

public class Test {
	public static void main(String[] args) {
		
		//Creation
		TreeIL til = new TreeIL(0);
		
		til.insert(1);
		til.insert(2);
		til.insert(3);
		til.insert(4);
		til.insert(5);
		til.insert(6);
		til.insert(7);
		
		System.out.println(til.find(3).intValue());
		
		//til.saveElements();
		til.saveTree();
		
		til.removeAll(til);
		
		til.display();
		
		//til.readElements();
		
		til.addAll(TreeIL.readTree());
		
		til.display();
		
		til.saveXml();
		
		System.out.println(til.toXml());
		
		
		
	}
}
