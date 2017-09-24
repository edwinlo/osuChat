package com.edwinlo.osuchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatScreen extends AppCompatActivity{

    public static ArrayList<String> listItems = new ArrayList<String>();
    public static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        Intent i = getIntent();
        //IRCClient irc = (IRCClient)i.getSerializableExtra("IRC");

        ListView lv = (ListView)findViewById(R.id.myView);

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        lv.setAdapter(adapter);
    }

    public void sendTestMSG(View v){
        MainActivity.irc.sendMessage("Tillerino", "!r");
        //listItems.add("test stest s");
        //adapter.notifyDataSetChanged();
    }

    public static void addMSG(String s){
        listItems.add(s);
        adapter.notifyDataSetChanged();
    }


}
