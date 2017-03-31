package kuidd.bot.commiton.tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import kuidd.bot.commiton.config.ConfigProperties;

public class ConfigPropertiesTest {
	
	@Test
	public void readPropertiesValueTest() {
		assertEquals("CommitOnBot", ConfigProperties.getInstance().getBotUsername());
		assertEquals("344689671:AAHOv6YKsFlxdhu3tYoDuaGSAoQHZiMegnk", ConfigProperties.getInstance().getBotToken());
		assertEquals(7777, ConfigProperties.getInstance().getServerPort());
	}
}
