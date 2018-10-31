package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
	/*
	 * 
		계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
		연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
		마지막 도착 계단은 반드시 밟아야 한다.
	 * 
	 * */
	
	static int arr[];
	static int dp[];
	static int N;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/계단오르기_2579.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		dp[1] = arr[1];
		dp[2] = arr[2]+dp[1];
		for(int i=3; i<=N; i++)
			dp[i] = getMax ( arr[i]+arr[i-1] + dp[i-3], arr[i]+dp[i-2] );
		System.out.println(dp[N]);
	}
	
	public static int getMax(int a, int b) {
		return a>b?a:b;
	}
	
}
