package com.edwinlo.osuchat;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.edwinlo.osuchat.com.edwinlo.irc.IRCClient;

public class MainActivity extends AppCompatActivity{

    public static IRCClient irc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        Context context = getApplicationContext();
        CharSequence text = "We're connected!";
        int duration = Toast.LENGTH_LONG;

        irc = new IRCConnection("FirenxFreeze","2f70fc4a");

        try {
            irc.connect("irc.ppy.sh",6667,"2f70fc4a");

            if (irc.isConnected()){
                Log.d("Yay!", " We're connected");

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent k = new Intent(MainActivity.this, ChatScreen.class);
                //k.putExtra("IRC", irc);
                startActivity(k);
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
