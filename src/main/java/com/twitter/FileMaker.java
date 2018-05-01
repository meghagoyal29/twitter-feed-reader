package com.twitter;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jxls.template.SimpleExporter;

import twitter4j.Relationship;
import twitter4j.User;
/**
* @author - Megha Goyal
* To creates excel files for data imported from Twitter using JXLS
**/


public class FileMaker {
	public static void makeFiles(List<NodeXlTemplate> tweets) {
		try(OutputStream os1 = new FileOutputStream("Yourabsolutefilepath"+
	System.currentTimeMillis()+"edges.xls")) {
			 List<String>headers = Arrays.asList(
					"Vertex 1", 
					"Vertex 2", 
					"Relationship",
             		"Relationship Date (UTC)",
             		"Tweet", 
             		"URLs in Tweet",
             		"Hashtags in Tweet",
             		"Latitude",
             		"Longitude",
             		"Favorited",
             		"Favorite Count",
             		"Language",
             		"Retweeted",
             		"Retweet Count",
             		"ID"
             		);
			 SimpleExporter exporter = new SimpleExporter();
            exporter.gridExport(headers, tweets,"vertex1, vertex2,relationship,relationshipDate,tweet,uRLsinTweet, hashtagsinTweet, latitude, longitude, favorited,"
            		+ "favoriteCount,language,retweeted,retweetCount,importedID", os1);

        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void makeVerticesFile(Set<User> vertices) {
		try(OutputStream os1 = new FileOutputStream("Yourabsolutefilepath"+
	System.currentTimeMillis()+"vertices.xls")) {
			 List<String>headers = Arrays.asList(
					"Vertex", 
					"Name", 
					"Followed",
             		"Followers",
             		"Tweets", 
             		"Favorites",
             		"Time Zone UTC Offset (Seconds)",
             		"Description",
             		"Location",
             		"Web",
             		"Time Zone",
             		"Joined Twitter Date (UTC)",
             		"Language",
             		"Listed Count",
             		"Verified"
             		);
			 SimpleExporter exporter = new SimpleExporter();
			 exporter.gridExport(headers, vertices,"screenName, name,friendsCount,followersCount,statusesCount,favouritesCount, utcOffset,"
            		+ " description,"
            		+ " location,"
            		+ " URL,"
            		+ "timeZone,"
            		+ "createdAt,"
            		+ "lang,"
            		+ "listedCount,"
            		+ "verified", os1);
        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void makeRelationShipEdges(List<Relationship> friendships) {
		try(OutputStream os1 = new FileOutputStream("Yourabsolutefilepath"+
	System.currentTimeMillis()+"edges.xls")) {
			 List<String>headers = Arrays.asList(
					"SourceUserScreenName", 
					"TargetUserScreenName", 
					"SourceFollowingTarget",
             		"isTargetFollowingSource",
             		"isSourceFollowedByTarget", 
             		"isTargetFollowedBySource",
             		"canSourceDm",
             		"isSourceNotificationsEnabled",
             		"isSourceWantRetweets"
             		);
			 SimpleExporter exporter = new SimpleExporter();
			 exporter.gridExport(headers, friendships,"sourceUserScreenName," 
						+"targetUserScreenName,"
						+"sourceFollowingTarget,"
	             		+"targetFollowingSource,"
	             		+"sourceFollowedByTarget," 
	             		+"targetFollowedBySource"
	             		//+"canSourceDm,"
	             		//+"sourceNotificationsEnabled,"+"sourceWantRetweets"
	             		, os1);
        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void makeFilesBots(List<NodeXlTemplate> tweets, String name) {
		try(OutputStream os1 = new FileOutputStream("Yourabsolutefilepath"+name+
	System.currentTimeMillis()+"edges.xls")) {
			 List<String>headers = Arrays.asList(
					"Vertex 1", 
					"Vertex 2", 
					"Relationship",
             		"Relationship Date (UTC)",
             		"Tweet", 
             		"URLs in Tweet",
             		"Hashtags in Tweet",
             		"Latitude",
             		"Longitude",
             		"Favorited",
             		"Favorite Count",
             		"Language",
             		"Retweeted",
             		"Retweet Count",
             		"ID"
             		);
			 SimpleExporter exporter = new SimpleExporter();
            exporter.gridExport(headers, tweets,"vertex1, vertex2,relationship,relationshipDate,tweet,uRLsinTweet, hashtagsinTweet, latitude, longitude, favorited,"
            		+ "favoriteCount,language,retweeted,retweetCount,importedID", os1);

        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	
}
