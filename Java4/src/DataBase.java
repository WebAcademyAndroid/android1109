
public class DataBase {

	private static DataBase db;

	public static DataBase getInstance() {
		if (db == null) {
			db = new DataBase();
		}

		return db;
	}

	private DataBase() {

	}

	public void saveData() {

	}
}
