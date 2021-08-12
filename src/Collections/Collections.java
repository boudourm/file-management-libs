package Collections;



import java.util.List; 
import java.util.ArrayList;
import java.util.Enumeration; //Interface
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Iterator;


public class Collections
{
	public static void main(String[] args)
	{
		//--------------------Les LIST---------------
		
		// -------------------LINKEDLIST-------------------------
		List l = new LinkedList() ;
		 l.add(12);
		 l.add("toto") ;
		 l.add(12.20f);
		 
		 for (int i = 0; i < l.size() ; i++)
		 {
			 System.out.println("�l�ment � l'index "+i+" = "+l.get(i));
		 }
		 
		 System.out.println("\n\tParcours avec un ITERATOR : ");
		 System.out.println("---------------------------------");
		 ListIterator li = l.listIterator() ;
		 
		 while(li.hasNext())
		 {
			 System.out.println(li.next());
		 }
		 
		 /*
		  add() permet d'ajouter un �l�ment ;

		get(int index) retourne l'�l�ment � l'indice demand� ;

		remove(int index) efface l'entr�e � l'indice demand� ;

		isEmpty() renvoie � vrai � si l'objet est vide ;

		removeAll() efface tout le contenu de l'objet ;

		contains(Object element) retourne � vrai � si l'�l�ment
		 pass� en param�tre est dans l'ArrayList.
		 */
		//---------------------ARRAYLIST----------------------------
		 l = new ArrayList() ;
		 l.add(12);
		 l.add("toto") ;
		 l.add(12.20f);
		 
		 for (int i = 0; i < l.size() ; i++)
		 {
			 System.out.println("�l�ment � l'index "+i+" = "+l.get(i));
		 }
		 
		 System.out.println("\n\tParcours avec un ITERATOR : ");
		 System.out.println("---------------------------------");
		  li = l.listIterator() ;
		 
		 while(li.hasNext())
		 {
			 System.out.println(li.next());
		 }
		 
		 //----------------------HASHTABLE------------------------
		 						//(Thread Safe) utilisation simultan�e sans Conflicts
		 System.out.println("------------HASHTABLE");
		 Hashtable ht = new Hashtable() ;
		 
		 ht.put(1, "Printemps") ;
		 ht.put(2, "�t�");
		 ht.put(4, "Automne");
		 ht.put(8, "Hiver");
		 
		 Enumeration e = ht.elements();
		 
		 while (e.hasMoreElements()) 
			 System.out.println(e.nextElement());
		 
		 /*
		  isEmpty() retourne � vrai � si l'objet est vide ;

		contains(Object value) retourne � vrai � si la valeur 
		est pr�sente. Identique � containsValue(Object value) ;

		containsKey(Object key) retourne � vrai � si la cl� pass�e 
		en param�tre est pr�sente dans la Hashtable ;

		put(Object key, Object value) ajoute le couple key - value dans l'objet ;

		elements() retourne une �num�ration des �l�ments de l'objet ;

		keys() retourne la liste des cl�s sous forme d'�num�ration.
		  * */
		
	//----------------HASHMAP = HASHTABLE + (Accept NULL) - (THREAD SAFE)
	
	//-------------------------les SET (pas de doublons pas de NULL)-------------------
	//------------------------------HASHSET------------------------
		 System.out.println("----------HASHSET");
		 HashSet hs = new HashSet() ;
		 
		 hs.add(12);
		 hs.add("une Chaine de caract�res");
		 hs.add(1.30f);
		 hs.add('d');
		 
		 Iterator it  =  hs.iterator() ;
		 while (it.hasNext()) 
			System.out.println(it.next());
		 
		 for (Object object : hs.toArray())
		 {
			 System.out.println(object);
		 }
		 
		 /*
		  add() ajoute un �l�ment ;

		contains(Object value) retourne � vrai � si l'objet contient value ;

		isEmpty() retourne � vrai � si l'objet est vide ;

		iterator() renvoie un objet de type Iterator ;

		remove(Object o) retire l'objet o de la collection ;

		toArray() retourne un tableau d'Object.
		  * */
		 
		 /*Astuces*/
		 /*
		  * Si vous ins�rez fr�quemment des donn�es en milieu 
		  * de liste, utilisez une LinkedList.

			Si vous voulez rechercher ou acc�der � une valeur via 
			une cl� de recherche, optez pour une collection de type Map.

			Si vous avez une grande quantit� de donn�es � traiter,
		 	tournez-vous vers une liste de type Set.
		  * */
		 //----------------------HASHTABLE------------------------
		
		 Map<Integer , String> map = new HashMap<>();
		 
		 map.put(1, "un");
		 map.put(2, "deux");
		 map.put(3, "trois");
		 map.put(4, "quatre");
		 map.put(5, "cinque");
		 map.put(6, "six");		
		 map.put(7, "sept");
		 
		 	
		
		 
		 
		 
	}
}
