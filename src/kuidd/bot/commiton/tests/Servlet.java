package kuidd.bot.commiton.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import kuidd.bot.commiton.commit.tests.File;

public class Servlet extends AbstractHandler {

	kuidd.bot.commiton.Servlet servlet;

	public Servlet(kuidd.bot.commiton.Servlet servlet) {
		this.servlet = servlet;
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		servlet.handle(target, baseRequest, request, response);

		if (!target.equals("/test"))
			return;

		response.getWriter().println(new File("src/kuidd/bot/commiton/tests/res/http_server_test.html").read());
		response.setContentType("text/html; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
	}

}