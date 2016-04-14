package ca.khuddam.android_winter2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by roomi on 4/13/2016.
 */
public class WinterJacketArrayAdapter extends ArrayAdapter<WinterJacket> {

    List<WinterJacket> mList;

    public WinterJacketArrayAdapter(Context context, int resource, int textViewResourceId, List<WinterJacket> objects) {
        super(context, resource, textViewResourceId, objects);
        mList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout ll = (LinearLayout)LayoutInflater.from(parent.getContext()).inflate(R.layout.mkac_list_item, null);

        TextView tv = (TextView)ll.findViewById(R.id.text_item);
        TextView msrp = (TextView)ll.findViewById(R.id.date);
        TextView length = (TextView)ll.findViewById(R.id.time);
        WinterJacket wj = mList.get(position);

        tv.setText(wj.description);
        msrp.setText("Price: $"+wj.msrp);
        length.setText("Arm Length: "+wj.armLength);

        return ll;
    }
}