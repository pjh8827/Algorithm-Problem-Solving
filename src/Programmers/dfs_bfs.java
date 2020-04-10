package Programmers;
import java.util.Arrays;

public class dfs_bfs {
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	static int[] myNumbers;
	static int myTarget;
	static int size;
	static int sum;
	static int myAnswer;
	public static int solution(int[] numbers, int target) {
	    int answer = 0;
	    
	    myNumbers = numbers.clone();
	    myTarget = target;
	    size = numbers.length;
	    myAnswer =0;
	    
	    dfs(0,0);
	    
	    answer = myAnswer;
	    return answer;
	}
	public static void dfs(int idx, int sum) {
		if(idx==size) {
			if(sum==myTarget) {
				myAnswer++;
			}
			return;
		}else {
			dfs(idx+1, sum+myNumbers[idx]);
			dfs(idx+1, sum-myNumbers[idx]);
		}
	}
	
}
