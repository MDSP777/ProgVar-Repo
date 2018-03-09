// AC as of 3/9/2018
// Solution: Trivial, store chat list in String array, then read from the back
//           Use HashMap to keep track of names already seen

import java.util.HashMap;
import java.util.Scanner;

public class CF637B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nChats = sc.nextInt();
		String[] chats = new String[nChats];
		for(int i=0; i<nChats; i++) chats[i] = sc.next();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=nChats-1; i>=0; i--){
			if(!map.containsKey(chats[i])) {
				map.put(chats[i], 0);
				System.out.println(chats[i]);
			}
		}
	}
}
