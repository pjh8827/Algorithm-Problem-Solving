package Programmers;
import java.util.HashMap;
import java.util.Set;

public class Hash1 {
	public static void main(String[] args) {
		String[] participant = {"leo","kiki","eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
	}
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String com : completion) {
        	if(!hm.containsKey(com)){
        		hm.put(com, 1);
        	}else {
        		hm.put(com, hm.get(com)+1);
        	}
        }
        
        for(String key : participant) {
        	if(!hm.containsKey(key)) {
        		return key;
        	}else if(hm.get(key)==0) {
        		return key;
        	}else {
        		hm.replace(key, hm.get(key)-1);
        	}
        	
        }
        
        return answer;
    }
}
