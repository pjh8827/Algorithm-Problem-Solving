package Programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dfs_bfs4 {
	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" }, {"BOO","DOO" }};
//		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
//		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },{ "ATL", "SFO" } };
		System.out.println(Arrays.toString(solution(tickets)));
	}

	static boolean[] visit;
	static String[] myTicket;
	static String[][] myTickets;
	static int max_idx;
	static int answer_cnt;
	static String[] myAnswer;
	static LinkedList<String> list;
	static int list_size;
	static int ticket_size;

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		answer_cnt = -1;
		list_size = -1;
		Map<String, Integer> map = new HashMap<>();
		ticket_size = tickets.length;
		myTickets = new String[tickets.length][2];
		for (int i = 0; i < tickets.length; i++) {
			for (int j = 0; j < 2; j++) {
				map.put(tickets[i][j], 0);
				myTickets[i][j] = tickets[i][j];
			}
		}

		Set<String> set = map.keySet();
		max_idx = set.size();
		visit = new boolean[tickets.length];
		list = new LinkedList<String>();
		list.addLast("ICN");
		
		String cmp = null;
		int idx = 0;
		boolean check = false;
		
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				if (cmp == null) {
					idx = i;
					cmp = myTickets[i][1];
					check = true;
				} else {
					int cmp_int = cmp.compareTo(myTickets[i][1]);
					check = true;
					if (cmp_int > 0) {
						cmp = myTickets[i][1];
						idx = i;
					}
				}
			}
		}
		if (check) {
			System.out.println(cmp);
			visit[idx] = true;
			list.addLast(cmp);
			dfs(cmp, 2);
			visit[idx] = false;
			list.removeLast();
		}
		
		answer = new String[list_size];
		for (int i = 0; i < myAnswer.length; i++) {
			answer[i] = myAnswer[i];
		}
		return answer;
	}

	public static void dfs(String s, int cnt) {
		if (cnt == ticket_size + 1) {
			if (list_size == -1 || list_size > list.size()) {
				list_size = list.size();
				myAnswer = new String[list.size()];
				int idx = 0;
				for (String s1 : list) {
					myAnswer[idx++] = s1;
					System.out.println(s1);
				}

				return;
			}
		}
		String cmp = null;
		int idx = 0;
		boolean check = false;
		for (int i = 0; i < ticket_size; i++) {
			if (!visit[i] && myTickets[i][0].equals(s)) {
				System.out.println("-----------"+myTickets[i][1]);
				if (cmp == null) {
					idx = i;
					cmp = myTickets[i][1];
					check = true;
				} else {
					int cmp_int = cmp.compareTo(myTickets[i][1]);
					System.out.println(cmp+" "+myTickets[i][1]+" "+cmp_int);
					check = true;
					if (cmp_int > 0) {
						cmp = myTickets[i][1];
						idx = i;
					}
				}
			}
		}
		System.out.println();
		if (check) {
			visit[idx] = true;
			list.addLast(cmp);
			dfs(cmp, cnt + 1);
			visit[idx] = false;
			list.removeLast();
		}

	}

}
