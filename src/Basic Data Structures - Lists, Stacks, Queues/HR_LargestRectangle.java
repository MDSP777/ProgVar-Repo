// AC as of 3/8/2018
// Problem link: https://www.hackerrank.com/challenges/largest-rectangle/problem
// Solution: By using a stack, one can keep track of the indices of the 
//           smallest elements left and right of any i in O(n) time
//           Add a building with height 0 to the end of the list to handle
//           the case where all buildings are ascending (and thus nothing is popped)

import java.util.Scanner;
import java.util.Stack;

public class HR_LargestRectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nBuildings = sc.nextInt();
		int[] buildings = new int[nBuildings+1];
		for(int i=0; i<nBuildings; i++) buildings[i] = sc.nextInt();
		buildings[nBuildings] = 0;
		int i = 0;
		long ans = 0;
		Stack<Integer> s = new Stack<>();
		while(i<buildings.length) {
			if(s.isEmpty() || buildings[i]>=buildings[s.peek()]) s.push(i++);
			else {
				int h = s.pop();
				ans = Math.max(ans, buildings[h] * (s.isEmpty() ? i : i-s.peek()-1));
			}
		}
		System.out.println(ans);
	}
}
