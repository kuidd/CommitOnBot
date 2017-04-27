package kuidd.bot.commiton;

public interface ITelegramBot {
	public void process(IChat chat, String command);
}
