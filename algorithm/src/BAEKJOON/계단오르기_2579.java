package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ��ܿ�����_2579 {
	/*
	 * 
		����� �� ���� �� ��ܾ� �Ǵ� �� ��ܾ� ���� �� �ִ�. ��, �� ����� �����鼭 �̾ ���� ����̳�, ���� ���� ������� ���� �� �ִ�.
		���ӵ� �� ���� ����� ��� ��Ƽ��� �� �ȴ�. ��, �������� ��ܿ� ���Ե��� �ʴ´�.
		������ ���� ����� �ݵ�� ��ƾ� �Ѵ�.
	 * 
	 * */
	
	static int arr[];
	static int dp[];
	static int N;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/��ܿ�����_2579.txt"));
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
