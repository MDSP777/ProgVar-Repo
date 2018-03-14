// AC as of 3/14/2018
// Solution: One may want to naively read the elements into an ArrayList, then sort and
//           grab the median value(s) each time, but that runs in O(n^2 logn) at best,
//           which is way too slow for n<=10^5.
//           One may also try to (naively) use a data structure like a PriorityQueue or TreeSet
//           to keep the elements sorted while reading them, however this will not work as the
//           elements are not truly sorted (implement this to see what I mean). Also, TreeSet
//           cannot handle duplicates, as it is inherently a set.
//           Best solution is to use two PriorityQueues, one for each half of the list. Let the
//           left half be sorted in descending order, and the right half in ascending order. Constantly
//           make sure they are balanced, by transferring an element from one queue to the other
//           whenever size difference > 1.
//           Because of how we sorted the queues, checking for the median is easy since if # elements is
//           odd, median is the top of the queue with the bigger size. If # elements is even, median is
//           the average of both queue tops.
//           Program time complexity: O(n logn)

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HR_FindTheRunningMedian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nTerms = sc.nextInt();
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		for(int i=1; i<=nTerms; i++) {
			int cur = sc.nextInt();
			if(left.isEmpty()) left.add(cur);
			else {
				if(cur>left.peek()) right.add(cur);
				else left.add(cur);
			}
			if(left.size()-right.size()>1) right.add(left.poll());
			else if(right.size()-left.size()>1) left.add(right.poll());
			if(i%2!=0) System.out.println((left.size()>right.size() ? left.peek() : right.peek())+".0");
			else System.out.printf("%.1f\n", (left.peek()+right.peek())/2.0);
		}
	}
}
