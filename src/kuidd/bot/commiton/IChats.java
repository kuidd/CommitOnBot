package kuidd.bot.commiton;

import kuidd.bot.commiton.commit.ICommit;

public interface IChats {
	public void add(IChat chat, String filter);

	public void remove(IChat chat, String filter);

	public void print(IChat chat);

	public void broadcast(ICommit commit);
}
