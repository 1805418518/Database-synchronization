package Model;

//DBSynchronizeManagerFactory��䵱���ݿ�ͬ�����̹������ļ򵥹���
//DBSynchronizeManager�ǳ����Ʒ,��OracleDBSynchronizeManagerΪ�����Ʒ
public class DBSynchronizeManagerFactory {
	public DBSynchronizeManager factory(String dbType) throws Exception {
		String className = DBSynConfigParser.getSynchronizeManagerClass(dbType);
		return (DBSynchronizeManager)Class.forName(className).newInstance();
	}
}
