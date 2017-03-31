package kuidd;

public class Main {
	public static void main(String[] args) {
		IBot bot = new Bot();

		Telegram telegram = new Telegram(bot);
		telegram.init();

		Servlet servlet = new Servlet(bot);
		servlet.init();
	}
}
