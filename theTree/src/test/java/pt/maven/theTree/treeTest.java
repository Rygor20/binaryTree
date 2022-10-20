package pt.maven.theTree;

import static org.junit.Assert.*;

import org.junit.Test;

public class treeTest<T extends Comparable<T>> {
	myTree<T> tree = new myTree<>();

	@Test
	public void testIntInsertAndDisplay() {
		myParse p = new myParseI();
		tree.insert((T) p.parse("5"));
		assertEquals("(5L()P())", tree.display());
	}
	@Test
	public void testDoubleInsertAndDisplay() {
		myParse p = new myParseD();
		tree.insert((T) p.parse("3.14"));
		assertEquals("(3.14L()P())", tree.display());
	}
	@Test
	public void testStringInsertAndDisplay() {
		myParse p = new myParseS();
		tree.insert((T) p.parse("Krzysiu"));
		assertEquals("(KrzysiuL()P())", tree.display());
	}
	
	@Test
	public void testSearchPositive() {
		myParse p = new myParseI();
		tree.insert((T) p.parse("5"));
		assertEquals(true, tree.search((T) p.parse("5")));
	}
	@Test
	public void testSearchNegative() {
		myParse p = new myParseI();
		tree.insert((T) p.parse("5"));
		assertEquals(false, tree.search((T) p.parse("7")));
	}
	
	@Test
	public void testRemoveExsistentData() {
		myParse p = new myParseI();
		tree.insert((T) p.parse("5"));
		tree.remove((T) p.parse("5"));
		assertEquals("()", tree.display());
	}
	@Test
	public void testRemoveNonExistentData() {
		myParse p = new myParseI();
		tree.insert((T) p.parse("5"));
		tree.remove((T) p.parse("7"));
		assertEquals("(5L()P())", tree.display());
	}

}
