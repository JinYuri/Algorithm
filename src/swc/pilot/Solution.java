package swc.pilot;

import java.util.Scanner;

public class Solution {
	// 점의 갯수가 N개일 때 그림자의 갯수가 N-1, N-2,..1개가 되는 빛의 방향수 구하기
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int tcCnt=0; tcCnt<tc; tcCnt++){
			// 점의 갯수
			int pCnt = sc.nextInt();
			// 점의 x,y 정보를 담은 배열
			int[][] pArr = new int[pCnt][2];
			// Hidden point 여부
			int[] hpArr = new int[pCnt];
			// 빛의 갯수 결과를 담을 배열
			int[] rArr = new int[pCnt];
			
			for(int i=0; i<pCnt; i++){
				pArr[i][0] = sc.nextInt();
				pArr[i][1] = sc.nextInt();
			}
			
			// 두점 사이의 기울기를 구한다. 
			// fArr[i]에는 j, a, b (비교한 점, 기울기, y절편)
			double[][][] fArr = new double [pCnt][pCnt][2];
			
			for(int i=0; i<pCnt; i++){
				for(int j=i+1; j<pCnt; j++){
					double a = getA(pArr[i][0], pArr[i][1], pArr[j][0], pArr[j][1]);
					double b = getB(a, pArr[i][0], pArr[i][1]);
					fArr[i][j][0] = a;
					fArr[i][j][1] = b;
					
					System.out.println(i + " " + j + " " + a+" "+b);
				}
			}
			
			// 구해진 기울기 a 만큼 광원을 설정 한 후 그림자 갯수를 구한다.
			for(int i=0; i<pCnt; i++){
				for(int j =i+1; j<pCnt; j++){
					double light = fArr[i][j][0];
					// 광원의 기울기와 같은 기울기가 몇개인지 찾는다.
					for(int ii=0; ii<pCnt; ii++){
						for(int jj =ii+1; jj<pCnt; jj++){
							if(light == fArr[ii][jj][0]){
								hpArr[jj] = 1;
							}
						}
					}
					// Hidden이 아닌 점의 갯수를 센다.
					int rCnt = 0;
					for(int h=0; h<hpArr.length; h++){
						if(hpArr[h] == 0){
							rCnt++;
						}
					}
					rArr[rCnt]++;
					// hpArr 초기화
					hpArr = new int[pCnt];
				}
			}
			
			// 결과 출력
			System.out.print("#");
			for(int i=1; i<rArr.length; i++){
				System.out.print(" " + rArr[i]*2);
			}
		}
	}

	private static double getA(int x1, int y1, int x2, int y2){
		double x = x2-x1;
		double y = y2-y1;
		// y=b의 구조
		if(x == 0){
			return Double.POSITIVE_INFINITY;
		}
		return y/x;
	}
	
	private static double getB(double a, int x, int y) {
		if(Double.isInfinite(a)){
			return y;
		}
		else{
			return y - (a*x);
		}
	}
}
