// AC as of 3/18/2018
// Problem link: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3344
// Solution: For each row, do a binary search to find the first element >= min, that will be
// our starting point. Then run through the elements in that cell's diagonal until you reach
// the element that is > max, stop there.
// Naively implementing this solution will TLE, so to optimize, always start the run-through at
// the max size found so far, so you don't waste time checking squares that are sure to be less
// than the optimal solution.
// Gotcha case: If there are multiple instances of the smallest element >= min in the same row, keep
// moving left until you reach the first element < min (or the end of the grid) to maximize the size 
// of your square.
// Note: This solution will pass with the use of BufferedReader, but will TLE with Scanner

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_12192 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		while(true) {
			String[] split = br.readLine().split(" ");
			int nRows = Integer.parseInt(split[0]);
			int nCols = Integer.parseInt(split[1]);
			if(nRows==0 && nCols==0) break;
			int[][] grid = new int[nRows][nCols];
			for(int i=0; i<nRows; i++) {
				split = br.readLine().split(" ");
				for(int j=0; j<nCols; j++) grid[i][j] = Integer.parseInt(split[j]);
			}
			int nQueries = Integer.parseInt(br.readLine());
			while(nQueries-->0) {
				split = br.readLine().split(" ");
				int min = Integer.parseInt(split[0]);
				int max = Integer.parseInt(split[1]);
				int best = 0;
				for(int i=0; i<nRows; i++) {
					int loc = Arrays.binarySearch(grid[i], min);
					if(loc<0) loc = -(loc+1);
					if(loc<nCols) {
						while(loc>=0 && grid[i][loc]>=min) loc--;
						loc++;
						int endRow = i+best;
						int endCol = loc+best;
						int curSize = best;
						while(endRow<nRows && endCol<nCols && grid[endRow][endCol]<=max) {
							curSize++;
							best = Math.max(best, curSize);
							endRow++;
							endCol++;
						}
					}
				}
				out.append(best).append("\n");
			}
			out.append("-\n");
		}
		System.out.print(out);
	}
}
