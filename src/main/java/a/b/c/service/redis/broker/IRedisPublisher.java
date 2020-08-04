package a.b.c.service.redis.broker;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 16:40.
 */
public interface IRedisPublisher {
    void publish(String channel, String key, String value, int expire);
}
