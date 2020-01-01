package Model;

//抽象命令类
public abstract class TempTableSynCommand {
	
	protected TempTableSynCommand previousCommand;//用于在出现异常时，调用上一个命令的undo()方法实现恢复操作
	protected TempTableSynCommand nextCommand;//用于在执行完当前命令的业务逻辑后，再执行下一个命令的业务逻辑
	
	public void setPreviousCommand(TempTableSynCommand preCommand) {
		this.previousCommand = preCommand;
	}
	
	//使用了职责链模式,nextCommnad.execute()实现正向职责链
	//执行命令方法
	protected void execute() throws Exception {
		
	}
	
	//previousCommand.undo()加上Java的异常处理机制实现反向职责链
	//回滚方法
	protected void undo() throws Exception {
		
	}
}
