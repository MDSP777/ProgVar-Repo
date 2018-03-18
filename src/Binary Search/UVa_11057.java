// AC as of 6/24/2016 (solved again on 3/17/2018)
// Solution: Sort the list, then count how often each book price appears.
//           For each value i from m/2 to 0, check if books with prices i
//           and m-i. First answer found is sure to be that which minimizes
//           the difference between i and m-i.

import java.util.Arrays;
import java.util.Scanner;

public class UVa_11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			int[] books = new int[n];
			for(int i=0; i<n; i++) books[i] = sc.nextInt();
			Arrays.sort(books);
			int[] count = new int[books[n-1]+1];
			for(int i=0; i<n; i++) count[books[i]]++;
			int m = sc.nextInt();
			int half = m/2;
			while(half>=0) {
				if(count[half]>=1 && count[m-half]>=1) {
					System.out.println("Peter should buy books whose prices are "+(half)+" and "+(m-half)+".");
					break;
				}
				half--;
			}
			System.out.println();
		} while(sc.hasNext());
	}
}
