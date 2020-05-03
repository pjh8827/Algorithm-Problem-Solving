package LINE;

import java.util.Arrays;

public class real3 {
	public static void main(String[] args) {
		String road = "111011110011111011111100011111";
//		String road = "001100";
		int n=3;
		System.out.println(solution(road, n));
	}
	public static int solution(String road, int n) {
		int answer=-1;
		int breakNum = 0;
		for(int i=0; i<road.length(); i++) {
			if(road.charAt(i)=='0'){
				breakNum++;
			}
		}
		int[] breakRoad = new int[breakNum+2];
		int breakRoadLength = 1;
		for(int i=0; i<road.length(); i++) {
			if(road.charAt(i)=='0') {
				breakRoad[breakRoadLength++]=i;
			}
		}
		
		breakRoad[breakRoadLength++] = road.length();
		
		System.out.println(Arrays.toString(breakRoad));
		
		for(int i=1; i<breakRoadLength; i++) {
			int tempMax = 0;
			if(i+n+1<breakRoadLength) {
				tempMax = (breakRoad[i+n+1]-1-breakRoad[i]);
			}else {
				tempMax = breakRoad[breakRoadLength-1] - breakRoad[i-1];
			}
			answer = Math.max(answer,  tempMax);
		}
		return answer;
	}
}
