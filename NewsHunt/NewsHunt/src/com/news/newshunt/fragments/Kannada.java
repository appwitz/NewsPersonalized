package com.news.newshunt.fragments;

import java.util.ArrayList;
import java.util.List;

import com.news.newshunt.NewsActivity;
import com.news.newshunt.R;
import com.news.newshunt.adapters.NewsAdapter;
import com.news.newshunt.pojo.News;
import com.news.newshunt.pojo.Newslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Kannada extends Fragment{
	ListView listView;
	NewsAdapter newsAdapter;
	List<Newslist> news;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		news = new ArrayList<Newslist>();

		// TODO : remove
		Newslist neww;
		for (int i = 0; i < 1; i++) {
			neww = new Newslist();
			neww.setHeadlines("ಅಮ್ಮಂದಿರ ದಿನ ವಿಶೇಷ: ಮಹಾತಾಯಿಯರಿಗೆ ನಮನ");
			neww.setNewstime("May 10, 2015, 04.00AM IST");
			neww.setImagelink("http://www.gospelherald.com/data/images/full/10526/mothers-day.jpg");
			news.add(neww);
		}

		View view = inflater.inflate(R.layout.kannada, null);
		listView = (ListView) view.findViewById(R.id.list_kannada_news);

		newsAdapter = new NewsAdapter(news, getActivity());

		listView.setAdapter(newsAdapter);
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Intent intent = new Intent(getActivity(), NewsActivity.class) ;
				getActivity().startActivity(intent) ;
			}
		});

		return view;

	}
}
