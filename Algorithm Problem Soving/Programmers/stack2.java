package Programmers;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class stack2 {
	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;

		Deque<Node> list = new LinkedList<>();
		Deque<Node> dst = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			Node node = new Node(i, priorities[i]);
			list.add(node);
		}

		int now = -1;
		while (!list.isEmpty()) {
			int max_weight = list.peekFirst().weight;
			
			for (Node node : list) {
				if (node.weight > max_weight) {
					max_weight = node.weight;
				}
			}
			if (max_weight != list.peekFirst().weight) {
				for(int i=0; i<list.size(); i++) {
					Node tmp = list.pollFirst();
					if(tmp.weight==max_weight) {
						dst.add(tmp);
						break;
					}else {
						list.addLast(tmp);
					}
				}
			} else {
				Node tmp = list.pollFirst();
				dst.add(tmp);
			}
		}
		int time = 1;
		for(Node node : dst) {
			if(node.idx==location) answer = time;
			time++;
		}
		return answer;
	}

}

class Node {
	int idx;
	int weight;

	public Node() {
	};

	public Node(int idx, int weight) {
		this.idx = idx;
		this.weight = weight;
	};
	
	public void setIdx(int idx) {
		this.idx=idx;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getIdx() {
		return this.idx;
	}
	
	public int getWeigth() {
		return this.weight;
	}
}
