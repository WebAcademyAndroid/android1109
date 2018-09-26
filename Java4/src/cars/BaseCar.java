package cars;

public abstract class BaseCar {
	public void go() {
		startEngine();
		drive();
	}

	public void cancel() {
		stop();
		stopEngine();
	}

	protected void startEngine() {
		System.out.println("startEngine");
	}

	protected void stopEngine() {
		System.out.println("stopEngine");
	}

	protected void drive() {
		System.out.println("drive");
	}

	protected void stop() {
		System.out.println("stop");
	}
}
