package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 조합_2047 {
	static int n, k;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		// n C 0 = 1
		// n C n = 1
		// n C r = n-1 C r + n-1 C r-1
		// 초기 값으로 1 C 0 = 1 C 1 = 1로 설정

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger d[][];
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		d = new BigInteger[101][101];
		
		d[1][0] = BigInteger.ONE;
		d[1][1] = BigInteger.ONE;

		for (int a = 1; a <= n; a++) {
			d[a][0] = BigInteger.ONE;
			for (int b = 1; b <= a; b++) {
				if(a==b)
					d[a][b] = new BigInteger("1");
				else if (b == 1)
					d[a][b] = new BigInteger(String.valueOf(a));
				else
					d[a][b] = d[a - 1][b - 1].add(d[a - 1][b]);
			}
		}
		System.out.println(d[n][k].toString());
	}
}
