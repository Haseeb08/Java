
package textgen;

import java.util.AbstractList;
//Using inbuilt list calss

/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() 
	{
		// TODO: Implement this metho
		//MyLinkedList<E> ll = new MyLinkedList<E>();
		head=null;
		tail=null;
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		 LLNode<E> node =new LLNode<E>(element);

		// Adding if list is empty			
		 if(head==null  || size = 0)
		 {
			 head=node; 
			 tail=node;
			 size++;
			 return true;
		 }
		// Adding at the ending of list
		
		 else
		 {
			 LLNode<E> tempNode=head;
			// System.out.println(temp);

			 while(tempNode.next!=null)
			 {
				 tempNode=tempNode.next;
			 } 
			 tempNode.next=node;
			 node.prev=tempNode;
			 tail=node;
			 size++;
			 return true;
		 }
		
		
	}


	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		
		LLNode<E> tempNode=head;
		
		try 
	   {
		  if(index<0 || index >= size())
		 throw new IndexOutOfBoundsException();
		
		
				int countI=0;
				while(countI!=index)
				{
					tempNode=tempNode.next;
				
					countI++;
				}
		 
	          return temp.data;
	   }
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> node=new LLNode<E>(element);
		LLNode<E> tempNode=head;

		//Adding at begining
		
		if(index==0)
		{
			node.next=head;
			head.prev=node;
			head=node;
			size++;
		}
		//Adding at end
		else if(index==size)
		{
			while(index!=1)
			{
				tempNode=tempNode.next;
				index-=1;	
			}
			node.prev=tempNode;
			tempNode.next=node;
			tail=node;
			size++;
		}
		
		else
		{
			
			while(index!=1)
			{
				tempNode=tempNode.next;
				index--;	
			}
			node.next=tempNode.next;
			node.prev=tempNode;
			tempNode.next=node;
			node.next.prev=node;
			size++;
		}

	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		try
		{
			
			if(index<0 || index >= size)
				throw new IndexOutOfBoundsException();
			
			
			
		   LLNode<E> tempNode=head;
		if(index==0)
		{
			head=head.next;
			head.prev=null;
			size--;
		}
		else if(index==size()-1)
		{
			tail=tail.prev;
			tail.next=null;
			size--;
		}
		else
		{
		  while(index!=0)
		  {
			tempNode=tempNode.next;
			index--;	
		  }
		  
		  tempNode.prev.next=tempNode.next;
		  tempNode.next.prev=tempNode.prev;
		  size--;
		}
		
		return tempNode.data;
	}
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
			
		}
		return null;
	
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		try 
		{
			  if(index<0 || index>= size())
				  throw new IndexOutOfBoundsException();
			
		E changedElement;
		LLNode<E> tempNode=head;
		while(index!=0)
		  {
			tempNode=tempNode.next;
			index-=1;	
		  }
		changedElement=tempNode.data;
		
		tempNode.data=element;
	
		return changedElement;
	   }
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
			
		}
		return null;
	
	}	
		
		
}		

class LLNode<E> 
{
	LLNode<E> prev;     //Points to previous node
	LLNode<E> next;	    // points to Next node		
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
