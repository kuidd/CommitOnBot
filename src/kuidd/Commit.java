package kuidd;

import org.json.JSONException;
import org.json.JSONObject;

public class Commit implements ICommit {
	private JSONObject json;

	public Commit(String json) {
		try {
			this.json = new JSONObject(json);
		} catch (JSONException e) {
		}
	}

	@Override
	public void notify(IChat chat) {
		try {
			chat.print(json.getJSONObject("head_commit").getJSONObject("author").get("name") + " committed on "
					+ json.getJSONObject("repository").get("name"));
		} catch (JSONException e) {
		}
	}
}