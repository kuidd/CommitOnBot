package kuidd;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class CommitOnBot extends TelegramLongPollingBot {
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
				chat.print("Привет, я CommitOnBot и пока ничего не понимаю");
			} else {
				chat.print("Не понимаю");
			}
		}
	}
}
