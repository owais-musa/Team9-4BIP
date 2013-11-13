package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import il.ac.technion.cs.ssdl.cs234311.yp09.fbip.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class ShortPressInfoAdapter extends BaseAdapter implements ListAdapter {

	private Context mContext;
	private String[] mKeyInfo;
	private TextView[] texts = new TextView[4];
	
	public ShortPressInfoAdapter(String[] data, Context c) {
		mKeyInfo = data;
		mContext = c;
	}
	
	@Override
	public int getCount() {
		return mKeyInfo.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(convertView == null) {
			Log.d("GRID_VIEW", "inflating");
			LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.grid_item, null);
			TextView text = texts[position] = (TextView) v.findViewById(R.id.gridItemText);
			Log.d("GRID_VIEW", "creating view");
			text.setText(mKeyInfo[position]);
			text.setTextColor(mContext.getResources().getColor(R.color.white));
			switch(position) {
			case 0:
				text.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
				break;
			case 1:
				text.setBackgroundColor(mContext.getResources().getColor(R.color.yellow));
				break;
			case 2:
				text.setBackgroundColor(mContext.getResources().getColor(R.color.green));
				break;
			case 3:
				text.setBackgroundColor(mContext.getResources().getColor(R.color.red));
				break;
			default:
				break;
					
			}
		}
		return v;
	}

	protected TextView getTextView(int position) {
		return texts[position];
	}
}
