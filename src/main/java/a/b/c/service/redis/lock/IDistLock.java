package a.b.c.service.redis.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 15:44.
 */
public interface IDistLock {

    String newLock(JedisCluster redisCluster);

    boolean lock(String requestId, Integer expireTime);

    boolean unlock(String requestId, Integer expireTime);
}
