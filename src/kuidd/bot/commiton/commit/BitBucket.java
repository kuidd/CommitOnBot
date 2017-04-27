package kuidd.bot.commiton.commit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kuidd.bot.commiton.IChat;
import kuidd.bot.commiton.json.bitbucket.Request;

public class BitBucket implements ICommit {
	private Commit commit;

	public BitBucket(String json) {
		try {
			Gson gson = new GsonBuilder().create();
			Request request = gson.fromJson(json, Request.class);
			commit = new Commit(request.getActor().getDisplayName(), request.getRepository().getName(),
					request.getPush().getChanges().get(0).getNew().getTarget().getMessage());
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat, String filter) {
		commit.notify(chat, filter);
	}

}
