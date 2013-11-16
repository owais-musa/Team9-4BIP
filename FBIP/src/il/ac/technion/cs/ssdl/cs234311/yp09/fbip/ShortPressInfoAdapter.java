package il.ac.technion.cs.ssdl.cs234311.yp09.fbip;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author Itamar Bitton
 * 
 *         Inflates the <code>View</code>s displayed in the
 *         <code>ShortPressInfoFragment</code>.
 */
public class ShortPressInfoAdapter extends BaseAdapter {

  private final Context mContext;
  private final String[] mKeyInfo;
  private final TextView[] texts = new TextView[4];

  /**
   * Creates the <code>ShortPressInfoAdapter</code> with the necessary
   * parameters.
   * 
   * @param s
   *          The text to display in the <code>TextView</code>s.
   * @param c
   *          The associated <code>Context</code>.
   */
  public ShortPressInfoAdapter(final String[] s, final Context c) {
    mKeyInfo = s;
    mContext = c;
  }

  @Override
  public int getCount() {
    return mKeyInfo.length;
  }

  @Override
  public Object getItem(final int position) {
    return texts[position];
  }

  @Override
  public long getItemId(final int position) {
    return position;
  }

  @Override
  public View getView(final int position, final View convertView,
      final ViewGroup parent) {
    View $ = convertView;
    if (convertView == null) {
      Log.d("GRID_VIEW", "inflating");
      $ = ((LayoutInflater) mContext
          .getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
          R.layout.grid_item, null);
      Log.d("GRID_VIEW", "creating view");
      final TextView text = texts[position] = (TextView) $
          .findViewById(R.id.gridItemText);
      text.setText(mKeyInfo[position]);
      switch (position) {
      case 0:
        text.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
        break;
      case 1:
        text.setBackgroundColor(mContext.getResources()
            .getColor(R.color.yellow));
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
    return $;
  }

  protected TextView getTextView(final int position) {
    return texts[position];
  }
}
