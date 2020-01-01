package Model;

//��������
public class MacroCommand extends TempTableSynCommand {
	TempTableSynCommand lastCommand = this;
	
	public void add(TempTableSynCommand tempTableSynCommand) {
		tempTableSynCommand.setPreviousCommand(lastCommand);
		lastCommand = tempTableSynCommand;	//����������
	}
	
	@Override
	protected void execute() throws Exception{
		
	}
	
	@Override
	protected void undo() throws Exception{
		
	}
}
