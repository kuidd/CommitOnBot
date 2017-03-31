package kuidd.bot.commiton;

public interface IBot {
	public void help(IChat chat);

	public void start(IChat chat);

	public void subscribe(IChat chat);

	public void unsubscribe(IChat chat);

	public void broadcast(ICommit commit);
}