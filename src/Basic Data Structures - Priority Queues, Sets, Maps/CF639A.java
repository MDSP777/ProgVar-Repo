// AC as of 3/13/2018
// Solution: Use priority queue, maintain size <= k

import java.util.PriorityQueue;
import java.util.Scanner;

public class CF639A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		int[] vals = new int[n];
		for(int i=0; i<n; i++) vals[i] = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<q; i++) {
			int command = sc.nextInt();
			int target = sc.nextInt()-1;
			if(command==1) {
				if(pq.size()==k) {
					if(vals[target]>pq.peek()) {
						pq.poll();
						pq.add(vals[target]);
					}
				} else pq.add(vals[target]);
			} else {
				System.out.println(pq.contains(vals[target]) ? "YES" : "NO");
			}
		}
	}
}
