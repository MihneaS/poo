
public class Point {
	float x;
	float y;
	Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	void changeCoords(float x, float y) {
		this.x = x;
		this.y = y;
	}
	void afis(){
		System.out.print("(" +x + ", " + y + ")");
	}
	Point(){};
}




/*static class T {
	void al (int a){
		a = 5;
	}
	static void main (String[] args){
		int a = 2;
		T.al(a);
		System.out.println(a);
	}
}*/