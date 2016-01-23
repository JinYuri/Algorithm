package algospot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arctic {
	// 기지마다 무전기를 설치하고 본부에서 간접적으로 모든 무전기에 연락 가능한 무전기의 출력범위 구하기
	// 모든 두 점사이의 거리 도출
	public static double[][] iMap;
	public static int[] passMap;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int testCase = sc.nextInt();
		for(int tc=0; tc<testCase; ++tc){
			// 기지 수
			int n = sc.nextInt();
			// 기지 수 만큼 기지의 좌표를 받아 배열에 저장
			double[][] pMap = new double[n][2];
			for(int i=0; i<n; ++i){
				pMap[i][0] = sc.nextDouble();
				pMap[i][1] = sc.nextDouble();
			}
			
			// 모든 두 점사이의 거리 도출
			iMap = new double[n][n];
			for(int i=0; i<n; ++i){
				for(int j=i+1; j<n; ++j){
					iMap[i][j] = iMap[j][i] = getDistance(pMap[i][0], pMap[i][1], pMap[j][0], pMap[j][1]);
				}
			}
			
			// 기지본부(0,0)에서 특정 점간의 거리를 무전기 출력범위로 두고
			// 그 출력범위로 모두 커버되는지 확인
			// 커버되지 않는 점이 있을 경우 간접으로 가능한지 확인
			List<Double> resultList = new ArrayList<>();
			for(int i=1; i<n; ++i){
				passMap = new int[n];
				double d = iMap[0][i];
				setPassMap(0, d);
				boolean isPassed = true;
				for(int p=0; p<passMap.length; ++p){
					if(passMap[p] != 1){
						isPassed = false;
						break;
					}
				}
				if(isPassed){
					resultList.add(d);
				}
			}
			
			// 출력가능한 범위값 중 최소값 출력
			double min = Double.MAX_VALUE;
			for(int i=1; i<resultList.size(); ++i){
				if(min > resultList.get(i)){
					min = resultList.get(i);
				}
			}
			
			System.out.println(Math.round((min*100))/100.0);
			
		}
		sc.close();
	}

	private static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
	}
	private static void setPassMap(int index, double distance){
		for(int i=0; i<iMap[index].length; ++i){
			if(i == index){
				passMap[i] = 1;
			}
			else if(passMap[i] == 1){
				continue;
			}
			else if(iMap[index][i] <= distance){
				passMap[i] = 1;
			}
			else{
				setPassMap(i, distance);
			}
		}
	}
}
