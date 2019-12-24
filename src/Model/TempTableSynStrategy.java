package Model;

import CompositeModeCommandModeAndResponsibilityChainMode.*;

public class TempTableSynStrategy  extends DataSynStrategy {
	
	public TempTableSynStrategy(String tableName,Database srcDB,Database destDB) {
		//this.tableName = tableName;
		//this.srcDB = srcDB;
		//this.destDB = destDB;
	}

	@Override
	public String processSyn() {
		//��������ʡ��
		String tempTableName = generateTempTableName();
		String backupTableName = "BAK_" + tempTableName;
		DataSynHelper dataSynHelper = new DataSynHelperImpl();
		MacroCommand marcoCommand = new MacroCommand();
		marcoCommand.add(new RenameTableConstraintCommand(dataSynHelper,tableName,destDB));
		marcoCommand.add(new SynTableDataCommand(dataSynHelper,tableName,tempTableName,srcDB,destDB));
		marcoCommand.add(new RenameTableCommand(dataSynHelper,tableName,backupTableName,destDB));
		marcoCommand.add(new RenameTableCommand(dataSynHelper, tempTableName, tableName, destDB));
		try {
			marcoCommand.execute();
			try {
				//��������ʡ��
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//��������ʡ��
		return null;
	}
	
	private String generateTempTableName() {
		return null;
	}
}
