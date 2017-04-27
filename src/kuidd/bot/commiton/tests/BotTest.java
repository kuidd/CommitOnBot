package kuidd.bot.commiton.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kuidd.bot.commiton.Bot;
import kuidd.bot.commiton.commit.Commit;
import kuidd.bot.commiton.mocks.MockChat;

public class BotTest {
	private MockChat mockChat1;
	private MockChat mockChat2;
	private Bot bot;

	@Before
	public void prepare() {
		mockChat1 = new MockChat();
		mockChat2 = new MockChat();
		bot = new Bot();
	}

	@After
	public void close() {
		mockChat1 = null;
		mockChat2 = null;
		bot = null;
	}

	@Test
	public void startTest() {
		bot.start(mockChat1);

		assertEquals("Hello, I'm ready!\nCan I /help you?", mockChat1.message);
	}

	@Test
	public void helpTest() {
		bot.help(mockChat1);

		assertEquals(
				"List of supported commands:\n/status - list of current subscriptions\n/subscribe <filter> - subscribe to all messages contains <filter> in repository name or in comment messages\n/unsubscribe <filter> - unsubscribe from all messages contains <filter> in repository name or in comment messages",
				mockChat1.message);
	}

	@Test
	public void subscribeTest() {
		bot.subscribe(mockChat1, "filter");

		assertEquals("Subscription to <filter> activated", mockChat1.message);
	}

	@Test
	public void unsubscribeTest() {
		bot.unsubscribe(mockChat1, "filter");

		assertEquals("Subscription to <filter> deactivated", mockChat1.message);
	}

	@Test
	public void statusTest_Unsubscribed() {
		bot.status(mockChat1);

		assertEquals("No subscriptions", mockChat1.message);
	}

	@Test
	public void statusTest_SubscribedOne() {
		bot.subscribe(mockChat1, "filter");
		bot.status(mockChat1);

		assertEquals("List of current subscriptions:\nfilter", mockChat1.message);
	}

	@Test
	public void statusTest_SubscribedTwo() {
		bot.subscribe(mockChat1, "filterOne");
		bot.subscribe(mockChat1, "filterTow");

		bot.status(mockChat1);

		assertEquals("List of current subscriptions:\nfilterOne\nfilterTow", mockChat1.message);
	}

	@Test
	public void statusTest_SubscribedTwoUnsubscribedOne() {
		bot.subscribe(mockChat1, "filterOne");
		bot.subscribe(mockChat1, "filterTow");

		bot.unsubscribe(mockChat1, "filterOne");

		bot.status(mockChat1);

		assertEquals("List of current subscriptions:\nfilterTow", mockChat1.message);
	}

	@Test
	public void broadcastTest() {
		Commit commit = new Commit("author", "repository", "filter");

		bot.subscribe(mockChat1, "filter");

		mockChat1.message = "";

		bot.broadcast(commit);

		assertEquals("author committed on repository: filter", mockChat1.message);
	}

	@Test
	public void broadcastTest_Double() {
		Commit commit = new Commit("author", "repository", "filter");

		bot.subscribe(mockChat1, "filter");
		bot.subscribe(mockChat1, "filter");

		mockChat1.message = "";

		bot.broadcast(commit);

		assertEquals("author committed on repository: filter", mockChat1.message);
	}

	@Test
	public void broadcastTest_Unsubscribe() {

		Commit commit = new Commit("author", "repository", "filter");

		bot.subscribe(mockChat1, "filter");
		bot.subscribe(mockChat2, "filter");

		bot.unsubscribe(mockChat2, "filter");

		mockChat1.message = "";
		mockChat2.message = "";

		bot.broadcast(commit);

		assertEquals("author committed on repository: filter", mockChat1.message);
		assertEquals("", mockChat2.message);
	}

	@Test
	public void broadcastTest_FilterByCommentCaseInsensitive() {
		Commit commit = new Commit("author", "repository", "FilterONE");

		bot.subscribe(mockChat1, "filterOne");
		bot.subscribe(mockChat2, "filterTwo");

		mockChat1.message = "";
		mockChat2.message = "";

		bot.broadcast(commit);

		assertEquals("author committed on repository: FilterONE", mockChat1.message);
		assertEquals("", mockChat2.message);
	}

	@Test
	public void broadcastTest_FilterByRepositoryCaseInsensitive() {
		Commit commit = new Commit("author", "RepositoryONE", "filter");

		bot.subscribe(mockChat1, "repositoryOne");
		bot.subscribe(mockChat2, "repositoryTwo");

		mockChat1.message = "";
		mockChat2.message = "";

		bot.broadcast(commit);

		assertEquals("author committed on RepositoryONE: filter", mockChat1.message);
		assertEquals("", mockChat2.message);
	}
}