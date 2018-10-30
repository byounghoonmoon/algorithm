package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
	/*
	 * 
		1.현재 위치를 청소한다.
		2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		  	왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
          	왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
          	네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
          	네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
		
		첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)

		둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. 
		0:북, 1:동, 2:남, 3:서 
	 * 
	 * */
	
	static int map[][];
	static boolean visited[][];
	static int N,M,r,c,d,cnt;
	static Robot rb;

	final static int[] dy = { -1, 0, 1, 0 };
	final static int[] dx = {  0, 1, 0,-1 };
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/BAEKJOON/input/로봇청소기_14503.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st= new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());	//0:북, 1:동, 2:남, 3:서 
		
		
		
		for(int i=0; i<N; i++){
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				map[i][j] =  Integer.parseInt(st.nextToken());
		}
		/*
		2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		  왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
		  왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
		  ★★★ 존재하던 안하던 방향은 회전한다 ! 
		  네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
		  ★★★ 방향을 유지하면서 후진!
		  네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		  로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
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
			       0(북)
			            ↙ 		↖
			 3(서)        1(동)
		                       ↘		↗
			       2(남)
			
			dx, dy 헷갈리지 말고 0,1,2,3 에 맞게끔 상하좌우 이동 확인
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
				d = backDirect(d);	// 후진하려면 반대방향 선정
				ny = temp.r + dy[d];
				nx = temp.c + dx[d];
				if(nx>=0 && nx <M && ny>=0 && ny<N){
					if(map[ny][nx]==0 )
					{
						d = backDirect(d);	//방향을 바꾸지 않으니 원상태로
						q.add(new Robot(ny,nx,d));
					}
					else
						return;
				}
				
			}
			
			
			
		}
		
		
	}
	
	
	public static class Robot{
		int r; 	// 북쪽에서 떨어진 거리
		int c;  // 서쪽에서 떨어진 거리
		int d;  // 현재바라보는 방향
		
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
