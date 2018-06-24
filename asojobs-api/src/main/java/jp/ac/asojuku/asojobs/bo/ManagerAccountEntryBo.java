package jp.ac.asojuku.asojobs.bo;

import jp.ac.asojuku.asojobs.beans.EntryManagerAccount;
import jp.ac.asojuku.asojobs.exception.HashMistakeException;

public interface ManagerAccountEntryBo {
	public int entryAccountEntry(EntryManagerAccount entrymangeraccount)throws HashMistakeException;
}
