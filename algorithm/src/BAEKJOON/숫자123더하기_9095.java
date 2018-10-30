package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 숫자123더하기_9095 {
	/*
	 	정수 N을 숫자 1,2,3을 이용하여 경우의 수 구하기
	 * */
	
	static int N, testCase;
	static int dp[];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/숫자123더하기_9095.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());

		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int j=0; j<testCase; j++)
		{
			N = Integer.parseInt(br.readLine());
		
		/*
			1을 만드는 경우의 수 : 1
			2를 만드는 경우의 수 : {1}+1 , 2 (기존 1을 만든경우에서 숫자 1만 활용 ==> 1만든 경우의수와 같음, 그리고 자기 자신 2)
			3을 만든는 경우의 수 : {1}+2 , {2}+1  ,3  (기존 1을 만든경우에서 숫자 1만 활용 ==> 1만드는 경우의수와 같음 , 
												  기존 1을 만든경우에서 숫자 2만 활용 ==> 1만드는 경우의수와 같음 ,
			                                                                          기존 2를 만든경우에서 숫자 1만 활용 ==> 2만드는 경우의수와 같음 ,
			                                                                          그리고 자기 자신 3 )
		    4를 만드는 경우의 수 : {1}+3 , {2}+2 , {3}+1 (기존 1을 만든경우에서 숫자 3만활용 ==> 1만든 경우의 수와 같음,
		    										기존2를 만드는경우에서 숫자 2만활용 ==> 2만든 경우의 수와 같음,
		    										기존3을 만드는경우에서 숫자 1만활용 ==> 3만든 경우의 수와 같음
		    										자기 자신은 없음 )
		    5를 만드는 경우의 수 : {2}+3 , {3}+2 , {4}+1 
		    ★ 따라서, 앞선 것들을 활용 가능함로 dp[n] = dp[n-3]+dp[n-2]+dp[n-1] 점화식 나옴
		*/
		
		for(int i=4; i<=N; i++)
			dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
		
		System.out.println(dp[N]);
		
		}
		
		
		
	}
	
}
