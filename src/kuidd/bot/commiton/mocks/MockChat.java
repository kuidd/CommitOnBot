package kuidd.bot.commiton.mocks;

import kuidd.bot.commiton.IChat;

public class MockChat implements IChat {

	public String message = new String();

	@Override
	public void print(String message) {
		this.message = message;
	}

	@Override
	public boolean equalId(IChat chat) {
		return this.equals(chat);
	}
}