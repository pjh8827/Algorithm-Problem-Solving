import java.util.*;

public class binary {
	public static void main(String[] args) {
		int[] budgets = { 120, 110, 140, 150 };
		int M = 485;
		System.out.println(solution(budgets, M));
	}

	public static int solution(int[] budgets, int M) {
		Arrays.sort(budgets);
		int start = 0, end = budgets[budgets.length - 1];
		while (start <= end) {
			int sum = 0;
			int mid = (start + end) / 2;
			for (int element : budgets)
				sum = element > mid ? sum + mid : sum + element;
			if (sum > M)
				end = mid - 1;
			else
				start = mid + 1;
			System.out.println(start+" "+end+" "+mid);
		}
		return end;
	}
//	public int solution(int[] budgets, int M) {
//        int start=0, end=0;
//		int sum =0;
//		for(int budget : budgets) {
//			if(end<budget) end = budget;
//		}
//		int mid=0;
//		while(start<=end) {
//			mid = (start+end)/2;
//			sum=0;
//			
//			for(int i=0; i<budgets.length; i++) {
//				if(budgets[i]>mid) {
//					sum+=mid;
//				}else
//					sum+=budgets[i];
//			}
//			if(sum<M) {
//				start = mid+1;
//			}else {
//				end = mid-1;
//			}
//            System.out.println(start+" "+end+" "+mid);
//		}
//		return end;
//	}
}
