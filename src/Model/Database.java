package Model;

public class Database {
	private String address = "";		//地址
	private String username = "";		//用户名
	private String password = "";		//密码
	private String databaseName = "";	//数据库名

	public Database(String address, String username, String password, String databaseName) {
		this.address = address;
		this.username = username;
		this.password = password;
		this.databaseName = databaseName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	@Override
	public String toString() {
		return address + ":" + databaseName;
	}
}
