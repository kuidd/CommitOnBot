package kuidd.bot.commiton.commit.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import kuidd.bot.commiton.commit.GitHub;
import kuidd.bot.commiton.mocks.MockChat;
import kuidd.bot.commiton.utils.File;

public class GitHubTest {

	@Test
	public void notifyTest() throws IOException {
		String json = new File("src/kuidd/bot/commiton/tests/res/github_push_example.json").read();

		MockChat mock = new MockChat();

		GitHub commit = new GitHub(json);
		commit.notify(mock, "test");

		assertEquals("Dmitry Usynin committed on CommitOnBot: Create test", mock.message);
	}
}