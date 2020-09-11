
public class Rectangle extends Shape {
	
	public Rectangle(double width, double height) {
		super();
		this.width= width;
		this.height = height;
	}

	@Override
	public void print() {
		System.out.println("print a rectangle");

	}

	@Override
	public void draw() {
		System.out.println("draw a rectangle");
		
	}
public double getArea() {
	return width * height;
}

private double width;
private double height;
}
