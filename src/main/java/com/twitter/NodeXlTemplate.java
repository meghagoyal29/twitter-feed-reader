package com.twitter;
import java.util.*;

import twitter4j.HashtagEntity;
import twitter4j.URLEntity;
public class NodeXlTemplate {
	private String vertex1;
	private String vertex2;
	private String relationship;
	private String relationshipDate;
	private String tweet;
	private String uRLsinTweet;
	private String domainsInTweet;
	private String hashtagsinTweet;
	private String mediainTweet;
	private Date tweetDate;
	private String twitterPageforTweet;
	private double latitude;
	private double longitude;
	private long importedID;
	private long inReplyToTweetID;
	private boolean favorited;
	private long favoriteCount;
	private long inReplyToUserID;
	private boolean isQuoteStatus;
	private String language;
	private long possiblySensitiveQuotedStatusID;
	private boolean retweeted;
	private long retweetCount;
	private long retweetID;
	private String source;
	private boolean truncated;
	private long unifiedTwitterID;
	/**
	 * @return the vertex1
	 */
	public String getVertex1() {
		return vertex1;
	}
	/**
	 * @param vertex1 the vertex1 to set
	 */
	public void setVertex1(String vertex1) {
		this.vertex1 = vertex1;
	}
	/**
	 * @return the vertex2
	 */
	public String getVertex2() {
		return vertex2;
	}
	/**
	 * @param vertex2 the vertex2 to set
	 */
	public void setVertex2(String vertex2) {
		this.vertex2 = vertex2;
	}
	/**
	 * @return the relationship
	 */
	public String getRelationship() {
		return relationship;
	}
	/**
	 * @param relationship the relationship to set
	 */
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	/**
	 * @return the relationshipDate
	 */
	public String getRelationshipDate() {
		return relationshipDate;
	}
	/**
	 * @param string the relationshipDate to set
	 */
	public void setRelationshipDate(String string) {
		this.relationshipDate = string;
	}
	/**
	 * @return the tweet
	 */
	public String getTweet() {
		return tweet;
	}
	/**
	 * @param tweet the tweet to set
	 */
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	/**
	 * @return the uRLsinTweet
	 */
	public String getuRLsinTweet() {
		return uRLsinTweet;
	}
	/**
	 * @param uRLsinTweet the uRLsinTweet to set
	 */
	public void setuRLsinTweet(URLEntity[] uRLsinTweet) {
		StringBuilder urls = new StringBuilder();
		for(URLEntity eachurl: uRLsinTweet)
		{
			urls = urls.append(eachurl.getURL());
			urls.append(",");
		}
		this.uRLsinTweet = urls.toString();
	}
	/**
	 * @return the domainsInTweet
	 */
	public String getDomainsInTweet() {
		return domainsInTweet;
	}
	/**
	 * @param domainsInTweet the domainsInTweet to set
	 */
	public void setDomainsInTweet(String domainsInTweet) {
		
		this.domainsInTweet = domainsInTweet;
	}
	/**
	 * @return the hashtagsinTweet
	 */
	public String getHashtagsinTweet() {
		return hashtagsinTweet;
	}
	/**
	 * @param hashtagsinTweet the hashtagsinTweet to set
	 */
	public void setHashtagsinTweet(HashtagEntity[] hashtagsinTweet) {
		StringBuilder hashtags = new StringBuilder();
		for(HashtagEntity eachhashtag: hashtagsinTweet)
		{
			hashtags = hashtags.append(eachhashtag.getText());
			hashtags.append(",");
		}
		this.hashtagsinTweet = hashtags.toString();
	}
	/**
	 * @return the mediainTweet
	 */
	public String getMediainTweet() {
		return mediainTweet;
	}
	/**
	 * @param mediainTweet the mediainTweet to set
	 */
	public void setMediainTweet(String mediainTweet) {
		this.mediainTweet = mediainTweet;
	}
	/**
	 * @return the tweetDate
	 */
	public Date getTweetDate() {
		return tweetDate;
	}
	/**
	 * @param tweetDate the tweetDate to set
	 */
	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}
	/**
	 * @return the twitterPageforTweet
	 */
	public String getTwitterPageforTweet() {
		return twitterPageforTweet;
	}
	/**
	 * @param twitterPageforTweet the twitterPageforTweet to set
	 */
	public void setTwitterPageforTweet(String twitterPageforTweet) {
		this.twitterPageforTweet = twitterPageforTweet;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param d the latitude to set
	 */
	public void setLatitude(double d) {
		this.latitude = d;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param d the longitude to set
	 */
	public void setLongitude(double d) {
		this.longitude = d;
	}
	/**
	 * @return the importedID
	 */
	public long getImportedID() {
		return importedID;
	}
	/**
	 * @param importedID the importedID to set
	 */
	public void setImportedID(long importedID) {
		this.importedID = importedID;
	}
	/**
	 * @return the inReplyToTweetID
	 */
	public long getInReplyToTweetID() {
		return inReplyToTweetID;
	}
	/**
	 * @param inReplyToTweetID the inReplyToTweetID to set
	 */
	public void setInReplyToTweetID(long inReplyToTweetID) {
		this.inReplyToTweetID = inReplyToTweetID;
	}
	/**
	 * @return the favorited
	 */
	public boolean isFavorited() {
		return favorited;
	}
	/**
	 * @param favorited the favorited to set
	 */
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	/**
	 * @return the favoriteCount
	 */
	public long getFavoriteCount() {
		return favoriteCount;
	}
	/**
	 * @param favoriteCount the favoriteCount to set
	 */
	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	/**
	 * @return the inReplyToUserID
	 */
	public long getInReplyToUserID() {
		return inReplyToUserID;
	}
	/**
	 * @param inReplyToUserID the inReplyToUserID to set
	 */
	public void setInReplyToUserID(long inReplyToUserID) {
		this.inReplyToUserID = inReplyToUserID;
	}
	/**
	 * @return the isQuoteStatus
	 */
	public boolean isQuoteStatus() {
		return isQuoteStatus;
	}
	/**
	 * @param isQuoteStatus the isQuoteStatus to set
	 */
	public void setQuoteStatus(boolean isQuoteStatus) {
		this.isQuoteStatus = isQuoteStatus;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the possiblySensitiveQuotedStatusID
	 */
	public long getPossiblySensitiveQuotedStatusID() {
		return possiblySensitiveQuotedStatusID;
	}
	/**
	 * @param possiblySensitiveQuotedStatusID the possiblySensitiveQuotedStatusID to set
	 */
	public void setPossiblySensitiveQuotedStatusID(long possiblySensitiveQuotedStatusID) {
		this.possiblySensitiveQuotedStatusID = possiblySensitiveQuotedStatusID;
	}
	/**
	 * @return the retweeted
	 */
	public boolean isRetweeted() {
		return retweeted;
	}
	/**
	 * @param retweeted the retweeted to set
	 */
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}
	/**
	 * @return the retweetCount
	 */
	public long getRetweetCount() {
		return retweetCount;
	}
	/**
	 * @param retweetCount the retweetCount to set
	 */
	public void setRetweetCount(long retweetCount) {
		this.retweetCount = retweetCount;
	}
	/**
	 * @return the retweetID
	 */
	public long getRetweetID() {
		return retweetID;
	}
	/**
	 * @param retweetID the retweetID to set
	 */
	public void setRetweetID(long retweetID) {
		this.retweetID = retweetID;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the truncated
	 */
	public boolean isTruncated() {
		return truncated;
	}
	/**
	 * @param truncated the truncated to set
	 */
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}
	/**
	 * @return the unifiedTwitterID
	 */
	public long getUnifiedTwitterID() {
		return unifiedTwitterID;
	}
	/**
	 * @param unifiedTwitterID the unifiedTwitterID to set
	 */
	public void setUnifiedTwitterID(long unifiedTwitterID) {
		this.unifiedTwitterID = unifiedTwitterID;
	}
	

}
