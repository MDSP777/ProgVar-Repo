// AC as of 4/15/2018
// Problem link: https://www.hackerrank.com/contests/acm-icpc-practice-contest/challenges/minimum-loss
// Solution: Read the prices and sort them, but remember the original index of each price (can be
//           achieved using custom class with comparator). Thankfully prices are distinct. After sorting,
//           iterate over the list and look for the minimum difference between every index i and i-1.
//           However, only consider differences where orig_index[i]<orig_index[i-1] (meaning that the higher
//           price came before the lower price in the original list). Problems can occur if this part is skipped,
//           as evidenced in sample I/O 1. The algo will give an answer of 1 (8-7), which is wrong.

import java.util.Arrays;
import java.util.Scanner;

public class HR_MinimumLoss {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nPrices = sc.nextInt();
		Price[] prices = new Price[nPrices];
		for(int i=0; i<nPrices; i++) prices[i] = new Price(sc.nextLong(), i);
		Arrays.sort(prices);
		long minDiff = Long.MAX_VALUE;
		for(int i=1; i<nPrices; i++) 
			if(prices[i].orig_index<prices[i-1].orig_index) minDiff = Math.min(minDiff, prices[i].val-prices[i-1].val);
		System.out.println(minDiff);
	}
	
	static class Price implements Comparable<Price> {
		long val;
		int orig_index;
		
		public Price(long val, int orig_index) {
			this.val = val;
			this.orig_index = orig_index;
		}

		@Override
		public int compareTo(Price o) {
			return Long.compare(this.val, o.val);
		}
	}
}
