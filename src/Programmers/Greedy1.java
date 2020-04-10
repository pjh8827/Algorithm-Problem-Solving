package Programmers;
import java.util.Arrays;

public class Greedy1 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = {3};
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] student = new int[n + 2];
		for (int num : lost)
			student[num]--;
		for (int num : reserve)
			student[num]++;
		for (int i = 1; i < student.length-1; i++) {
			if (student[i] == -1) {
				if(student[i-1]==1) {
					student[i-1]--;
					student[i]++;
				}else if(student[i+1]==1) {
					student[i+1]--;
					student[i]++;
				}
			}
		}
		
		for(int i = 1; i < student.length-1; i++) {
			if(student[i]!=-1) answer++;
		}
		
		return answer;
	}
}
