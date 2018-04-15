// AC as of 3/6/2018
// Problem link: https://www.hackerrank.com/challenges/balanced-brackets/problem
// Solution: textbook brace balance using a stack

import java.util.Scanner;

import java.util.Stack;

public class HR_BalancedBrackets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			String in = sc.next();
			boolean valid = true;
			Stack<Character> s = new Stack<>();
			for(int i=0; i<in.length(); i++) {
				char c = in.charAt(i);
				if(c=='(' || c=='[' || c=='{') s.push(c);
				else {
					if(s.isEmpty()) {
						valid = false;
						break;
					}
					char c2;
					switch(c) {
						case ']':
							c2 = '[';
							break;
						case '}':
							c2 = '{';
							break;
						default:
							c2 = '(';
					}
					if(s.peek()==c2) s.pop();
					else {
						valid = false;	
						break;
					}
				}
			}
			System.out.println(s.isEmpty() && valid ? "YES" : "NO");
		}
	}
}
