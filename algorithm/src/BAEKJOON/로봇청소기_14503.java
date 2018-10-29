package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �κ�û�ұ�_14503 {
	/*
	 * 
		1.���� ��ġ�� û���Ѵ�.
		2.���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
		  ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
          ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
          �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
          �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
		�κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.
		
		ù° �ٿ� ���� ũ�� N�� ���� ũ�� M�� �־�����. (3 �� N, M �� 50)

		��° �ٿ� �κ� û�ұⰡ �ִ� ĭ�� ��ǥ (r, c)�� �ٶ󺸴� ���� d�� �־�����. 
		0:��, 1:��, 2:��, 3:�� 
	 * 
	 * */
	
	static int map[][];
	static boolean visited[][];
	static int N,M,r,c,d,cnt;
	static Robot rb;

	final static int[] dx = { -1, 0, 1, 0 };
	final static int[] dy = {  0, 1, 0,-1 };
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/�κ�û�ұ�_14503.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st= new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());	//0:��, 1:��, 2:��, 3:�� 
		
		
		
		for(int i=0; i<N; i++){
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				map[i][j] =  Integer.parseInt(st.nextToken());
		}
		print();
		/*
		2.���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
		  ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
		  ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
		  �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
		  �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
		  �κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.
		 */
		System.out.println();
		
		// �ð� �ݴ�������� �� 
		// 0:��, 1:��, 2:��, 3:��
		// 0 �� 3 �� 2 �� 1 
		
		bfs();
		
	}
	
	public static void bfs(){

		Queue<Robot> q = new LinkedList<>(); 
		q.add(new Robot(r,c,d));
		visited[r][c] = true;
		
		while(!q.isEmpty()){
			Robot temp = q.poll();
			int nx, ny;
			// ���⿡ ���缭 �������� �����ϹǷ�
			// �� => ���� ��ĭ , 3 (x-1,y)
			// �� => ���� ��ĭ , 0 (x,y-1)
			// �� => ���� ��ĭ , 1
			// �� => ���� ��ĭ , 2
			// 0:��, 1:��, 2:��, 3:��
			// ���� Ʋ��
			// 3:��, 0:��, 1:��, 2:��
			// 
			for(int i=0; i<4; i++){
				d = nextDirect(d);
				ny = temp.r + dy[d];
				nx = temp.c + dx[d];
				
				if(nx>=0 && nx <M && ny>=0 && ny<N){
					if(map[ny][nx]==0 && !visited[ny][nx])
					{
						
						q.add(new Robot(ny,nx,d));
						visited[ny][nx] = true;
						break;
					}
				}
			}
			
			
		}
		
		
	}
	
	
	public static class Robot{
		int r; 	// ���ʿ��� ������ �Ÿ�
		int c;  // ���ʿ��� ������ �Ÿ�
		int d;  // ����ٶ󺸴� ����
//		int cnt; // û���� Ƚ��
		
		Robot (int r, int c, int d){
			this.r = r;
			this.c = c;
			this.d = d; 
//			this.cnt = cnt;
		}
		
	}
	
	public static int nextDirect(int curr){
		if(curr==0)
			return 3;
		else if (curr==3)
			return 2;
		else if (curr==2)
			return 1;
		else
			return 0;
	}
	
	public static void print(){
		for(int i=0; i<N; i++){
			System.out.println();
			for(int j=0; j<M; j++)
				System.out.print(map[i][j]+" ");
		}
	}
	
}
