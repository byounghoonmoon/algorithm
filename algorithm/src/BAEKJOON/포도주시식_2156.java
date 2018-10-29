package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 포도주시식_2156 {
	/*
	 *   n개의 와인잔 
	 *   연속 3잔은 못마심
	 *   가장 많이 먹을수 있는 와인   
	 * */
	
	static int[] wine, dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/포도주시식_2156.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());

		wine = new int[10001];
		dp = new int[10001];
		
		/*
		   경우의수 
		   1. 해당잔을 안먹는경우
		   2. 해당잔을 먹고 + 이전잔을 먹는 경우 (이전전잔은 안묵)
		   3. 해당잔을 먹고 + 이전전을 안먹는경우 (이전전잔을 처묵)
		   
		   1. dp[i-1]
		   2. wine[i] + wine[i-1] + dp[i-3]
		   3. wine[i] + wine[i-2] ==> wine[i] + dp[i-2] 
		   
		*/
		
		for(int i=1; i<=N; i++)
			wine[i] = Integer.parseInt(br.readLine());
		
//		dp[0] = 0;
		dp[1] = wine[1];		
		dp[2] = wine[1]+wine[2];
		
		
		for(int i=3; i<=N; i++){
			dp[i] = max(	dp[i-1],
							wine[i]+wine[i-1]+dp[i-3],
							wine[i]+dp[i-2]
						);
		}
		System.out.println(dp[N]);
	}
	
	public static int max (int a, int b, int c){
		return (a>b?a:b)>c?(a>b?a:b):c;
	}
	
	
}