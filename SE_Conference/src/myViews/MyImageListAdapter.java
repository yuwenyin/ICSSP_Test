package myViews;

import java.util.ArrayList;

import com.activity.se_conference.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyImageListAdapter extends BaseAdapter{
	private Context context;
	private ArrayList<Bitmap> arraylist = new ArrayList<Bitmap>();
	private ImageView imageview = null;
	
	public MyImageListAdapter(Context cont, ArrayList<Bitmap> list){
		this.context = cont;
		this.arraylist = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arraylist.size();
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
		// TODO Auto-generated method stub
		 LayoutInflater inflater = LayoutInflater.from(context);
		 View view = inflater.inflate(R.layout.maps_imagelist_layout, null);
		 imageview = (ImageView)view.findViewById(R.id.ListImage);
		 imageview.setImageBitmap(arraylist.get(position));
		 return view;
	}

}
