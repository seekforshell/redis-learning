package a.b.c.service.redis.broker;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 18:59.
 */
@Slf4j
public class RedisPubSubImpl extends JedisPubSub {
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log.info("subscribe channel");
    }

    @Override
    public void onMessage(String channel, String message) {
        log.info(String.format("on message\r\nchannel\r\n:%s\r\nmessage:%s", channel, message));
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        super.onPMessage(pattern, channel, message);
    }
}
