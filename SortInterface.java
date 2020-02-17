public interface SortInterface {
	
	public void SelectionSort(Integer data[]);
	
	public void merge(Integer arr[], int l, int m, int r);
	
	public void MergeSort(Integer arr[], int l, int r);
	
	public void QuickSort(Integer arr[], int low, int high);
	
	public int partition(Integer arr[], int low, int high);
	
	public void RadixSort(Integer arr[], int n);
	
	public int getMax(Integer arr[], int n);
	
	public void countSort(Integer arr[], int n, int exp);
	
	public void InsertionSort(Integer arr[]);

}
