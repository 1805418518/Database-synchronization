package Model;

import java.util.HashMap;
import java.util.Map;

public class DBObjectSynchronizerFlyweightFactory {
	private static DBObjectSynchronizerFlyweightFactory instance = new DBObjectSynchronizerFlyweightFactory();
	private Map<String, DBObjectSynchronizer> map = new HashMap<String,DBObjectSynchronizer>();
	
	private DBObjectSynchronizerFlyweightFactory() {
		
	}
	
	public static DBObjectSynchronizerFlyweightFactory getInstance() {
		return instance;
	}
	
	public DBObjectSynchronizer factory(DBObjectSynchronizerMeta dbObjectSynchronizerMeta) {
		/**/
		DBObjectSynchronizer temp = null;
		return temp;
		/**/
	}
	
	private DBObjectSynchronizer buildDBObjectSynchronizer(DBObjectSynchronizerMeta dbObjectSynchronizeMeta) {
		/**/
		DBObjectSynchronizer temp = null;
		return temp;
		/**/
	}
}
