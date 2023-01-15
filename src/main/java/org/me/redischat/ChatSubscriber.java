package org.me.redischat;

import org.bukkit.Bukkit;
import redis.clients.jedis.JedisPubSub;

public class ChatSubscriber extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        // Handle the received message here
        // e.g. broadcast the message to all players on the server
        Bukkit.getServer().broadcastMessage(message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // Handle the subscription here
        // e.g. log a message to the console
        Bukkit.getLogger().info("Subscribed to channel: " + channel);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        // Handle the unsubscription here
        // e.g. log a message to the console
        Bukkit.getLogger().info("Unsubscribed from channel: " + channel);
    }
}
