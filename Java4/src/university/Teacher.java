package university;

public class Teacher extends Person {
	public int salaryHour = 100;

	public int getSalary(int hours) {
		return salaryHour * hours;
	}
}
