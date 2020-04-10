package Programmers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Hash3 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
		System.out.println(solution(clothes));
	}
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] key : clothes) {
        	if(hm.containsKey(key[1])) {
        		hm.replace(key[1], hm.get(key[1])+1);
        	}else {
        		hm.put(key[1], 1);
        	}
        }
        
        Set<String> set = hm.keySet();
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
        	String key = iter.next();
        	answer *= hm.get(key)+1;
        }
        
        
        
        return answer-1;
    }
}
