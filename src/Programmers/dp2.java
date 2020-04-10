package Programmers;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class dp2 {
	public static void main(String[] args) {
		int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(solution(triangle));
	}
	public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] myTriangle = triangle.clone();
        for(int i=0; i<triangle.length; i++) {
        	if(i==0) continue;
        	for(int j=0; j<triangle[i].length; j++) {
        		if(j==0) myTriangle[i][j] += myTriangle[i-1][j];
        		else if(j==triangle[i].length-1) myTriangle[i][j] += myTriangle[i-1][j-1];
        		else {
        			myTriangle[i][j] = myTriangle[i][j]+(Math.max(myTriangle[i-1][j], myTriangle[i-1][j-1]));
        		}
        	}
        }
        return Arrays.stream(myTriangle[myTriangle.length-1]).max().getAsInt();
    }
}
