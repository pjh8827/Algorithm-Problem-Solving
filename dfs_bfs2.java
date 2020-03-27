
public class dfs_bfs2 {
	public static void main(String[] args) {
		int n =3;
//		int[][] computers = {{1,1,0}, {1,1,0},{0,0,1}};
		int[][] computers = {{1,1,0}, {1,1,1},{0,1,1}};
		System.out.println(solution(n, computers));
	}
	static int answer_cnt;
	static int max_idx;
	static boolean[][] visit;
	static int[][] map;
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        max_idx = computers[0].length;
        map = new int[max_idx][max_idx];
        visit = new boolean[max_idx][max_idx];
        for(int i=0; i<max_idx; i++) {
        	for(int j=0; j<max_idx; j++) {
        		map[i][j] = computers[i][j];
        	}
        }
        for(int i=0; i<max_idx; i++) {
        	for(int j=0; j<max_idx; j++) {
        		if(computers[i][j]==1 && !visit[i][j]) {
//        			System.out.println(i+" "+j);
        			dfs(i);
        			answer++;
        		}
        	}
        }
        return answer;
    }
	public static void dfs(int now_idx) {
		
		for(int i=0; i<max_idx; i++) {
			if(map[now_idx][i]==1&&!visit[now_idx][i]) {
				visit[now_idx][i]=true;
				visit[i][now_idx]=true;
				visit[i][i]=true;
				dfs(i);
			}
		}
		return;
	}
	
}
