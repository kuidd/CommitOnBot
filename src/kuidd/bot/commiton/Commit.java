package kuidd.bot.commiton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kuidd.bot.commiton.json.github.GitHubResponse;

public class Commit implements ICommit {
	private GitHubResponse response;

	public Commit(String json) {
		try {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			response = gson.fromJson(json, GitHubResponse.class);
		} catch (Exception e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		try { chat.print(response.getHeadCommit().getAuthor().getName() + " committed on "
					+ response.getRepository().getName());
		} catch (Exception e) {
		}
	}
}