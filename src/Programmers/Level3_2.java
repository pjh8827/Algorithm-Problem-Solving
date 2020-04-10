package Programmers;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Level3_2 {
//	public static void main(String[] args) {
//		int[][] routes = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
//		System.out.println(solution(routes));
//	}
//	public static int solution(int[][] routes) {
//        int answer = 1;
//        ArrayList<Route> list = new ArrayList<Route>();
//        for(int i=0; i<routes.length; i++) {
//        	Route route = new Route(routes[i][0], routes[i][1]);
//        	list.add(route);
//        }
//        Collections.sort(list);
//        for(Route r : list) {
//        	System.out.println(r.enter+" "+r.exit);
//        }
//        Route tmp = list.get(0);
//        for(int i=1; i<list.size(); i++) {
//        	Route cur = list.get(i);
//        	if(tmp.exit>cur.exit) {
//        		tmp = cur;
//        	}else if(tmp.exit < cur.enter) {
//        		answer++;
//        		tmp=cur;
//        	}
//        }
//        return answer;
//    }
//}
//class Route implements Comparable<Route>{
//	int exit;
//	int enter;
//	public Route(int enter, int exit) {
//		this.enter = enter;
//		this.exit = exit;
//	}
//
//	@Override
//	public int compareTo(Route r) {
//		if(this.enter > r.enter) return 1;
//		else if(r.enter == this.enter) return 0;
//		else return -1;
//	}
//}