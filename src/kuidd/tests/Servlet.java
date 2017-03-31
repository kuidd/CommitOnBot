package kuidd.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class Servlet extends AbstractHandler {

	kuidd.Servlet servlet;

	public Servlet(kuidd.Servlet servlet) {
		this.servlet = servlet;
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		servlet.handle(target, baseRequest, request, response);

		if (!target.equals("/test"))
			return;

		response.getWriter().println(new File("src/kuidd/tests/res/http_server_test.html").read());
		response.setContentType("text/html; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
	}

}