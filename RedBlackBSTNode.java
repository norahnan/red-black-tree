import java.awt.Color;


public class RedBlackBSTNode<T extends Comparable<T>> {
	
	//pointers
	private RedBlackBSTNode<T> parent;
	private RedBlackBSTNode<T> leftChild;
	private RedBlackBSTNode<T> rightChild;
	//data 
	private T data;
	private boolean isRed;
	private boolean isNull;
	
	
	public boolean isNull()
	{
		return isNull;
	}
	
	public RedBlackBSTNode()
	{
		isNull = true;
		leftChild = null;
		rightChild = null;
		
		//set its color to be red
		isRed = false;
	}
	
	public String getColorString()
	{
		if (this.getC())
		{
			return "red";
		}
		else 
		{
			return "black";
		}
	}
	
	public RedBlackBSTNode(T data) {
		this.data = data;
		isNull = false;
		// create the null nodes
		RedBlackBSTNode<T> p = new RedBlackBSTNode<T>();
		RedBlackBSTNode<T> l = new RedBlackBSTNode<T>();
		RedBlackBSTNode<T> r = new RedBlackBSTNode<T>();
		
		this.SetC(true);
		// set its parent and children point to null nodes
		parent = p;
		leftChild = l;
		rightChild = r;
	}
	
	/**get the parent node**/
	public RedBlackBSTNode<T> getP()
	{
		return parent;
	}
	
	/**set the parent of a node**/
	public void setP(RedBlackBSTNode<T> p)
	{
		parent = p;
	}
	
	/**get the left child**/
	public RedBlackBSTNode<T> getLeftC()
	{
		return leftChild;
	}
	
	/**set the left child of a node**/
	public void setLeftC(RedBlackBSTNode<T> p)
	{
		leftChild = p;
	}

	/**get the right child**/
	public RedBlackBSTNode<T> getRightC()
	{
		return rightChild;
	}
	
	/**set the right child of a node**/
	public void setRightC(RedBlackBSTNode<T> p)
	{
		rightChild = p;
	}
	
	/**get the data**/
	public T getD()
	{
		return data;
	}
	
	/**set the data**/
	public void setData(T d)
	{
		data = d;
	}
	
	/**get the color(red or black)**/
	public boolean getC()
	{
		return isRed;
	}
	
	/**Set the color(red or black)**/
	public void SetC(boolean c)
	{
		isRed = c;
	}
	
	
	/**cheak if only null
	 * general case one**/
	public boolean isonlyrootPnull()
	{
		
		//returns flase if parent or suntree node;s parent is null
		//returns true otherwise 
		//if the left child of this node points to null
		if (this.getLeftC() == null)
		{
			//check for this left child
			if(this.getLeftC().isonlyrootPnullH() ==false)
			{
				
				return false;
			}
			
		}
		//if the right child of this node points to null
		if (this.getRightC() == null)
		{
			//check for the right child
			if(this.getRightC().isonlyrootPnullH() ==false)
			{
				return false;
			}
			
		}
		//if the parent of this node points to null/this is root
		if (this.getP()==null)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean isonlyrootPnullH()
	{
		
		//returns flase if parent or suntree node;s parent is null
		//returns true otherwise 
		if (this.getLeftC() == null)
		{
			if(this.getLeftC().isonlyrootPnullH() ==false)
			{
				return false;
			}
			
		}
		if (this.getRightC() == null)
		{
			if(this.getRightC().isonlyrootPnullH() ==false)
			{
				return false;
			}
			
		}
		//if the parent of this node is not null/this is not a root
		if (!(this.getP()==null))
		{
			return false;
		}
		
		return true;
	}
	
	
	public RedBlackBSTNode<T> search(T data)
	{
		//if the data of this node is what we are looking for
		if(this.getD().equals(data))
		{
			//return the node
			return this;
			
		}
		else 
		{
			//if the data is larger than the data we are looking for,and we need to find
			//something smaller
			if(this.getD().compareTo(data)>0)
			{
				//if we cannot find any left child
				if(this.getLeftC().isNull())
				{
					//data is not in the tree
					return null;
				}
				//search the left child
				this.getLeftC().search(data);
			}
			//if our data is too small and we need bigger one
			else if(this.getD().compareTo(data)<0)
			{
				//if no right nodes
				if(this.getRightC().isNull())
				{
					return null;
				}
				//check for right child
				this.getRightC().search(data);
			}
			return null;
		}
	}
	
	
	
	/**get the black height or negative infinity if there is different black height**/
	public int testBH(int height) {
		/*// set the black height to be the passing data
		int bh = height;

		// if we have reached a leaf
		if (this.isNull()) {
			// return the height
			return 1;
		}
		
		else
		{
			int lb = this.getLeftC().testBH(0);
			int rb = this.getRightC().testBH(0);
			
			if (lb == rb)
			{
				if(!this.getC())
				{
					return lb+1;
				}
				else 
				{
					return lb;
				}
			}
			else 
			{
				//return  (int) Double.NEGATIVE_INFINITY;
				return -1;
			}
		}*/
		/*// check the color of the current node if it is black
		if (!this.getC()) {
			// increase the black height
			bh++;
		}
		// if the black height on the right does not equal to the left
		else if (!(this.getRightC().testBH(bh) == this.getLeftC().testBH(bh))) {
			// set the black height to be negative inifinity
			bh = (int) Double.NEGATIVE_INFINITY;
			;
		}
		// return the height
		return bh;*/
		
		
		
		
		//set the black height to be the passing data
				int bh = height;
				//check the color of the current node if it is black
				if(!this.getC())
				{
					//increase the black height
					bh++;
				}
				//if we have reached a leaf
				if (this.isNull())
				{
					//return the height
					return bh;
				}
				//if the black height on the right does not equal to the left
				else if(!(this.getRightC().testBH(bh)==this.getLeftC().testBH(bh)))
				{
					//set the black height to be negative inifinity
					bh = (int)Double.NEGATIVE_INFINITY;;
				}
				//return the height
				return bh;
		
		
	}

	/**check if the balck height is corrent**/
	public boolean isBHright()
	{
		//if the height turns to be less than 0
		if(this.testBH(0)<0) 
		{
			//System.out.println(this.testBH(0));
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**test for all the leaf if they are black**/
	public boolean testBlack(RedBlackBSTNode<T> m)
	{
		//if we have not yet reached leaves
		if(!m.isNull)
		{
			//check its children
			testBlack(m.getLeftC());
			testBlack(m.getRightC());
		}
		else 
		{
			//if m is a leaf and m is red
			if (m.getC())
			{
				return false;
			}
		}
		
		return true;
	}
	

	
	
}
