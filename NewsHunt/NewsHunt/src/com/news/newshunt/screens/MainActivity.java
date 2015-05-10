package com.news.newshunt.screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.news.newshunt.R;
import com.news.newshunt.fragments.MainPageCategories;
import com.news.newshunt.fragments.MainPageRecomended;

public class MainActivity extends ActionBarActivity  {
    FragmentPagerAdapter adapterViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewPager vpPager = (ViewPager) findViewById(R.id.pagerFirstPage);
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
				return new MainPageCategories();
			} else if (pos == 1) {
				return new MainPageRecomended();
			}

			return fragment;
		}

		// Returns the page title for the top indicator
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub

			if (position == 0)
				return "CATEGORIES";
			return "RECOMMENDED";

		}

	}
}
