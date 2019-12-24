package Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*DBSynchronizeManager充当复杂产品
 数据库同步流程管理器DBSynchronizeManager类，用于负责控制数据库同步的具体执行步骤。
用户在前台界面可以配置同步参数，程序运行时，需要根据这些参数来创建DBSynchronizeManager对象
创建完整DBSynchronizeManager对象的过程由类DBSynchronizeManagerBuilder负责
省略了抽象建造者
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
	
	//注册方法
	public void attachDBSynchronizer(DBObjectSynchronizer dbSynchronizer) {
		synchronizers.add(dbSynchronizer);
	}
	
	//注销方法
	public void detachDBSynchronizer(DBObjectSynchronizer dbSynchronizer) {
		synchronizers.remove(dbSynchronizer);
	}
	
	/*
	如果DBSynchronizeManager的executeSyn()方法被调用，
	将遍历观察者集合，调用每一个DBObjectSynchronizer对象的executeSyn()方法和compileDBObject()方法，
	此时DBSynchronizeManager充当抽象观察目标，
	OracleDBSynchronizeManager充当具体观察目标，
	DBObjectSynchronizer充当抽象观察者，
	OracleTableDBSynchronizer充当具体观察者。
	*/
	//抽象的通知方法
	public void executeSyn() throws Exception{
		
	}
}
