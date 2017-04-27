package kuidd.bot.commiton;

public class TelegramBot implements ITelegramBot {

	private IBot bot = null;

	public TelegramBot(IBot bot) {
		this.bot = bot;
	}

	@Override
	public void process(IChat chat, String command) {
		if (command.equals("/start")) {
			bot.start(chat);
		} else if (command.equals("/help")) {
			bot.help(chat);
		} else if (command.equals("/status")) {
			bot.status(chat);
		} else if (command.startsWith("/subscribe")) {
			String filter = command.substring("/subscribe".length()).trim();

			if (filter.isEmpty()) {
				chat.print(
						"Filter needed.\n/subscribe <filter> - subscribe to all messages contains <filter> in repository name or in comment messages");
			} else {
				bot.subscribe(chat, filter);
			}
		} else if (command.startsWith("/unsubscribe")) {
			String filter = command.substring("/unsubscribe".length()).trim();

			if (filter.isEmpty()) {
				chat.print(
						"Filter needed.\n/unsubscribe <filter> - unsubscribe from all messages contains <filter> in repository name or in comment messages");
			} else {
				bot.unsubscribe(chat, filter);
			}
		} else {
			chat.print("I don't understand");
		}
	}
}
