import java.util.Random;

public class RandomStringGenerator {
	public StringBuilder s;
	int n;
	String alfabet;
	Random rnd = new Random();
	RandomStringGenerator(int n, String alfabet) {
		this.n = n;
		this.alfabet = alfabet;
		int len = alfabet.length();
		s = new StringBuilder("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
		for (int i = 0; i < n; i++) {
			s.setCharAt(i, alfabet.charAt(rnd.nextInt(len)));
		}
	}
	
	StringBuilder next () {
		StringBuilder s;
		int len = alfabet.length();
		s = new StringBuilder("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
		for (int i = 0; i < n; i++) {
			s.setCharAt(i, alfabet.charAt(rnd.nextInt(len)));
		}
		return s;
	}
}