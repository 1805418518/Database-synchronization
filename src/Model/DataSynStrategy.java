package Model;

//同步策略接口DataSynStrategy
public abstract class DataSynStrategy {
	protected String tableName;
	protected Database srcDB,destDB;
	
	/*
	public DataSynStrategy(String tableName,Database srcDB,Database destDB) {
		//this.tableName = tableName;
		//this.srcDB = srcDB;
		//this.destDB = destDB;
	}
	*/
	
	public String processSyn() {
		//return null;
	}
}
