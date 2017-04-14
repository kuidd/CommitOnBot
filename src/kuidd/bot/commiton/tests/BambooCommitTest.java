package kuidd.bot.commiton.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import kuidd.bot.commiton.BambooCommit;
import kuidd.bot.commiton.mocks.MockChat;

public class BambooCommitTest {

	@Test
	public void notifyTest() throws IOException {
		String json = new File("src/kuidd/bot/commiton/tests/res/bamboo_commit_example.json").read();

		MockChat mock = new MockChat();

		BambooCommit commit = new BambooCommit(json);
		commit.notify(mock);

		assertEquals(mock.message, "Dmitry Usynin committed on Repository");
	}
}