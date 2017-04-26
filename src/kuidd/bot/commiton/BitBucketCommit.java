package kuidd.bot.commiton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kuidd.bot.commiton.json.bitbucket.BitBucket;

public class BitBucketCommit implements ICommit {
	private Commit commit;

	public BitBucketCommit(String json) {
		try {
			Gson gson = new GsonBuilder().create();
			BitBucket response = gson.fromJson(json, BitBucket.class);
			commit = new Commit(response.getActor().getDisplayName(), response.getRepository().getName(),
					response.getPush().getChanges().get(0).getNew().getTarget().getMessage());
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		commit.notify(chat);
	}

}
