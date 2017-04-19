package kuidd.bot.commiton;

import java.util.ArrayList;
import java.util.List;

public class Chats implements IChats {
	private List<IChat> chats = new ArrayList<IChat>();

	@Override
	public void add(IChat chat) {
		if (exists(chat)) {
			return;
		}

		chats.add(chat);
	}

	@Override
	public void remove(IChat chat) {
		for (int i = 0; i < chats.size(); i++) {
			if (chat.equalId(chats.get(i))) {
				chats.remove(i);
				break;
			}
		}
	}

	@Override
	public boolean exists(IChat chat) {
		for (int i = 0; i < chats.size(); i++) {
			if (chat.equalId(chats.get(i))) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void broadcast(ICommit commit) {
		for (int i = 0; i < chats.size(); i++) {
			commit.notify(chats.get(i));
		}
	}
}
