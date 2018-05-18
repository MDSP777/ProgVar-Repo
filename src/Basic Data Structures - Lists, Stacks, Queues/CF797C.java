// AC as of 5/19/2018
// Problem link: http://codeforces.com/problemset/problem/797/C
// Solution: First, sort s (while remembering original index). Use custom class with comparator to do this.
//           Take the first character of the sorted string and pop characters from s until that first character's original index
//           is reached. Then pop from t into u once (we are now guaranteed that this is the smallest character in the string).
           
//           Next, iterate over the rest of the sorted string. Look for the first element whose original index > where we are
//           right now (initially, the index of the first character). Pop from t while top value <= that element's value, then
//           make your way to the new element's original index in the same way as earlier (keep pushing into t newIndex-curIndex
//           times, then pop from t into u once). Set cur = this element. Repeat until we reach the end of the sorted string.

//           Lastly, pop any remaining elements from t into u then print u.

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CF797C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		ArrayList<C> sorted = new ArrayList<>();
		LinkedList<Character> s = new LinkedList<>();
		Stack<Character> t = new Stack<>();
		StringBuilder u = new StringBuilder();
		for(int i=0; i<in.length; i++) {
			s.add(in[i]);
			sorted.add(new C(in[i], i));
		}
		Collections.sort(sorted);
		C smallest = sorted.get(0);
		for(int i=0; i<=smallest.o_index; i++) t.push(s.poll());
		u.append(t.pop());
		for(int i=1; i<sorted.size(); i++) {
			if(sorted.get(i).o_index>smallest.o_index) {
				while(!t.isEmpty() && t.peek()<=sorted.get(i).val) u.append(t.pop());
				for(int j=smallest.o_index+1; j<=sorted.get(i).o_index; j++) t.push(s.poll());
				u.append(t.pop());
				smallest = sorted.get(i);
			}
		}
		while(!t.isEmpty()) u.append(t.pop());
		System.out.println(u.toString());
	}
	
	static class C implements Comparable<C> {
		char val;
		int o_index;
		
		public C(char val, int o_index) {
			 this.val = val;
			 this.o_index = o_index;
		}

		@Override
		public int compareTo(C o) {
			if(this.val==o.val) return Integer.compare(this.o_index, o.o_index);
			return Integer.compare(this.val, o.val);
		}
	}
}
