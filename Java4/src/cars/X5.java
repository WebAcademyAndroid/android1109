package cars;

public class X5 extends BaseCar {
	protected void drive() {
		System.out.println("Belt on");
		super.drive();
	}

	public void cancel() {
		super.cancel();

		System.out.println("Belt off");
	}
}
