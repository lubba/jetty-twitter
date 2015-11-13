package com.ok.servlets;

import com.ok.Records;
import com.ok.Tweet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TweetServlet extends HttpServlet {

	private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Tweet> tweets = Records.get();
            if (tweets == null)
                System.out.println("Null");
            System.out.println("doPost");
            req.getSession().setAttribute("tweets",tweets);
        forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
        if ("search".equals(action)) {
            String line = req.getParameter("tweetline");
             Records.add(line);
            System.out.println("doPost");
        }

		forward(req, resp);
	}
}
