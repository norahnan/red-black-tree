import static org.junit.Assert.*;

import org.junit.Test;

public class RedBlackBSTTest {

	RedBlackBST myTree;

	/** test the search function of the tree **/
	@Test
	public void testsearch() {

		// create the tree object
		myTree = new RedBlackBST<String>();
		// create and insert the first node
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>(
				"just for search");
		// z.setData();
		myTree.insert(z);
		// System.out.println(myTree.getRoot().search(("just for search")).getD());
		// test of the search is correct
		assertEquals("testsearch", "just for search",
				myTree.search("just for search").getD());
	}

	/** test the search function of the tree **/
	@Test
	public void testsearch2() {

		// create the tree object
		myTree = new RedBlackBST<String>();
		// create and insert the first node
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>();
		z.setData("just for search");
		myTree.insert(z);
		//assertTrue(myTree.validateTree());

		// System.out.println(myTree.search("just for search").getD());
		// test of the search is correct
		assertEquals("testsearch2", "just for search",
				myTree.search("just for search").getD());
	}

	// check validity

	/** only root parent points to null **/
	@Test
	public void onlyrooTPNULL() {
		// fail("Not yet implemented");

		// assertEquals("onlyrooTPNULL",true,myTree.getRoot().isonlyrootPnull());
	}

	/** test if a certain node has the same black height in different paths **/
	@Test
	public void sameblackheight() {
		// fail("Not yet implemented");

		// create the tree object
		myTree = new RedBlackBST<String>();
		// create and insert the first node
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>("a");
		// z.setData();
		myTree.insert(z);
		RedBlackBSTNode<String> z1 = new RedBlackBSTNode<String>("v");
		// z.setData();
		myTree.insert(z1);
		RedBlackBSTNode<String> z2 = new RedBlackBSTNode<String>("d");
		// z.setData();
		myTree.insert(z2);
		RedBlackBSTNode<String> z3 = new RedBlackBSTNode<String>("f");
		// z.setData();
		myTree.insert(z3);
		// myTree.printTree();
		// System.out.println(myTree.validateBlackHeight(myTree.getRoot()));
		// test the black height from the root to the leaves if they are correct
		assertEquals("sameblackheight", true,
				myTree.validateBlackHeight(myTree.getRoot()));
		//assertTrue(myTree.validateTree());

	}

	/** the root parent is null **/
	@Test
	public void rootpnull() {
		// fail("Not yet implemented");
		// create the tree object
		myTree = new RedBlackBST<String>();
		// create and insert the first node
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>(
				"just for search");
		// z.setData();
		myTree.insert(z);

		assertEquals("rootpnull", true, myTree.getRoot().getP().isNull());
	}

	/** there is no two reds in a roll **/
	@Test
	public void testontwored() {
		// fail("Not yet implemented");
		myTree = new RedBlackBST<String>();
		// create and insert the first node
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>(
				"just for search");
		// z.setData();
		myTree.insert(z);

		assertEquals("testontwored", true, myTree.validateRedHasBlackChildren());
	}

	/** root node is black **/
	@Test
	public void testrootisblack() {
		// fail("Not yet implemented");
		myTree = new RedBlackBST<String>();
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>("first element");
		// z.setData();
		myTree.insert(z);
		// test if the color of the t
		// assertEquals("testrootisblack",false ,myTree.getRoot().getC());
		assertTrue(!(myTree.getRoot().getC()));
		assertTrue(myTree.validateRootNodeBlack());

	}

	/** every leaf is black **/
	@Test
	public void testleaf() {
		myTree = new RedBlackBST<String>();
		RedBlackBSTNode<String> z = new RedBlackBSTNode<String>(
				"test for leaf black");
		// z.setData();
		myTree.insert(z);

		// assertEquals("testleaf",false,myTree.getRoot().testBlack(myTree.getRoot()));

		assertTrue((myTree.validateLeafNodesBlack()));
	}

