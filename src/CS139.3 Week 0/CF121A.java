// AC as of 4/12/2018
// Problem link: http://codeforces.com/problemset/problem/121/A
// Solution: generate an ArrayList of all lucky numbers with 1 to 9 digits (problem bounds). After, jump from
//           one lucky number to another from l to r. Binary search can be used to optimize the next() function,
//           but linear search should comfortably pass the time limit as well as there are only ~2000 lucky numbers.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CF121A {
	static ArrayList<Long> lucky;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		lucky = new ArrayList<>();
		lucky.add((long) 4);
		lucky.add((long) 7);
		for(int i=1; i<10; i++) {
			long t = (long) Math.pow(10, i);
			long four = t*4;
			long  seven = t*7;
			ArrayList<Long> n = new ArrayList<>();
			for(int cur=0; cur<lucky.size(); cur++) {
				if(nDigits(lucky.get(cur))==i) {
					n.add(four+lucky.get(cur));
					n.add(seven+lucky.get(cur));
				}
			}
			for(int cur=0; cur<n.size(); cur++) lucky.add(n.get(cur));
		}
		Collections.sort(lucky);
		long l = sc.nextLong();
		long r = sc.nextLong();
		long total = 0;
		do {
			long next = next(l);
			if(next>=r){
				total+=(r-l+1)*next;
				l = next;
			} else {
				total+=(next-l+1)*next;
				l = next+1;
				if(l==r) total+=next(l);
			}
		}while(l<r);
		System.out.println(total);
	}

	private static int nDigits(Long l) {
		int total = 0;
		while(l>0) {
			l/=10;
			total++;
		}
		return total;
	}

	private static long next(long l) {
		int index = Collections.binarySearch(lucky, l);
		if(index<0) index = -(index+1);
		return lucky.get(index);
	}
}
