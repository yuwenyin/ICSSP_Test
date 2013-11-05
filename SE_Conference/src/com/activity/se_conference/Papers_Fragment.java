package com.activity.se_conference;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import myViews.ClassItem;
import myViews.ClassListAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Papers_Fragment extends Fragment{
	private ListView classItemList;
	private ClassListAdapter classListAdapter;
	private View view=null;
	ViewGroup container=null;
	LayoutInflater inflater=null;
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {  
		this.container=container;
		this.inflater=inflater;
		view=inflater.inflate(R.layout.papers_fragment, container, false);
		initView();
        return  view; 
    }
	private void initView() {
		// TODO Auto-generated method stub
		classItemList=(ListView) view.findViewById(R.id.classItemListView);
		classListAdapter = new ClassListAdapter(getActivity());
		classItemList.setAdapter(classListAdapter);
		
		Vector<ClassItem> data = new Vector<ClassItem>();
	
		ClassItem item1 = new ClassItem(1,"class1",1,"part1","");
		ClassItem item2 = new ClassItem(1,"class1",2,"part2","");
		ClassItem item3 = new ClassItem(1,"class1",2,"part2","");
		ClassItem item4 = new ClassItem(1,"class1",3,"part3","");
		ClassItem item5 = new ClassItem(1,"class1",3,"part3","");
		ClassItem item6 = new ClassItem(1,"class1",3,"part3","");
		ClassItem item7 = new ClassItem(1,"class1",4,"part4","");
		ClassItem item8 = new ClassItem(1,"class1",4,"part4","");
		
		data.addElement(item1);
		data.addElement(item2);
		data.addElement(item3);
		data.addElement(item4);
		data.addElement(item5);
		data.addElement(item6);
		data.addElement(item7);
		data.addElement(item8);
		addAdapterItem(data);
		
		classItemList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent=null;
				switch(arg2){
				case 0:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				case 1:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				case 2:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				case 3:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				case 4:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				case 5:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				case 6:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				case 7:
					intent=new Intent(getActivity(),Pages_Details.class);
					startActivity(intent);
					break;
				
				}
				
			}
			
		});
	} 

	private void addAdapterItem(Vector<ClassItem> data){
		Vector<ClassItem> classItem = new Vector<ClassItem>();
		classItem.removeAllElements();
		
		ClassItem temp = null;
		Set<Integer> set = new HashSet<Integer>();
		if(data!=null && data.size()>0){
			for(int i=0 ; i<data.size() ; i++){
				temp = data.get(i);
				if(set.contains(temp.partId)){
					classItem.add(temp); 
				}else{
					temp.ifTop = true;
					set.add(temp.partId);
					classItem.add(temp);
				}
			}
			classListAdapter.removeAll();
			for(ClassItem item : classItem){
				classListAdapter.addItem(item);
			}
		}
	}
}
