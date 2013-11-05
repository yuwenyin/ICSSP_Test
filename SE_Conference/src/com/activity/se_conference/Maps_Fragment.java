package com.activity.se_conference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
		
		ImageList.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_layout, 
				new String[]{"Image1","Image2","Image3","Image4","Image5","Image6"}));
		
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
