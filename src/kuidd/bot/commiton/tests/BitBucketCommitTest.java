package kuidd.bot.commiton.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import kuidd.bot.commiton.BitBucketCommit;
import kuidd.bot.commiton.mocks.MockChat;

public class BitBucketCommitTest {

	@Test
	public void notifyTest() throws IOException {
		String json = new File("src/kuidd/bot/commiton/tests/res/bitbucket_push_example.json").read();

		MockChat mock = new MockChat();

		BitBucketCommit commit = new BitBucketCommit(json);
		commit.notify(mock);

		assertEquals(mock.message, "Dmitry Usynin committed on Predictor: test created online with Bitbucket");
	}
}