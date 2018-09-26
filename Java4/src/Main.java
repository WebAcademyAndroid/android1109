import cars.Tesla;
import cars.X5;
import univercity2.Person;
import univercity2.Student;
import univercity2.Teacher;

public class Main {

	public static final int Circle = 0;
	public static final int Square = 1;

	public static void main(String[] args) {
		// DataBase.getInstance().saveData();

		/*
		 * Circle c = new Circle(100); System.out.println(c.calculate()); print(c);
		 */

		// Square s = new Square(200);
		// System.out.println(s.calculate());
		// print(s);
		// s.test();

		// IShape[] arr;

		/*
		 * X5 x5 = new X5(); x5.go(); x5.cancel();
		 * 
		 * Tesla t = new Tesla(); t.go(); t.cancel();
		 */

		/*
		 * Student s = new Student(); Teacher t = new Teacher();
		 * 
		 * t.salaryHour = 3333;
		 */

		// Person p = new Person();
		// p.student = new Student();
		// p.teacher = new Teacher();

		Circle c = null;
		print(c);
	}

	public static void print(BaseShape bShape) {
		try {
			int a = 5 / 0;
			System.out.println(bShape.calculate());
			bShape.printType();

			if (bShape instanceof Square) {
				Square s = (Square) bShape;
				s.test();
			}
		} catch (NullPointerException e) {
			System.out.println("null pointer");
			return;
		} catch (Exception e) {
			System.out.println("Exception");
			return;
		} finally {
			System.out.println("some code");
		}
	}

}
