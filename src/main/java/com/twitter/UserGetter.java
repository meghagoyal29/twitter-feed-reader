package com.twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import twitter4j.Paging;
import twitter4j.Relationship;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;
/**
* @author - Megha Goyal
* File to get a user's information, if publically available on twitter
**/

public class UserGetter {
	private static Twitter twitter;

	public static void main(String[] args) throws TwitterException, InterruptedException {
		List<String> nameList = new ArrayList<String>();
		Set<User> frinedslist = new HashSet<>();
		List<String> partitionList  =new ArrayList<String>();
		createList(nameList);
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("your Consumer Key");
				.setOAuthConsumerSecret("yourConsumerSecret")
				.setOAuthAccessToken("yourAccessToken")
				.setOAuthAccessTokenSecret("yourAccessTokenSecret");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
		int count = 0;
		
		for (;count<nameList.size();count++) {
			for(int i=0; i<100 && count<nameList.size(); i++) {
			partitionList.add(nameList.get(count));
			count++;
			}	
			frinedslist.addAll(twitter.lookupUsers((String[])partitionList.toArray(new String[0])));
			partitionList  =new ArrayList<String>();
		}
				
		FileMaker.makeVerticesFile(frinedslist);
		System.out.println("done");
	}

	private static void createList(List<String> userlist) {
		//add user handles here
}
}
