// AC as of 2/28/2018
// Solution: stack manipulation using arraylists
//           Gotcha case: cd can include ..

import java.util.ArrayList;
import java.util.Scanner;

public class CF158C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		Dir d = new Dir("/");
		while(nC-->0) {
			String in = sc.next();
			if(in.equals("pwd")) System.out.println(d);
			else {
				in = sc.next();
				if(in.startsWith("/")) d = new Dir(in);
				else d.add(in);
			}
		}
	}
	
	static class Dir {
		ArrayList<String> contents;
		
		public Dir(String in) {
			contents = new ArrayList<>();
			String[] split = in.split("/");
			for(int i=0; i<split.length; i++) {
				if(split[i].equals("..")) contents.remove(contents.size()-1);
				else if(!split[i].equals("")) contents.add(split[i]);
			}
		}
		
		void add(String s) {
			String[] split = s.split("/");
			for(int i=0; i<split.length; i++) {
				if(split[i].equals("..")) contents.remove(contents.size()-1);
				else if(!split[i].equals("")) contents.add(split[i]);
			}
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder("/");
			for(int i=0; i<contents.size(); i++) sb.append(contents.get(i)).append("/");
			return sb.toString();
		}
	}
}
