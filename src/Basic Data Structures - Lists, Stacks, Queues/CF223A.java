// AC as of 3/1/2018
// Problem link: http://codeforces.com/problemset/problem/223/A
// Solution: For each open brace, try to identify a matching closing brace
//           Store these pairs (index of opening and closing brace) in a list
//           Identify brace pairs that are covered by others (ie. pair j is 
//           covered by pair i if i.end > j.end && i.start < j.start) and 
//           discard them
//           Identify contiguous brace pairs (ie. i.end+1 == i+1.start) and
//           merge them
//           Find largest amount of [ from remaining brace pairs

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class CF223A {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		int[] nBrackets = new int[in.length()+1];
		Stack<StackElement> s = new Stack<>();
		ArrayList<Point> points = new ArrayList<>();
		for(int i=0; i<in.length(); i++) {
			char c = in.charAt(i);
			if(c=='[') nBrackets[i+1]++;
			if(i>0) nBrackets[i+1]+=nBrackets[i];
			if(c=='(' || c=='[') {
				s.push(new StackElement(c, i));
			} else if(c==')') {
				if(!s.isEmpty()) {
					if(s.peek().c=='(') {
						points.add(new Point(s.peek().index, i));
						s.pop();
					} else s = new Stack<>();
				}
			} else {
				if(!s.isEmpty()) { 
					if(s.peek().c=='[') {
						points.add(new Point(s.peek().index, i));
						s.pop();
					} else s = new Stack<>();
				}
			}
		}
		Collections.sort(points);
		ArrayList<Point> cleanedPoints = new ArrayList<>();
		int curEnd = -1;
		for(int i=0; i<points.size(); i++) {
			if(points.get(i).start>curEnd) {
				curEnd = points.get(i).end;
				cleanedPoints.add(points.get(i));
			}
		}
		points = cleanedPoints;
		boolean didMerge = false;
		for(int i=0; i<points.size(); i++) {
			if(i<points.size()-1) {
				if(points.get(i).end+1==points.get(i+1).start) {
					points.get(i+1).start = points.get(i).start;
					points.remove(i);
					i--;
				}
			}
		}
		int best = 0;
		Point bestPoint = null;
		for(int i=0; i<cleanedPoints.size(); i++) {
			Point curP = cleanedPoints.get(i);
			int curBest = nBrackets[curP.end+1]-nBrackets[curP.start];
			if(curBest>best) {
				best = curBest;
				bestPoint = cleanedPoints.get(i);
			}
		}
		System.out.println(best);
		System.out.println(bestPoint==null ? "" : in.substring(bestPoint.start, bestPoint.end+1));
	}
	
	static class Point implements Comparable<Point> {
		int start;
		int end;
		
		public Point(int a, int b) {
			start = a;
			end = b;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.start, o.start);
		}
	}
	
	static class StackElement {
		char c;
		int index;
		
		public StackElement(char c, int index) {
			this.c = c;
			this.index = index;
		}
	}
}
