package cars;

public class Tesla extends BaseCar {
	protected void startEngine() {
		System.out.println("Button on");
	}

	protected void stopEngine() {
		System.out.println("Button off");
	}
}
