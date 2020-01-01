package Model;

//DBSynchronizeManagerFactory类充当数据库同步流程管理器的简单工厂
//DBSynchronizeManager是抽象产品,而OracleDBSynchronizeManager为具体产品
public class DBSynchronizeManagerFactory {
	public DBSynchronizeManager factory(String dbType) throws Exception {
		String className = DBSynConfigParser.getSynchronizeManagerClass(dbType);
		return (DBSynchronizeManager)Class.forName(className).newInstance();
	}
}
