// AC as of 3/8/2018
// Solution: Build a Map containing info about each player and each
//           round they played. Afterwards, iterate over the map and
//           look for the max score. If there is a tie, use the stored
//           info to determine who reached the score first

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CF2A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nRounds = sc.nextInt();
		HashMap<String, MapElement> map = new HashMap<>();
		for(int i=0; i<nRounds; i++) {
			String player = sc.next();
			int score = sc.nextInt();
			if(!map.containsKey(player)) map.put(player, new MapElement());
			map.get(player).add(score, i);
		}
		
		int maxScore = 0;
		String winner = "";
		for(String player: map.keySet()) {
			if(map.get(player).total>maxScore) {
				maxScore = map.get(player).total;
				winner = player;
			} else if(map.get(player).total==maxScore &&
				map.get(player).findEarliest(maxScore)<map.get(winner).findEarliest(maxScore)) winner = player;
		}
		System.out.println(winner);
	}
	
	static class MapElement {
		ArrayList<Round> rounds;
		int total;
		
		public MapElement() {
			rounds = new ArrayList<>();
			total = 0;
		}
		
		public int findEarliest(int target) {
			int total = 0;
			for(int i=0; i<rounds.size(); i++) {
				total+=rounds.get(i).score;
				if(total>=target) return rounds.get(i).index;
			}
			return 1000000;
		}

		void add(int score, int index) {
			rounds.add(new Round(score, index));
			total+=score;
		}
	}
	
	static class Round {
		int score;
		int index;
		
		public Round(int score, int index) {
			this.score = score;
			this.index = index;
		}
	}
}
