// AC as of 3/14/2018
// Problem link: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1167
// Solution: Store species in a HashMap, with value being the frequency, and keep track of the
//           global total. After, store the keySet in an ArrayList, and then sort (for alphabetical order).
//           Finally, use a simple percentage formula to calculate the answer for each species.
//           Surprisingly, using a TreeMap instead of a HashMap to bypass the ArrayList actually caused TLE.
//           Not yet sure why.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10226 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		while(nC-->0) {
			HashMap<String, Long> map = new HashMap<>();
			long total = 0;
			while(true) {
				if(!sc.hasNext()) break;
				String s = sc.nextLine();
				if(s.equals("")) break;
				if(!map.containsKey(s)) map.put(s, (long) 1);
				else map.put(s, map.get(s)+1);
				total++;
			}
			ArrayList<String> species = new ArrayList<>();
			for(String s: map.keySet()) species.add(s);
			Collections.sort(species);
			for(String s: species) System.out.printf("%s %.4f\n", s, (map.get(s)*1.0)/total*100);
			if(nC>0) System.out.println();
		}
	}
}
