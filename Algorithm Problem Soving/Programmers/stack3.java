package Programmers;
import java.util.LinkedList;
import java.util.Stack;

public class stack3 {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
	
	public static int solution(String arrangement) {
		int answer =0;
		int many=-1;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<arrangement.length(); i++) {
			char c = arrangement.charAt(i);
			if(c=='(') {
				many++;
				stack.add('(');
			}else {
				char cc = stack.peek();
				stack.add(')');
				if(cc=='(') {
					answer+= many;
					many--;
				}else {
					answer++;
					many--;
				}
			}
		}
		
		return answer;
	}
}
