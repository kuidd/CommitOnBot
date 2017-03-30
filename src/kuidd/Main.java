package kuidd;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		CommitOnBot bot = new CommitOnBot();
		try {
			telegramBotsApi.registerBot(bot);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		Chat chat = new Chat(bot, "-218462190");
		chat.print("Тестирование");
	}
}
