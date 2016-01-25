package algospot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Allergy {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=0; t<testCase;++t){
			// 친구수
			int n = sc.nextInt();
			// 음식 수
			int m = sc.nextInt();
			
			Map<String, Integer> names = new HashMap<>();
			int[][] map = new int[n][m];
			for(int i=0; i<n; ++i){
				names.put(sc.next(), i);
			}
			for(int i=0; i<m; ++i){
				int idx = sc.nextInt();
				map[i][idx] = names.get(sc.next());
			}
		}
		
		sc.close();
	}
}
