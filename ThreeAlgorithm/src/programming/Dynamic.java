package programming;

public class Dynamic {
	public Dynamic(int[][] cost){
		//start time 
		long start = System.currentTimeMillis();
		
		//create a integer array to save the cheapest sequence
		int[] sequence = new int[cost.length];
		
		//size of cost table
		int size = cost.length - 1;		
		
		//bottom-up algorithm
		//start from 2 to the destination, which is the size of table
		for (int i = 2; i <= size; i++){
			//integer that store the cheapest cost so far
			int min = Integer.MAX_VALUE;
			//compare every possible sequence and get the cheapest one
			for (int j = i - 1; j >0; j--){
				if (cost[1][j] + cost[j][i] < min){
					min = cost[1][j] + cost[j][i];
					//the cheapest cost to i must through j
					sequence[i] = j;
				}
			}
			//save the cheapest cost from 1 to
			cost[1][i] = min;
		}
		
		System.out.println("For the Dynamic Programming: ");
		
		//print the cheapest cost from post 1 to post n
		System.out.println("The cheapest cost is:		" + cost[1][size]);
		
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
}
