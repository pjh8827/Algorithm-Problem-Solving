package Programmers;
import java.util.Arrays;

public class BruteForce4 {
	public static void main(String[] args) {
		int brown = 10;
		int red = 2;
		System.out.println(Arrays.toString(solution(brown, red)));
	}
	public static int[] solution(int brown, int red) {
        int[] answer = {};
        int row = 0;
        int col = 0;
        for(int i=1; i<=red+2; i++) {
        	for(int j=i; j<=red+2; j++) {
        		if(i>j) continue;
        		System.out.println(i+" "+j);
        		if((i*j)-(i-2)*(j-2)==brown) {
        			if((i-2)*(j-2)==red) {
        				row = i;
        				col = j;
        			}
        		}
        	}
        }
        answer = new int[2];
        answer[0]=col;
        answer[1]=row;
        return answer;
    }
}
