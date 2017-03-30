package kuidd.tests;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {
	private String filepath;

	public File(String filepath) {
		this.filepath = filepath;
	}

	public String read() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(filepath));
		return new String(encoded, Charset.defaultCharset());
	}
}