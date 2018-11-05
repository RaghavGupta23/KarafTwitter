//@Author Raghav Gupta
	
package com.decters.TwitterMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class TwitterGet {

	@SuppressWarnings({ "unused", "deprecation" })
	public static HttpResponse executeHttpGet(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpGet request = new HttpGet(apiUrl);
		Auth.Authentication().sign(request);
		@SuppressWarnings("resource")
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request);
		return response;
	}

	// @Author Aaron
	public List<String> listfriendsids(String status) {
		List<String> ResponseList = new ArrayList<String>();
		try {

			String twitApiLink ="https://api.twitter.com/1.1/friends/ids.json?cursor=-1&count=5000";
			
			HttpResponse apiResponse = executeHttpGet(twitApiLink);
			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("ids");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					ResponseList.add(jsonArray.getString(i));

				}
			} else {
				ResponseList.add("API call was Unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}
	
	// @Author Aaron
	public List<String> listFollowersIDs() {
		List<String> ResponseList = new ArrayList<String>();
		try {
			String twitApiLink ="https://api.twitter.com/1.1/followers/ids.json?cursor=-1&count=5000";

			HttpResponse apiResponse = executeHttpGet(twitApiLink);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("ids");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					ResponseList.add(jsonArray.getString(i));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}
	
	// @Author Sam
	public List<String> followersList() {
		List<String> ResponseList = new ArrayList<String>();
		try {
			String twitApiLink ="https://api.twitter.com/1.1/followers/list.json";
		
			HttpResponse apiResponse = executeHttpGet(twitApiLink);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("users");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("name") + " : " + (String) object.get("screen_name");
					ResponseList.add(displayText);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}
	//@Author Sam
	public List<String> friendsList() {
		List<String> ResponseList = new ArrayList<String>();
		try {
			String twitApiLink ="https://api.twitter.com/1.1/friends/list.json?cursor=-1&screen_name=twitterapi&skip_status=true&include_user_entities=false";
		
			HttpResponse apiResponse = executeHttpGet(twitApiLink);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("users");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("name") + " : " + (String) object.get("screen_name");
					ResponseList.add(displayText);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}
	//@Author Nikita
	public List<String> listBlockIDs() {
		List<String> ResponseList = new ArrayList<String>();
		try {

			String twitApiLink ="https://api.twitter.com/1.1/blocks/ids.json?stringify_ids=true&cursor=-1";

			HttpResponse apiResponse = executeHttpGet(twitApiLink);
			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("ids");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					ResponseList.add(jsonArray.getString(i));

				}
			} else {
				ResponseList.add("API call was Unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}
	//@Author Nikita
	public List<String> blockList() {
		List<String> ResponseList = new ArrayList<String>();
		try {
			String twitApiLink ="https://api.twitter.com/1.1/blocks/list.json?skip_status=true&cursor=-1";
			
			HttpResponse apiResponse = executeHttpGet(twitApiLink);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				System.out.println("200 OK");
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("users");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("name") + " : " + (String) object.get("screen_name");
					ResponseList.add(displayText);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}

}