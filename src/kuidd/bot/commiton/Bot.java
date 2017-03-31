package kuidd.bot.commiton;

public class Bot implements IBot {

	private IChats chats = new Chats();

	@Override
	public void help(IChat chat) {
		chat.print("Доступные команды:\n/subscribe - подписаться\n/unsubscribe - отписаться");
	}

	@Override
	public void start(IChat chat) {
		if (chats.exists(chat)) {
			chat.print("Подписка уже активирована.\n/unsubscribe - отписаться");
		} else {
			chat.print("Подписка ещё не активирована.\n/subscribe - подписаться");
		}
	}

	@Override
	public void subscribe(IChat chat) {
		chats.add(chat);
		chat.print("Подписка активирована.");
	}

	@Override
	public void unsubscribe(IChat chat) {
		chats.remove(chat);
		chat.print("Подписка отменена.");
	}

	@Override
	public void broadcast(ICommit commit) {
		chats.broadcast(commit);
	}

}
