package com.news.newshunt;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.news.newshunt.constants.Conatants;
import com.news.newshunt.pojo.ContentOfNews;
import com.news.newshunt.pojo.Newscontent;
import com.parse.ParsePushBroadcastReceiver;

public class PushDataReceiver extends ParsePushBroadcastReceiver {

	ContentOfNews contentOfNews;
	Context context;
	Intent intent2 ;

	@Override
	protected void onPushReceive(Context context, Intent intent) {
		super.onPushReceive(context, intent);
		try {
			this.context = context;
			Bundle bundle = intent.getExtras();
			JSONObject jsonObject = new JSONObject(intent.getExtras()
					.getString("com.parse.Data"));
			String jsonData = jsonObject.getString("alert");
			Gson gson = new Gson();
			System.out.println(jsonData + "         onPushReceive");
			contentOfNews = gson.fromJson(jsonData, ContentOfNews.class);

			Newscontent newscontent = contentOfNews.getNewscontent().get(0);

			 intent2 = new Intent(context, NotificationActivity.class);
			intent2.putExtra(Conatants.NEWS_CONTENT, newscontent.getContent());
			intent2.putExtra(Conatants.NEWS_IMAGE_LINK,
					newscontent.getImagelink());
			intent2.putExtra(Conatants.NEWS_HEADLINE,
					newscontent.getHeadlines());
			intent2.putExtra(Conatants.NEWS_DATE, newscontent.getNewstime());
			intent2.putExtra(Conatants.NEWS_ID__, newscontent.getId());

			
			showNotification(newscontent.getHeadlines()) ;

//			PendingIntent pIntent = PendingIntent.getActivity(context, 0,
//					intent2, PendingIntent.FLAG_UPDATE_CURRENT);
//
//			Notification n = new Notification.Builder(context)
//					.setContentTitle("New mail from " + "test@gmail.com")
//					.setContentText("Subject").setSmallIcon(R.drawable.news)
//					.setContentIntent(pIntent).setAutoCancel(true).build();
//
//			NotificationManager notificationmanager = (NotificationManager) context
//					.getSystemService(Context.NOTIFICATION_SERVICE);
//			// Build Notification with Notification Manager
//			notificationmanager.notify(0, n);

			Log.e("in broadcast receiver", jsonData);
		} catch (Exception exception) {
			Log.d("PushDataReceiver", "PushDataReceiver Eception");
			exception.printStackTrace() ;
		}
	}

	public void showNotification(String title) throws JSONException {

		PendingIntent pendingIntent = PendingIntent.getActivity(context, 9,
				intent2, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(R.drawable.news)
				.setContentTitle(title)
				.setContentIntent(pendingIntent);
		mBuilder.setSound(RingtoneManager
				.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(99, mBuilder.build());
	}

}
