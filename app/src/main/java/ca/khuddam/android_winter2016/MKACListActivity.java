package ca.khuddam.android_winter2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MKACListActivity extends AppCompatActivity {

    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkaclist);

        listView = (ListView)findViewById(R.id.list);

        String[] myListofItems = new String[] {"zero is very long", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven", "8", "9", "10",
                "zero is very long", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven", "8", "9", "10",
                "zero is very long", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven", "8", "9", "10",
                "zero is very long", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven", "8", "9", "10"
        };

//        String[] largerList = new String[50];


//        listView.setAdapter(new ArrayAdapter(this, R.layout.mkac_list_item, R.id.text_item, myListofItems));
        int price = 0;
        ArrayList<WinterJacket> jacketArrayList = new ArrayList();
        for(String s : myListofItems) {
            WinterJacket wj = new WinterJacket();
            wj.description = s;
            wj.msrp += 10;
            wj.armLength = (int)((1.5f)*wj.msrp);
            jacketArrayList.add(wj);
        }

        listView.setAdapter(new WinterJacketArrayAdapter(this, R.layout.mkac_list_item, R.id.text_item, jacketArrayList));

    }
}
