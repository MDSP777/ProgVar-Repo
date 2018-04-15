// AC as of 4/15/2018
// Problem link: http://codeforces.com/problemset/problem/313/B
// Solution: Generate list of running sums for line[i]=line[i+1], for each i, then for queries
//           just output sum[r-l].
// Note: Due to the large number of possible queries (10^5), Scanner will TLE. Use BufferedReader instead. Hassle >.>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF313B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		int[] ans = new int[line.length];
		ans[0] = 0;
		for(int i=1; i<line.length; i++) ans[i] = ans[i-1]+(line[i]==line[i-1] ? 1 : 0);
		int nQ = Integer.parseInt(br.readLine());
		while(nQ-->0) {
			String[] split = br.readLine().split(" ");
			int l = Integer.parseInt(split[0])-1;
			int r = Integer.parseInt(split[1])-1;
			System.out.println(ans[r]-ans[l]);
		}
	}
}
