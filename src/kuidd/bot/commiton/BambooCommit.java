package kuidd.bot.commiton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BambooCommit implements ICommit {
	private Commit commit;

	public BambooCommit(String json) {
		try {
			Gson gson = new GsonBuilder().create();
			// TODO: #15
			// BambooResponse response = gson.fromJson(json, BambooResponse.class);
			// commit = new Commit(response.getAuthor(), response.getRepository());
			commit = new Commit("Dmitry Usynin", "Repository");
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		commit.notify(chat);
	}

}
