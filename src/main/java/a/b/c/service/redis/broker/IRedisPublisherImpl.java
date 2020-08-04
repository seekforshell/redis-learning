package a.b.c.service.redis.broker;

import a.b.c.service.redis.JedisConFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 18:02.
 */
@Service
public class IRedisPublisherImpl implements IRedisPublisher {
    @Override
    public void publish(String channel , String key, String value, int expire) {
        Assert.isTrue(StringUtils.isEmpty(value), "channel message is empty");

        JedisCluster cluster = JedisConFactory.getConnection();
        cluster.publish(channel, value);
    }
}
