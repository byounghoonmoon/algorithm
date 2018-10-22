package BAEKJOON;

import java.io.FileInputStream;
import java.util.Scanner;

public class а╤гу_2047 {
	static int cnt, n, k, d[][];

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		cnt = sc.nextInt();

		for (int i = 1; i <= cnt; i++) {
			n = sc.nextInt();
			k = sc.nextInt();
			d = new int[n + 1][k + 1];

			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= k && b <= a; b++) {
					if (a == b)
						d[a][b] = 1;
					else if (b == 1)
						d[a][b] = a;
					else if (d[a][b] == 0)
						d[a][b] = d[a - 1][b - 1] + d[a - 1][b];
				}
			}

			System.out.println(d[n][k]);
			/*
			 * for (int a=1; a<=n; a++) { for (int b=1; b<=k; b++) {
			 * System.out.print(d[a][b] + " "); } System.out.println(""); }
			 */
		}
	}
}
