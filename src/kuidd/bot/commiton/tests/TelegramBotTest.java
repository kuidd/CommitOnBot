package kuidd.bot.commiton.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kuidd.bot.commiton.ITelegramBot;
import kuidd.bot.commiton.TelegramBot;
import kuidd.bot.commiton.mocks.MockBot;
import kuidd.bot.commiton.mocks.MockChat;

public class TelegramBotTest {

	private MockBot mockBot;
	private MockChat mockChat;

	@Before
	public void prepare() {
		mockBot = new MockBot();
		mockChat = new MockChat();
	}

	@After
	public void close() {
		mockBot = null;
		mockChat = null;
	}

	@Test
	public void processTest_Empty() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "");

		assertEquals("I don't understand", mockChat.message);
		assertEquals("", mockBot.call);
	}

	@Test
	public void processTest_Something() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "Something");

		assertEquals("I don't understand", mockChat.message);
		assertEquals("", mockBot.call);
	}

	@Test
	public void processTest_Start() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "/start");

		assertEquals("", mockChat.message);
		assertEquals("start", mockBot.call);
	}

	@Test
	public void processTest_Help() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "/help");

		assertEquals("", mockChat.message);
		assertEquals("help", mockBot.call);
	}

	@Test
	public void processTest_Status() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "/status");

		assertEquals("", mockChat.message);
		assertEquals("status", mockBot.call);
	}

	@Test
	public void processTest_Subscribe() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "/subscribe filter");

		assertEquals("", mockChat.message);
		assertEquals("subscribe: filter", mockBot.call);
	}

	@Test
	public void processTest_Subscribe_EmptyFilter() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "/subscribe");

		assertEquals(
				"Filter needed.\n/subscribe <filter> - subscribe to all messages contains <filter> in repository name or in comment messages",
				mockChat.message);
		assertEquals("", mockBot.call);
	}

	@Test
	public void processTest_Unsubscribe() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "/unsubscribe filter");

		assertEquals("", mockChat.message);
		assertEquals("unsubscribe: filter", mockBot.call);
	}

	@Test
	public void processTest_Unsubscribe_EmptyFilter() {
		ITelegramBot telegramBot = new TelegramBot(mockBot);

		telegramBot.process(mockChat, "/unsubscribe");

		assertEquals(
				"Filter needed.\n/unsubscribe <filter> - unsubscribe from all messages contains <filter> in repository name or in comment messages",
				mockChat.message);
		assertEquals("", mockBot.call);
	}
}