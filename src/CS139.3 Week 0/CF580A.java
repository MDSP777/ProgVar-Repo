// AC as of 4/15/2018
// Problem link: http://codeforces.com/problemset/problem/580/A
// Solution: Length of longest non-decreasing subsegment can be identified in O(n) time. Simply
//           keep a counter of the current length and reset whenever the array decreases. Before
//           reset, compare with current best length and update if necessary. Do one last update
//           at the very end to cover the last value of the array.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF580A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nTerms = Integer.parseInt(br.readLine());
		int[] terms = new int[nTerms];
		String[] split = br.readLine().split(" ");
		int best = 1;
		int cur = 1;
		terms[0] = Integer.parseInt(split[0]);
		for(int i=1; i<nTerms; i++) {
			terms[i] = Integer.parseInt(split[i]);
			if(terms[i]>=terms[i-1]) cur++;
			else {
				best = Math.max(best, cur);
				cur = 1;
			}
		}
		best = Math.max(best, cur);
		System.out.println(best);
	}
}
