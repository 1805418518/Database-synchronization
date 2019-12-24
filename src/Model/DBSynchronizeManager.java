package Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*DBSynchronizeManager�䵱���Ӳ�Ʒ
 ���ݿ�ͬ�����̹�����DBSynchronizeManager�࣬���ڸ���������ݿ�ͬ���ľ���ִ�в��衣
�û���ǰ̨�����������ͬ����������������ʱ����Ҫ������Щ����������DBSynchronizeManager����
��������DBSynchronizeManager����Ĺ�������DBSynchronizeManagerBuilder����
ʡ���˳�������
*/

public abstract class DBSynchronizeManager {
	protected List<DBObjectSynchronizer> synchronizers = 
			new ArrayList<DBObjectSynchronizer>();
	protected Database srcDB,destDB,ctrlDB;
	Map <String,SynDataTableConfig> synDataTableConfigs;
	
	public Database getSrcDB() {
		return srcDB;
	}
	public void setSrcDB(Database srcDB) {
		this.srcDB = srcDB;
	}
	public Database getDestDB() {
		return destDB;
	}
	public void setDestDB(Database destDB) {
		this.destDB = destDB;
	}
	public Database getCtrlDB() {
		return ctrlDB;
	}
	public void setCtrlDB(Database ctrlDB) {
		this.ctrlDB = ctrlDB;
	}
	public Map<String, SynDataTableConfig> getSynDataTableConfigs() {
		return synDataTableConfigs;
	}
	public void setSynDataTableConfigs(Map<String, SynDataTableConfig> synDataTableConfigs) {
		this.synDataTableConfigs = synDataTableConfigs;
	}
	
	//ע�᷽��
	public void attachDBSynchronizer(DBObjectSynchronizer dbSynchronizer) {
		synchronizers.add(dbSynchronizer);
	}
	
	//ע������
	public void detachDBSynchronizer(DBObjectSynchronizer dbSynchronizer) {
		synchronizers.remove(dbSynchronizer);
	}
	
	/*
	���DBSynchronizeManager��executeSyn()���������ã�
	�������۲��߼��ϣ�����ÿһ��DBObjectSynchronizer�����executeSyn()������compileDBObject()������
	��ʱDBSynchronizeManager�䵱����۲�Ŀ�꣬
	OracleDBSynchronizeManager�䵱����۲�Ŀ�꣬
	DBObjectSynchronizer�䵱����۲��ߣ�
	OracleTableDBSynchronizer�䵱����۲��ߡ�
	*/
	//�����֪ͨ����
	public void executeSyn() throws Exception{
		
	}
}
