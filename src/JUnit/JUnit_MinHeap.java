package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import DataTypes.ADTExceptions;
import DataTypes.Heap;

public class JUnit_MinHeap {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Heap minH = new Heap();
		minH.add(10);
		minH.add(20);
		minH.add(5);
		minH.add(2);
		minH.add(15);
		
		try {
			assertEquals(minH.remove(),2);
		} catch (ADTExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
