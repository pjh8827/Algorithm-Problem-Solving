package Programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Binary2 {

	public static void main(String[] args) {
		int n = 6;
		int[] times = { 7, 10 };
		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		long start=0;
		long end=0;
		for(int time : times) {
			if(end<time) end=time;
		}
		
		end *= n;
		
		while(start<=end) {
			long mid = (start+end)/2;
			long sum = 0;
			for(int time : times) {
				sum+=mid/time;
			}
			if(sum<n) {
				start = mid+1;
			}else {
				answer = Math.min(mid, answer);
				end = mid-1;
			}
		}
		
		return answer;
	}
}