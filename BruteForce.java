import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {
	public static void main(String[] args) {
		int[] answer = {1,3,2,4,2,1,4};
		System.out.println(Arrays.toString(solution(answer)));
	}
	public static int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] supo1 = {1,2,3,4,5,1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5,2,1};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        int cnt1=0, cnt2=0, cnt3=0;
        for(int i=0; i<answers.length; i++) {
        	if(answers[i]==supo1[i%10]) cnt1++;
        	if(answers[i]==supo2[i%8]) cnt2++;
        	if(answers[i]==supo3[i%10]) cnt3++;
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        List<Integer> list = new ArrayList<Integer>();
        
        if(cnt1==max) list.add(1);
        if(cnt2==max) list.add(2);
        if(cnt3==max) list.add(3);
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
