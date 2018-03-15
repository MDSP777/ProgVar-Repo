// AC as of 3/15/2018
// Solution: intended solution probably should have made use of binary search and a
//           running sum, but problem can be "cheated" by generating the actual array
//           of individual worms, with the value being the pile they belong to. After,
//           querying runs in constant time.
//           Program time complexity: O(n), where n is the total number of worms (not piles!)

import java.util.Scanner;

public class CF474B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nPiles = sc.nextInt();
		int total = 0;
		int[] piles = new int[nPiles];
		for(int i=0; i<nPiles; i++) {
			piles[i] = sc.nextInt();
			total+=piles[i];
		}
		int[] worms = new int[total];
		int index = 0;
		for(int i=0; i<nPiles; i++)
			for(int j=0; j<piles[i]; j++) worms[index++] = i+1;
		int nQ = sc.nextInt();
		while(nQ-->0) System.out.println(worms[sc.nextInt()-1]);
	}
}
