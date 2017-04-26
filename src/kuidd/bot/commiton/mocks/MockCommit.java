package kuidd.bot.commiton.mocks;

import java.util.ArrayList;
import java.util.List;

import kuidd.bot.commiton.IChat;
import kuidd.bot.commiton.commit.ICommit;

public class MockCommit implements ICommit {

	public List<IChat> chats = new ArrayList<IChat>();

	@Override
	public void notify(IChat chat) {
		chats.add(chat);
	}

}
