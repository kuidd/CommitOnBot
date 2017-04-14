package kuidd.bot.commiton.json.bamboo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BambooResponse {

	@SerializedName("author")
	@Expose
	private String author;
	@SerializedName("repository")
	@Expose
	private String repository;

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

}