package Model;

//OracleDBSynchronizeManager为具体产品
public class OracleDBSynchronizeManager extends DBSynchronizeManager{
	//DBSynchronizeManager子类OracleDBSynchronizeManager为executeSyn()方法提供了具体实现
	public void executeSyn() {
		synDBObject();
		compileDBObject();
	}
	
	protected void synDBObject() {
		for(DBObjectSynchronizer dbSynchronizer : synchronizers) {
			try {
				dbSynchronizer.processSyn(this);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void compileDBObject() {
		for(DBObjectSynchronizer dbSynchronizer : synchronizers) {
			try {
				dbSynchronizer.compile(this);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
