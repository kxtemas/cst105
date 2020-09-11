
public abstract class Shape implements Drawable, Printable{

		public abstract double getArea();
		
		public void PrintArea() {
			System.out.println("i am a " + super.getClass().toString()
					+ " of area: " + getArea());
		}
}
