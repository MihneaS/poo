
public class Polygon {
	Point[] points;
	int n;
	
	Polygon(int n) {
		points = new Point[n];
	}
	
	Polygon(float[] colturi){
		this(colturi.length/2);
		int n = colturi.length / 2;
		for (int i = 0; i < n; i++) {
			points[i] = new Point (colturi[2*i], colturi[2*i+1]);
		}
	}
	
	void afis(){
		for (int i = 0; i < points.length; i++) {
			points[i].afis();
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String [ ] args) {
		float[] colturi = {(float)1.2, (float)2.3, (float)3.4, (float)4.5};
		Polygon poly = new Polygon(colturi);
		poly.afis();
		
		Polygon.showUsedMemory();
		String x;
		for (int i = 0; i < 100000; i++){
			x = "abc";
		}
		Polygon.showUsedMemory();
		for (int i = 0; i < 100000; i++){
			x = new String("abc");
		}
		Polygon.showUsedMemory();
		
		RandomStringGenerator rnds = new RandomStringGenerator(5, "alphb");
		System.out.println(rnds.s);
		System.out.println(rnds.next());
	}
	
	public static void showUsedMemory() { 
	    long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
	    System.out.println(usedMem); 
	} 
}