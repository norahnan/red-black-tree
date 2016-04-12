import java.awt.Color;
import java.util.Queue;





public class RedBlackBST<T extends Comparable<T>> {
	
	//the root node
	private RedBlackBSTNode<T> root;
	
	/**constructor**/
	public RedBlackBST()
	{
		//initialise the root
		this.root = new RedBlackBSTNode<T>();
		//set the root color to be black
		root.SetC(false);
		//set it parent to point to a null node
		RedBlackBSTNode<T> a = new RedBlackBSTNode<T>();
		//a = null;
		root.setP(a);
	}
	
	/**get the root of the tree**/
	public RedBlackBSTNode<T> getRoot()
	{
		//return the root node
		return root;
	}
	
	/**insert an element**/
	public void insert(RedBlackBSTNode<T> z)
	{
		//create two nodes
		RedBlackBSTNode<T> y = new RedBlackBSTNode<T>();
		//RedBlackBSTNode<T> y = null;

		RedBlackBSTNode<T> x = this.getRoot();
		
		//while the root is not null
		while(!x.isNull())
		{
			//set y to be the root
			y = x;
			//check if z < x
			if(z.getD().compareTo(x.getD())<0)
			{
				//set x to be its left child
				/*if( x.getLeftC()!=null)
				{*/
					x = x.getLeftC();

				//}
			}
			else
			{
				//if(x.getRightC()!=null)
				//{
					x = x.getRightC();

				//}
				//set x to be its right child
			}
		}
		//set the y to be the parent of the new node
		z.setP(y);
		
		//if we did not enter the while loop and y is still null,
		//which means the root is null
		if(y.isNull())
		{
			//set z to be the root
			this.root = z;
			y =new RedBlackBSTNode<T>();
			z.setP(y);
		}
		//Z<Y if new node is smaller than y
		else if (z.getD().compareTo(y.getD())<0)
		{
			//set the new node to be the left child of y
			y.setLeftC(z);
					
		}
		else
		{
			//set the new node to be the right child of z
			y.setRightC(z);
		}
		//creating the null nodes
		RedBlackBSTNode<T> l = new RedBlackBSTNode<T>();
		RedBlackBSTNode<T> r = new RedBlackBSTNode<T>();
		//r= null;
		//l= null;
		
		//set new node's children  to be pointing to null nodes
		z.setLeftC(l);
		z.setRightC(r);
		//set the color of z to e true
		z.SetC(true);
		
		insertFix(z);
		
	}
	
	
	
	/**fix the order after inserting an element**/
	public void insertFix(RedBlackBSTNode<T> z)
	{
		//create a temp node
		RedBlackBSTNode<T> y = null;

		
		//while the parent of z is a red node
		while (z.getP().getC())
		{
			//z's parent is a left child
			if(z.getP().equals(z.getP().getP().getLeftC()))
			{
				//set y to be the brother of z
				y= z.getP().getP().getRightC();
				
				//if y is a red node
				if(y.getC())
				{
					//set the parent of z to be black
					z.getP().SetC(false);
					//set y's color to be black
					y.SetC(false);
					//set z's grandparent to be red
					z.getP().getP().SetC(true);
					//set z to its grand parent
					z=  z.getP().getP();
				}
				//else if z is a right child
				else {
					if (z.equals(z.getP().getRightC())) {
						// set z to be its parent
						z = z.getP();
						// left rotate around node z
						leftR(z);
					}
					// set the parent of z to be black
					z.getP().SetC(false);
					// set z 's grand parent to be red
					z.getP().getP().SetC(true);
					// right rotate around the node z's grand parent
					rightR(z.getP().getP());
				}
			}
			else
			{
				//set y to be the left uncle of z
				y= z.getP().getP().getLeftC();
				
				//if y is a red node
				if(y.getC())
				{
					//set the parent of z to be black
					z.getP().SetC(false);
					//set y's color to be black
					y.SetC(false);
					//set z's grandparent to be red
					z.getP().getP().SetC(true);
					//set z to its grand parent
					z=  z.getP().getP();
				}
				//else if z is a left child
				else {
					if (z.equals(z.getP().getLeftC())) {
						// set z to be its parent
						z = z.getP();
						// right rotate around node z
						rightR(z);
					}
					// set the parent of z to be black
					z.getP().SetC(false);
					// set z 's grand parent to be red
					z.getP().getP().SetC(true);
					// left rotate around the node z's grand parent
					leftR(z.getP().getP());
				}
			}
		}
		
		
		//set the root to be black
		this.root.SetC(false);
		
		
	}
	
