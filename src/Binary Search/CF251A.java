// AC as of 3/15/2018
// Problem link: http://codeforces.com/problemset/problem/251/A
// Solution: Very reminiscent of Triangles from Algolympics 2018.
//           First observation you should make is that since array length is <=10^5,
//           any algo that runs in O(n^2) or slower will NOT pass. O(n logn) solution is needed.
//           For each i, find the first j such that arr[j]-arr[i] > d. Therefore,
//           all k from i+2 to j-1 are valid endpoints (since arr[k]-arr[i] is guaranteed to
//           be <= d). # of combinations using i and k is simply k-i-1, and sum of combinations
//           across all k is the (k-i-1)th triangular number. Binary search should be used to find j
//           since array is sorted.
//           Program time complexity: O(n logn)

import java.util.Arrays;
import java.util.Scanner;

public class CF251A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] triangle = new long[100100];
		triangle[0] = 0;
		for(int i=1; i<100100; i++) triangle[i] = i+triangle[i-1]; 
		int n = sc.nextInt();
		long d = sc.nextLong();
		long total = 0;
		long[] arr = new long[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextLong();
		for(int i=0; i<n; i++) {
			long target = arr[i]+d;
			int k = Arrays.binarySearch(arr, target);
			if(k>=0) {
				k = k-i-1;
				if(k>=0) total+=triangle[k];
			} else {
				k++;
				k*=-1;
				k = k-i-2;
				if(k>=0) total+=triangle[k];
			}
		}
		System.out.println(total);
	}
}
