// AC as of 3/1/2018
// Solution: Simple simulation. Use BigInteger to manage large numbers

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class CF493B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> one = new ArrayList<>();
		ArrayList<Integer> two = new ArrayList<>();
		BigInteger oneScore = BigInteger.ZERO;
		BigInteger twoScore = BigInteger.ZERO;
		boolean firstLast = true;
		while(n-->0) {
			int x = sc.nextInt();
			if(n==0 && x<0) firstLast = false;
			if(x<0) {
				x*=-1;
				two.add(x);
				twoScore = twoScore.add(new BigInteger(x+""));
			} else {
				one.add(x);
				oneScore = oneScore.add(new BigInteger(x+""));
			}
		}
		if(oneScore.compareTo(twoScore)>0) System.out.println("first");
		else if(oneScore.compareTo(twoScore)<0) System.out.println("second");
		else {
			int l = Math.min(one.size(), two.size());
			boolean allEqual = true;
			for(int i=0; i<l; i++) {
				if(one.get(i)>two.get(i)) {
					System.out.println("first");
					allEqual = false;
					break;
				}
				if(one.get(i)<two.get(i)) {
					System.out.println("second");
					allEqual = false;
					break;
				}
			}
			if(allEqual) {
				if(one.size()>two.size()) System.out.println("first");
				else if(one.size()<two.size()) System.out.println("second");
				else {
					System.out.println(firstLast ? "first" : "second");
				}
			}
		}
	}
}
