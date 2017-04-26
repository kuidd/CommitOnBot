package kuidd.bot.commiton;

import kuidd.bot.commiton.commit.ICommit;

public interface IBot {
	public void help(IChat chat);

	public void start(IChat chat);

	public void subscribe(IChat chat);

	public void unsubscribe(IChat chat);

	public void broadcast(ICommit commit);
}