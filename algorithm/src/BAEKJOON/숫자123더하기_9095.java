package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ����123���ϱ�_9095 {
	/*
	 	���� N�� ���� 1,2,3�� �̿��Ͽ� ����� �� ���ϱ�
	 * */
	
	static int N, testCase;
	static int dp[];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/����123���ϱ�_9095.txt"));
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
			1�� ����� ����� �� : 1
			2�� ����� ����� �� : {1}+1 , 2 (���� 1�� �����쿡�� ���� 1�� Ȱ�� ==> 1���� ����Ǽ��� ����, �׸��� �ڱ� �ڽ� 2)
			3�� ����� ����� �� : {1}+2 , {2}+1  ,3  (���� 1�� �����쿡�� ���� 1�� Ȱ�� ==> 1����� ����Ǽ��� ���� , 
												  ���� 1�� �����쿡�� ���� 2�� Ȱ�� ==> 1����� ����Ǽ��� ���� ,
			                                                                          ���� 2�� �����쿡�� ���� 1�� Ȱ�� ==> 2����� ����Ǽ��� ���� ,
			                                                                          �׸��� �ڱ� �ڽ� 3 )
		    4�� ����� ����� �� : {1}+3 , {2}+2 , {3}+1 (���� 1�� �����쿡�� ���� 3��Ȱ�� ==> 1���� ����� ���� ����,
		    										����2�� ����°�쿡�� ���� 2��Ȱ�� ==> 2���� ����� ���� ����,
		    										����3�� ����°�쿡�� ���� 1��Ȱ�� ==> 3���� ����� ���� ����
		    										�ڱ� �ڽ��� ���� )
		    5�� ����� ����� �� : {2}+3 , {3}+2 , {4}+1 
		    �� ����, �ռ� �͵��� Ȱ�� �����Է� dp[n] = dp[n-3]+dp[n-2]+dp[n-1] ��ȭ�� ����
		*/
		
		for(int i=4; i<=N; i++)
			dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
		
		System.out.println(dp[N]);
		
		}
		
		
		
	}
	
}
