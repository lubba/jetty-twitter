package com.ok.servlets;

import com.ok.Records;
import com.ok.Tweet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TweetServlet extends HttpServlet {

	private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../index.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		List<Tweet> tweets = Records.get();
		req.getSession().setAttribute("tweets",tweets);
		List<Tweet> tweetsAttr = (List<Tweet>) req.getSession().getAttribute("tweets");

		if (tweetsAttr == null)
			System.out.println("No tweets yet");
		else {
			for (Tweet tweet : tweetsAttr){
				System.out.println(tweet);
			}
		}
        forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		String action = req.getParameter("action");
		if ("tweet".equals(action)) {
            String line = req.getParameter("tweetline");
			Records.add(line);

        }
		doGet(req,resp);
		//forward(req, resp);
	}
}
