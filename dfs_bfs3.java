
public class dfs_bfs3 {

	static String[] myWords;
	static boolean[] visit;
	static String myBegin;
	static String myTarget;
	static int size;
	static int answer_cnt;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
//		String[] words = {"hot","dot","dog","lot","log"};
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		myBegin = begin;
		myTarget = target;
		size = words.length;
		answer_cnt = size + 1;
		myWords = new String[size];
		visit = new boolean[size];
		for (int i = 0; i < words.length; i++) {
			myWords[i] = words[i];
		}
		for (int i = 0; i < size; i++) {
			if (check(myWords[i], begin)) {
				visit[i] = true;
				dfs(0, i);
				visit[i] = false;
			}
		}
		answer = answer_cnt;
		if (answer_cnt == size + 1)
			answer = 0;
		else
			answer = answer_cnt;
		return answer;
	}

	public static void dfs(int cnt, int idx) {
		// 기저를 설정해주어야 한다. 모든 단어를 썼을때가 기저.
		if (cnt == size + 1)
			return;
		// 지금까지 교환수가 answer_cnt보다 크면 그 뒤는 의미가 없다.
		if (cnt > answer_cnt)
			return;
		// 만약에 현 위치의 단어가 타겟이면 정답과 비교해 볼만하다.
		if (myWords[idx].equals(myTarget)) {
			System.out.println(myWords[idx] + " " + myTarget);
			if (cnt + 1 < answer_cnt)
				answer_cnt = cnt + 1;
			for (int i = 0; i < size; i++) {
				System.out.print(myWords[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < size; i++) {
				System.out.print(visit[i] + " ");
			}
			System.out.println();
			System.out.println();
			return;
		}
		for (int i = 0; i < size; i++) {
			if (!visit[i] && check(myWords[i], myWords[idx])) {
				visit[i] = true;
				dfs(cnt + 1, i);
				visit[i] = false;
			}
		}

	}

	public static boolean check(String s1, String s2) {
		int cnt = 0;
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (c1 != c2)
				cnt++;
		}
		if (cnt == 1)
			return true;
		else
			return false;
	}
}
