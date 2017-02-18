package programming;

import java.util.Random;

public class Tester {

	public static void main(String[] args) {
		//the size of cost table
		int size = 20;
		
		//create a 2D array 
		int[][] cost = new int[size + 1][size + 1];
		
		//generate random cost and save it in the 2D array
		Random random = new Random();
		for (int i = 1; i <= size; i++){
			for (int j = i + 1; j <= size; j++){
				cost[i][j] = random.nextInt(100) + 1;
			}
		}
		
		//print the cost table
		for (int i = 1; i <= size; i++){
			for (int j = 1; j <= size; j++){
				if (i > j){
					System.out.print(999+ "	");
				}else{
					System.out.print(cost[i][j] + "	");					
				}
			}
			System.out.println();
		}
		
//		Brute Force Algorithm
		BruteForce bruteForce = new BruteForce(cost);
		
		//Divide And Conquer Algorithm
		DivideAndConquer divideAndConquer = new DivideAndConquer(cost);
		
		//Dynamic Programming
		Dynamic dynamic = new Dynamic(cost);
		
		}
}
