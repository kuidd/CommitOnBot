package kuidd.bot.commiton.commit.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import kuidd.bot.commiton.commit.GitHub;
import kuidd.bot.commiton.mocks.MockChat;

public class GitHubTest {

	@Test
	public void notifyTest() throws IOException {
		String json = new File("src/kuidd/bot/commiton/tests/res/github_push_example.json").read();

		MockChat mock = new MockChat();

		GitHub commit = new GitHub(json);
		commit.notify(mock);

		assertEquals(mock.message, "Dmitry Usynin committed on CommitOnBot: Create test");
	}
}