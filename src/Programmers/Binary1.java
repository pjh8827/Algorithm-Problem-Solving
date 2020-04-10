package Programmers;
import java.util.*;

public class Binary1 {
	public static void main(String[] args) {
		int[] budgets = { 120, 110, 140, 150 };
		int M = 485;
		System.out.println(solution(budgets, M));
	}

	public static int solution(int[] budgets, int M) {
		int answer = 0;
		int start = 0;
		int end = 0;
		int sum = 0;

		for (int budget : budgets) {
			if (end < budget)
				end = budget;
		}

		while (start <= end) {
			sum = 0;
			int mid = (start + end) / 2;
			for (int budget : budgets) {
				if (budget <= mid) {
					sum += budget;
				} else {
					sum += mid;
				}
			}

			if (sum <= M) {
				start = mid + 1;
				answer = mid;
			} else {
				end = mid - 1;
			}
		}

		return answer;
	}

}
