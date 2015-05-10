package com.news.newshunt.screens;

import android.provider.SyncStateContract.Constants;

import com.news.newshunt.NewsActivity;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.PushService;

public class Application extends android.app.Application {

	  public Application() {
	  }

	  @Override
	  public void onCreate() {
	    super.onCreate();

		// Initialize the Parse SDK.
	    //Parse.initialize(this, "cmd5q2Iv4eQd5eNddbd1mIhQ3aELHs4Cp2mQhXab", "o8uk2vC3n6a2WfNtN6AxapqcUNbnHqwqZIAurprD");
	    Parse.initialize(this, "NppKY4yeSGviUAtgHB8PTHjyaLYV3KnegmG2Tq93", "9f2UtVl8hIFlSfGD0ara3VR688Og7vl6vaAaAsNf");	    ParseInstallation.getCurrentInstallation().saveInBackground();

	    // Specify an Activity to handle all pushes by default.
		PushService.setDefaultPushCallback(this, NewsActivity.class);		
		
	  }
	}