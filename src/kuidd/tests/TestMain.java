package kuidd.tests;

import org.eclipse.jetty.server.Server;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import kuidd.Bot;
import kuidd.IBot;
import kuidd.Servlet;
import kuidd.Telegram;

public class TestMain {
	public static void main(String[] args) {
		IBot bot = new Bot();

		Server server = new Server(7777); // TODO: set port from setting
		server.setHandler(new kuidd.tests.Servlet(new Servlet(bot)));

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ApiContextInitializer.init();
		try {
			new TelegramBotsApi().registerBot(new Telegram(bot));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
