package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ����1�θ����_1463 {
	/*
	 * 
		X�� 3���� ������ ��������, 3���� ������.
		X�� 2�� ������ ��������, 2�� ������.
		1�� ����.
		������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.
	 * 
	 * */
	
	static int X, min;
	static int dp[];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/����1�θ����_1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		dp = new int[X+1];
		
		/* ����Լ��� Ǯ��
		func(X,0);
		System.out.println(min);
		*/
		
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=3; i<=X; i++)
			dp[i] = getMin(
							i%3==0?dp[i/3]+1:Integer.MAX_VALUE, 
							i%2==0?dp[i/2]+1:Integer.MAX_VALUE, 
							dp[i-1]+1
					);
		
		System.out.println(dp[X]);
		
	}
	
	
	// ��� �Լ�
	public static void func(int num, int cnt) {
		if(num==1){
			min=cnt;
			return ;
		}
		if(num%3==0 && min>cnt)
			func(num/3,cnt+1);
		if(num%2==0 && min>cnt)
			func(num/2,cnt+1);
		if(min>cnt)
			func(num-1,cnt+1);
	}
	
	public static int getMin(int a, int b, int c){
		return (a<b?a:b)<c?(a<b?a:b):c;
	}
}
