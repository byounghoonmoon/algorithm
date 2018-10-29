package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.StringTokenizer;

public class �����ֽý�_2156 {
	/*
	 *   n���� ������ 
	 *   ���� 3���� ������
	 *   ���� ���� ������ �ִ� ����   
	 * */
	
	static int[] wine, dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/�����ֽý�_2156.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());

		wine = new int[10001];
		dp = new int[10001];
		
		/*
		   ����Ǽ� 
		   1. �ش����� �ȸԴ°��
		   2. �ش����� �԰� + �������� �Դ� ��� (���������� �ȹ�)
		   3. �ش����� �԰� + �������� �ȸԴ°�� (���������� ó��)
		   
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