	/** coverage for insert case **/
	// performance for both sorted and random data
	@Test
	public void testinsert() {
		// fail("Not yet implemented");
		// create the new node
		myTree = new RedBlackBST<Integer>();
		RedBlackBSTNode newN = new RedBlackBSTNode<Integer>(4);
		// set its data
		// newN.setData(4);
		// insert the node
		myTree.insert(newN);
		//assertTrue(myTree.validateTree());

		// (myTree.getRoot().getD());
		// test
		assertEquals("testheapsort", 4, myTree.getRoot().getD());
		RedBlackBSTNode newN2 = new RedBlackBSTNode<Integer>(2);
		myTree.insert(newN2);
		// check what is printed out: 4 black 2 red null black null black null
		// black
		// and this is the right order
		System.out.println("insert1 ends " + "n/");
		myTree.printTree();
		// insert the thrid node
		RedBlackBSTNode newN3 = new RedBlackBSTNode<Integer>(3);
		myTree.insert(newN3);
		// check it prints out: black 3 black 2 red null black null black 4 red
		// null black null black
		// which is the correct structure
		System.out.println("insert1 ends " + "n/");

		myTree.printTree();

		RedBlackBSTNode newN4 = new RedBlackBSTNode<Integer>(0);
		myTree.insert(newN4);
		// check it prints out:3 black 2 black 0 red null black null black null
		// black 4 black null black null black
		// which is the correct structure
		System.out.println("insert1 ends " + "n/");

		myTree.printTree();

		final int TEST_LENGTH = 7;
		Integer[] random = new Integer[TEST_LENGTH];
		for (int i = 0; i < random.length; i++) {
			Integer r = (Integer) (int) (Math.random() * random.length);
			random[i] = r;
		}
		RedBlackBST<Integer> tree = new RedBlackBST<Integer>();

		for (int i = 0; i < random.length; i++) {
			RedBlackBSTNode<Integer> newNode = new RedBlackBSTNode<Integer>(
					random[i]);

			tree.insert(newNode);
		}

		// create the ramdom tree and use the website to check if it is correct
		System.out.println("this is the random tree" + tree.getRoot().getD());
		tree.printTree();
		//test if tree is valid
		//assertTrue(tree.validateTree());


		// make an other tree
		RedBlackBST<String> newTree = new RedBlackBST<String>();
		// insert a root node
		RedBlackBSTNode<String> m = new RedBlackBSTNode<String>("m");
		newTree.insert(m);
		// check the root is black
		assertTrue(!(newTree.getRoot().getC()));
		// and the node should have the rode inserted
		assertEquals("check root", m, newTree.getRoot());

		// create two nnodes and insert them
		RedBlackBSTNode<String> g = new RedBlackBSTNode<String>("g");
		newTree.insert(g);
		RedBlackBSTNode<String> w = new RedBlackBSTNode<String>("w");
		newTree.insert(w);
		


		
		RedBlackBSTNode<String> j = new RedBlackBSTNode<String>("j");
		newTree.insert(j);
		// check the color of the inserted nodes, they shoud be black(no 2 reds in a roll)
		assertTrue(!g.getC());
		assertTrue(!w.getC());
		//test if the tree is valid
				assertTrue(newTree.validateTree());

		// for the case three
		RedBlackBSTNode<String> k = new RedBlackBSTNode<String>("k");
		newTree.insert(k);
		// check the parent child relation
		assertEquals("valid3", g, j.getLeftC());
		assertEquals("valid3", k, j.getRightC());
		
		//check the color
		assertTrue(!j.getC());
		assertTrue(g.getC());
		assertTrue(k.getC());
		RedBlackBSTNode<String> l = new RedBlackBSTNode<String>("l");
		newTree.insert(l);
		// test the parent children relationship, check parent and it is a right child
		assertEquals("valid4", k, l.getP());
		assertEquals("valid3", l, k.getRightC());

		// test the colors,the colors should change
		assertTrue(j.getC());
		assertTrue(!g.getC());
		assertTrue(!k.getC());
		//test if the tree is valid
				assertTrue(newTree.validateTree());
		// case 3
		RedBlackBSTNode<String> u = new RedBlackBSTNode<String>("u");
		newTree.insert(u);
		assertTrue(u.getC());
		
		//as u is larger than r and smaller than w, it should be the child of u, it stays its default 
		//color red
		RedBlackBSTNode<String> r = new RedBlackBSTNode<String>("r");
		newTree.insert(r);
		assertTrue(!u.getC());
		//after inserting the new node, test the parent children relation according to the website
		assertEquals("valid3", u, m.getRightC());
		
		assertTrue(r.getC());
		assertEquals("valid3", r, u.getLeftC());
		assertTrue(w.getC());
		assertEquals("valid3", w, u.getRightC());
		
		//test if the tree is valid
				assertTrue(newTree.validateTree());

		//insert and test the color
		RedBlackBSTNode<String> i = new RedBlackBSTNode<String>("i");
		newTree.insert(i);
		assertTrue(i.getC());
		RedBlackBSTNode<String> h = new RedBlackBSTNode<String>("h");
		newTree.insert(h);
		assertTrue(!h.getC());

		
		//test if the tree is valid
		assertTrue(newTree.validateTree());

	}

}
