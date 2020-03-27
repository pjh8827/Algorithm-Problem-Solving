import java.util.*;

public class binary3 {
	public static void main(String[] args) {
		int distance=25;
		int[] rocks = {2,14,11,21,17};
		int n=2;
		System.out.println(solution(distance, rocks, n));
	}
	
	public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance;
        
        while(start<=end) {
        	int mid = (start+end)/2;
        	
        	int last =0;
        	int cnt=0;
        	
        	for(int i=0; i<rocks.length+1; i++) {
        		int dis = i != rocks.length ? rocks[i]-last : distance-rocks[i-1];
        		if(dis<mid) {
        			cnt++;
        		}else if(i < rocks.length) {
        			last = rocks[i];
        		}
        	}
        	
        	if(cnt<=n) {
        		start = mid+1;
        		answer = mid;
        	}else {
        		end = mid-1;
        	}
        }
        
        
        
        
	    return answer;
	}
}
