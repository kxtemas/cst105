
public class Circle extends Shape {
	
	public Circle (double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public void print() {
		System.out.println("print a circle");

	}
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	private double radius;
}
