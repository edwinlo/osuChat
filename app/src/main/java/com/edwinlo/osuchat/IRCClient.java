package com.edwinlo.osuchat;

/**
 * Created by Edwin Lo on 9/13/2017.
 */

import net.engio.mbassy.listener.Handler;

import org.kitteh.irc.client.library.Client;
import org.kitteh.irc.client.library.event.channel.ChannelJoinEvent;

public class IRCClient {

    public IRCClient(String host, String realName, String ircPassword){

    }

    public static class Listener {
        @Handler
        public void onUserJoinChannel(ChannelJoinEvent event) {
            if (event.getClient().isUser(event.getUser())) { // It's me!
                event.getChannel().sendMessage("Hello world! Kitteh's here for cuddles.");
                return;
            }
            // It's not me!
            event.getChannel().sendMessage("Welcome, " + event.getUser().getNick() + "! :3");
        }
    }

/*    public static void main(String[] args) {
        // Calling build() starts connecting.
        Client client = Client.builder().nick("Kitteh").serverHost("127.0.0.1").build();
        client.getEventManager().registerEventListener(new Listener());
        client.addChannel("#kicl");
    }*/
}
