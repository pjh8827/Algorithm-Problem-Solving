import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Hash4 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500,600,150,800,2500};
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> hm = new  HashMap<>(); 
        for(int i=0; i<genres.length; i++){
            if(hm.containsKey(genres[i]))
               hm.replace(genres[i], hm.get(genres[i])+plays[i]);
            else
               hm.put(genres[i], plays[i]);
        }
        
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>(hm);
        Iterator<String> keys2 = tm.keySet().iterator();
        while(keys2.hasNext()) {
        	String key = keys2.next();
        	System.out.println(key+" "+tm.get(key));
        }
        
        List<String> list = new ArrayList<>();
        list.addAll(hm.keySet());
        
        Collections.sort(list, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Object v1 = hm.get(o1);
				Object v2 = hm.get(o2);
				
				return ((Comparable)v2).compareTo(v1);
			}
        	
        });
        
        Iterator it = list.iterator();
        List<Integer> list3 = new ArrayList<>();
        while(it.hasNext()) {
        	List<Music> list2 = new ArrayList<Music>();
        	String key3 = (String)it.next();
        	for(int i=0; i<genres.length; i++) {
        		if(key3.equals(genres[i])) {
        			list2.add(new Music(i, plays[i]));
        		}
        	}
        	Collections.sort(list2, new Comparator<Music>() {

				@Override
				public int compare(Music m1, Music m2) {
					if(m1.time<m2.time)return 1;
					else {
						if(m1.time==m2.time) {
							if(m1.idx<m2.idx) return -1;
							else return 1;
						}
						return -1;
					}
				}
        	});
        	int idx=0;
        	for(Music m : list2) {
        		if(idx==2) break;
        		list3.add(m.idx);
        		idx++;
        	}
        }
        answer = new int[list3.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list3.get(i);
        }
        
        
        return answer;
    }
}
class Music{
	int idx;
	int time;
	public Music(int idx, int time) {
		super();
		this.idx = idx;
		this.time = time;
	}
	
}
