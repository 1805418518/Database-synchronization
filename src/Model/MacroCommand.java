package Model;

//∫Í√¸¡Ó¿‡
public class MacroCommand extends TempTableSynCommand {
	TempTableSynCommand lastCommand = this;
	
	public void add(TempTableSynCommand tempTableSynCommand) {
		tempTableSynCommand.setPreviousCommand(lastCommand);
		lastCommand = tempTableSynCommand;	//¥¥Ω®√¸¡Ó¡¥
	}
	
	@Override
	public void execute() throws Exception{
		
	}
	
	@Override
	public void undo() throws Exception{
		
	}
}
