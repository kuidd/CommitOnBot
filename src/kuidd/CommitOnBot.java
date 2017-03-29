package kuidd;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class CommitOnBot extends TelegramLongPollingBot {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new CommitOnBot());
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
			if (message.getText().equals("/help"))
				sendMsgToChat(message.getChatId().toString(), "Привет, я CommitOnBot и пока ничего не понимаю");
			else
				sendMsgToChat(message.getChatId().toString(), "Не понимаю");
		}
	}
 
	private void sendMsgToChat(String charId, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(charId);
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
