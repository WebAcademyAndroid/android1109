import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		/*
		 * int salary = 1500;
		 * 
		 * if (salary < 500 || salary > 2000) { System.out.println("NO!"); } else {
		 * System.out.println("YES"); }
		 * 
		 * if (salary >= 500 && salary <= 2000) { System.out.println("YES"); } else {
		 * System.out.println("NO!"); }
		 * 
		 * boolean b = salary < 500 || salary > 2000; if (b) {
		 * System.out.println("NO!"); } else { System.out.println("YES"); }
		 * 
		 * if (salary < 500 || salary > 2000) { System.out.println("NO!"); }
		 * 
		 * if (salary < 500 || salary > 2000) System.out.println("NO!");
		 * System.out.println("NO!");
		 * 
		 * System.out.println(salary < 500 || salary > 2000 ? "NO!" : salary == 666 ?
		 * "NO!" : "YES");
		 */

		/*
		 * int salary = 1000; switch (salary) { case 100: case 2000:
		 * System.out.println("NO!"); break; case 500: case 1000:
		 * System.out.println("YES"); break; default: System.out.println("I DONT KNOW");
		 * break; }
		 */

		/*
		 * int salary = 1000; int money = 0;
		 * 
		 * for (int i = 0; i < 3; i++) { money += salary; }
		 * 
		 * System.out.println(money);
		 */

		/*
		 * int salary = 100; int count = 0;
		 * 
		 * while (salary < 1000) { salary += 10; count++;
		 * 
		 * if (count > 1000) { break; } }
		 * 
		 * System.out.println(salary);
		 * 
		 * do { salary += 10; } while (salary < 1000);
		 */

		/*
		 * int[] arr = new int[10];
		 * 
		 * for (int i = 0; i < arr.length; i++) { arr[i] = i; }
		 * 
		 * arr[5] = 55;
		 * 
		 * for (int i = 0; i < arr.length; i++) { System.out.print(arr[i]);
		 * 
		 * if (i < arr.length - 1) { System.out.print("-"); } }
		 */

		/*
		 * int[][][][] matrix = new int[99][99][99][99]; matrix[0][1][66][6] = 3;
		 * 
		 * ArrayList<String> arr = new ArrayList<>(); arr.add("AAA"); arr.add(0, "BBB");
		 * arr.set(1, "CCC"); arr.remove(0);
		 * 
		 * for (int i = 0; i < arr.size(); i++) { System.out.println(arr.get(i)); } for
		 * (String s : arr) { System.out.println(s); }
		 */

		// ArrayList<ArrayList<ArrayList<String>>> arr2 = new ArrayList<>();

		/*
		 * ArrayList<String> arr = new ArrayList<>(); arr.add("AAA"); arr.add("BBB");
		 * arr.add("CCC"); arr.add("DDD"); arr.add("BBB"); arr.add("BBB");
		 * arr.add("EEE"); arr.add("FFF"); arr.add("BBB");
		 * 
		 * for (int i = arr.size() - 1; i >= 0; i--) { if (arr.get(i).equals("BBB")) {
		 * arr.remove(i); } }
		 * 
		 * for (String s : arr) { System.out.println(s); }
		 * 
		 * 
		 * int position = find(arr); while(position >= 0) { arr.remove(position);
		 * position = find(arr); }
		 */

		HashMap<String, Integer> map = new HashMap<>();
		map.put("B", 2);
		map.put("A", 1);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);

		map.remove("C");

		for (String s : map.keySet()) {
			System.out.println(s + ": " + map.get(s));
		}

		if (map.containsKey("H")) {
			System.out.println(map.get("H"));
		}
	}

	public static int find(ArrayList<String> arr) {
		for (int i = arr.size() - 1; i >= 0; i--) {
			if (arr.get(i).equals("BBB")) {
				return i;
			}
		}

		return -1;
	}

	/*
	 * public static String test(int salary) { /* if (salary >= 500 && salary <=
	 * 2000) { return "NO!"; } return "YES";
	 * 
	 * 
	 * if (salary < 500) { return "NO!"; } else if (salary > 2000) { return "NO!"; }
	 * 
	 * // return salary >= 500 && salary <= 2000 ? "NO!" : "YES"; }
	 * 
	 * public static String test2(int salary) { switch (salary) { case 100: case
	 * 2000: return "NO!"; case 500: case 1000: return "YES"; default: return
	 * "I DONT KNOW"; } }
	 * 
	 * public static void test2() { return; }
	 */
}
