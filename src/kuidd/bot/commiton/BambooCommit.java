package kuidd.bot.commiton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kuidd.bot.commiton.json.bamboo.BambooResponse;

public class BambooCommit implements ICommit {
	private Commit commit;

	public BambooCommit(String json) {
		try {
			Gson gson = new GsonBuilder().create();
			BambooResponse response = gson.fromJson(json, BambooResponse.class);
			commit = new Commit(response.getAuthor(), response.getRepository(), response.getComment());
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		commit.notify(chat);
	}

}
