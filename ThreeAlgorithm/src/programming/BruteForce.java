package programming;

import java.util.ArrayList;

public class BruteForce{
	public BruteForce(int[][] cost){
		//start time 
		long start = System.currentTimeMillis();
		
		//size of cost table
		int size = cost.length - 1;
		
		//create an arraylist that contains the sequence, each sequence is also an arraylist
		ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<ArrayList<Integer>>();
		
		//get the combination of size from 2 to size -1
		for (int i = 0; i < size - 2; i++){
			combine(2, size - 1, i, sequenceList);
		}
		
		//calculate the cost of every sequence and find the cheapest one
		int seq = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < sequenceList.size(); i++){
			int tempCost = 0;
			int current = 1;
			for(int j = 0; j < sequenceList.get(i).size(); j++){
				tempCost += cost[current][sequenceList.get(i).get(j)];
				current = sequenceList.get(i).get(j);
			}
			tempCost += cost[current][size];
			
			//if found a cheaper cost, replace the min and store the index of this sequence
			if (tempCost < min){
				min = tempCost;
				seq = i;
			}
		}
		//end time
		long end = System.currentTimeMillis();

		System.out.println("The cheapest cost is:		" + min);
		System.out.print("The cheapest sequence is:" + "	" + "1  ");
		//print the sequence
		for (int i = 0; i < sequenceList.get(seq).size(); i++){
			System.out.print(sequenceList.get(seq).get(i) + "  ");
		}
		
		System.out.println(size);
		//running time = end time - start time
		System.out.println("The running time is:		" + (end - start));
	}
	
	public void combine(int start, int end, int size, ArrayList<ArrayList<Integer>>sequenceList) {
		//return when end < start or size > number of total elements
		if (end < start || end - start +1 < size)
			return;
		
		//create a arraylist to store the combination
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		
		//find the combination
		dfs(start, size, end, sequence, sequenceList); 
	 
	}
	 
	private void dfs(int start, int size, int end, ArrayList<Integer> sequence, ArrayList<ArrayList<Integer>> sequenceList) {
		//if the size of sequence equals the size we want, add it to sequence list 
		if (sequence.size() == size) {
			sequenceList.add(new ArrayList<Integer>(sequence));
			return;
		}		
		
		for (int i = start; i <= end; i++) {
			sequence.add(i);
			dfs(i + 1, size, end, sequence, sequenceList);
			sequence.remove(sequence.size() - 1);
		}
	}
}