
public class Circle extends BaseShape  {

	private int radius;

	public Circle(int radius) {
		this.type = Shapes.Circle;
		this.radius = radius;
	}

	public double calculate() {
		return 3.14 * radius * radius;
	}
}
