package com.news.newshunt;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.news.newshunt.constants.Conatants;
import com.news.newshunt.pojo.ContentOfNews;
import com.news.newshunt.pojo.Newscontent;
import com.news.newshunt.screens.TimeLineActivity;
import com.parse.ParseInstallation;
import com.squareup.picasso.Picasso;

public class NewsActivity extends ActionBarActivity {

	TextView headline;
	TextView date;
	TextView content;
	ImageView imageView;
	Button timeLine ;
	ContentOfNews contentOfNews;
	String urlForFetch;
	long timeStart;
	public String currentCategory;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		timeStart = System.currentTimeMillis();
		super.onResume();
	}

	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
		AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
			
			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				long timeDiff = (System.currentTimeMillis() - timeStart) / 1000;
				ParseInstallation installation = ParseInstallation
						.getCurrentInstallation();
				String installationId = installation.getInstallationId();
				String updateUserActivity = Conatants.TIME_ANALYTIC + "userid="
						+ installationId + "&categoryid=" + currentCategory
						+ "&timings=" + Long.toString(timeDiff) + "&newsid=" + contentOfNews.getNewscontent().get(0).getId() ;
				System.out.println(updateUserActivity);
				FetchFromServer fetchFromServer = new FetchFromServer(updateUserActivity) ;
				fetchFromServer.fetch() ;
				return null;
			}
		};
	

	asyncTask.execute() ;
		

		super.onStop();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		Intent intent = getIntent();
		urlForFetch = intent.getStringExtra(Conatants.NEWS);
		currentCategory = intent.getStringExtra(Conatants.CURRENT_CATEGORY);
		init();

		AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {

			ProgressDialog progressDialog;

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();

				progressDialog = new ProgressDialog(NewsActivity.this);
				progressDialog.setMessage("Please Wait.........");
				progressDialog.show();

			}

			@Override
			protected Void doInBackground(Void... params) {
				try {
					String url = NewsListActivity.newsListHalfUrl + "English";
					System.out.println(url);
					FetchFromServer fetchFromServer = new FetchFromServer(
							urlForFetch);
					String s = fetchFromServer.fetch();
					Gson gson = new Gson();
					System.out.println(s + "         crep");
					contentOfNews = gson.fromJson(s, ContentOfNews.class);
				} catch (Exception exception) {
					exception.printStackTrace();
				}

				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				try {

					Newscontent newscontent = contentOfNews.getNewscontent()
							.get(0);
					headline.setText(newscontent.getHeadlines());
					date.setText(newscontent.getNewstime());
					content.setText(newscontent.getContent());

					Picasso.with(NewsActivity.this)
							.load(newscontent.getImagelink()).into(imageView);
				} catch (Exception exception) {
					exception.printStackTrace();
				}

				progressDialog.dismiss();
			}
		};

		asyncTask.execute();

	}

	private void init() {

		headline = (TextView) findViewById(R.id.headline);
		date = (TextView) findViewById(R.id.date);
		content = (TextView) findViewById(R.id.content);
		imageView = (ImageView) findViewById(R.id.newsImage);
		timeLine = (Button)findViewById(R.id.timeline) ;
		
		timeLine.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new  Intent(NewsActivity.this, TimeLineActivity.class) ;
				intent.putExtra(Conatants.TIMELINE_NEWS_ID, contentOfNews.getNewscontent().get(0).getId() ) ;
				startActivity(intent);
			}
		}) ;

	}

}
