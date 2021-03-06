package com.news.newshunt.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.gson.Gson;
import com.news.newshunt.FetchFromServer;
import com.news.newshunt.NewsActivity;
import com.news.newshunt.NewsListActivity;
import com.news.newshunt.R;
import com.news.newshunt.adapters.CategoriesPageAdapter;
import com.news.newshunt.adapters.NewsAdapter;
import com.news.newshunt.constants.Conatants;
import com.news.newshunt.pojo.Category;
import com.news.newshunt.pojo.CategoryList;
import com.news.newshunt.pojo.ListOfNews;
import com.news.newshunt.pojo.News;
import com.news.newshunt.pojo.Newslist;

public class English extends Fragment {

	ListView listView;
	NewsAdapter newsAdapter;
	ListOfNews listOfNews;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		// // TODO : remove
		// News neww;
		// for (int i = 0; i < 15; i++) {
		// neww = new News();
		// neww.setNews("english");
		// neww.setNewsBrief("cersdfsdfgds");
		// neww.setLinkToImage("cersdfgdff");
		// news.add(neww);
		// }

		View view = inflater.inflate(R.layout.english, null);
		listView = (ListView) view.findViewById(R.id.list_english_news);

		return view;

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

		AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {

			ProgressDialog progressDialog;

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();

				progressDialog = new ProgressDialog(getActivity());
				progressDialog.setMessage("Please Wait.........");
				progressDialog.show();

			}

			@Override
			protected Void doInBackground(Void... params) {
				try {
					String url = NewsListActivity.newsListHalfUrl + "English" ;
					System.out.println(url);
					FetchFromServer fetchFromServer = new FetchFromServer(
							url);
					String s = fetchFromServer.fetch();
					Gson gson = new Gson();
					System.out.println(s + "         crep");
					listOfNews = gson.fromJson(s, ListOfNews.class);
				} catch (Exception exception) {
					exception.printStackTrace();
				}

				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				
				try{

				newsAdapter = new NewsAdapter(listOfNews.getNewslist(), getActivity());

				listView.setAdapter(newsAdapter);

				listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
							long arg3) {

						Intent intent = new Intent(getActivity(), NewsActivity.class) ;
						String newsId = Conatants.NEWS_HTTP + listOfNews.getNewslist().get(pos).getId() ;
						intent.putExtra(Conatants.NEWS, newsId) ;
						intent.putExtra(Conatants.CURRENT_CATEGORY, NewsListActivity.currentCategory) ;
						getActivity().startActivity(intent) ;
					}
				});
			}
				catch(Exception exception)
				{
					exception.printStackTrace() ;
				}
				progressDialog.dismiss();
			}
		};

		asyncTask.execute();

	}

}
