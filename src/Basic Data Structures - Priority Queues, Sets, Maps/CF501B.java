// AC as of 3/9/2018
// Solution: Create a class to remember the original name of each user
//           Create a HashMap with key being user's current name
//           If new user, just put into map
//           If old user, remove mapping to previous name, and switch
//           mapping to new name

import java.util.HashMap;
import java.util.Scanner;

public class CF501B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<String, User> map = new HashMap<>();
		while(n-->0) {
			String oldName = sc.next();
			String newName = sc.next();
			if(!map.containsKey(oldName)) map.put(newName, new User(oldName, newName));
			else {
				User u = map.get(oldName);
				u.curName = newName;
				map.remove(oldName);
				map.put(newName, u);
			}
		}
		System.out.println(map.size());
		for(User u: map.values()) System.out.println(u);
		
	}
	
	static class User {
		String originalName;
		String curName;
		
		public User (String oN, String cN) {
			originalName = oN;
			curName = cN;
		}
		
		public String toString() {
			return originalName+" "+curName;
		}
	}
}
