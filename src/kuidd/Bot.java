package kuidd;

public class Bot implements IBot {

	private Chats chats = new Chats();

	@Override
	public void help(IChat chat) {
		chat.print("Доступные команды:\n/subscribe - подписаться\n/unsubscribe - отписаться");
	}

	@Override
	public void start(IChat chat) {
		if (chats.exists(chat)) {
			chat.print("Подписка уже активирована. Чтобы отписаться введите /unsubscribe.");
		} else {
			chat.print("Подписка ещё не активирована. Чтобы подписаться введите /subscribe.");
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
