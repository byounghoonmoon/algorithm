package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

	final static int[] dy = { -1, 0, 1, 0 };
	final static int[] dx = {  0, 1, 0,-1 };
	
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
		/*
		2.���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
		  ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
		  ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
		  �ڡڡ� �����ϴ� ���ϴ� ������ ȸ���Ѵ� ! 
		  �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
		  �ڡڡ� ������ �����ϸ鼭 ����!
		  �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
		  �κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.
		 */
		
		bfs();
		System.out.println(cnt);
		
	}
	
	public static void bfs(){

		Queue<Robot> q = new LinkedList<>(); 
		q.add(new Robot(r,c,d));
		visited[r][c] = true;
		
		cnt=1;
		
		while(!q.isEmpty()){
			Robot temp = q.poll();
			
			int nx, ny;
			boolean check = false;
			/*
			       0(��)
			            �� 		��
			 3(��)        1(��)
		                       ��		��
			       2(��)
			
			dx, dy �򰥸��� ���� 0,1,2,3 �� �°Բ� �����¿� �̵� Ȯ��
			*/
			
			for(int i=0; i<4; i++){
				d = nextDirect(d);
				ny = temp.r + dy[d];
				nx = temp.c + dx[d];
				
				if(nx>=0 && nx <M && ny>=0 && ny<N){
					if(map[ny][nx]==0 && !visited[ny][nx])
					{
						q.add(new Robot(ny,nx,d));
						visited[ny][nx] = true;
						cnt++;
						check = true;
						break;
					}
				}
			}
			
			if(!check)
			{
				d = backDirect(d);	// �����Ϸ��� �ݴ���� ����
				ny = temp.r + dy[d];
				nx = temp.c + dx[d];
				if(nx>=0 && nx <M && ny>=0 && ny<N){
					if(map[ny][nx]==0 )
					{
						d = backDirect(d);	//������ �ٲ��� ������ �����·�
						q.add(new Robot(ny,nx,d));
					}
					else
						return;
				}
				
			}
			
			
			
		}
		
		
	}
	
	
	public static class Robot{
		int r; 	// ���ʿ��� ������ �Ÿ�
		int c;  // ���ʿ��� ������ �Ÿ�
		int d;  // ����ٶ󺸴� ����
		
		Robot (int r, int c, int d){
			this.r = r;
			this.c = c;
			this.d = d; 
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
	
	public static int backDirect(int curr){
		if(curr==0)
			return 2;
		else if (curr==3)
			return 1;
		else if (curr==2)
			return 0;
		else
			return 3;
	}
	
	public static void print(){
		for(int i=0; i<N; i++){
			System.out.println();
			for(int j=0; j<M; j++)
				System.out.print(map[i][j]+" ");
		}
	}
	
}
