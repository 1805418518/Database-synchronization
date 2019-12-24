package Model;

//��������
public class MacroCommand extends TempTableSynCommand {
	TempTableSynCommand lastCommand = this;
	
	public void add(TempTableSynCommand tempTableSynCommand) {
		tempTableSynCommand.setPreviousCommand(lastCommand);
		lastCommand = tempTableSynCommand;	//����������
	}
	
	@Override
	public void execute() throws Exception{
		
	}
	
	@Override
	public void undo() throws Exception{
		
	}
}
