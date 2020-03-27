import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Hash2 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String key : phone_book) {
        	hm.put(key, 0);
        }
        
        Set<String> ks = hm.keySet();
        
        for(String key : ks) {
        	for(String key2 :ks) {
        		if(key.equals(key2)) continue;
        		else if(key.length()>=key2.length()) continue;
        		
        		if(key2.startsWith(key)) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
}
