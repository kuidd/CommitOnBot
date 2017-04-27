package kuidd.bot.commiton;

import kuidd.bot.commiton.commit.ICommit;

public interface IBot {
	public void start(IChat chat);

	public void help(IChat chat);

	public void status(IChat chat);

	public void subscribe(IChat chat, String filter);

	public void unsubscribe(IChat chat, String filter);

	public void broadcast(ICommit commit);
}