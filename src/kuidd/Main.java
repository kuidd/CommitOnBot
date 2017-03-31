package kuidd;

import org.eclipse.jetty.server.Server;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

		IBot bot = new Bot();

		Telegram telegram = new Telegram(bot);
		try {
			telegramBotsApi.registerBot(telegram);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		Server server = new Server(7777);
		server.setHandler(new Servlet(bot));

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
