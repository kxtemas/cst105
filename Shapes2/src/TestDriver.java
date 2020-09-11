
public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape shape = new Circle(2);
		shape.PrintArea();
		doPrint(shape);
		
		shape = new Rectangle(3,2);
		shape.PrintArea();
		doPrint(shape);
		
		shape = new Triangle(4,3);
		shape.PrintArea();
		doPrint(shape);
	}

	static void doPrint(Printable p) {
		p.print();
	}
}
 