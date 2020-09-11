//inheritence is where it extends to the shape class
//the shape class has an abtract class
public class Triangle extends Shape {
//all of these public methods would be considered encapsulation
	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}

	// there is polymorphism at the area and printing of the triangle
	@Override
	public void print() {
		System.out.println("print a triangle");

	}

	@Override
	public void draw() {
		System.out.println("draw a triangle");
		
	}
public double getArea() {
	return ((base * height)/2);
}
//encapsulation since it is private data and we also have public methods
private double base;
private double height;
}
