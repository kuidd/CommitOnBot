package kuidd.bot.commiton;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import kuidd.bot.commiton.commit.BitBucket;
import kuidd.bot.commiton.commit.Custom;
import kuidd.bot.commiton.commit.GitHub;
import kuidd.bot.commiton.commit.ICommit;

public class Servlet extends AbstractHandler {

	private IBot bot;

	public Servlet(IBot bot) {
		this.bot = bot;
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);

		if (!target.equals("/message"))
			return;

		StringBuffer sb = new StringBuffer();
		BufferedReader bufferedReader = request.getReader();
		char[] charBuffer = new char[128];
		int bytesRead;
		while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
			sb.append(charBuffer, 0, bytesRead);
		}

		String json = sb.toString();
		String headerUserAgent = request.getHeader("User-Agent");

		ICommit commit = null;

		if (headerUserAgent.contains("GitHub")) {
			commit = new GitHub(json);
		} else if (headerUserAgent.contains("Bitbucket")) {
			commit = new BitBucket(json);
		} else {
			commit = new Custom(json);
		}

		bot.broadcast(commit);
	}

}