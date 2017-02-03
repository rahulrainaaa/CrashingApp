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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Crashlytics Service
        Fabric.with(this, new Crashlytics());

        Button b = new Button(this);
        b.setText("click button");
        setContentView(b);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Digit Service
        TwitterAuthConfig authConfig = new TwitterAuthConfig(Const.TWITTER_KEY, Const.TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());
    }
}
