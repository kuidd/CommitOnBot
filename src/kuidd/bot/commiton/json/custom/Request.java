package kuidd.bot.commiton.json.custom;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

	@SerializedName("author")
	@Expose
	private String author;
	@SerializedName("repository")
	@Expose
	private String repository;
	@SerializedName("comment")
	@Expose
	private String comment;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}