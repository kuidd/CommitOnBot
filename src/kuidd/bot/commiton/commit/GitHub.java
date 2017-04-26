package kuidd.bot.commiton.commit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kuidd.bot.commiton.IChat;
import kuidd.bot.commiton.json.github.Request;

public class GitHub implements ICommit {
	private Commit commit;

	public GitHub(String json) {
		try {
			Gson gson = new GsonBuilder().create();
			Request request = gson.fromJson(json, Request.class);
			commit = new Commit(request.getHeadCommit().getAuthor().getName(), request.getRepository().getName(),
					request.getHeadCommit().getMessage());
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		commit.notify(chat);
	}
}