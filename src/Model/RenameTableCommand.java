package Model;

//≥‰µ±æﬂÃÂ√¸¡Ó
public class RenameTableCommand  extends TempTableSynCommand {
	private DataSynHelper dataSynHelper;
	private Database database;
	private String fromTableName;
	private String toTableName;
	
	public RenameTableCommand(DataSynHelper dataSynHelper,String fromTableName,String toTableName,Database database) {
		
	}
	
	@Override
	protected  void execute() throws Exception{
		
	}
	
	@Override
	protected void undo() throws Exception{
		
	}
}
