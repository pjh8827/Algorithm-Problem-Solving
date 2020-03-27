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
        	if(hm.containsKey(com)) {
        		hm.replace(com, hm.get(com)+1);
        	}else {
        		hm.put(com, 1);
        	}
        }
        
        for(String part : participant) {
        	if (!hm.containsKey(part)) return part;
            else if(hm.get(part)==0) return part;
        	else hm.replace(part, hm.get(part)-1);
        }
        
        return answer;
    }
}
