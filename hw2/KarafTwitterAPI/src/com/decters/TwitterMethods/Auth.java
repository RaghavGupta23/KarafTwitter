//@Author Raghav Gupta created
package com.decters.TwitterMethods;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class Auth {

	private static final String consumerKey = "ElaHJBajg066QPP84MQoetAxT";
	private static final String consumerSecret ="yFptzWgxHKNMxNaWoStH9zZceydMcR1atJdIazs0RE1bdxvdbU";
	private static final String accessToken = "1048374569130553344-j84EBtzj2by8IAHz2TUDLtA1ChaHvP";
	private static final String accessTokenSecretStr = "BkiXljJOMZZ7PCAqTFV3nsEp0csSX065WqkijoVhG7ZI3";
	
	public static OAuthConsumer Authentication() throws IOException {
		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
		oAuthConsumer.setTokenWithSecret(accessToken, accessTokenSecretStr);
		return oAuthConsumer;
	}

}