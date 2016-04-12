



public class LinkedList<T> {

	
	private LinkedListNode<T> head = new LinkedListNode<T>();
	//private LinkedListNode<T> tail = new LinkedListNode<T>();
	
	
	/**
	 * Get data stored in head node of list.
	 **/
	public T getFirst()
	{
		return head.getData();
	}
	 
	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode()
	{
		return head;
	}
	 
	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast()
	{
		return getLastNode().getData();
	}
	 
	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode()
	{
		LinkedListNode<T> newNude = new LinkedListNode<T>();
		 newNude = head;
		while (newNude.getNext()!=null)
		{
			newNude= newNude.getNext();
		}
		return newNude;
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst( T data )
	{
		LinkedListNode<T> newNude = new LinkedListNode<T>();
		newNude.setNext(head);
		newNude.setData(data);
		head = newNude;
		

	}
	 
	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter( LinkedListNode<T> currentNode, T data )
	{
		 LinkedListNode<T> newNude = new LinkedListNode<T>();
		 newNude.setData(data);
		 newNude.setNext(currentNode.getNext());
		 currentNode.setNext(newNude);

	}
	 
	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	
	public void insertLast( T data )
	{// create a newNode to hold the new data
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		// set its data to the one passed in
		 newNode.setData(data);
		if(head==null)
		{
			head = newNode;
		}
		else
		{// let the original tail point to this node
		 getLastNode().setNext(newNode);
		}
	}
	 
	/**
	 * Remove the first node
	 **/
	public void deleteFirst()
	{
		 
		 head = head.getNext();
	}
	 
	/**
	 * Remove the last node
	 **/
	public void deleteLast()
	{
		LinkedListNode<T> newNude = new LinkedListNode<T>();
		newNude = head;
		while (newNude.getNext()!=null)
		{
			newNude= newNude.getNext();
			//getLastNode()= head;
		}
		newNude= null;
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void deleteNext( LinkedListNode<T> currentNode )
	{
		
		currentNode.setNext(currentNode.getNext().getNext());
	}
	 
	/**
	 * Return the number of nodes in this list.
	 **/
	public int size()
	{
		int n = 0;
		 LinkedListNode<T> newNude = new LinkedListNode<T>();
		 newNude = head;
		while (newNude.getNext()!=null)
		{
			n++;
			newNude= newNude.getNext();
		}
		return n;
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty()
	{
		
		if (head.getData()!= null)
		{
			return false;
		}
		else {return true;}
	}
	 
	/**
	 * Return a String representation of the list.
	 **/
	public String toString()
	{
		
		LinkedListNode<T> newNude = new LinkedListNode<T>();
		 newNude = head;
		 String myString = newNude.toString();
		while (newNude.getNext()!=null
				&&newNude.getNext().getData()!=null)
		{
			//myString = newNude.toString();
			myString = myString+" -> "+newNude.getNext().toString();
			
			newNude = newNude.getNext();
		}
		return myString;
	}
	
	/*public static void main (String[] argus)
	{
		LinkedList<String> my = new LinkedList<String>();
		my.insertFirst("this");
		my.insertFirst("this");
		my.insertFirst("this");
		my.insertFirst("this");
		my.insertAfter(my.getFirstNode(),"this2");
		System.out.println(my.toString());
	}*/
	
	
}
