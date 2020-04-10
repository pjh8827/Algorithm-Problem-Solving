package Programmers;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class dfs_bfs3 {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}
	
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		Queue<Word> q = new LinkedList<Word>();
		List<String> list = new ArrayList<>();
		boolean[] use = new boolean[words.length];
		boolean check = false;
		for(String word : words) {
			if(word.equals(target)) check= true;
		}
		if(!check) return 0;
		
		q.add(new Word(0, begin));
		int cnt=0;
		while(!q.isEmpty()) {
			Word w = q.poll();
			int time = w.cnt;
			String now = w.myWord;
			
			if(now.equals(target)) {
				answer = time;
				return answer;
			}
			
			for(int i=0; i<words.length; i++) {
				if(now.equals(words[i])) continue;
				cnt=0;
				for(int j=0; j<words[i].length(); j++) {
					if(now.charAt(j)!=words[i].charAt(j)) cnt++;
				}
				if(cnt==1&&!use[i]) {
					use[i]=true;
					q.add(new Word(time+1, words[i]));
				}
			}
		}
		
		return answer;
	}
}
class Word{
	int cnt;
	String myWord;
	public String getMyWord() {
		return this.myWord;
	}
	public int getCnt() {
		return this.cnt;
	}
	public Word(int cnt, String myWord) {
		this.cnt = cnt;
		this.myWord = myWord;
	}
}
