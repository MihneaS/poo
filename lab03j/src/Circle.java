
public class Circle extends Form{
	float radius;
	
	Circle(){}
	
	Circle(String color, float radius) {
		super(color);
		this.radius = radius;
	}
	
	float getArea() {
		return 3.14f*radius*radius;
	}
	
	public String toString(){
		return "Cerc: " + super.toString() + " " + getArea();
	}
	
	public void printCircleDimensions(){
		System.out.println(radius);
	}
	
	public void printDimensions(){
		printCircleDimensions();
	}
}
