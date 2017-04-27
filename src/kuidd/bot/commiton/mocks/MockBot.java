package kuidd.bot.commiton.mocks;

import kuidd.bot.commiton.IBot;
import kuidd.bot.commiton.IChat;
import kuidd.bot.commiton.commit.ICommit;

public class MockBot implements IBot {

	public String call = new String();

	@Override
	public void start(IChat chat) {
		call = "start";
	}

	@Override
	public void help(IChat chat) {
		call = "help";
	}

	@Override
	public void status(IChat chat) {
		call = "status";
	}

	@Override
	public void subscribe(IChat chat, String filter) {
		call = "subscribe: " + filter;
	}

	@Override
	public void unsubscribe(IChat chat, String filter) {
		call = "unsubscribe: " + filter;
	}

	@Override
	public void broadcast(ICommit commit) {
		call = "broadcast";
	}
}