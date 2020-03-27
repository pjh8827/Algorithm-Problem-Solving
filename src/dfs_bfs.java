
public class dfs_bfs {
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	static int cnt =0;
	static int max_idx=0;
	static int myTarget=0;
	static int[] numbers2 = {};
	public static int solution(int[] numbers, int target) {
	    int answer = 0;
	    max_idx = numbers.length;
	    myTarget = target;
	    numbers2 = new int[max_idx];
	    for(int i=0; i<max_idx; i++) {
	    	numbers2[i]=numbers[i];
	    }
	    dfs(0,0);
	    answer = cnt;
	    return answer;
	}
	
	public static void dfs(int idx, int sum) {
		if(idx==max_idx) {
			if(sum==myTarget) cnt++;
			return;
		}else {
			dfs(idx+1, sum+numbers2[idx]);
			dfs(idx+1, sum-numbers2[idx]);
		}
		
	}
}
