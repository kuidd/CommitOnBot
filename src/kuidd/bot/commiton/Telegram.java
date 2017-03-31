package kuidd.bot.commiton;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import kuidd.bot.commiton.config.ConfigProperties;

public class Telegram extends TelegramLongPollingBot {

	private IBot bot;

	public Telegram(IBot bot) {
		this.bot = bot;
	}

	@Override
	public String getBotUsername() {
		return ConfigProperties.getInstance().getBotUsername();
	}

	@Override
	public String getBotToken() {
		return ConfigProperties.getInstance().getBotToken();
	}

	@Override
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		if (message != null && message.hasText()) {

			Chat chat = new Chat(this, message.getChatId().toString());

			if (message.getText().equals("/help")) {
				bot.help(chat);
			} else if (message.getText().equals("/start")) {
				bot.start(chat);
			} else if (message.getText().equals("/subscribe")) {
				bot.subscribe(chat);
			} else if (message.getText().equals("/unsubscribe")) {
				bot.unsubscribe(chat);
			} else {
				chat.print("Не понимаю");
			}
		}
	}
}