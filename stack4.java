import java.util.*;

public class stack4 {
	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(prices)));
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = {};
		answer = new int[prices.length];
		for(int i=0; i<prices.length; i++) {
			int time=0;
			if(i==prices.length-1) answer[i]=time;
			else {
				for(int j=i+1; j<prices.length; j++) {
					time++;
					if(prices[j]<prices[i]) break;
				}
				answer[i]=time;
			}
		}
		
		return answer;
	}
}
