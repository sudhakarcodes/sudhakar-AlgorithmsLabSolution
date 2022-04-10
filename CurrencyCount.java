import java.util.Scanner;

/* Java program for Merge Sort */
class CurrencyCount 
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
   
	void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
          L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
          R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
           // if (L[i] <= R[j]) {
        	if (L[i] > R[j]) { 
        	arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
  
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
            System.out.println();
    }
  
     
    // Driver code
    public static void main(String args[])
    {
       
    	int n;  
    	
    	Scanner sc=new Scanner(System.in);  
    	System.out.print("\nEnter the number of currency denominations you want to use: ");  
    	
    	//reading the number of elements from the that we want to enter  
    	n=sc.nextInt();  
    	
    	//creates an array in the memory of length n  
    	int[] array = new int[n];  
    	System.out.println("\nEnter the currency denominations values (in any order): ");
    	
    	for(int i=0; i<n; i++)  
    	{  
    	//reading array elements from the user   
    	array[i]=sc.nextInt();  
    	}  
    	    	
    	//int arr[] = { 5, 1, 10, 25, 18, 32, 63 };
  
        System.out.println("\nGiven Currency Denominations: ");
        printArray(array);
  
        CurrencyCount ob = new CurrencyCount();
        ob.sort(array, 0, array.length - 1);
  
        System.out.println("\nSorted Denominations in Descending Order: ");
        printArray(array);
        
        int amount;
        
        System.out.print("\nEnter the amount you want to pay: ");  
    	
    	//reading the amount to be paid with the available denominations  
    	amount=sc.nextInt();
    	System.out.println("\nAmount to be paid: " + amount);
    	
    	//countCurreny(amount);
    	
    	int [] noteCounter = new int[array.length];
    	
    	for (int i = 0; i<array.length; i++ ) {
    		if (amount>= array[i]) {
    			noteCounter[i] = amount/array[i];
    			amount = amount - noteCounter[i]*array[i];
    		}
     	}
    	
    	//print notes
    	
    	System.out.println("\nYour payment approach in order to give min no of notes will be: ");
    	for (int i = 0; i<array.length; i++) {
    		if (noteCounter[i] != 0) {
    			System.out.println(array[i] + ":" + noteCounter[i]);
    		}
    	}
    }
}