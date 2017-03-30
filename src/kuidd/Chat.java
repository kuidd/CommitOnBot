package kuidd;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Chat implements IChat {

	private AbsSender bot;
	private String chatId;

	public Chat(AbsSender bot, String chatId) {
		this.bot = bot;
		this.chatId = chatId;
	}

	@Override
	public void print(String message) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(message);
		try {
			bot.sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
