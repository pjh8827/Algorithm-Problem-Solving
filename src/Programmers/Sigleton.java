package Programmers;

public class Sigleton {
	
	private Sigleton () {}
	
	private static Sigleton sigleton;
	
	public static Sigleton getSigleton() {
		if(sigleton==null) {
			sigleton = new Sigleton();
		}
		return sigleton;
	}
}
