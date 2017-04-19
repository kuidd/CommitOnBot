package kuidd.bot.commiton;

import org.eclipse.jetty.server.Server;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

	public static void main(String[] args) {
		IBot bot = new Bot();

		ApiContextInitializer.init();
		try {
			new TelegramBotsApi().registerBot(new Telegram(bot));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		int iport = 7777;
		String sport = System.getenv("PORT");
		if (sport != null && !sport.isEmpty()) {
			iport = Integer.parseInt(sport);
		}

		Server server = new Server(iport);
		server.setHandler(new Servlet(bot));
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
