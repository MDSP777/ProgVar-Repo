// AC as of 3/6/2018
// Solution: Build a list of strings, and maintain a single "current"
// 			 string. Each time you encounter a [ or ], append the "current"
//			 string to its respective location (start or end of the list)

import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			StringBuilder out = new StringBuilder();
			String in = sc.next();
			LinkedList<StringBuilder> ll = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			boolean leftTyping = false;
			for(int i=0; i<in.length(); i++) {
				if(in.charAt(i)=='[') {
					if(leftTyping) ll.addFirst(sb);
					else ll.addLast(sb);
					sb = new StringBuilder();
					leftTyping = true;
				}
				else if(in.charAt(i)==']') {
					if(leftTyping) ll.addFirst(sb);
					else ll.addLast(sb);
					sb = new StringBuilder();
					leftTyping = false;
				}
				else sb.append(in.charAt(i));
			}
			if(leftTyping) ll.addFirst(sb);
			else ll.addLast(sb);
			for(StringBuilder cur : ll) out.append(cur);
			System.out.println(out);
		} while(sc.hasNext());
	}
}
