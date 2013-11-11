package com.activity.se_conference;

import java.util.ArrayList;

import myViews.MyImageListAdapter;
import myViews.MyPopDialogForImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Maps_Fragment extends Fragment{
	private ImageView AddressImage;
	private ImageView LocationImage;
	private TextView AddressTextView;
	private TextView LocationTextView;
	private ListView ImageList;
	private boolean isAddressImageVisible = false;
	private boolean isLocationImageVisble = false;
	
	
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {  
		View view = inflater.inflate(R.layout.maps_fragment, container, false);
		AddressImage = (ImageView) view.findViewById(R.id.Address_Image);
/*		LocationImage = (ImageView) view.findViewById(R.id.Location_Image);*/
		AddressTextView = (TextView) view.findViewById(R.id.Address_TextView);
		LocationTextView = (TextView) view.findViewById(R.id.Location_TextView);
		ImageList = (ListView)view.findViewById(R.id.Image_List);
		
		ArrayList<Bitmap> bitmaplist = new ArrayList<Bitmap>(); 
		bitmaplist.add(BitmapFactory.decodeResource(getResources(), R.drawable.test1));
		bitmaplist.add(BitmapFactory.decodeResource(getResources(), R.drawable.test2));
		bitmaplist.add(BitmapFactory.decodeResource(getResources(), R.drawable.test3));
		bitmaplist.add(BitmapFactory.decodeResource(getResources(), R.drawable.test4));
/*			bitmaplist.add(BitmapFactory.decodeResource(getResources(), R.drawable.test5));
		bitmaplist.add(BitmapFactory.decodeResource(getResources(), R.drawable.test6));
		bitmaplist.add(BitmapFactory.decodeResource(getResources(), R.drawable.test7));*/
		//比例为8:5的图片显示效果最好？
		
		ImageList.setAdapter(new MyImageListAdapter(getActivity(), bitmaplist));
		ImageList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				new MyPopDialogForImage(getActivity(), position).show();
				
			}
		});
		
		
		AddressTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(isAddressImageVisible){
					AddressImage.setVisibility(View.GONE);
					isAddressImageVisible = false;
				}
				else if(!isAddressImageVisible){
					AddressImage.setVisibility(View.VISIBLE);
					isAddressImageVisible = true;
				}
			}
		});
			
		LocationTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLocationImageVisble){
					ImageList.setVisibility(View.GONE);
					isLocationImageVisble = false;
				}
				else if(!isLocationImageVisble){
					ImageList.setVisibility(View.VISIBLE);
					isLocationImageVisble = true;
				}
			}
		});
			
        return view;

	}
	
}
