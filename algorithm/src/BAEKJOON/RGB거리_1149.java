package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB�Ÿ�_1149 {
	/*
	 * 
		����� �� ���� �� ��ܾ� �Ǵ� �� ��ܾ� ���� �� �ִ�. ��, �� ����� �����鼭 �̾ ���� ����̳�, ���� ���� ������� ���� �� �ִ�.
		���ӵ� �� ���� ����� ��� ��Ƽ��� �� �ȴ�. ��, �������� ��ܿ� ���Ե��� �ʴ´�.
		������ ���� ����� �ݵ�� ��ƾ� �Ѵ�.
	 * 
	 * */
	
	static int N;
	static int arr[][];
	static int dp[][];

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/RGB�Ÿ�_1149.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		arr = new int[N+1][4];
		dp = new int[N+1][4];
		
		StringTokenizer st;
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// dp[1][1] = arr[1][1]  + getMax(arr[0][2],arr[0][3])
		// dp[1][2] = arr[1][2]  + getMax(arr[0][1],arr[0][3])
		// dp[1][3] = arr[1][3]  + getMax(arr[0][1],arr[0][2])
		
		for(int i=1; i<=N; i++) {
			dp[i][1] = arr[i][1] + getMin(dp[i-1][2],dp[i-1][3]);
			dp[i][2] = arr[i][2] + getMin(dp[i-1][1],dp[i-1][3]);
			dp[i][3] = arr[i][3] + getMin(dp[i-1][2],dp[i-1][1]);
		}
		System.out.println(getMin(getMin(dp[N][1],dp[N][2]),dp[N][3]));
		
	}
	
	public static int getMin(int a, int b) {
		return a<b?a:b;
	}
	
}
