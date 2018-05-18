// AC as of 5/1/2018
// Problem link: http://codeforces.com/contest/140/problem/C
// Solution: Be greedy. Count the quantities of each snowball radius, and greedily build snowmen from the three largest quantities.
//           Implementation:
//           1. Store quantities in a HashMap with KV pair (radius, quantity)
//           2. Convert KV pairs to objects with comparator for sorting in descending order, and push these objects into a priority queue
//           3. While there are >= 3 quantities left, grab the 3 quantities on top of the prio queue, and use them to make a snowman
//           4. If any of the quantities used still have snowballs remaining after using them, push the updated values back into the queue
//           5. Repeat until you run out of quantities
//           Program runtime: O(n logn)
//           Note: using an ArrayList and sorting after making each snowball will TLE, O(n^2 logn)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CF140C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nBalls = Integer.parseInt(br.readLine());
//		int nBalls = 100000;
		HashMap<Integer, Integer> map = new HashMap<>();
		String[] split = br.readLine().split(" ");
		for(int i=0; i<nBalls; i++) {
			int r = Integer.parseInt(split[i]);
			if(map.containsKey(r)) map.put(r, map.get(r)+1);
			else map.put(r, 1);
//			map.put(i+1, 1);
		}
		PriorityQueue<Quantity> quantities = new PriorityQueue<>();
		for(int c : map.keySet()) quantities.add(new Quantity(c, map.get(c)));	
		ArrayList<Snowman> snowmen = new ArrayList<>();
		while(quantities.size()>=3) {
			Quantity q1 = quantities.poll();
			Quantity q2 = quantities.poll();
			Quantity q3 = quantities.poll();
			snowmen.add(new Snowman(q1.r, q2.r, q3.r));
			q1.count--;
			q2.count--;
			q3.count--;
			if(q1.count>=1) quantities.add(q1);
			if(q2.count>=1) quantities.add(q2);
			if(q3.count>=1) quantities.add(q3);
		}
		sb.append(snowmen.size()).append("\n");
		for(int i=0; i<snowmen.size(); i++) sb.append(snowmen.get(i)).append("\n");
		System.out.print(sb);
	}
	
	static class Quantity implements Comparable<Quantity> {
		int r;
		int count;
		
		public Quantity(int r, int count) {
			this.r = r;
			this.count = count;
		}

		@Override
		public int compareTo(Quantity o) {
			return Integer.compare(o.count, this.count);
		}
	}
	
	static class Snowman {
		int[] stack;
		
		public Snowman(int a, int b, int c) {
			stack = new int[3];
			stack[0] = a;
			stack[1] = b;
			stack[2] = c;
			Arrays.sort(stack);
		}
		
		public String toString() {
			return stack[2]+" "+stack[1]+" "+stack[0];
		}
	}
}

/*
Important test case:
In:
13
1 1 1 2 2 2 3 3 3 4 4 5 5

Out:
4
3 2 1
4 3 2
5 3 1
5 4 1


*/
