package etc.function;

public class Functions {
	public static void main(String args[]) {
		System.out.println("getSummation(4) : " + getSummation(4));
		System.out.println("getFactorial(4) : " + getFactorial(4));
		System.out.println("getDistance(0, 0, 0, 2) : " +getDistance(0, 0, 0, 2));
		System.out.println("getRoundNPoint(123.23456, 4) : " +getRoundNPoint(123.23456, 4));
	}
	// n, n-1, ... 1까지의 합
	private static int getSummation(int n){
		if(n == 1){
			return 1;
		}
		return n + getSummation(n-1);
	}
	// n, n-1, ... 1 까지의 곱
	private static int getFactorial(int n){
		if(n == 1){
			return 1;
		}
		return n * getFactorial(n-1);
	}
	// 두 점 사이의 거리
	private static double getDistance(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
	}
	
	// 소수점 n번째 자리에서 반올림
	private static double getRoundNPoint(double n, int p){
		double d = Math.pow(10, p-1);
		return Math.round(n*d)/d;
	}
	// 원의 면적 구하기
	private static double getCircleArea(double r){
		return r*r*Math.PI;
	}
	// 원주구하기
	private static double getCircleCircumference(double r){
		return 2.0*r*Math.PI;
	}
	// 호의 넓이
	private static double getArcArea(double r, double l){
		return r*l/2.0;
	}
	// 최대공약수
	private static int getGcd(int a, int b){
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
	// 최소공배수
	private static long getLcm(int a, int b){
		int gcd = getGcd(a, b);
		if(gcd == 0){
			return 0;
		}
		return Math.abs((a*b)/gcd);
	}
	// 기울기
	private static double getAngle(int x1,int y1, int x2,int y2){
		int dx = x2 - x1;
		int dy = y2 - y1;
		double rad= Math.atan2(dx, dy);
		double degree = (rad*180)/Math.PI ;
		return degree;
	}
	// 소수 구하기
	private static boolean isPrimeNumber(int n)
    {
        double nSqrt = Math.sqrt(n);
        for(int i = 2; i <= nSqrt; i++)
            if((n % i) == 0)
                return false;
        return true;
    }
    
}
