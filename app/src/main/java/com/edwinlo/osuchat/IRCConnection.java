package com.edwinlo.osuchat;

import android.util.Log;

import com.edwinlo.osuchat.com.edwinlo.irc.IRCClient;

/**
 * Created by Edwin Lo on 9/18/2017.
 */

public class IRCConnection extends IRCClient{

    public IRCConnection(String nickname, String password){
        this.setName(nickname);
    }

    @Override
    protected void onPrivateMessage(String sender, String login, String hostname, String message){
        String s = sender + ": " + message;
        ChatScreen.addMSG(s);
        Log.d("Test msg:", "he replied!!");
    }

}
