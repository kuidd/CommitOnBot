package kuidd.bot.commiton.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import kuidd.bot.commiton.Commit;
import kuidd.bot.commiton.mocks.MockChat;

public class CommitTest {

	@Test
	public void notifyTest() throws IOException {
		String json = new File("src/kuidd/bot/commiton/tests/res/github_push_example.json").read();

		MockChat mock = new MockChat();

		Commit commit = new Commit(json);
		commit.notify(mock);

		assertEquals(mock.message, "Dmitry Usynin committed on CommitOnBot");
	}
}