package com.ok.servlets;

import com.ok.Tweet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TweetServlet extends HttpServlet {

	private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
        if ("search".equals(action)) {
            String line = (String) req.getParameter("tweetline");
            LinkedList<Tweet> docs = Records.add(line);
            if (docs == null)
                System.out.println("Null");
            System.out.println("doPost in Search");
            req.getSession().setAttribute("docs",docs);
            resp.sendRedirect("/serverapp/res");
        }

		forward(req, resp);
	}
}
