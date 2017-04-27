package kuidd.bot.commiton;

import kuidd.bot.commiton.commit.ICommit;

public class Bot implements IBot {

	private IChats chats = new Chats();

	@Override
	public void start(IChat chat) {
		chat.print("Hello, I'm ready!\nCan I /help you?");
	}

	@Override
	public void help(IChat chat) {
		chat.print(
				"List of supported commands:\n/status - list of current subscriptions\n/subscribe <filter> - subscribe to all messages contains <filter> in repository name or in comment messages\n/unsubscribe <filter> - unsubscribe from all messages contains <filter> in repository name or in comment messages");
	}

	@Override
	public void status(IChat chat) {
		chats.print(chat);
	}

	@Override
	public void subscribe(IChat chat, String filter) {
		chats.add(chat, filter);
		chat.print("Subscription to <" + filter + "> activated");
	}

	@Override
	public void unsubscribe(IChat chat, String filter) {
		chats.remove(chat, filter);
		chat.print("Subscription to <" + filter + "> deactivated");
	}

	@Override
	public void broadcast(ICommit commit) {
		chats.broadcast(commit);
	}
}
