import static org.junit.Assert.*;

import org.junit.Test;


public class RedBlackBSTNodeTest {

	RedBlackBSTNode<Integer> nullnode;
	RedBlackBSTNode<Integer> goodnode;
	
	
	/**test the constructors**/
	@Test
	public void testConstructor() {
		//fail("Not yet implemented");
		nullnode = new RedBlackBSTNode<Integer>();
		goodnode = new RedBlackBSTNode<Integer>(24324);
		
		//test the colors
		assertTrue("testConstructor", !nullnode.getC());
		assertTrue("testConstructor", goodnode.getC());

		

	}
	
	
	

}
