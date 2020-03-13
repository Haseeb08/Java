package textgen;

public class LinkedListAdd 
{
	
public static void  main(String[] args)
	{
		MyLinkedList<Integer> Llist=new MyLinkedList<Integer>();
		// Adding at the end of list.			
		Llist.add(11);
		ll.add(12);
		ll.add(13);
		Llist.add(14);
		Llist.add(15);
		//Adding at particular Index.
		Llist.add(1,9);
		Llist.add(2,10);

		System.out.println("Size of List : "+Llist.size());  //7
		//Printing the list
		for(int i=0;i<7;i++)		
		System.out.println(Llist.get(i));
		
		//Changing Items of list

		System.out.println("changed element"+ll.set(2,20));
		
		for(int i=0;i<7;i++)		
		System.out.println(Llist.get(i));
		
	}

	
}
