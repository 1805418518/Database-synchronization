package Model;


//DBSynchronizeManagerBuilder充当建造者
//由类DBSynchronizeManagerBuilder负责创建完整DBSynchronizeManager对象的过程
public class DBSynchronizeManagerBuilder {
	private SynchronizeParaminfo synchronizeParaminfo;
	private DBSynchronizeManager dbSynchronizeManager;
	
	public void initParam(SynchronizeParaminfo synchronizeParaminfo) {
		
	}
	
	//创建一个初始的DBSynchronizeManager实例,再一步一步为其设置属性
	public void buildLife() {
		
	}
	
	public void buildDatabase() {
		
	}
	
	public void buildDBSynchronizer() {
		
	}
	
	public void buildSynDataTableConfigs() {
		
	}
	
	public DBSynchronizeManager retrieveResult() {
		/**/
		DBSynchronizeManager temp = null;
		return temp;
		/**/
	}
}
