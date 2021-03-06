package com.news.newshunt.adapters;

import java.util.List;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoriesPageAdapter extends BaseAdapter {
	
	List<String> categories, categoriesBriefdescription ;
	LayoutInflater layoutInflater ;
	
	public CategoriesPageAdapter(List<String> categories,List<String> categoriesBriefdescription,Context context) {
		
		this.categories = categories ;
		System.out.println("con"+this.categories);
		this.categoriesBriefdescription = categoriesBriefdescription ;	
		this.layoutInflater = LayoutInflater.from(context) ;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		System.out.println(categories);
		return categories.size();
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
                 convertView = layoutInflater.inflate(com.news.newshunt.R.layout.list_item_mainpage_categories,null);
                 mViewHolder = new MyViewHolder();
                 mViewHolder.categories = (TextView)convertView.findViewById(com.news.newshunt.R.id.list_item_main_page_category) ;
                 mViewHolder.categoriesDescription = (TextView)convertView.findViewById(com.news.newshunt.R.id.list_item_main_page_category_details) ;
                 convertView.setTag(mViewHolder);
         } else {
                 mViewHolder = (MyViewHolder) convertView.getTag();
         }
         
       
         mViewHolder.categories.setText(this.categories.get(position)) ;
         mViewHolder.categoriesDescription.setText(this.categoriesBriefdescription.get(position)) ;
        
        return convertView;
	}
	
	
	private class MyViewHolder {
        TextView categories, categoriesDescription;
}

}
