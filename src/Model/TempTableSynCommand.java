package Model;

//����������
public abstract class TempTableSynCommand {
	
	protected TempTableSynCommand previousCommand;//�����ڳ����쳣ʱ��������һ�������undo()����ʵ�ָֻ�����
	protected TempTableSynCommand nextCommand;//������ִ���굱ǰ�����ҵ���߼�����ִ����һ�������ҵ���߼�
	
	public void setPreviousCommand(TempTableSynCommand preCommand) {
		this.previousCommand = preCommand;
	}
	
	//ʹ����ְ����ģʽ,nextCommnad.execute()ʵ������ְ����
	//ִ�������
	protected void execute() throws Exception {
		
	}
	
	//previousCommand.undo()����Java���쳣�������ʵ�ַ���ְ����
	//�ع�����
	protected void undo() throws Exception {
		
	}
}
