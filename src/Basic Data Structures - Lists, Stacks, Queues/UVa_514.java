// AC as of 3/7/2018
// Solution: Since cars can only move in one direction, problem can easily
//			 be simulated by treating A, B, and the station as stacks

import java.util.Scanner;
import java.util.Stack;

public class UVa_514 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int nCars = sc.nextInt();
			if(nCars==0) break;
			while(true) {
				int firstCar = sc.nextInt();
				if(firstCar==0) break;
				Stack<Integer> aStack = new Stack<>();
				for(int i=nCars; i>0; i--) aStack.push(i);
				Stack<Integer> station = new Stack<>();
				Stack<Integer> bStack = new Stack<>();
				int[] outArrangement = new int[nCars];
				outArrangement[0] = firstCar;
				for(int i=1; i<nCars; i++) outArrangement[i] = sc.nextInt();
				station.push(aStack.pop());
				for(int i=0; i<nCars; i++) {
					while(station.peek()!=outArrangement[i]) {
						if(aStack.isEmpty()) break;
						station.push(aStack.pop());
					}
					if(station.peek()==outArrangement[i]) {
						bStack.push(station.pop());
						if(station.isEmpty() && aStack.isEmpty()) break;
						if(station.isEmpty()) station.push(aStack.pop());
					}
				}
				System.out.println(bStack.size()==nCars ? "Yes" : "No");
			}
			System.out.println();
		}
	}
}
