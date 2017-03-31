package kuidd.bot.commiton.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

	private final static String DEFAULT_PROPERTIES_FILE_NAME = "config.properties";
	
	private Properties properties;
	private String propertiesFileName = DEFAULT_PROPERTIES_FILE_NAME;
	
	private static ConfigProperties instance;

	public static synchronized ConfigProperties getInstance() {
		if (instance == null) {
			instance = new ConfigProperties();
			instance.load();
		}
		return instance;
	}
	
	private ConfigProperties() {
		this.properties = new Properties();
	}
	
	public void load() {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(getPropertiesFileName())) {
			if (inputStream == null) {
				throw new RuntimeException("property file '" + getPropertiesFileName() + "' not found in the classpath");	
			}
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
	}
	
	public String getPropertiesFileName() {
		return propertiesFileName;
	}

	public void setPropertiesFileName(String propertiesFileName) {
		this.propertiesFileName = propertiesFileName;
	}

	public String getBotUsername() {
		return properties.getProperty("bot.username");
	}
	
	public String getBotToken() {
		return properties.getProperty("bot.token");
	}
	
	public int getServerPort() {
		return Integer.parseInt(properties.getProperty("server.port", "777"));
	}
}
