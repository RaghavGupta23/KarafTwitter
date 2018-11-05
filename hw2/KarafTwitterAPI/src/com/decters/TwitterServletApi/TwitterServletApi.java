//*@Author Nikita, Raghav, Sam, Tahsin, Aaron:
package com.decters.TwitterServletApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decters.TwitterMethods.TwitterGet;
import com.decters.TwitterMethods.TwitterPost;


@WebServlet("/TwitterServletApi")
public class TwitterServletApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TwitterGet tg = new TwitterGet();
	TwitterPost tp = new TwitterPost();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       try {
			
			String twitteroptions = request.getParameter("twitteroptions");
			System.out.println("twitteroptions ::::::"+twitteroptions);
			String searchStr = request.getParameter("value");
			System.out.println("searchStr:;;;;;;;;;;;;"+searchStr);
			List<String> twitterResponseList = new ArrayList<String>();
			
			switch (twitteroptions) {
			case "Create Friendship":
				twitterResponseList = tp.createFriendship(searchStr);
				break;
			case "Destroy Friendship":
				twitterResponseList = tp.destroyfriendship(searchStr);
				break;
			case "List Friends ids":
				twitterResponseList = tg.listfriendsids(searchStr);
				break;
			case "list Followers ids":
				twitterResponseList = tg.listFollowersIDs();
				break;			
			case "Followers List":
				twitterResponseList = tg.followersList();
				break;
			case "Friends List":
				twitterResponseList = tg.friendsList();
				break;
			case "Blocks IDs":
				twitterResponseList = tg.listBlockIDs();
				break;
			case "Blocks List":
				twitterResponseList = tg.blockList();
				break;
				
			default:
				break;
		}
			
			request.getSession().setAttribute("twitterResponse", twitterResponseList);
			request.getSession().setAttribute("option", twitteroptions);
		} catch (Exception e) {
			e.printStackTrace();
		}
     
		RequestDispatcher rqtDispatcher = request.getRequestDispatcher("/index.jsp");
		rqtDispatcher.forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rqtDispatcher = request.getRequestDispatcher("/index.jsp");
		rqtDispatcher.forward(request, response);
	}

}


