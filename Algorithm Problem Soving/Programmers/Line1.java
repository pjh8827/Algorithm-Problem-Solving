package Programmers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Line1 {
	public static void main(String[] args) {
		int k = 6, b = 3;
		System.out.println(solution(k,b));
	}
	
	static Queue<Integer> brown_q;
	static List<Integer> brown_l;
	static HashSet<Integer> brown_s;
	public static int solution(int k, int b) {
		brown_q = new LinkedList<Integer>();
		brown_l = new ArrayList<Integer>();
		brown_s = new HashSet<Integer>();
		
		brown_q.add(b);
		
		
		int time = 0;
		int dist = 1;
		int b_location =0;
		
		while(k<=200000) {
			
			while(!brown_q.isEmpty()) {
				b_location=brown_q.poll();
//				System.out.print(b_location+" ");
				for(int i=0; i<3; i++) {
					if(i==0) {
						if(b_location-1>=0) {
							if(k+dist==b_location-1) {
//								System.out.println(k+" "+(b_location-1));
								return time+1;
							}
							
							brown_l.add(b_location-1);
						}
					}else if(i==1) {
						if(b_location+1<=2000000) {
							if(k+dist==b_location+1) {
//								System.out.println(k+" "+(b_location+1));
								return time+1;
							}
							brown_l.add(b_location+1);
						}
					}else {
						if(b_location*2<=2000000) {
							if(k+dist==b_location*2) {
//								System.out.println(k+" "+(b_location*2));
								return time+1;
							}
							brown_l.add(b_location*2);
						}
					}
				}
			}
//			System.out.println("  = "+k);
			for(int num : brown_l) {
				brown_q.add(num);
			}
			brown_l = new ArrayList<Integer>();
			time++;
			k += dist;
			dist+=1;
		}
		return -1;
	}
	
	
}


