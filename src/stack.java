import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class stack {
	
	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(Arrays.toString(solution(progresses,speeds)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = new int[progresses.length]; 
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<speeds.length; i++) {
			int[] arr = {progresses[i], speeds[i]};
			q.add(arr);
		}
		//전체시간
		int all_time=0;
		int idx=0;
		
		while(!q.isEmpty()) {
			int here_time=0;
			System.out.println(here_time+" "+all_time);
			int progress = q.peek()[0];
			int speed = q.peek()[1];
			while(progress<100) {
				progress+=speed;
				here_time++;
			}
			if(here_time>all_time) {
				System.out.println(all_time+" "+here_time);
				all_time=here_time;
				if(idx==0&&answer[0]==0)answer[idx]++;
				else answer[++idx]++;
			}else if(here_time<=all_time) {
				answer[idx]++;
			}
			q.poll();
		}
		
		
		return Arrays.stream(answer).filter(i -> i!=0).toArray();
	}
}
