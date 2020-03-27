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
}
