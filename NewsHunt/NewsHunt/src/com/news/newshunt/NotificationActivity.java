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

import com.news.newshunt.constants.Conatants;
import com.news.newshunt.pojo.ContentOfNews;
import com.news.newshunt.pojo.Newscontent;
import com.news.newshunt.screens.TimeLineActivity;
import com.squareup.picasso.Picasso;

public class NotificationActivity extends ActionBarActivity {

	TextView headline;
	TextView date;
	TextView content;
	ImageView imageView;
	ContentOfNews contentOfNews;
	String urlForFetch;
	long timeStart;
	Intent intent;
	Newscontent newscontent;
	Button timeLine;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stu
		super.onPause();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		intent = getIntent();

		init();

		AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {

			ProgressDialog progressDialog;

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();

				progressDialog = new ProgressDialog(NotificationActivity.this);
				progressDialog.setMessage("Please Wait.........");
				progressDialog.show();

			}

			@Override
			protected Void doInBackground(Void... params) {
				try {

					newscontent = new Newscontent();
					newscontent.setContent(intent
							.getStringExtra(Conatants.NEWS_CONTENT));
					newscontent.setNewstime(intent
							.getStringExtra(Conatants.NEWS_DATE));
					newscontent.setHeadlines(intent
							.getStringExtra(Conatants.NEWS_HEADLINE));
					newscontent.setImagelink(intent
							.getStringExtra(Conatants.NEWS_IMAGE_LINK));
					newscontent.setId(intent
							.getStringExtra(Conatants.NEWS_ID__));

				} catch (Exception exception) {
					exception.printStackTrace();
				}

				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				try {

					headline.setText(newscontent.getHeadlines());
					date.setText(newscontent.getNewstime());
					content.setText(newscontent.getContent());

					Picasso.with(NotificationActivity.this)
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

		timeLine = (Button) findViewById(R.id.timeline);

		timeLine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(NotificationActivity.this,
						TimeLineActivity.class);
				intent.putExtra(Conatants.TIMELINE_NEWS_ID, newscontent.getId());
				startActivity(intent);
			}
		});

	}

}
