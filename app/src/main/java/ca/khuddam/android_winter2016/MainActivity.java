package ca.khuddam.android_winter2016;

import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    TextView txtTopLine, txtSecondLine;
    Button btnRed, btnGreen, btnBlue;
    LinearLayout rootLayout;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wiring UI objects to respective object in Layout
        txtTopLine = (TextView) findViewById(R.id.txtTopLine);
        txtSecondLine = (TextView) findViewById(R.id.txtSecondLine);
        btnRed=(Button) findViewById(R.id.btnRed);
        btnGreen=(Button) findViewById(R.id.btnGreen);
        btnBlue=(Button) findViewById(R.id.btnBlue);
        rootLayout=(LinearLayout)findViewById((R.id.rootLayout));

        txtTopLine.setTextColor(Color.YELLOW);

        // Creating 3 instances of WinterJacket and initializing
        // their Color and description
        WinterJacket redJacket = new WinterJacket();
        redJacket.setColor(WinterJacket.JacketColor.RED);
        redJacket.description = "Red Jacket";
        btnRed.setTag(redJacket);

        WinterJacket greenJacket = new WinterJacket();
        greenJacket.setColor(WinterJacket.JacketColor.GREEN);
        greenJacket.description="Green Jacket";
        btnGreen.setTag(greenJacket);

        WinterJacket blueJacket = new WinterJacket();
        blueJacket.setColor(WinterJacket.JacketColor.BLUE);
        blueJacket.description="Blue Jacket";
        btnBlue.setTag(blueJacket);

        // Defining an OnClickListenr object that will be used to perform
        // action for onClick event of all buttons
        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get reference to button that was clicked
                Button ClickedButton = (Button)v;
                // Get reference to WinterJacket object that was tagged with Clicked button
                WinterJacket associatedJacket = (WinterJacket)ClickedButton.getTag();
                // Set background of root layout to same as defined by associated Winter Jacket
                rootLayout.setBackgroundColor(associatedJacket.getColorInt());

                // The above three statemetns could be written in a single line as below
                // rootLayout.setBackgroundColor(((WinterJacket) (((Button) v).getTag())).getColorInt());

                txtSecondLine.setText("User clicked Button...\nwhich had  \"" + associatedJacket.description + "\" associated with it.");
                txtSecondLine.setTextColor(Color.WHITE);
            }
        };

        // Setting the OnClickListener event, defined above, to each of the three button's OnClickListener event.
        btnRed.setOnClickListener(buttonListener);
        btnGreen.setOnClickListener(buttonListener);
        btnBlue.setOnClickListener(buttonListener);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ca.khuddam.android_winter2016/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ca.khuddam.android_winter2016/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
