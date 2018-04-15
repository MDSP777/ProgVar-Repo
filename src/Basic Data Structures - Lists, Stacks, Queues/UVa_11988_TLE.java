// TLE Code for UVa 11988
// Problem link: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3139
// Exercise: Explain why this code TLEs and UVa_11988.java is AC

import java.util.Scanner;

public class UVa_11988_TLE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			String in = sc.next();
			StringBuilder sbRight = new StringBuilder();
			StringBuilder sbLeft = new StringBuilder();
			boolean leftTyping = false;
			for(int i=0; i<in.length(); i++) {
				if(in.charAt(i)=='[') {
					sbRight = sbLeft.append(sbRight);
					sbLeft = new StringBuilder();
					leftTyping = true;
				}
				else if(in.charAt(i)==']') {
					sbRight = sbLeft.append(sbRight);
					sbLeft = new StringBuilder();
					leftTyping = false;
				}
				else {
					if(leftTyping) sbLeft.append(in.charAt(i));
					else sbRight.append(in.charAt(i));
				}
			}
			sbLeft.append(sbRight);
			System.out.println(sbLeft);
		} while(sc.hasNext());
	}
}
