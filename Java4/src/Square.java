
public class Square extends BaseShape  {
	private int side;

	public Square(int side) {
		this.type = Shapes.Square;
		this.side = side;
	}

	public double calculate() {
		return side * side;
	}

	public void test() {

	}
}
