package Programmers;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BruteForce2 {
	static int[] number = new int[10000000];
	static boolean[] check = new boolean[10000000];
	static int[] cnt = new int[10];
	static boolean[] visit;
	static StringBuilder sb;
	static LinkedList<Character> list2;
	static List<Character> list;
	static int myAnswer;
	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<Character>();
        
        for(int i=0; i<numbers.length(); i++) {
        	list.add(numbers.charAt(i));
        	cnt[numbers.charAt(i)-'0']++;
        }
        
        check[0]=true;
        check[1]=true;
        for(int i=2; i<number.length; i++) {
        	for(int j=2*i; j <number.length; j+=i) {
        		check[j]= true;
        	}
        }
    
        int size =0;
        int max=0;
        for(int i=9; i>=0; i--) {
        	if(cnt[i]!=0) {
        		if(i>max) max=i;
        		size+=cnt[i];
        	}
        }
        visit = new boolean[size];
        list2 = new LinkedList<Character>();
        for(int i=0; i<list.size(); i++) {
        	list2.addLast(list.get(i));
        	visit[i]=true;
        	dfs(i);
        	list2.removeLast();
        	visit[i]=false;
        }
        answer = myAnswer;
        return answer;
    }
	public static void dfs(int idx) {
		sb = new StringBuilder();
		for(Character c : list2) {
			sb.append(c);
		}
		String s = sb.toString();
		int num = Integer.parseInt(s);
		if(!check[num]) {
			check[num]=true;
			myAnswer++;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(!visit[i]) {
				list2.addLast(list.get(i));
				visit[i]=true;
				dfs(i);
				list2.removeLast();
				visit[i]=false;
			}
		}
		return;
	}
}
