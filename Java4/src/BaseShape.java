
public abstract class BaseShape implements IShape {
	protected Shapes type;

	public void printType() {
		switch (type) {
		case Circle:
			System.out.println("I am circle");
			break;
		case Square:
			System.out.println("I am square");
			break;
		}
	}
}
