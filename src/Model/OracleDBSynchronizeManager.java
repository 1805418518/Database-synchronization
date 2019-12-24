package Model;

//OracleDBSynchronizeManagerΪ�����Ʒ
public class OracleDBSynchronizeManager extends DBSynchronizeManager{
	//DBSynchronizeManager����OracleDBSynchronizeManagerΪexecuteSyn()�����ṩ�˾���ʵ��
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
