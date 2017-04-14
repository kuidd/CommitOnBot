package kuidd.bot.commiton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kuidd.bot.commiton.json.github.GitHubResponse;

public class GitHubCommit implements ICommit {
	private Commit commit;

	public GitHubCommit(String json) {
		try {
			Gson gson = new GsonBuilder().create();
			GitHubResponse response = gson.fromJson(json, GitHubResponse.class);
			commit = new Commit(response.getHeadCommit().getAuthor().getName(), response.getRepository().getName());
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		commit.notify(chat);
	}
}