package org.me.redischat;

import redis.clients.jedis.Jedis;

public class RedisConnection {
    private Jedis jedis;
    private final String host;
    private final String password;
    private final int database;
    private final int port;

    public RedisConnection(String host, String password, int database, int port) {
        this.host = host;
        this.password = password;
        this.database = database;
        this.port = port;
    }

    public void connect() {
        jedis = new Jedis(host, port);
        jedis.auth(password);
        jedis.select(database);
    }

    public void disconnect() {
        jedis.close();
    }

    public void sendMessage(String channel, String message) {
        jedis.publish(channel, message);
    }

    public void subscribe(String channel) {
        jedis.subscribe(new ChatSubscriber(), channel);
    }
}
