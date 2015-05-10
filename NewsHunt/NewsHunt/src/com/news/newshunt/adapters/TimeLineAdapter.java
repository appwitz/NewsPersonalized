package com.news.newshunt.adapters;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.news.newshunt.R;
import com.news.newshunt.pojo.Newslist;

public class TimeLineAdapter extends BaseAdapter {
	Context context;
	List<Newslist> recomendedNews;
	LayoutInflater layoutInflater;

	public TimeLineAdapter(List<Newslist> recomendedNews, Context context) {
		super();
		this.recomendedNews = recomendedNews;
		this.layoutInflater = LayoutInflater.from(context);
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return recomendedNews.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MyViewHolder mViewHolder;
		Integer monthhhh = null ;
		Integer yearrr = null ;
		Integer dateee = null ;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.timeline, parent, false);
			mViewHolder = new MyViewHolder();

			mViewHolder.date = (TextView) convertView
					.findViewById(R.id.timDate);
			mViewHolder.monthYear = (TextView) convertView
					.findViewById(R.id.timmonthyear);
			mViewHolder.headline = (TextView) convertView
					.findViewById(R.id.timeheadline);

			convertView.setTag(mViewHolder);

		} else {
			mViewHolder = (MyViewHolder) convertView.getTag();

		}
		try {

			String dateString = recomendedNews.get(position).getNewstime();
			int index = dateString.indexOf("IST");
			String date = dateString.substring(0, index);
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"EEE MMM dd HH:mm:ss");
			Date date2 = dateFormat.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date2);
			 dateee = calendar.get(Calendar.DATE);
			 monthhhh = calendar.get(Calendar.MONTH);
			 yearrr = 15;
		} catch (Exception e) {
			// TODO: handle exception
		}
		mViewHolder.date.setText(dateee.toString());
		mViewHolder.headline.setText(recomendedNews.get(position)
				.getHeadlines());
		mViewHolder.monthYear.setText(monthhhh.toString() + "'"
				+ yearrr.toString());

		FrameLayout frameLayout = (FrameLayout) convertView
				.findViewById(R.id.timeline);
		frameLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Clicked");
				int position = ((ListView) (((View) v.getParent()).getParent()))
						.getPositionForView((View) v.getParent());
				System.out.println(position);
				View view = (View) v.getParent();
				TextView textView = (TextView) view.findViewById(R.id.headline);
				LinearLayout layout = (LinearLayout) view
						.findViewById(R.id.dateLayout);
				LinearLayout goneLayout = (LinearLayout) view
						.findViewById(R.id.goneLayout);
				if (layout.getVisibility() == View.VISIBLE) {
					layout.setVisibility(View.GONE);
					textView.setVisibility(View.GONE);
					goneLayout.setVisibility(View.VISIBLE);
				} else {
					layout.setVisibility(View.VISIBLE);
					textView.setVisibility(View.VISIBLE);
					goneLayout.setVisibility(View.GONE);
				}
			}
		});

		LinearLayout layout = (LinearLayout) convertView
				.findViewById(R.id.dateLayout);
		layout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Clicked");
				int position = ((ListView) (((View) v.getParent()).getParent()))
						.getPositionForView((View) v.getParent());
				System.out.println(position);
				View view = (View) v.getParent();
				TextView textView = (TextView) view
						.findViewById(R.id.timeheadline);
				LinearLayout layout = (LinearLayout) view
						.findViewById(R.id.dateLayout);
				LinearLayout goneLayout = (LinearLayout) view
						.findViewById(R.id.goneLayout);
				if (layout.getVisibility() == View.VISIBLE) {
					layout.setVisibility(View.GONE);
					textView.setVisibility(View.GONE);
					goneLayout.setVisibility(View.VISIBLE);
				} else {
					layout.setVisibility(View.VISIBLE);
					textView.setVisibility(View.VISIBLE);
					goneLayout.setVisibility(View.GONE);
				}
			}
		});

		LinearLayout layoutGone = (LinearLayout) convertView
				.findViewById(R.id.goneLayout);
		layoutGone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Clicked");
				int position = ((ListView) (((View) v.getParent()).getParent()))
						.getPositionForView((View) v.getParent());
				System.out.println(position);
				View view = (View) v.getParent();
				TextView textView = (TextView) view
						.findViewById(R.id.timeheadline);
				LinearLayout layout = (LinearLayout) view
						.findViewById(R.id.dateLayout);
				LinearLayout goneLayout = (LinearLayout) view
						.findViewById(R.id.goneLayout);
				if (layout.getVisibility() == View.VISIBLE) {
					layout.setVisibility(View.GONE);
					textView.setVisibility(View.GONE);
					goneLayout.setVisibility(View.VISIBLE);
				} else {
					layout.setVisibility(View.VISIBLE);
					textView.setVisibility(View.VISIBLE);
					goneLayout.setVisibility(View.GONE);
				}
			}
		});
		return convertView;
	}

	private class MyViewHolder {
		TextView date, monthYear, headline;
	}

}
