package Model;

//≥‰µ±æﬂÃÂ√¸¡Ó
public class RenameTableConstraintCommand  extends TempTableSynCommand {
	private String[] oldConstraintNames;
	private String[] newConstraintNames;
	private DataSynHelper dataSynHelper;
	private Database database;
	private String tableName,constraintNamePrefix;
	
	public RenameTableConstraintCommand(DataSynHelper dataSynHelper,String tableName,Database database) {
		
	}
	
	@Override
	public void execute() throws Exception{
		
	}
	
	@Override
	public void undo() throws Exception{
		
	}
	
	private String[] queryConstraintNames(String tableName,Database database){
		
	}
}
