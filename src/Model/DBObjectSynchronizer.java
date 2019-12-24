package Model;

public abstract class DBObjectSynchronizer {
	protected String objectTypeCode;
	protected String objectTypeLable;
	
	public String getObjectTypeCode() {
		return objectTypeCode;
	}
	
	public void setObjectTypeCode(String objectTypeCode) {
		this.objectTypeCode = objectTypeCode;
	}
	
	public String getObjectTypeLable() {
		return objectTypeLable;
	}
	
	public void setObjectTypeLable(String objectTypeLable) {
		this.objectTypeLable = objectTypeLable;
	}
	
	public void processSyn(DBSynchronizeManager dbSynchronizeManager) {
		
	}
	
	public void compile(DBSynchronizeManager dbSynchronizeManager) {
		
	}
}
