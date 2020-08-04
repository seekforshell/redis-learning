package a.b.c.service.redis.broker;

import a.b.c.service.redis.JedisConFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 18:01.
 */
@Service
public class IRedisSubscribeImpl implements IRedisSubscribe {
    @Override
    public void subscribe(String channel) {
        Assert.isTrue(!StringUtils.isEmpty(channel), "channel message is empty");

        JedisCluster cluster = JedisConFactory.getConnection();
        RedisPubSubImpl redisPubSub = new RedisPubSubImpl();
        cluster.subscribe(redisPubSub, channel);
    }
}
