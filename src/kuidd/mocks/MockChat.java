package kuidd.mocks;

import kuidd.IChat;

public class MockChat implements IChat {

	public String message;

	@Override
	public void print(String message) {
		this.message = message;
	}
}