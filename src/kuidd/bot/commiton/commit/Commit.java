package kuidd.bot.commiton.commit;

import kuidd.bot.commiton.IChat;

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
	public void notify(IChat chat, String filter) {
		if (repository.toLowerCase().contains(filter.toLowerCase()) || comment.toLowerCase().contains(filter.toLowerCase())) {
			chat.print(author + " committed on " + repository + ": " + comment);
		}
	}
}
