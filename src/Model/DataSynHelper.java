package Model;

//���������,�����˸���ʵ����ʱ��ʽͬ����һЩ���������������н�������Щ����
public interface DataSynHelper {
	public void renameTable(String fromTableName,String toTableName,Database database);
	
	public void renameConstraintNames(String tableName,String oldConstraintNames[],
			String newConstraintNames[],Database database);
	
	public void synTableData(String fromTableName,String toTableName,Database srcDB,Database destDB);
	
	public void dropTable(String tableName,Database database);
}
