package kuidd.bot.commiton;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import kuidd.bot.commiton.config.ConfigProperties;

public class Telegram extends TelegramLongPollingBot {

	private ITelegramBot telegramBot;

	public Telegram(ITelegramBot telegramBot) {
		this.telegramBot = telegramBot;
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

			String command = message.getText();

			telegramBot.process(chat, command);
		}
	}
}