// AC as of 3/15/2018
// Problem link: https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1508
// Solution: For each target string, do a linear scan and attempt to match each character.
//           Maintain a global running index for the current location of the source string,
//           and advance the loop when you find a match between target and source. If you ever
//           reach the end while there are still letters in the target left to process, then
//           it is impossible to match the two.
//           Program time complexity: O(source.length())+O(target.length())
//           Note: Vernon classified this problem under Binary Search. Not sure why

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		String s = br.readLine();
		int nQ = Integer.parseInt(br.readLine());
		while(nQ-->0) {
			String target = br.readLine();
			int curIndex = 0;
			int firstMatch = -1;
			boolean found = true;
			for(int i=0; i<target.length(); i++) {
				if(curIndex==s.length()) {
					found = false;
					break;
				}
				while(s.charAt(curIndex)!=target.charAt(i)) {
					curIndex++;
					if(curIndex==s.length()) {
						found = false;
						break;
					}
				}
				if(!found) break;
				if(firstMatch==-1) firstMatch = curIndex;
				curIndex++;
			}
			out.append(found ? "Matched "+firstMatch+" "+(curIndex-1) : "Not matched").append("\n");
		}
		System.out.print(out);
	}
}
