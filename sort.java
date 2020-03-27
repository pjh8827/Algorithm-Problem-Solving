import java.util.*;

public class sort {
	public static void main(String[] args) {
		int[] numbers = {6,10,2};
		int[][] arra = {{1000,3}, {2000,2}, {3000,1}};
		System.out.println(solution(numbers, arra));
	}
	
	public static String solution(int[] numbers, int[][] arra) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = (String.valueOf(numbers[i]));
        }
        
//        Arrays.sort(arr, new Comparator<String>(){
//        	@Override
//        	public int compare(String s1, String s2) {
//        		return (s2+s1).compareTo(s1+s2);
//        	}
//		});
        
//        Arrays.sort(arra, new Comparator<int[]>() {
//        	@Override
//        	public int compare(int[] a, int[] b) {
//        		return b[1]-a[1];
//        	}
//        });
        
//        Arrays.sort(arra, (a,b)->(a[1]-b[1]));
        Arrays.sort(arra, (a,b)->(b[1]-a[1]));
        Arrays.sort(arr, (s1,s2)->(s2+s1).compareTo(s1+s2));
        
        for(int[] a : arra) {
        	System.out.println(a[0]+" "+a[1]);
        }
        
        
        
        if (arr[0].equals("0")) return "0";
        
        for(int i=0; i<arr.length; i++){
            answer += arr[i];
        }
        
        return answer;
    }
}
