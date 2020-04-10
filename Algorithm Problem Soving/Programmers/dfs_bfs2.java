package Programmers;

public class dfs_bfs2 {
	public static void main(String[] args) {
		int n =3;
		int[][] computers = {{1,1,0}, {1,1,0},{0,0,1}};
		System.out.println(solution(n, computers));
	}
	
	static int[][] myComputer;
	static boolean[][] use;
	static int N;
	static int size;
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        myComputer = computers.clone();
        size = computers.length;
        use = new boolean[size][size];
        N = n;
        
        for(int i=0; i<size; i++) {
        	for(int j=0; j<size; j++) {
        		if(!use[i][j]) {
        			if(myComputer[i][j]==1 || i==j) {
        				use[i][j]=true;
        				dfs(j);
        				answer++;
        			}
        		}
        	}
        }
        
        
        return answer;
    }
	public static void dfs(int idx) {
		for(int i=0; i<size; i++) {
			if(!use[idx][i]) {
				if(myComputer[idx][i]==1 || idx==i) {
					use[idx][i]=true;					
					dfs(i);
				}
			}
		}
		return;
	}
	
}
