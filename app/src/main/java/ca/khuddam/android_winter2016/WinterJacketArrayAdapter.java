package ca.khuddam.android_winter2016;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
    Context mContext;

    public WinterJacketArrayAdapter(Context context, int resource, int textViewResourceId, List<WinterJacket> objects) {
        super(context, resource, textViewResourceId, objects);
        mList = objects;
        mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        TextView tv = null;
        TextView msrp = null;
        TextView length = null;

        if (convertView == null) {
            convertView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.mkac_list_item, null);

            tv = (TextView)convertView.findViewById(R.id.text_item);
            msrp = (TextView)convertView.findViewById(R.id.date);
            length = (TextView)convertView.findViewById(R.id.time);

            MyViewHolder viewHolder = new MyViewHolder();
            viewHolder.descTextView = tv;
            viewHolder.priceTextView = msrp;
            viewHolder.armlengthTextView = length;
            convertView.setTag(viewHolder);

        } else {
            MyViewHolder viewHolder = (MyViewHolder)convertView.getTag();
            tv = viewHolder.descTextView;
            msrp = viewHolder.priceTextView;
            length = viewHolder.armlengthTextView;
        }

        final WinterJacket wj = mList.get(position);
        tv.setText(wj.description);
        msrp.setText("Price: $"+wj.msrp);
        length.setText("Arm Length: "+wj.armLength);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String url = ((position % 3) == 0 ) ? "http://www.google.com" : "http://www.khuddam.ca";
                String url = wj.website;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    private static class MyViewHolder {
        TextView descTextView;
        TextView priceTextView;
        TextView armlengthTextView;
    }
}