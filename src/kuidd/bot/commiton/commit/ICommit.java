package kuidd.bot.commiton.commit;

import kuidd.bot.commiton.IChat;

public interface ICommit {
	public void notify(IChat chat, String filter);
}
