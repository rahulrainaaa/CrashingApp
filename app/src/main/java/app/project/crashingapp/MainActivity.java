package app.project.crashingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.digits.sdk.android.Digits;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private static final String TWITTER_KEY = "--------------";
    private static final String TWITTER_SECRET = "---------------";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        Fabric.with(this, new Crashlytics());

        Button b = new Button(this);
        b.setText("click button ");
        setContentView(b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Write some app crashing code.


            }
        });
    }
}
