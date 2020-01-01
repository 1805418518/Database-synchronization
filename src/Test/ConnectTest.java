package Test;

import Util.DBUtil2;

public class ConnectTest {

	public static void main(String[] args) {
		DBUtil2.getConnection("sys", "gc123456", "ORCL", "127.0.0.1");
	}

}
