package kuidd.bot.commiton;

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
	public boolean equalId(IChat chat) {
		Chat equal = (Chat) chat;

		if (equal == null)
			return false;

		if (chatId.equals(equal.chatId))
			return true;

		return false;
	}
}
