package jungol.basic;

import java.util.Scanner;

public class NumberSquare {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		square1(n, m);
		
		sc.close();
	}
	
	public static void square1(int n, int m){
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
