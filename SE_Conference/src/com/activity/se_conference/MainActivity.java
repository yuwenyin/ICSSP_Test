package com.activity.se_conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	private ViewPager mViewPager = null;
	private View news_view = null;
	private View papers_view = null;
	private View agenda_view = null;
	private View maps_view = null;
	private View info_view = null;
	private TextView News_textview;
	private TextView Papers_textview;
	private TextView Agenda_textview;
	private TextView Maps_textview;
	private TextView Info_textview;
	private ListView Drawer_List;
	private DrawerLayout MyDrawerLayout = null;
	private Button Drawer_Btn = null;
	public static Resources resources;	
	private int currentPage = 0;
	private boolean drawer_open = false;
	Map<Integer,View> map = new HashMap<Integer,View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mViewPager = (ViewPager)this.findViewById(R.id.viewpager);		
		News_textview= (TextView)findViewById(R.id.News_textview);
		Papers_textview= (TextView)findViewById(R.id.Papers_textview);
		Agenda_textview= (TextView)findViewById(R.id.Agenda_textview);		
		Maps_textview= (TextView)findViewById(R.id.Maps_textview);
		Info_textview= (TextView)findViewById(R.id.Info_textview);
		Drawer_List = (ListView)findViewById(R.id.drawer);
		Drawer_Btn = (Button)findViewById(R.id.Drawer_Btn);
		MyDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		
		Drawer_List.setAdapter(new ArrayAdapter<String>(this, R.layout.list_layout, new String[]{
				"News","Papers","Agenda","Maps","Info"}));
		Drawer_List.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(position);
				MyDrawerLayout.closeDrawer(Gravity.LEFT);
				
			}
		});
		
		
		resources = getResources();
		News_textview.setBackgroundColor(resources.getColor(R.color.skyblue));
		map.put(0, News_textview);
		map.put(1,Papers_textview);
		map.put(2,Agenda_textview);
		map.put(3,Maps_textview);
		map.put(4,Info_textview);
		
		//ͨ��inflater�Ҳ����ļ�   
		LayoutInflater mLi = LayoutInflater.from(this);     
        news_view = mLi.inflate(R.layout.news, null);
        papers_view = mLi.inflate(R.layout.papers, null);
        agenda_view = mLi.inflate(R.layout.agenda, null);
        maps_view = mLi.inflate(R.layout.maps, null);        
        info_view = mLi.inflate(R.layout.info, null);
        
        InitViewpager();

		//�����ǩ��ת
		News_textview.setOnClickListener(new MyViewPageListener(0));
		Papers_textview.setOnClickListener(new MyViewPageListener(1));
		Agenda_textview.setOnClickListener(new MyViewPageListener(2));
		Maps_textview.setOnClickListener(new MyViewPageListener(3));
		Info_textview.setOnClickListener(new MyViewPageListener(4));
			
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				switch (arg0){
					case 0:
						News_textview.setBackgroundColor(resources.getColor(R.color.skyblue));						
						break;
					case 1:
						Papers_textview.setBackgroundColor(resources.getColor(R.color.skyblue));
						break;
					case 2:
						Agenda_textview.setBackgroundColor(resources.getColor(R.color.skyblue));
						break;
					case 3:
						Maps_textview.setBackgroundColor(resources.getColor(R.color.skyblue));
						break;
					case 4:
						Info_textview.setBackgroundColor(resources.getColor(R.color.skyblue));
						break;
				}
				map.get(currentPage).setBackgroundColor(0);			
				currentPage = arg0;
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Drawer_Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!drawer_open){
					MyDrawerLayout.openDrawer(Gravity.LEFT);
					drawer_open = true;
				}
				else if(drawer_open){
					MyDrawerLayout.closeDrawer(Gravity.LEFT);
					drawer_open = false;
				}
				
				
			}
		});
				
	} 

	class MyViewPageListener implements OnClickListener{
		
		int index = 0;
		public MyViewPageListener(int i){
			index = i;
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mViewPager.setCurrentItem(index);
	
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void InitViewpager(){

        final ArrayList<View> views = new ArrayList<View>();
        views.add(news_view);
        views.add(papers_view);
        views.add(agenda_view);
        views.add(maps_view);
        views.add(info_view);
        
        PagerAdapter mPagerAdapter = new MyPagerAdapter(views);
		mViewPager.setAdapter(mPagerAdapter);
	}
	

}


