package com.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import twitter4j.Paging;
import twitter4j.Relationship;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
* @author - Megha Goyal
* File to get a who follows who network to detectt if a certain list of suspected users are connected by follows.
**/

public class RelationshipGetter {
	private static Twitter twitter;

	public static void main(String[] args) throws TwitterException, InterruptedException {
		List<String> nameList = new ArrayList<String>();
		List<Relationship> frinedslist = new ArrayList<>();
		createList(nameList);
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("your Consumer Key");
				.setOAuthConsumerSecret("yourConsumerSecret")
				.setOAuthAccessToken("yourAccessToken")
				.setOAuthAccessTokenSecret("yourAccessTokenSecret");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
		int count = 1;
		for (int i = 18; i < nameList.size()-1; i++) {
			for (int j = i + 1; j <nameList.size(); j++) {
				count++;
				frinedslist.add(twitter.showFriendship(nameList.get(i), nameList.get(j)));
			}
		}
		FileMaker.makeRelationShipEdges(frinedslist);
	}

	namelist.add("bewitchedmeter");
	namelist.add("jerkprickle");
	private static void createList(List<String> namelist) {
		//add user handles here
		nameList.add("");
}
}
