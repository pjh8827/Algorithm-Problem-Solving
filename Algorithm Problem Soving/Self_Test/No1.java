package Self_Test;

import java.util.Stack;

public class No1 {
	public static void main(String[] args) {
		String inputString = "Hel[lo,< worl]d!>";
//		String inputString = ">_<";
		System.out.println(solution(inputString));
	}
	public static int solution(String inputString) {
		int answer = 0;
		int[] typeArr = new int[4];
		int idx=0;
		
		for(int i=0; i<inputString.length(); i++) {
			if(inputString.charAt(i)=='{'){
				typeArr[0]++;
			}else if(inputString.charAt(i)=='(') {
				typeArr[1]++;
			}else if(inputString.charAt(i)=='<') {
				typeArr[2]++;
			}else if(inputString.charAt(i)=='[') {
				typeArr[3]++;
			}else if(inputString.charAt(i)=='}') {
				if(typeArr[0]<=0) return -1;
				else {
					typeArr[0]--;
					idx++;
				}
			}else if(inputString.charAt(i)==')') {
				if(typeArr[1]<=0) return -1;
				else {
					typeArr[1]--;
					idx++;
				}
			}else if(inputString.charAt(i)=='>') {
				if(typeArr[2]<=0) return -1;
				else {
					typeArr[2]--;
					idx++;
				}
			}else if(inputString.charAt(i)==']') {
				if(typeArr[3]<=0) return -1;
				else {
					typeArr[3]--;
					idx++;
				}
			}
		}
		answer = idx;
		
		return answer;
	}
}
