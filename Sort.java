/*
 * Christian Perez De Leon
 * 
 * fuente: https://www.geeksforgeeks.org/
 */

import java.util.*;

public class Sort implements SortInterface {

	
	public void SelectionSort(Integer[] arr) {
		int n = arr.length;
		 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx]) /// eerror
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
	}
	
	void printArray(Integer[] dat) 
    { 
        int n = dat.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(dat[i]+" "); 
        System.out.println(); 
    } 
	
	public void merge(Integer [] arr, int l, int m, int r) {
		// Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
		
	}

	
	public void MergeSort(Integer arr[], int l, int r) {
		 if (l < r) 
		    { 
		        // Same as (l+r)/2, but avoids overflow for 
		        // large l and h 
		        int m = l+(r-l)/2; 
		  
		        // Sort first and second halves 
		        MergeSort(arr, l, m); 
		        MergeSort(arr, m+1, r); 
		  
		        merge(arr, l, m, r); 
		    } 
	}
	
	public void QuickSort(Integer [] arr, int low, int high) {
		if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            QuickSort(arr, low, pi-1); 
            QuickSort(arr, pi+1, high); 
        }
	}
	
	public int partition(Integer [] arr, int low, int high) {
		int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1;
		
	}
	
	public int getMax(Integer [] arr, int n) {
		int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx;
	}
	
	
	public void countSort(Integer arr[], int n, int exp) {
		int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
		
	}
	
	public void InsertionSort(Integer [] arr) {
		int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
		
	}

	@Override
	public void RadixSort(Integer[] arr, int n) {
		// TODO Auto-generated method stub
		 // Find the maximum number to know number of digits 
	       int m = getMax(arr, n); 
	 
	       // Do counting sort for every digit. Note that instead 
	       // of passing digit number, exp is passed. exp is 10^i 
	       // where i is current digit number 
	       for (int exp = 1; m/exp > 0; exp *= 10) {
	       	 countSort(arr, n, exp); 
	       }
		
	}
	
	
	
	
	
	
	
}
