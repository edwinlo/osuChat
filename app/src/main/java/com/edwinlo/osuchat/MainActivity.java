package com.edwinlo.osuchat;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.edwinlo.osuchat.com.edwinlo.irc.IRCClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        Context context = getApplicationContext();
        CharSequence text = "We're connected!";
        int duration = Toast.LENGTH_LONG;

        IRCClient irc = new IRCConnection("FirenxFreeze","2f70fc4a");

        try {
            Log.d("asdasd","2f70fc4a");
            irc.connect("irc.ppy.sh",6667,"2f70fc4a");

            if (irc.isConnected()){
                Log.d("Yay!", " We're connected");

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else {
                Toast toast = Toast.makeText(context, "Rip", duration);
                toast.show();
            }
        }

        catch (Exception e) {
            Log.d("Error: ", "Cannot connect to server.");
            Log.d("Error info: ", e.toString());

            Toast toast = Toast.makeText(context, e.toString(), duration);
            toast.show();
        }


    }
}
