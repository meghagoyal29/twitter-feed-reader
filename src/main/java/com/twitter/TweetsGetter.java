package com.twitter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.ConfigurationBuilder;
/**
* @author - Megha Goyal
* To get tweets regarding a certain query. you can use a short phrase or a word to be looked up. The tweets for the past week, if any, will be returned
**/

public class TweetsGetter {
	private static Twitter twitter;
	public static Set<User> vertices = new HashSet();
	static SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
    
	public static void main(String[] args) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("your Consumer Key");
				.setOAuthConsumerSecret("yourConsumerSecret")
				.setOAuthAccessToken("yourAccessToken")
				.setOAuthAccessTokenSecret("yourAccessTokenSecret");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
		try {
			Query query = new Query("your query goes here");
			//query.setMaxId(976191918374900000L);
			//query.setSinceId(976193209406763008L);
			query.setSince("2018-04-10");
			query.setUntil("2018-04-25");
			query.setCount(100);
			// query.set
			// query.setLang("en");
			QueryResult result;
			result = twitter.search(query);
			List<Status> tweets = result.getTweets();
			int count = 0;
			List<NodeXlTemplate> nodes = new ArrayList<NodeXlTemplate>();
			nodes.addAll(printTweets(tweets).get("edges"));
			vertices.addAll(twitter.lookupUsers((String[]) (printTweets(tweets).get("vertices")).toArray(new String[0])));
			while (result.hasNext() && count<100) {
				query = result.nextQuery();
				result = twitter.search(query);
				tweets = result.getTweets();
				nodes.addAll(printTweets(tweets).get("edges"));
				vertices.addAll(twitter.lookupUsers((String[]) (printTweets(tweets).get("vertices")).toArray(new String[0])));
				count++;
			}
			System.out.println(nodes.size());
			FileMaker.makeFiles(nodes);
			FileMaker.makeVerticesFile(vertices);
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
	}

	private static Map<String, Collection> printTweets(List<Status> tweets) throws TwitterException {
		List<NodeXlTemplate> nodesList = new ArrayList<>();
		Set<String> vertexNames = new HashSet<>();
		Map<String, Collection> returnMap = new HashMap<String, Collection>();
		for (Status tweet : tweets) {
			if (tweet.getInReplyToScreenName() != null) {
				nodesList.add(createNode(tweet, tweet.getInReplyToScreenName()));
				vertexNames.add(tweet.getInReplyToScreenName());
			} else if (tweet.getText().indexOf("RT") == 0) {
				String[] words = tweet.getText().split(" ");
				words[1] = words[1].replaceAll("@", "");
				words[1] = words[1].replaceAll(":", "");
				nodesList.add(createNode(tweet, words[1]));
				vertexNames.add(words[1]);
			} else if (tweet.getUserMentionEntities().length > 1) {
				for (UserMentionEntity user : tweet.getUserMentionEntities()) {
					nodesList.add(createNode(tweet, user.getScreenName()));
					vertexNames.add(user.getScreenName());
				}
			}
			else{
				nodesList.add(createNode(tweet, tweet.getUser().getScreenName()));
				vertexNames.add(tweet.getUser().getScreenName());
				}
		}
		returnMap.put("edges", nodesList);
		returnMap.put("vertices", vertexNames);
		return returnMap;
	}

	private static NodeXlTemplate createNode(Status tweet, String vertexTwoName) {
		NodeXlTemplate template = new NodeXlTemplate();
		template.setVertex1(tweet.getUser().getScreenName());
		template.setVertex2(vertexTwoName);
		template.setHashtagsinTweet(tweet.getHashtagEntities());
		template.setuRLsinTweet(tweet.getURLEntities());
		template.setLanguage(tweet.getLang());
		template.setLatitude((tweet.getGeoLocation() != null) ? tweet.getGeoLocation().getLatitude() : 0D);
		template.setLongitude((tweet.getGeoLocation() != null) ? tweet.getGeoLocation().getLongitude() : 0D);
		template.setRetweeted(tweet.isRetweeted());
		template.setRetweetCount(tweet.getRetweetCount());
		template.setFavorited(tweet.getFavoriteCount() > 0 ? true : false);
		template.setFavoriteCount(tweet.getFavoriteCount());
		template.setRelationship(tweet.getInReplyToScreenName() != null ? "Replies" : getRelationship(tweet));
		template.setTweet(tweet.getText());
		template.setRelationshipDate(dateFormatter.format(tweet.getCreatedAt()));
		template.setImportedID(tweet.getId());
		return template;
	}

	private static String getRelationship(Status tweet) {
		String text = tweet.getText();
		if (text.indexOf("RT") == 0) {
			return "Retweet";
		}
		if (tweet.getUserMentionEntities().length > 0)
			return "Mentions";
		return "Tweets";
	}
}
