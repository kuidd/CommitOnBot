package kuidd.bot.commiton;

import java.util.ArrayList;
import java.util.List;

import kuidd.bot.commiton.commit.ICommit;
import kuidd.bot.commiton.utils.Pair;

public class Chats implements IChats {
	private List<Pair<IChat, String>> chats = new ArrayList<Pair<IChat, String>>();

	@Override
	public void add(IChat chat, String filter) {
		for (int i = 0; i < chats.size(); i++) {
			if (chat.equalId(chats.get(i).getL()) && filter.equals(chats.get(i).getR())) {
				return;
			}
		}

		chats.add(new Pair<IChat, String>(chat, filter));
	}

	@Override
	public void remove(IChat chat, String filter) {
		for (int i = 0; i < chats.size(); i++) {
			if (chat.equalId(chats.get(i).getL()) && filter.equals(chats.get(i).getR())) {
				chats.remove(i);
				break;
			}
		}
	}

	@Override
	public void print(IChat chat) {
		String list = new String();
		for (int i = 0; i < chats.size(); i++) {
			if (chat.equalId(chats.get(i).getL())) {
				list += "\n" + chats.get(i).getR();
			}
		}

		if (list.isEmpty()) {
			chat.print("No subscriptions");
		} else {
			chat.print("List of current subscriptions:" + list);
		}
	}

	@Override
	public void broadcast(ICommit commit) {
		for (int i = 0; i < chats.size(); i++) {
			commit.notify(chats.get(i).getL(), chats.get(i).getR());
		}
	}
}
