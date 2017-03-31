package kuidd;

import org.telegram.telegrambots.ApiContextInitializer;

public class Main {
	public static void main(String[] args) {
		IBot bot = new Bot();

		ApiContextInitializer.init();
		Telegram telegram = new Telegram(bot);
		telegram.init();

		Servlet servlet = new Servlet(bot);
		servlet.init();
	}
}