	/** rotate the tree towards the left **/
	public void leftR(RedBlackBSTNode<T> z) {
		// create a temp node
		RedBlackBSTNode<T> y = z.getRightC();
		// turn y's sub tree into z's subtree
		z.setRightC(y.getLeftC());
		// if y's left child is not null
		if (!(y.getLeftC().isNull())) {
			// set y's left child's parent to be z
			y.getLeftC().setP(z);
		}
		// link x's parent to y
		y.setP(z.getP());
		//if the parent of z is null
		if (z.getP().isNull()) {
			//set y to be the root of the tree
			this.root = y;
		}
		//if z is a left child
		else if (z.equals(z.getP().getLeftC())) {
			//set y to be the left brother of z
			z.getP().setLeftC(y);
		}
		
		else {
			//set y to be the right brother of z
			z.getP().setRightC(y);
		}
		// set y's left child to be x
		y.setLeftC(z);
		// set x's parent to be y
		z.setP(y);
	}
	
	/** rotate the tree towards the right **/
	public void rightR(RedBlackBSTNode<T> z) {
		// create a temp node
		RedBlackBSTNode<T> y = z.getLeftC();
		// turn y's sub tree into z's subtree
		z.setLeftC(y.getRightC());
		// if y's right child is not null
		if (!(y.getRightC().isNull())) {
			// set y's right child's parent to be z
			y.getRightC().setP(z);
		}
		// link x's parent to y
		y.setP(z.getP());
		// if the parent of z is null
		if (z.getP().isNull()) {
			// set y to be the root of the tree
			this.root = y;
		}
		// if z is a right child
		else if (z.equals(z.getP().getRightC())) {
			// set y to be the right brother of z
			z.getP().setRightC(y);
		}

		else {
			// set y to be the left brother of z
			z.getP().setLeftC(y);
		}
		// set y's right child to be x
		y.setRightC(z);
		// set x's parent to be y
		z.setP(y);
	}
	
	/**search for a specific data and return the node**/
	public RedBlackBSTNode<T> search(T data)
	{
		//recursive search
		//return the node if data is found or null
		
		RedBlackBSTNode<T> temp = null;
		temp = this.root.search(data);

		return temp;
	}
	
	/**set the root of the tree**/
	public void setRoot(RedBlackBSTNode<T> a)
	{
		this.root = a;
	}
	
	
	
	
	
	/** test if all the node has right black height **/
	public boolean validateBlackHeight(RedBlackBSTNode<T> t)
	{
		
		// create a temporary node
		RedBlackBSTNode<T> temp = new RedBlackBSTNode<T>();
		// set temp to be input node
		temp = t;
		//if temp is not a leaf
		if(!temp.equals(null))
		{
			//check if black height of this node is correct
			if(! temp.isBHright())
			{
				return false;
				
			}
			validateBlackHeight(temp.getLeftC());
			validateBlackHeight(temp.getRightC());
			/*//check for its left child and right child
			if (!validateBlackHeight(temp.getLeftC())||!validateBlackHeight(temp.getRightC()))
			{
				return false;
			}*/
			
		}
		
		
		//return true if we do not find wrong black height
		return true;
	}
	
	
	 /**
	   * Search for data in the tree, finding the node
	   * containing it, or null if the data is not present
	   * in the tree.
	   * return the node containing data or null if none exists.
	   */
	  public RedBlackBSTNode<T> search1( T data )
	  {	
		  // if the tree is empty return null
		  if (this.getRoot().equals(null))
		  {
			  return null;
		  }
		  //pass in the root of the tree to represent the tree and begin the search if the tree is not null
		  RedBlackBSTNode<T> newNode = new RedBlackBSTNode<T>();
		  newNode=root;
		  return search(newNode,data);
		  
	  }
	  
	  
	  private RedBlackBSTNode<T> search(RedBlackBSTNode<T> node,T data)
	   {
		  // check the node
		  if (node == null)
			   return null;
		  
		  // base case
		  //when the root/the node passed in is the node we are looking for
		 if(node.getD() == data)
			 return node;
		 
		 //int to record the relative maginitude 
		  int myInt = node.getD().compareTo(data);
		  //when we need to find a smaller value, check the left children of the node
		  if(myInt>0)
		  {
			  
			  return search(node.getLeftC(),data);
		  }
		  //when we need to find a larger value, check the right children of the node
		  else
		  {
			  return(search(node.getRightC(),data));
		  }
	   }
	  
	  
		
		
		
		
	public void printT(RedBlackBSTNode<T> a) {
		// make a temp node
		RedBlackBSTNode<T> newNode = new RedBlackBSTNode<T>();

		/*String m;
		m = q;*/
		newNode = a;
		if (newNode != null) {
			System.out.print(newNode.getD() + " " + newNode.getColorString()
					+ " ");
			/*m = m+ newNode.getD() + " " + newNode.getColorString()
					+ " ";*/

		}
		if (newNode.getLeftC() != null) {
			printT(newNode.getLeftC());

		}
		if (newNode.getRightC() != null) {
			printT(newNode.getRightC());

		}
		//return m;

	}
	
