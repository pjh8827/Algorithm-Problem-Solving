package Programmers;
import java.util.*;

public class Greedy6 {
	public static void main(String[] args) {
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(solution(routes));
	}

	public static int solution(int[][] routes) {
		int answer = 1;
		ArrayList<Route> list = new ArrayList<>();
		for (int[] route : routes) {
			list.add(new Route(route[0], route[1]));
		}
		Collections.sort(list, new Comparator<Route>() {
			@Override
			public int compare(Route r1, Route r2) {
				if (r2.start < r1.start)
					return 1;
				else if (r2.start == r1.start)
					return 0;
				else
					return -1;
			}
		});

		
		Route before = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			Route now = list.get(i);
			if (before.end > now.end) {
				before = now;
			} else if (now.start > before.end) {
				answer++;
				before = now;
			}
		}

		return answer;
	}
}

class Route {
	int start;
	int end;

	public Route(int start, int end) {
		this.start = start;
		this.end = end;
	}
}