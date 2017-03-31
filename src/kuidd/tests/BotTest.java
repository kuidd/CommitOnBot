package kuidd.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kuidd.Bot;
import kuidd.mocks.MockChat;
import kuidd.mocks.MockCommit;

public class BotTest {

	@Test
	public void helpTest() {
		MockChat mock = new MockChat();

		Bot bot = new Bot();
		bot.help(mock);

		assertEquals(mock.message, "TODO: help");
	}

	@Test
	public void startTest() {
		MockChat mock = new MockChat();

		Bot bot = new Bot();
		bot.start(mock);

		assertEquals(mock.message, "TODO: start");
	}

	@Test
	public void subscribeTest() {
		MockChat mock = new MockChat();

		Bot bot = new Bot();
		bot.subscribe(mock);

		assertEquals(mock.message, "TODO: subscribe");
	}

	@Test
	public void unsubscribeTest() {
		MockChat mock = new MockChat();

		Bot bot = new Bot();
		bot.unsubscribe(mock);

		assertEquals(mock.message, "TODO: unsubscribe");
	}

	@Test
	public void broadcastTest() {
		MockChat subscribed1 = new MockChat();
		MockChat subscribed2 = new MockChat();
		MockChat unsubscribed1 = new MockChat();
		MockChat unsubscribed2 = new MockChat();

		MockCommit mock = new MockCommit();

		Bot bot = new Bot();

		bot.subscribe(subscribed1);
		bot.unsubscribe(unsubscribed1);
		bot.subscribe(subscribed2);
		bot.unsubscribe(unsubscribed2);

		bot.broadcast(mock);

		assertEquals(mock.chats.size(), 2);
		assertEquals(mock.chats.get(0), subscribed1);
		assertEquals(mock.chats.get(1), subscribed2);
	}
}