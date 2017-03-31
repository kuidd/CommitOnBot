package kuidd.mocks;

import java.util.ArrayList;
import java.util.List;

import kuidd.IChat;
import kuidd.ICommit;

public class MockCommit implements ICommit {

	public List<IChat> chats = new ArrayList<IChat>();

	@Override
	public void notify(IChat chat) {
		chats.add(chat);
	}

}
