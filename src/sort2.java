import java.util.*;

public class sort2 {
	public static void main(String[] args) {
//		int[] citations = {3,0,6,1,5};
//		int[] citations = {10, 8, 5, 4, 3};
		int[] citations = {25, 8, 5, 3, 3};
		System.out.println(solution(citations));
	}
	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);
		int size = citations.length;
		for(int a : citations) {
			System.out.print(a+" ");
		}
		System.out.println();
		for(int i=size-1; i>=0; i--) {
			if(citations[i]>size) continue;
			System.out.print(citations[i]+" "+(i+1)+" "+citations[i]);
			System.out.println();
			if(size-i>=citations[i] && citations[i-1]<=citations[i] ) {
				answer = citations[i];
				break;
			}
		}
		
		return answer;
	}
}
