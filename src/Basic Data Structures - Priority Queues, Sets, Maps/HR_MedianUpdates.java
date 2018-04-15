// AC as of 3/14/2018
// Problem link: https://www.hackerrank.com/challenges/median/problem
// Solution: Simple variation on HR_FindTheRunningMedian. Same idea as that problem,
//           just have to handle removal of elements.
//           Gotcha case: When calculating the median of an even # of elements, sum may
//           overflow integer, so use long. When printing double for the possible .5 median,
//           make sure you don't print in scientific notation.

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HR_MedianUpdates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long nTerms = sc.nextInt();
		PriorityQueue<Long> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Long> right = new PriorityQueue<>();
		while(nTerms-->0) {
			char type = sc.next().charAt(0);
			long cur = sc.nextLong();
			if(type=='a') {
				if(left.isEmpty()) left.add(cur);
				else {
					if(cur>left.peek()) right.add(cur);
					else left.add(cur);
				}
			} else {
				if(left.contains(cur)) left.remove(cur);
				else if(right.contains(cur)) right.remove(cur);
				else {
					System.out.println("Wrong!");
					continue;
				}
			}
			if(left.size()-right.size()>1) right.add(left.poll());
			else if(right.size()-left.size()>1) left.add(right.poll());
			if(left.isEmpty() && right.isEmpty()) System.out.println("Wrong!");
			else if((left.size()+right.size())%2!=0) System.out.println(left.size()>right.size() ? left.peek() : right.peek());
			else {
				double ans = (left.peek()+right.peek())/2.0;
				if(ans==Math.floor(ans)) System.out.println((long) ans);
				else System.out.printf("%.1f\n", ans);
			}
		}
	}
}

/*
Important cases:
Input
2
a 2147483647
a 2147483646

Output
2147483647
2147483646.5

Input
2
a 2147483647
a 2147483647

Output
2147483647
2147483647

*/