package com.activity.se_conference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class News_Fragment extends Fragment{
	private Button test_button;
	
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.news_fragment, null);
		test_button = (Button)view.findViewById(R.id.test_button);
		test_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "Clicked!", Toast.LENGTH_SHORT).show();

			}
		});
		
        return view;
    } 

}
