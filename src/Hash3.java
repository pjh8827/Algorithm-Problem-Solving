import java.util.HashMap;
import java.util.Set;

public class Hash3 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
		System.out.println(solution(clothes));
	}
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hm =new HashMap<String, Integer>();
        for(String[] cloth : clothes) {
        	System.out.println(cloth[1]);
    		if(hm.containsKey(cloth[1])) {
    			hm.replace(cloth[1], hm.get(cloth[1])+1);
    			System.out.println(hm.get(cloth[1]));
    		}else {
    			hm.put(cloth[1], 1);
    			System.out.println(hm.get(cloth[1]));
    		}
        }
        
        Set<String> ks = hm.keySet();
        
        for(String key : ks) {
        	answer *= (hm.get(key)+1);
        }
        
        return answer-1;
    }
}
