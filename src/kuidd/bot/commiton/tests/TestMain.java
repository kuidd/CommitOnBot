package kuidd.bot.commiton.tests;

import org.eclipse.jetty.server.Server;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import kuidd.bot.commiton.Bot;
import kuidd.bot.commiton.IBot;
import kuidd.bot.commiton.Servlet;
import kuidd.bot.commiton.Telegram;
import kuidd.bot.commiton.config.ConfigProperties;

public class TestMain {
	public static void main(String[] args) {
		IBot bot = new Bot();

		ApiContextInitializer.init();
		try {
			new TelegramBotsApi().registerBot(new Telegram(bot));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		Server server = new Server(ConfigProperties.getInstance().getServerPort());
		server.setHandler(new kuidd.bot.commiton.tests.Servlet(new Servlet(bot)));
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}