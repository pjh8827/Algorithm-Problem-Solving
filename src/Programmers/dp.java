package Programmers;

public class dp {
	public static void main(String[] args) {
		int N =6;
		System.out.println(solution(N));
	}
	static long[] map = new long[81];
	public static long solution(int N) {
		long answer=0;
		map[1]=1;
		map[2]=1;
		
		for(int i=3; i<81; i++) {
			map[i]=map[i-1]+map[i-2];
		}
		
		if(N==1) answer = 4;
		else if(N==2) answer = 6;
		else answer = (map[N]*4)+(map[N-1]*2);
		
		return answer;
	}
	
}
