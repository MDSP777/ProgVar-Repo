// AC as of 3/6/2018
// Solution: Since array is circular, starting point
//           is simply d%n
//           Afterwards, it's just a matter of printing the array

import java.util.Scanner;

public class HR_LeftRotation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		int start = d%n;
		sb.append(arr[start]);
		for(int i=1; i<n; i++) {
			start++;
			start%=n;
			sb.append(" ").append(arr[start]);
		}
		System.out.print(sb);
	}
}
