import java.util.Arrays;
import java.util.Scanner;

public class PayMoneyTransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Transactions: ");
		int noOfTrans = sc.nextInt();
		
		sc.nextLine();
		
		int[] transValues = new int[noOfTrans];
		int[] runningTotal = new int[noOfTrans];
		
		System.out.println("Enter the Transaction Values: ");
		
		for (int i = 0; i < noOfTrans; i++) {
			transValues[i] = sc.nextInt();
			if (i == 0)
				runningTotal[i] = transValues[i];
			else
				runningTotal[i] = runningTotal[i-1] + transValues[i];
		}
		
		sc.nextLine();
		
		System.out.println("Enter the number of Targets: ");
		
		int n = sc.nextInt();
		
		for (int j=0; j<n; j++) {
			
			System.out.println("Enter the Value of the Target: ");
			
//			int target = sc.nextInt();
			
				int sum = sc.nextInt();;
				int index = transaction(runningTotal, sum);
			
				if (index == -1)

				{
					System.out.println();
					
					System.out.println("Given Target not Achieved!!!");
				}
				
				else
				{
					System.out.println();
					
					if (index == 1)
					{	
						System.out.println("Target " + sum + " is achieved after " + index + " transaction.");
						System.out.println();
					
					}
					else
					{	
						System.out.println("Target " + sum + " is achieved after " + index + " transactions.");
						System.out.println();	
					}
				}

		}		
		
		sc.close();
		
}
	
public static int transaction(int[] runningTotal, int sum )
{ int index = 0;
  for (int i:runningTotal) {
	  index++;
	  if (i>= sum)
		  return index;
  }
  
	return -1;

}

}