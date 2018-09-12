
public class Main {

	static int mAaa = 44;

	public static void main(String[] args) {

		/*
		 * int a = 0; a = 88 + (7 - 222) * 5;
		 * 
		 * int aa = a + 44;
		 * 
		 * boolean b = true;
		 * 
		 * char c = '1';
		 * 
		 * double d = 11.1;
		 * 
		 * String s = "AAAAAAAAaa";
		 * 
		 * System.out.println("Hello world!"); System.out.println(aa / 9);
		 * System.out.println(b); System.out.println(c); //System.out.println(s); sdf
		 * sdf sdf sdf sdf
		 */

		/*
		 * double a = 5 / 2.0; System.out.println(a);
		 * 
		 * String s = "Hello" + " " + "World" + (a + 10); System.out.println(s);
		 */

		/*
		 * String s = "abcabc"; int a = s.indexOf("b"); System.out.println(a);
		 * 
		 * System.out.println(s.indexOf("abc")); System.out.println(s.indexOf("b", 30));
		 */

		/*
		 * String s = "abcabc"; s = s.replace("ab", "AB");
		 * System.out.println(s.replace("ab", "AB")); System.out.println(s);
		 */

		// String s = " abc abc ";
		// System.out.println(s.trim().replace(" ", ""));

		// String s = "abcabc";
		// System.out.println(s.charAt(3));

		/*
		 * String email = "vasya@mail.com"; int dog = email.indexOf("@"); String login =
		 * email.substring(0, dog); String domain = email.substring(dog + 1);
		 * 
		 * System.out.println(login); System.out.println(domain);
		 */

		/*
		 * int a = 0; a = a + 5; a += 5;
		 */

		/*
		 * int a = 0; int b = 0;
		 * 
		 * System.out.println(a++); System.out.println(++b); System.out.println(a);
		 * System.out.println(b);
		 */

		/*
		 * test("");
		 * 
		 * String sss = test2("a", "b"); System.out.println(sss);
		 * 
		 * int aaa = mAaa + 4;
		 * 
		 * int a = 2; test3(a);
		 * 
		 * System.out.println(a);
		 * 
		 * String s = "BBB"; s = test3(s);
		 * 
		 * System.out.println(s);
		 */

		int a = 5;

		String s = Integer.toString(a);
		String ss = String.valueOf(a);

		a = Integer.valueOf("1,500 ".replace(" ", "").replace(".", "").replace(",", ""));
		a = Integer.parseInt("5");
		
		float f = Float.parseFloat("1,123.456");

	}

	public static void test3(int a) {
		a += 10;
	}

	public static String test3(String ss) {
		ss += "AAAA";
		return ss;
	}

	public static String test2(String s, String ss) {
		int aaa = 55 - mAaa;
		return s + ss;
	}

	public static void test(String s) {
		test(s, "");
	}

	public static void test(String s, String ss) {
		test(s, ss, 0);
	}

	public static void test(String s, String ss, int a) {
		System.out.println(s + ss + a);
	}
}
