import java.util.HashMap;

public class BruteForce3 {
	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1},{356,1,0},{327,2,0},{489,0,1}};
		System.out.println(solution(baseball));
	}
	
	public static int solution(int[][] baseball) {
        int answer = 0;
        boolean[] used = new boolean[10];
        int strike, ball, rightConditionNum;
        
        for(int i=1; i<10; i++) {
        	used[i]=true;
        	for(int j=1; j<10; j++) {
        		used[j]=true;
        		for(int k=1; k<10; k++) {
        			if(used[k]) continue;
        			used[k]=true;
        			
        			rightConditionNum=0;
        			for(int h=0; h<baseball.length; h++) {
        				strike=0;
        				ball=0;
        				
        				int temp = baseball[h][0];
        				int oneTemp = temp%10;
        				temp/=10;
        				int tenTemp = temp%10;
        				temp/=10;
        				int hunTemp = temp%10;
        				
        				if(i==hunTemp) strike++;
        				if(j==tenTemp) strike++;
        				if(k==oneTemp) strike++;
        				if(i==tenTemp || i==oneTemp) ball++;
        				if(j==hunTemp || j==oneTemp) ball++;
        				if(k==hunTemp || k==tenTemp) ball++;
        				
        				if(strike == baseball[h][1] && ball==baseball[h][2])
        					rightConditionNum++;
        			}
        			if(rightConditionNum==baseball.length) {
        				System.out.println(i+" "+j+" "+k);
        				answer++;
        			}
        			used[k]=false;
        		}
        		used[j]=false;
        	}
        	used[i]=false;
        }
        return answer;
    }
}
