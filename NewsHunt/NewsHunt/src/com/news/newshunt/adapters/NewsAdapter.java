package com.news.newshunt.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.newshunt.R;
import com.news.newshunt.pojo.News;
import com.news.newshunt.pojo.Newslist;
import com.squareup.picasso.Picasso;

public class NewsAdapter extends BaseAdapter{

	List<Newslist> recomendedNews;
	LayoutInflater layoutInflater ;
	Context context ;
	
	public NewsAdapter(List<Newslist> recomendedNews,Context context) {
		
		this.recomendedNews = 	recomendedNews ;
		this.layoutInflater = LayoutInflater.from(context) ;
		this.context = context ;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return recomendedNews.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
	
		 MyViewHolder mViewHolder;
         
         if(convertView == null) {
                 convertView = layoutInflater.inflate(com.news.newshunt.R.layout.list_item_recomended,null);
                 mViewHolder = new MyViewHolder();
                 
                 mViewHolder.news = (TextView)convertView.findViewById(R.id.list_item_recomended_news) ;
                 mViewHolder.newsBrief = (TextView)convertView.findViewById(R.id.list_item_recomended_news_brief) ;
                 mViewHolder.newsImage = (ImageView)convertView.findViewById(R.id.list_item_news_image ) ;
                 convertView.setTag(mViewHolder);
         } else {
                 mViewHolder = (MyViewHolder)convertView.getTag();
         }
         
         
        
       mViewHolder.news.setText(this.recomendedNews.get(position).getHeadlines()) ;
       mViewHolder.newsBrief.setText(this.recomendedNews.get(position).getNewstime()) ;
       
     //  TODO Remove comment
       Picasso.with(context).load(this.recomendedNews.get(position).getImagelink()	) 
       .into(mViewHolder.newsImage);
       
         
        
        return convertView;
	}
	
	
	private class MyViewHolder {
        TextView news , newsBrief;
        ImageView newsImage ;
}
	
	
}
