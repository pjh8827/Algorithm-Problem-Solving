package Programmers;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hash2 {
	public static void main(String[] args) {
		String[] phone_book = {"123", "456", "789"};
		System.out.println(solution(phone_book));
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<String>();
        for(String key : phone_book) {
        	set.add(key);
        }
        
        
        Iterator<String> iter1 = set.iterator();
        
        while(iter1.hasNext()) {
        	String key1 = iter1.next();
        	Iterator<String> iter2 = set.iterator();
        	while(iter2.hasNext()) {
        		String key2 = iter2.next();
        		if(key1.equals(key2)) continue;
        		if(key1.startsWith(key2)) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
}
