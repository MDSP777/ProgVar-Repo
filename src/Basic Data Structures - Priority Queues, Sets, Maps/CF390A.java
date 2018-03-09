// AC as of 3/9/2018
// Solution: Since there is no limit to length of segments, be greedy
//           Always make segments that span the entire row or column
//           Afterwards it's simply a matter of counting the number of
//           distinct rows and columns the clocks span, and getting minimum

import java.util.Scanner;

public class CF390A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nClocks = sc.nextInt();
		int rowTotal = 0;
		int colTotal = 0;
		boolean[] rows = new boolean[101];
		boolean[] cols = new boolean[101];
		while(nClocks-->0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			if(!rows[r]) {
				rows[r] = true;
				rowTotal++;
			}
			if(!cols[c]) {
				cols[c] = true;
				colTotal++;
			}
		}
		System.out.println(Math.min(rowTotal, colTotal));
	}
}
