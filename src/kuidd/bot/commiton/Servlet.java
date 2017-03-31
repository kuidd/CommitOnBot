package kuidd.bot.commiton;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class Servlet extends AbstractHandler {

	private IBot bot;

	public Servlet(IBot bot) {
		this.bot = bot;
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if (!target.equals("/message"))
			return;

		StringBuffer sb = new StringBuffer();
		BufferedReader bufferedReader = request.getReader();
		char[] charBuffer = new char[128];
		int bytesRead;
		while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
			sb.append(charBuffer, 0, bytesRead);
		}

		Commit commit = new Commit(sb.toString());
		bot.broadcast(commit);
	}

}