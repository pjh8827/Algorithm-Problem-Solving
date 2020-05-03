package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj17825 {
	static int[] order, dice;
	static Node[] horse;
	static Node start;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		order = new int[10 + 1];
		dice = new int[10 + 1];
		horse = new Node[5 + 1];

		for (int i = 1; i <= 10; i++) {
			dice[i] = Integer.parseInt(s[i - 1]);
		}
		init();
		permutation(1);
		System.out.println(answer);
	}

	private static void permutation(int depth) {
		if (depth >= 11) {
			answer = Math.max(answer, getStart());
			return;
		}
		for (int i = 1; i <= 4; i++) {
			order[depth] = i;
			permutation(depth + 1);
		}
	}
	
	private static int getStart() {
		Arrays.fill(horse, start);
		int score = 0;
		for(int i=1; i<=10; i++) {
			Node cur = horse[order[i]];
			cur.isEmpty = true;
			
			for(int j=1; j<=dice[i]; j++) {
				if(j==1 && cur.fastPath!=null) {
					cur = cur.fastPath;
				}else {
					cur = cur.next;
				}
			}
			
			horse[order[i]] = cur;
			if(!cur.isEmpty&&!cur.isFinish) {
				score = 0;
				break;
			}else {
				score += cur.val;
				cur.isEmpty = false;
			}
			
		}
		for(int i=1; i<=4; i++) {
			horse[i].isEmpty=true;
		}
		
		return score;
	}

	private static void init() {
		start = new Node(0);
		Node tmp = start;
		for (int i = 2; i <= 40; i += 2) {
			tmp = tmp.addNext(i);
		}
		tmp = tmp.addNext(0);
		tmp.isFinish = true;
		tmp.next = tmp;

		Node cross = new Node(25);
		tmp = cross.addNext(30);
		tmp = tmp.addNext(35);
		tmp.next = Node.getNode(start, 40);

		tmp = Node.getNode(start, 10);
		tmp = tmp.fastPath = new Node(13);
		tmp = tmp.addNext(16);
		tmp = tmp.addNext(19);
		tmp.next = cross;

		tmp = Node.getNode(start, 20);
		tmp = tmp.fastPath = new Node(22);
		tmp = tmp.addNext(24);
		tmp.next = cross;

		tmp = Node.getNode(start, 30);
		tmp = tmp.fastPath = new Node(28);
		tmp = tmp.addNext(27);
		tmp = tmp.addNext(26);
		tmp.next = cross;
	}
}

class Node {
	int val;
	boolean isEmpty, isFinish;
	Node next, fastPath;

	Node(int val) {
		this.val = val;
		this.isEmpty = true;
	}

	Node addNext(int val) {
		Node newNode = new Node(val);
		this.next = newNode;
		return newNode;
	}

	static Node getNode(Node start, int target) {
		Node cur = start;
		while (true) {
			if (cur == null) {
				return null;
			}
			if (cur.val == target) {
				return cur;
			}
			cur = cur.next;
		}
	}
}
