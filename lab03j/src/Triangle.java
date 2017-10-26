
public class Triangle extends Form {
	float height;
	float base;
	
	Triangle(){}
	
	Triangle(String color,float height, float base) {
		super(color);
		this.height = height;
		this.base = base;
	}
	
	float getArea(){
		return height * base / 2;
	}
	
	
	public String toString(){
		return "Triunghi: " + super.toString() + " " + getArea();
	}
	
	public boolean equals(Triangle other) {
		return other.toString().equals(toString());
	}
	
	public void printTriangleDimensions(){
		System.out.println(base + " " + height);
	}
	
	public void printDimensions(){
		printTriangleDimensions();
	}
}
