package org.me.redischat.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.me.redischat.RedisChat;

public class ChatEventHandler implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        // Send the message to the Redis channel
        RedisChat.getInstance().getRedisConnection().sendMessage("global_chat", event.getMessage());
    }
}
