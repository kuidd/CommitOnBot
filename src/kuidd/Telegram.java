package kuidd;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Telegram extends TelegramLongPollingBot {

	private IBot bot;

	public Telegram(IBot bot) {
		this.bot = bot;
	}

	public void init() {
		ApiContextInitializer.init();
		try {
			new TelegramBotsApi().registerBot(this);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return "CommitOnBot";
	}

	@Override
	public String getBotToken() {
		return "344689671:AAHOv6YKsFlxdhu3tYoDuaGSAoQHZiMegnk";
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