package kuidd.bot.commiton.commit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kuidd.bot.commiton.IChat;
import kuidd.bot.commiton.json.custom.Request;

public class Custom implements ICommit {
	private Commit commit;

	public Custom(String json) {
		try {
			Gson gson = new GsonBuilder().create();
			Request request = gson.fromJson(json, Request.class);
			commit = new Commit(request.getAuthor(), request.getRepository(), request.getComment());
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		commit.notify(chat);
	}

}
