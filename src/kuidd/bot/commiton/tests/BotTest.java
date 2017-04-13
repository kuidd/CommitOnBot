package kuidd.bot.commiton.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kuidd.bot.commiton.Bot;
import kuidd.bot.commiton.mocks.MockChat;
import kuidd.bot.commiton.mocks.MockCommit;

public class BotTest {
	private MockChat mock;
	private Bot bot;

	@Before
	public void prepare() {
		mock = new MockChat();
		bot = new Bot();
	}
	
	@After
	public void close() {
		mock = null;
		bot = null;
	}
	
	@Test
	public void helpTest() {
		bot.help(mock);
		
		assertEquals(mock.message, "Доступные команды:\n/subscribe - подписаться\n/unsubscribe - отписаться");
	}

	@Test
	public void startUnsubscribedTest() {
		bot.start(mock);

		assertEquals(mock.message, "Подписка ещё не активирована.\n/subscribe - подписаться");
	}

	@Test
	public void startSubscribedTest() {
		bot.subscribe(mock);
		bot.start(mock);

		assertEquals(mock.message, "Подписка уже активирована.\n/unsubscribe - отписаться");
	}

	@Test
	public void subscribeTest() {
		bot.subscribe(mock);

		assertEquals(mock.message, "Подписка активирована.");
	}

	@Test
	public void unsubscribeTest() {
		bot.unsubscribe(mock);

		assertEquals(mock.message, "Подписка отменена.");
	}

	@Test
	public void broadcastTest() {
		MockChat subscribed1 = new MockChat();
		MockChat subscribed2 = new MockChat();
		MockChat unsubscribed1 = new MockChat();
		MockChat unsubscribed2 = new MockChat();

		MockCommit mock = new MockCommit();

		bot.subscribe(subscribed1);
		bot.subscribe(subscribed2);
		bot.subscribe(unsubscribed1);
		bot.subscribe(unsubscribed2);

		bot.unsubscribe(unsubscribed1);
		bot.unsubscribe(unsubscribed2);

		bot.broadcast(mock);

		assertEquals(mock.chats.size(), 2);
		assertEquals(mock.chats.get(0), subscribed1);
		assertEquals(mock.chats.get(1), subscribed2);
	}
}