package com.news.newshunt;

import com.news.newshunt.constants.Conatants;
import com.news.newshunt.fragments.English;
import com.news.newshunt.fragments.Kannada;
import com.news.newshunt.fragments.MainPageCategories;
import com.news.newshunt.fragments.MainPageRecomended;
import com.news.newshunt.screens.MainActivity.MyPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class NewsListActivity extends ActionBarActivity {
	private FragmentPagerAdapter adapterViewPager;
	public static String newsListHalfUrl ; 
	public static String currentCategory ; 

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_list);

		Intent intent = getIntent();
		newsListHalfUrl = intent.getStringExtra(Conatants.HALF_URL) ;
		currentCategory = intent.getStringExtra(Conatants.CURRENT_CATEGORY) ;

		System.out.println(newsListHalfUrl);
		ViewPager vpPager = (ViewPager) findViewById(R.id.pagerNewsList);
		adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
		vpPager.setAdapter(adapterViewPager);

	}

	public static class MyPagerAdapter extends FragmentPagerAdapter {
		private static int NUM_ITEMS = 2;

		public MyPagerAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		// Returns total number of pages
		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

		// Returns the fragment to display for that page
		@Override
		public Fragment getItem(int pos) {
			// TODO Auto-generated method stub
			Fragment fragment = null;

			if (pos == 0) {
				return new English();
			} else if (pos == 1) {
				return new Kannada();
			}

			return fragment;
		}

		// Returns the page title for the top indicator
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub

			if (position == 0)
				return "ENGLISH";
			return "ಕನ್ನಡ";

		}
		
		

	}
}
