package Programmers;
import java.util.Arrays;

public class Level3_1 {
	public static void main(String[] args) {
		int n = 5;
		int[] money = { 1, 2, 5 };
		System.out.println(solution(n, money));
	}

	public static int solution(int n, int[] money) {
		Arrays.sort(money);
		int[] answer = new int[n];
		for(int i=0; i<n; i++) {
			if((i+1)%money[0]==0) answer[i]=1;
		}
		for(int i=1; i<money.length; i++) {
			int now = money[i];
			for(int j=now-1; j<n; j++) {
				if(j==now-1) answer[j]=(answer[j]+1)%1000000007;
				else if(j>now-1) {
					answer[j] = (answer[j]+answer[j-now])%1000000007;
				}
			}
		}
		return answer[n-1];
	}
}
