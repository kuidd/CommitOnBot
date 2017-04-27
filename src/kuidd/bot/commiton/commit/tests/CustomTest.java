package kuidd.bot.commiton.commit.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import kuidd.bot.commiton.commit.Custom;
import kuidd.bot.commiton.mocks.MockChat;
import kuidd.bot.commiton.utils.File;

public class CustomTest {

	@Test
	public void notifyTest() throws IOException {
		String json = new File("src/kuidd/bot/commiton/tests/res/custom_commit_example.json").read();

		MockChat mock = new MockChat();

		Custom commit = new Custom(json);
		commit.notify(mock, "Comment");

		assertEquals("Dmitry Usynin committed on Repository: Comment", mock.message);
	}
}