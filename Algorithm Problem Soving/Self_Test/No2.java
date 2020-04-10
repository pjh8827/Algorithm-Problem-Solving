package Self_Test;

public class No2 {
	public static void main(String[] args) {
		String answer_sheet = "24551";
		String[] sheets = {"24553", "24553","24553", "24553","24553"};
		System.out.println(solution(answer_sheet, sheets));
	}
	public static int solution(String answer_sheet, String[] sheets) {
		int answer =0;
		int length = answer_sheet.length();
		int max_leng, cnt_long, cnt_total;
		for(int i=0; i<sheets.length; i++) {
			for(int j=0; j<sheets.length; j++) {
				cnt_total=0; cnt_long=0; max_leng=0;
				for(int k=0; k<length; k++) {
					char c1 = sheets[i].charAt(k);
					char c2 = sheets[j].charAt(k);
					char c3 = answer_sheet.charAt(k);
					if(c1==c2) {
						if(c1!=c3) {
							cnt_total++;
							cnt_long++;
						}else {
							max_leng = Math.max(cnt_long, max_leng);
							cnt_long=0;
						}
					}else {
						max_leng = Math.max(cnt_long, max_leng);
						cnt_long=0;
					}
				}
				max_leng = Math.max(cnt_long, max_leng);
				answer = Math.max(answer,  cnt_total+(max_leng*max_leng));
			}
		}
		
		return answer;
	}
}
