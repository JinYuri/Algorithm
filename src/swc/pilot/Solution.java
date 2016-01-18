package swc.pilot;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	// 점의 갯수가 N개일 때 그림자의 갯수가 N-1, N-2,..1개가 되는 빛의 방향수 구하기
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int tcCnt=1; tcCnt<=tc; tcCnt++){
			// 점의 갯수
			int pCnt = sc.nextInt();
			// 점의 x,y 정보를 담은 배열
			int[][] pArr = new int[pCnt][2];
			// Hidden point 여부
			int[] hpArr = new int[pCnt];
			// 빛의 갯수 결과를 담을 배열
			int[] rArr = new int[pCnt];
			int fCnt = getSummation(pCnt-1);
			
			for(int i=0; i<pCnt; i++){
				pArr[i][0] = sc.nextInt();
				pArr[i][1] = sc.nextInt();
			}
			// 두점 사이의 기울기를 구한다. 
			// fArr[i]에는 (visible, 점 j, 기울기 x, 기울기 y)
			int[][] fArr = new int [fCnt][4];
			int tfCnt = 0;
			
			for(int i=0; i<pCnt; i++){
				for(int j=i+1; j<pCnt; j++){
					int ax = pArr[j][0] - pArr[i][0];
					int ay =  pArr[j][1] - pArr[i][1];
					int gcd = getGcd(ax, ay);
					fArr[tfCnt][0] = 0;
					fArr[tfCnt][1] = j;
					fArr[tfCnt][2] = ax/gcd;
					fArr[tfCnt][3] = ay/gcd;
					tfCnt++;
				}
			}
			
			// 구해진 기울기 a 만큼 광원을 설정 한 후 그림자 갯수를 구한다.
			for(int f=0; f<fCnt; f++){
				int lightX = fArr[f][2];
				int lightY = fArr[f][3];
				hpArr = new int[pCnt];
				for(int ff=f; ff<fCnt; ff++){
					// 광원의 기울기와 같은 기울기가 몇개인지 찾는다.
					int visible = fArr[ff][0];
					int jj = fArr[ff][1];
					int ax = fArr[ff][2];
					int ay = fArr[ff][3];

					if(visible != 0){
						continue;
					}
					// light와 같은 함수
					else if(f == ff){
						hpArr[jj] = 1;
						fArr[ff][0] = 1;
					}
					// y=b와 같은 형태
					else if(lightX == 0 && ax == 0){
						hpArr[jj] = 1;
						fArr[ff][0] = 1;
					}
					// x=a와 같은 형태
					else if (lightY == 0 && ay == 0){
						hpArr[jj] = 1;
						fArr[ff][0] = 1;
					}
					// 부호의 곱이 같고 절대 값이 같으면 같은 선에 존재
					else if(Math.abs(lightX) == Math.abs(ax) && Math.abs(lightY) == Math.abs(ay)){
						if((lightX * lightY) - (ax*ay) == 0 ){
							hpArr[jj] = 1;
							fArr[ff][0] = 1;
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
				if(rCnt != pCnt){
					rArr[rCnt]++;
				}
			}
			
			// 결과 출력
			System.out.print("# " + tcCnt);
			for(int i=1; i<rArr.length; i++){
				System.out.print(" " + rArr[i]*2);
			}
		}
		sc.close();
	}
	// 최대공약수 구하기
	private static int getGcd(int a, int b) {
	    BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	
	// summation 구하기
	private static int getSummation(int n){
		if(n == 1){
			return 1;
		}
		return n + getSummation(n-1);
	}
}
