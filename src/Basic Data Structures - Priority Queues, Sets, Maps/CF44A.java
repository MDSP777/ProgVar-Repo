// AC as of 3/9/2018
// Solution: Trivial, use a HashMap to keep track of leaves already seen

import java.util.HashMap;
import java.util.Scanner;

public class CF44A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nLeaves = sc.nextInt();
		sc.nextLine();
		HashMap<String, Integer> map = new HashMap<>();
		int total = 0;
		while(nLeaves-->0) {
			String leaf = sc.nextLine();
			if(!map.containsKey(leaf)) {
				map.put(leaf, 0);
				total++;
			}
		}
		System.out.println(total);
	}
}
