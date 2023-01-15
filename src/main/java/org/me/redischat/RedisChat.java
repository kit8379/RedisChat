package org.me.redischat;

import org.bukkit.plugin.java.JavaPlugin;
import org.me.redischat.events.ChatEventHandler;

public class RedisChat extends JavaPlugin {
    private static RedisChat instance;
    private RedisConnection redisConnection;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        redisConnection = new RedisConnection(
                getConfig().getString("redis.host", "localhost"),
                getConfig().getString("redis.password", "123456"),
                getConfig().getInt("redis.database", 0),
                getConfig().getInt("redis.port", 6379)
        );
        redisConnection.connect();
        redisConnection.subscribe("global_chat");
        getServer().getPluginManager().registerEvents(new ChatEventHandler(), this);
    }

    @Override
    public void onDisable() {
        redisConnection.disconnect();
    }

    public static RedisChat getInstance() {
        return instance;
    }

    public RedisConnection getRedisConnection() {
        return redisConnection;
    }
}
