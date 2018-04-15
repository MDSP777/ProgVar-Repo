// AC as of 3/24/2018
// Problem link: http://codeforces.com/problemset/problem/778/A
// Solution: Binary search the answer
//           After each letter removal, the string will either be in a YES state (target
//           string is a subsequence) or a NO state (target string is no longer a subsequence).
//           Due to the nature of the problem, one can assume that all states to the left of a
//           YES state are also YES states, and all states to the right of a NO state are also
//           NO states. Therefore, binary search can be employed to find the answer. Start in the
//           middle of the string, then check if it is a YES state or not. If it is, move to the
//           right, and if it is a NO state, move to the left. Keep going until the binary search
//           converges on a single index. That index will be the answer.

import java.util.Arrays;
import java.util.Scanner;

public class CF778A {
	static char[] src;
	static char[] target;
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		src = sc.next().toCharArray();
		target = sc.next().toCharArray();
		p = new int[src.length];
		for(int i=0; i<src.length; i++) p[i] = sc.nextInt()-1;
		System.out.println(getAns(0, src.length));
	}
	
	static int getAns(int start, int end) {
		if(end-start==1) {
			if(isSub(start)) return end;
			else return start;
		} else {
			int mid = (end+start)/2;
			if(isSub(mid)) return getAns(mid, end);
			else return getAns(start, mid);
		}
	}
	
	static boolean isSub(int x) {
		char[] state = Arrays.copyOf(src, src.length);
		for(int i=0; i<=x; i++) state[p[i]] = '_';
		int index = 0;
		for(int i=0; i<target.length; i++) {
			if(index==state.length) return false;
			while(target[i]!=state[index]) {
				index++;
				if(index==state.length) return false;
			}
			index++;
		}
		return true;
	}
}
	
