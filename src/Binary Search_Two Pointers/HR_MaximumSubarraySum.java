import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class HR_MaximumSubarraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			long m = sc.nextLong();
			HashSet<Long> set = new HashSet<>();
			ArrayList<Long> list = new ArrayList<>();
 			for(int i=0; i<n; i++) {
				long l = sc.nextLong();
				for(int j=0; j<list.size(); j++) 
					if(!set.contains((l+list.get(j))%m)) {
						set.add((l+list.get(j))%m);
						list.add((l+list.get(j))%m);
					}
				if(!set.contains(l%m)) {
					set.add(l%m);
					list.add(l%m);
				}
			}
			Collections.sort(list);
			System.out.println(list.get(list.size()-1));
		}
	}
}
