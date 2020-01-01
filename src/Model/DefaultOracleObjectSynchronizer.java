package Model;

public class DefaultOracleObjectSynchronizer extends DBObjectSynchronizer {
	public void processSyn(DBSynchronizeManager dbSynchronizeManager) {
		
	}
	
	public void compile(DBSynchronizeManager dbSynchronizeManager) {
		if(getCompileable()) {
			Database destDB = dbSynchronizeManager.getDestDB();
			String[] compileObjs = findAllObjects(destDB);
			int iLen = compileObjs.length;
			for(int i = 0; i < iLen; i++) {
				compileObject(destDB,compileObjs[i]);
			}
		}
	}
	
	protected boolean getCompileable() {
		/**/
		return true;
		/**/
	}
	
	protected String[] findAllObjects(Database destDB) {
		/**/
		String[] str = null;
		return str;
		/**/
	}
	
	protected void compileObject(Database destDB,String dbObjName) {
		
	}
}
