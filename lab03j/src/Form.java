
public class Form {
	String color;
	
	Form(){
	}
	
	Form(String color){
		this.color = color;
	}
	
	float getArea() {
		return 0;
	}
	
	public String toString() {
		return color;
	}
	
	public void printDimensions() {}
	
	public static void main(String [ ] args) {
		Triangle tri = new Triangle("albastru", 1, 2);
		Circle cerc = new Circle("cerculet", 1);
		
		System.out.println(cerc + " " + tri);
		
		//Form trif = tri;
		//Form cercf = cerc;
		Form[] forme = new Form[20];
		//forme.add(cercf); DE CE NU merGEEEEEEE?????

		//forme.add(trif);
		
		forme[0] = new Circle("rosu", 1);
		forme[1] = new Triangle("rosu", 1, 1);
		System.out.println(forme[0]);
		System.out.println(forme[1]);
		
		for(int i = 0; i<2; ++i) {
			if (forme[i] instanceof Circle) {
				Circle aux = (Circle)forme[i];
				aux.printCircleDimensions();
			} else if (forme[i] instanceof Triangle) {
				Triangle aux = (Triangle)forme[i];
				aux.printTriangleDimensions();
			}
		}
		
		for(int i = 0; i<2; ++i) {
			forme[i].printDimensions();
		}
	}
	
}
