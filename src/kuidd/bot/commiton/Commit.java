package kuidd.bot.commiton;

public class Commit implements ICommit {
	private String author;
	private String repository;

	public Commit(String author, String repository) {
		this.author = author;
		this.repository = repository;
	}

	@Override
	public void notify(IChat chat) {
		chat.print(author + " committed on " + repository);
	}
}
