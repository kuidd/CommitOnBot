package kuidd.bot.commiton;

public class Commit implements ICommit {
	private String author;
	private String repository;
	private String comment;

	public Commit(String author, String repository, String comment) {
		this.author = author;
		this.repository = repository;
		this.comment = comment;
	}

	@Override
	public void notify(IChat chat) {
		chat.print(author + " committed on " + repository + ": " + comment);
	}
}
