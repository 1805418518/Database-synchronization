package Model;

//∫Í√¸¡Ó¿‡
public class MacroCommand extends TempTableSynCommand {
	TempTableSynCommand lastCommand = this;
	
	public void add(TempTableSynCommand tempTableSynCommand) {
		tempTableSynCommand.setPreviousCommand(lastCommand);
		lastCommand = tempTableSynCommand;	//¥¥Ω®√¸¡Ó¡¥
	}
	
	@Override
	protected void execute() throws Exception{
		
	}
	
	@Override
	protected void undo() throws Exception{
		
	}
}
