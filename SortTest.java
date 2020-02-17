/*
 * Christian Perez De Leon
 * 
 */


import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {
	
	Sort sort = new Sort();

	@Test
	public void testSelectionSort() {
		Integer[] x = new Integer[] {6, 8, 5, 1, 2, 3};
		
		sort.SelectionSort(x);
		Integer[] val1 = x;
		Integer[] val2 = new Integer[] {1,2,3,5,6,8};
		
		assertEquals(val1, val2);
		
	}

}
