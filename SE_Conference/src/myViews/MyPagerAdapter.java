package myViews;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MyPagerAdapter extends PagerAdapter{
	private ArrayList<View> MyView;
	public MyPagerAdapter(ArrayList<View> views) {
		MyView = views;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return MyView.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager)container).removeView(MyView.get(position));
	}
	
	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager)container).addView(MyView.get(position));
		return MyView.get(position);
	}


}
