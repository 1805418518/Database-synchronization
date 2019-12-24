package Model;

//≥‰µ±æﬂÃÂ√¸¡Ó
public class SynTableDataCommand  extends TempTableSynCommand {
	private DataSynHelper dataSynHelper;
	private Database srcDB,detDB;
	private String fromTableName,toTableName;
	
	public SynTableDataCommand(DataSynHelper dataSynHelper,String fromTableName,String toTableName,Database srcDB,Database destDB) {
		
	}
	
	@Override
	public void execute() throws Exception{
		
	}
	
	@Override
	public void undo() throws Exception{
		
	}
}
