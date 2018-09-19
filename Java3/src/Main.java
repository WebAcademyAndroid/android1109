import java.util.HashMap;

import test.TestClass;

public class Main {

	public static void main(String[] args) {
		/*
		 * int a = 9; a = 4;
		 * 
		 * Student s = new Student(); s.name = "Ivan"; s.age = 33;
		 * 
		 * Student s2 = null; if (s2 != null) { s2.age = 22; }
		 */

		/*
		 * int a = 1; int b = a; a = 2;
		 * 
		 * 
		 * Student s = new Student(); s.age = 22;
		 * 
		 * Student s2 = s; s2.age = 33;
		 */

		Student s = new Student();
		s.setName("Ivan");
		s.setAge(33);

		Student s2 = new Student("Ivan");
		s.setAge(333);

		Student s3 = new Student("Ivan", 33);

		int a = 2;
		test(a);

		Student s4 = new Student();
		test(s4);
		s4.test();

		TestClass tc = new TestClass();
		// tc.test = "AAAA";
		
		Student[] arr = new Student[10];
		arr[0] = new Student();
		arr[0].setAge(22);
		
		HashMap<Student, String> map = new HashMap<>();
		
		
		Student s5 = new Student("Ivan", 33);
		Student s6 = new Student("Ivan", 33);
		
		if(s5.getName().equals(s6.getName())) {
			
		}
		
		String str1 = "AAA";
		String[] str2 = "AAA".split("\\+\\+");
		if(str1 != null && str1.length() > 0) {
			
		}
	}

	public static void test(int a) {
		a = 10;
	}

	public static void test(Student s) {
		if (s != null) {
			s.setAge(10);
		}
		
		Student.getLogin("vasya@mail.com");
	}

}
