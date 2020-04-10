package Programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(n, vertex));
	}
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<edge.length; i++) {
        	list.add(new ArrayList<Integer>());
        }
        
        for(int[] pair : edge) {
        	int l = pair[0];
        	int r = pair[1];
        	list.get(l).add(r);
        	list.get(r).add(l);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        
        int[] weight = new int[list.size()+1];
        Arrays.fill(weight, -1);
        weight[1]=0;
        
        
        int idx=0;
        int max=1;
        int cnt=0;
        while(!q.isEmpty()) {
        	idx = q.poll();
        	for(int i=0; i<list.get(idx).size(); i++) {
        		if(weight[list.get(idx).get(i)]==-1){
        			weight[list.get(idx).get(i)] = weight[idx]+1;
        			if(max<weight[list.get(idx).get(i)]) {
        				max = weight[list.get(idx).get(i)];
        				cnt=1;
        			}else if(max==weight[list.get(idx).get(i)]) {
        				cnt++;
        			}
        			q.add(list.get(idx).get(i));
        		}
        	}
        }
        
        answer = cnt;
        
        return answer;
    }
}
