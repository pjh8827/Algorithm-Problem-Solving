package Programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort1 {
	public static void main(String[] args) {
		int[] arr = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		System.out.println(Arrays.toString(solution(arr, commands)));
	}
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<commands.length; i++) {
        	int start = commands[i][0]-1;
        	int end = commands[i][1]-1;
        	int dst = commands[i][2]-1;
        	
        	int[] array2 = new int[end-start+1];
        	int idx=0;
        	for(int j=start; j<=end; j++) {
        		array2[idx++] = array[j];
        	}
        	
        	Arrays.sort(array2);
        	
        	list.add(array2[dst]);
        }
        for(int i=0; i<answer.length; i++) {
        	answer[i]= list.get(i);
        }
        
        return answer;
    }
}
