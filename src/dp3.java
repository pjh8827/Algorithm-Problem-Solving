
public class dp3 {
	public static void main(String[] args) {
		int m = 10;
		int n = 10;
		int[][] puddles = {{4,2},{3,3}};
		System.out.println(solution(m, n, puddles));
	}
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        for(int i=0; i<puddles.length; i++) {
        	for(int j=0; j<puddles[i].length; j++) {
        		puddles[i][j]--;
        	}
        }
        
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) map[i][0]=1;
        for(int i=0; i<m; i++) map[0][i]=1;
        
        for(int[] puddle : puddles) {
        	map[puddle[1]][puddle[0]] =-1;
        }
        
        
        for(int i=1; i<n; i++) {
        	for(int j=1; j<m; j++) {
        		if(map[i][j]==-1) continue;
        		
        		int num1 = map[i-1][j];
        		int num2 = map[i][j-1];
        		if(num1==-1) num1=0;
        		if(num2==-1) num2=0;
        		map[i][j] = (num1+num2)%1000000007;
        	}
        }
        for(int i=0; i<10; i++) {
        	for(int j=0; j<10; j++) {
        		System.out.print(map[i][j]+"\t"); 
        	}System.out.println();
        }
        answer = map[n-1][m-1];
        return answer;
    }
}
