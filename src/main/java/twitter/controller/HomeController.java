package twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private final Twitter twitter;

	@Autowired
	public HomeController(Twitter twitter) {
		this.twitter = twitter;
	}

	@RequestMapping(value="/")
	public String test(HttpServletResponse response) throws IOException{
		SearchResults search = twitter.searchOperations().search("#spring");
		System.out.println("hello world");
		System.out.println(search.getTweets().size());
		search.getTweets().forEach(t-> System.out.println(t.getText()));

		// Optional Step - format the Tweets into HTML
		return "home";	}
	@RequestMapping(value = "timeline", method = RequestMethod.GET)
	public String getUserTimeline(@RequestParam("id") String screenName, Model model) {


		List<Tweet> tweets = twitter.timelineOperations().getUserTimeline(screenName);
		System.out.println("hello world");
		System.out.println(tweets.size());
		tweets.forEach(t-> System.out.println(t.getText()));

		return "home";
	}
	private List<Tweet> queryForTweets(String screenName) {

		TimelineOperations timelineOps = twitter.timelineOperations();
		List<Tweet> results = timelineOps.getUserTimeline(screenName);
		return results;
	}


}