	public void printTree()
	{
		printT(this.getRoot());
		//System.out.println("This is "+ this.printT(this.getRoot(),""));
	}
		
	  
	  /**main method**/
	public static void main(String[] args ) {
		
		//System.out.println("hello java");
		
		// create the tree object
		RedBlackBST myTree = new RedBlackBST<String>();
		// create and insert the first node
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>("A");
		RedBlackBSTNode<String> a = new RedBlackBSTNode<String>("B");

		//z.setData("just for search");

		myTree.insert(z);
		myTree.insert(a);

		//myTree.printTree();
		//
		RedBlackBSTNode<String> a1 = new RedBlackBSTNode<String>("D");
		myTree.insert(a1);

		//System.out.println(myTree.getRoot().getD());
		RedBlackBSTNode<String> a2 = new RedBlackBSTNode<String>("F");
		myTree.insert(a2);
		//System.out.println(myTree.validateBlackHeight(myTree.getRoot()));
		//myTree.printTree();

		//myTree.insert(a);

		//System.out.println("This is root:  "+myTree.getRoot().getD());
		//myTree.printTree();
		/*Generate a sequence of random numbers and store them in an array,
		create a new RedBlackBST instance
		start timing insertion,
		insert the sequence of random numbers stored in the array into the Red-Black Tree in order,
		end timing and store the time to insert,
		start timing search,
		perform search on each of the elements in sequence,
		end timing and store  the time to search,
		display the time to complete all of the insertions,
		display the time to complete all of the searches.*/

		final int TEST_LENGTH = 1000000;
		Integer[] random = new Integer[TEST_LENGTH];
		for (int i = 0; i < random.length; i++) {
			Integer r = (Integer) (int) (Math.random() * random.length);
			random[i] = r;
		}
		RedBlackBST<Integer> tree = new RedBlackBST<Integer>();

		long startTime = System.nanoTime();

		// DO SOME STUFF
		for (int i = 0; i < random.length; i++) {
			RedBlackBSTNode<Integer> newNode = new RedBlackBSTNode<Integer>();

			newNode.setData(random[i]);
			tree.insert(newNode);
		}

		long endTime = System.nanoTime();
		long randomInsertduration = (endTime - startTime);
		System.out.println("random insert duration : "
				+ (randomInsertduration / 1000000000.0));

		startTime = System.nanoTime();
		for (int i = 0; i < random.length; i++) {
			tree.search(random[i]);
		}
		endTime = System.nanoTime();
		long randomsearchduration = (endTime - startTime);
		System.out.println("random search duration : "
				+ (randomsearchduration / 1000000000.0));
		
		

		//final int TEST_LENGTH = 1000000;
		Integer[] sorted = new Integer[TEST_LENGTH];
		for (int i = 0; i < sorted.length; i++) {
			//Integer r = i;
			sorted[i] = i;
		}
		RedBlackBST<Integer> tree1 = new RedBlackBST<Integer>();

		long startTime1 = System.nanoTime();

		// DO SOME STUFF
		for (int i = 0; i < sorted.length; i++) {
			RedBlackBSTNode<Integer> newNode1 = new RedBlackBSTNode<Integer>();

			newNode1.setData(sorted[i]);
			tree1.insert(newNode1);
		}

		long endTime1 = System.nanoTime();
		long randomInsertduration1 = (endTime1 - startTime1);
		System.out.println("sorted insert duration : "
				+ (randomInsertduration1 / 1000000000.0));

		startTime1 = System.nanoTime();
		for (int i = 0; i < sorted.length; i++) {
			tree1.search(sorted[i]);
		}
		endTime1 = System.nanoTime();
		long randomsearchduration1 = (endTime1 - startTime1);
		System.out.println("sorted search duration : "
				+ (randomsearchduration1 / 1000000000.0));

		// long startTime
		
		
		}
	
	public boolean validateRedHasBlackChildren()
	{
		
		RedBlackBSTNode<T> m;
		m = this.getRoot();
		//while m is not a leaf
		while (!m.isNull())
		{
			//cheack if its children and itself is red
			if (m.getC()&&(m.getLeftC().getC()||m.getRightC().getC()))
			{
				return false;
			}
			return true;
			
		}
		return true;
	}

	public boolean validateLeafNodesBlack()
	{
		return this.getRoot().testBlack(this.getRoot());
	}
	
	
	public boolean validateRootNodeBlack()
	{
		return !(this.getRoot().getC());
	}
	
	public boolean validateTree() {

		  return validateRootNodeBlack() && validateLeafNodesBlack() && validateRedHasBlackChildren() && (validateBlackHeight(this.getRoot()));

		}

	/*boolean validateRootNodeBlack()
	boolean validateLeafNodesBlack()
	boolean validateRedHasBlackChildren()
	boolean validateBlackHeight()*/
	

}
