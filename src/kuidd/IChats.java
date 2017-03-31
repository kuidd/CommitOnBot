package kuidd;

public interface IChats {
	public void add(IChat chat);

	public void remove(IChat chat);

	public boolean exists(IChat chat);

	public void broadcast(ICommit commit);
}
