package programming;

public class DivideAndConquer {
	public DivideAndConquer(int[][] cost) {
		//start time
		long start = System.currentTimeMillis();
		
		//create a int array to save the cheapest sequence
		int[] sequence = new int[cost.length];
		
		//size of cost table
		int size = cost.length - 1;		
		
		//find the cheapest cost from post 1 to post n
		int min = findCost(size, sequence, cost);
		
		System.out.println("For the Divide and Conquer Algorithm: ");
		//print the cheapest cost from post 1 to post n
		System.out.println("The cheapest cost is:		" + min);
		
		//print the cheapest
		System.out.print("The cheapest sequence is:	");
		sequence(sequence, size);
		//end time
		long end = System.currentTimeMillis();
		
		//running time = end time - start time
		System.out.println("\nThe running time is:		" + (end - start));
	}
	
	//find the path from the end
		private void sequence(int[] sequence, int n) {
			//find from post n to the post
			if (n != 1){
				sequence(sequence, sequence[n]);
			}
			//print the sequence
			System.out.print(n + "  ");
		}
	
	//n is number of post
	private int  findCost(int n, int[] sequence, int[][] cost){
		//if n==1, exit the recursion 
		if (n == 1){
			return 0;
		}else {
			//find the cheapest cost from post 1 to post n-1
			findCost(n - 1, sequence, cost);
			//search the every sequence from 1 to n
			for (int i = 1; i < n; i++){
				if (cost[1][i] + cost[i][n] <= cost[1][n]){
					cost[1][n] = cost[1][i] + cost[i][n];
					sequence[n] = i;
				}
			}
		}
		return cost[1][n];
	}
}
