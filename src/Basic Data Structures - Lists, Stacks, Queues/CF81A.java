// AC as of 5/19/2018
// Problem link: http://codeforces.com/problemset/problem/81/A
// Solution: Glorified parentheses balance. Use stack. After looping over string, pop leftover contents of stack and reverse.

import java.util.Scanner;
import java.util.Stack;

public class CF81A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		Stack<Character> s = new Stack<>();
		for(int i=0; i<in.length; i++)
			if(!s.isEmpty() && s.peek()==in[i]) s.pop();
			else s.push(in[i]);
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty()) sb.append(s.pop());
		System.out.println(sb.reverse());
	}
}
