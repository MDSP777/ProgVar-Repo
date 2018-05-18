// AC as of 5/18/2018
// Problem link: http://codeforces.com/problemset/problem/450/A
// Solution: Simple simulation. Use queue. Subtract m from head each poll, and push if new val >0. Output index when only 1 elem left in queue.

import java.util.LinkedList;
import java.util.Scanner;

public class CF450A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Child> l = new LinkedList<>();
		for(int i=1; i<=n; i++) l.add(new Child(sc.nextInt(), i));
		while(l.size()>1) {
			Child c = l.poll();
			c.val-=m;
			if(c.val>0) l.add(c);
		}
		System.out.println(l.peek().index);
	}
	
	static class Child {
		int val;
		int index;
		
		public Child(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}
}
