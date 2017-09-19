package com.edwinlo.osuchat;

import com.edwinlo.osuchat.com.edwinlo.irc.IRCClient;

/**
 * Created by Edwin Lo on 9/18/2017.
 */

public class IRCConnection extends IRCClient{

    public IRCConnection(String nickname, String password){
        this.setName(nickname);
    }
}
