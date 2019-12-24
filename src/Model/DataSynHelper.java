package Model;

//请求接收者,定义了辅助实现临时表方式同步的一些方法，在命令类中将调用这些方法
public interface DataSynHelper {
	public void renameTable(String fromTableName,String toTableName,Database database);
	
	public void renameConstraintNames(String tableName,String oldConstraintNames[],
			String newConstraintNames[],Database database);
	
	public void synTableData(String fromTableName,String toTableName,Database srcDB,Database destDB);
	
	public void dropTable(String tableName,Database database);
}
