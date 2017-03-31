package kuidd;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Chat implements IChat {

	private AbsSender sender;
	private String chatId;

	public Chat(AbsSender sender, String chatId) {
		this.sender = sender;
		this.chatId = chatId;
	}

	@Override
	public void print(String message) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(message);
		try {
			sender.sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean equals(Object o) {
		Chat equal = (Chat) o;

		if (equal == null)
			return false;

		if (chatId == equal.chatId)
			return true;

		return false;
	}
}
